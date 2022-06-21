package io.reader;

import java.io.Closeable;
import java.io.IOException;

//Reader 뜯어보기
public abstract class Reader implements Readable, Closeable {

	protected Object lock; // 동기화 처리에 사용될 lock

	protected Reader() {
		this.lock = this;
	}

	protected Reader(Object lock) {
		if (lock == null) {
			throw new NullPointerException();
		}
		this.lock = lock;
	}

	// CharBuffer 사용할일이 있으면 뜯어보기
	public int read(java.nio.CharBuffer target) throws IOException {
		int len = target.remaining();
		char[] cbuf = new char[len];
		int n = read(cbuf, 0, len);
		if (n > 0)
			target.put(cbuf, 0, n);
		return n;
	}

	public int read() throws IOException {
		char cb[] = new char[1];
		// 내부적으로 read(char cbuf[], int off, int len) 호출
		if (read(cb, 0, 1) == -1)
			return -1;
		else
			return cb[0];
	}

	public int read(char cbuf[]) throws IOException {
		// 내부적으로 read(char cbuf[], int off, int len) 호출
		return read(cbuf, 0, cbuf.length);
	}

	// sub class의 구현 대상!!!!
	abstract public int read(char cbuf[], int off, int len) throws IOException;

	private static final int maxSkipBufferSize = 8192;

	// skip메서드 호출전까지는 null 상태
	// skip()메서드 사용시 안읽을 것들을 skipBuffer에다 대신 read시켜버리는 것임. 쓰레기 처리장 느낌
	private char skipBuffer[] = null;

	// n= 스킵할 전체 개수(10000가정)
	public long skip(long n) throws IOException {

		if (n < 0L)
			throw new IllegalArgumentException("skip value is negative");
		// 작은 값(8192). 작은 값으로 버퍼 사이즈가 결정됨
		int nn = (int) Math.min(n, maxSkipBufferSize);
		synchronized (lock) {
			if ((skipBuffer == null) || (skipBuffer.length < nn))
				// 작은 값으로 배열 생성(8192)
				skipBuffer = new char[nn];
			// r= 남은 스킵 처리 개수 10000 (while문을 돌며 남은 스킵 처리 개수가 r에 초기화됨)
			long r = n;
			while (r > 0) {
				// 내부적으로 read(char cbuf[], int off, int len) 호출
				// nc = 스킵 처리한 개수(쓰레기 처리장 skipBuffer에 읽힌 개수)
				int nc = read(skipBuffer, 0, (int) Math.min(r, nn));
				if (nc == -1)
					// 읽은 개수가 없으면 탈출 후 return n-r -> 10000-10000(스킵할 전체개수 - 남은 스킵처리개수)=0
					break;
				r -= nc; // 10000-8192(1808개 스킵 처리 남음)
				// 처리할 것이 남으면 재반복
				// 다음 반복에서 1000개 읽고 스트림의 끝에 도달했다고 가정
				// 1808-1000 ->(808개 스킵 처리 남음)
				// 다음 반복에서는 스트림의 끝이라 -1리턴되고 n-r(10000-808)이 계산됨-> 스킵 진행된 개수
			}
			return n - r; // (전체 스킵처리개수 - 스킵 처리 남은 개수) -> 스킵 진행된 개수
		}
	}

	public boolean ready() throws IOException {
		return false;
	}

	public boolean markSupported() {
		return false;
	}

	public void mark(int readAheadLimit) throws IOException {
		throw new IOException("mark() not supported");
	}

	public void reset() throws IOException {
		throw new IOException("reset() not supported");
	}

	abstract public void close() throws IOException;

}