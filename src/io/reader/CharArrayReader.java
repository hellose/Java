package io.reader;

import java.io.IOException;
import java.io.Reader;

//바이트 기반 ByteArrayInputStream과 클래스 구조가 비슷한 느낌...

//CharArrayReader 뜯어보기
class CharArrayReader extends Reader {

	protected char buf[]; // 데이터를 읽을 대상 <- 생성자에 Char[] 전달
	protected int pos;
	protected int markedPos = 0;
	protected int count;

	// 읽을 지점 배열의 처음 ~ 끝
	public CharArrayReader(char buf[]) {
		this.buf = buf;
		this.pos = 0;
		this.count = buf.length;
	}

	// 읽을 지점 배열의 인자에 지정한 offset부터 length개수만큼
	public CharArrayReader(char buf[], int offset, int length) {
		if ((offset < 0) || (offset > buf.length) || (length < 0) || ((offset + length) < 0)) {
			throw new IllegalArgumentException();
		}
		this.buf = buf;
		this.pos = offset;
		this.count = Math.min(offset + length, buf.length);
		this.markedPos = offset;
	}

	// read,skip,mark,reset....에서 사용됨. close되었으면 에러던짐
	private void ensureOpen() throws IOException {
		if (buf == null)
			throw new IOException("Stream closed");
	}

	public int read() throws IOException {
		synchronized (lock) { // Reader 추상 클래스에 포함된 필드 Object lock;
			ensureOpen();
			if (pos >= count)
				return -1;
			else
				return buf[pos++];
		}
	}

	public int read(char b[], int off, int len) throws IOException {
		synchronized (lock) {
			ensureOpen();
			if ((off < 0) || (off > b.length) || (len < 0) || ((off + len) > b.length) || ((off + len) < 0)) {
				throw new IndexOutOfBoundsException();
			} else if (len == 0) {
				return 0;
			}

			if (pos >= count) {
				return -1;
			}

			int avail = count - pos;
			if (len > avail) {
				len = avail;
			}
			if (len <= 0) {
				return 0;
			}
			System.arraycopy(buf, pos, b, off, len);
			pos += len;
			return len;
		}
	}

	public long skip(long n) throws IOException {
		synchronized (lock) {
			ensureOpen();
			// avail = 현 시점에서 읽을 수 있는 개수
			long avail = count - pos;
			if (n > avail) {
				n = avail;
			}
			if (n < 0) {
				return 0;
			}
			pos += n;
			return n;
		}
	}

	// 읽을 것이 없으면 false리턴
	public boolean ready() throws IOException {
		synchronized (lock) {
			ensureOpen();
			return (count - pos) > 0;
		}
	}

	public boolean markSupported() {
		return true;
	}

	// 메모리 배열로부터 오므로 readAheadLimit 소용없음
	public void mark(int readAheadLimit) throws IOException {
		synchronized (lock) {
			ensureOpen();
			markedPos = pos;
		}
	}

	public void reset() throws IOException {
		synchronized (lock) {
			ensureOpen();
			pos = markedPos;
		}
	}

	public void close() {
		buf = null;
	}
}