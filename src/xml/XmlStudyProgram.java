package xml;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;

public class XmlStudyProgram {

	private static TransformerFactory TRANSFORMER_FACTORY;
	private static Transformer TRANSFORMER;

	private static DocumentBuilder DOCUMENT_BUILDER;

	static {
		try {
			TRANSFORMER_FACTORY = TransformerFactory.newInstance();

			TRANSFORMER = TRANSFORMER_FACTORY.newTransformer();
			customizeTransformerProperty(TRANSFORMER);

			DOCUMENT_BUILDER = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	private static void customizeTransformerProperty(Transformer transformer) {
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF8");
	}

	public static void main(String[] args) throws Exception {

		// 테스트1
		// String xmlString = createXmlString();
		// saveFile(xmlString, Constants.SAVE_PATH);
		// checkXml(xmlString);

		// 테스트2
		String xmlString = readFile(Constants.READ_PATH);
		System.out.println(xmlString);
		checkXml(xmlString);

	}

	private static String createXmlString() throws Exception {
		Document xmlDocument = DOCUMENT_BUILDER.newDocument();

		Element rowSetElement = xmlDocument.createElement(Constants.ROWSET);
		xmlDocument.appendChild(rowSetElement);

		Element rowElement = xmlDocument.createElement(Constants.ROW);
		rowSetElement.appendChild(rowElement);

		Element colElement = xmlDocument.createElement(Constants.COLUMN);
		rowElement.appendChild(colElement);

		Text textNode = xmlDocument.createTextNode(Constants.COLUMN_VALUE);
		colElement.appendChild(textNode);

		DOMSource domSource = new DOMSource(xmlDocument);

		StringWriter stringWriter = new StringWriter();
		TRANSFORMER.transform(domSource, new StreamResult(stringWriter));

		String result = stringWriter.toString();
		System.out.println(result);

		stringWriter.close();
		domSource = null;
		xmlDocument = null;

		return result;
	}

	private static void saveFile(String str, String pathString) throws Exception {
		byte[] bytes = str.getBytes("UTF8");
		FileOutputStream fos = new FileOutputStream(pathString);
		fos.write(bytes);
		fos.close();
	}

	private static String readFile(String pathString) throws Exception {
		FileInputStream fis = new FileInputStream(pathString);
		byte[] bytes = fis.readAllBytes();
		fis.close();
		return new String(bytes);
	}

	private static void checkXml(String xmlString) throws Exception {
		InputSource inputSource = new InputSource();
		inputSource.setCharacterStream(new StringReader(xmlString));

		Document document = DOCUMENT_BUILDER.newDocument();
		document = DOCUMENT_BUILDER.parse(inputSource);
		printDocumentTypeElementInfo(document);

		// Document 노드의 모든 자식들 리스트
		// NodeList documentChildList = document.getChildNodes();
		// int documentChildLength = documentChildList.getLength();

		// Document 노드의 첫 자식
		System.out.println("Document의 첫 자식");
		Node documentFirstChild = document.getFirstChild();
		printNodeType(documentFirstChild);
		System.out.println();

		// ROWSET 엘리먼트의 모든 자식 노드들
		System.out.println("ROWSET 엘리먼트(Document의 첫 자식)의 모든 자식 노드");
		NodeList rowSetChildList = documentFirstChild.getChildNodes();
		for (int i = 0; i < rowSetChildList.getLength(); i++) {
			Node rowSetEachChild = rowSetChildList.item(i);
			printNodeType(rowSetEachChild);
		}
		System.out.println();

		// ROW 엘리먼트의 모든 자식 노드들
		System.out.println("ROW 엘리먼트(ROWSET의 두번째 자식 노드)의 모든 자식 노드");
		Node rowNode = rowSetChildList.item(1);
		NodeList rowChildList = rowNode.getChildNodes();
		for (int i = 0; i < rowChildList.getLength(); i++) {
			Node rowChild = rowChildList.item(i);
			printNodeType(rowChild);
		}
		System.out.println();

		// COLUMN 엘리먼트의 모든 자식 노드들
		System.out.println("COLUMN 엘리먼트(ROW 노드의 두번째 자식 노드)의 모든 자식 노드");
		Node columnNode = rowChildList.item(1);
		NodeList columnChilds = columnNode.getChildNodes();
		for (int i = 0; i < columnChilds.getLength(); i++) {
			Node columnChild = columnChilds.item(i);
			printNodeType(columnChild);
		}
		System.out.println();

	}

	private static void printNodeType(Node node) {
		short type = node.getNodeType();
		String nodeName = node.getNodeName();

		String result = null;
		String textValue = null;

		switch (type) {
		case Node.TEXT_NODE:
			result = "TEXT_NODE";
			break;
		case Node.ATTRIBUTE_NODE:
			result = "ATTRIBUTE_NODE";
			break;
		case Node.CDATA_SECTION_NODE:
			result = "CDATA_SECTION_NODE";
			break;
		case Node.COMMENT_NODE:
			result = "COMMENT_NODE";
			break;
		case Node.DOCUMENT_FRAGMENT_NODE:
			result = "DOCUMENT_FRAGMENT_NODE";
			break;
		case Node.DOCUMENT_NODE:
			result = "DOCUMENT_NODE";
			break;
		case Node.DOCUMENT_TYPE_NODE:
			result = "DOCUMENT_TYPE_NODE";
			break;
		case Node.ELEMENT_NODE:
			result = "ELEMENT_NODE";
			break;
		default:
			result = "해당없음";
			break;
		}

		System.out.println("nodeName: " + nodeName + ", nodeType: " + result);
		if (type == Node.TEXT_NODE) {
			String textContent = node.getTextContent();
			if (textContent.contains("\n")) {
				int index = textContent.indexOf("\n");
				System.out.println("textContent - 길이: " + textContent.length() + ", 줄바꿈 문자 위치: " + index);
			} else {
				System.out.println("textContent - 길이: " + textContent.length() + ", 줄바꿈 없음");
			}
		}
	}

	private static void printDocumentTypeElementInfo(Document document) {
		DocumentType docType = document.getDoctype();

		if (docType == null) {
			System.out.println("DocumentType element is null");
		} else {
			System.out.println("DocumentType element is not null");
//			System.out.println("getName:" + docType.getName());
//			System.out.println("getBaseURI:" + docType.getBaseURI());
//			System.out.println("getInternalSubset:" + docType.getInternalSubset());
//			System.out.println("getName:" + docType.getName());
//			System.out.println("getNamespaceURI:" + docType.getNamespaceURI());
//			System.out.println("getNodeName:" + docType.getNodeName());
//			System.out.println("getNodeValue:" + docType.getNodeValue());
//			System.out.println("getPrefix:" + docType.getPrefix());
//			System.out.println("getPublicId:" + docType.getPublicId());
//			System.out.println("getSystemId: " + docType.getSystemId());
//			System.out.println("getTextContent: " + docType.getTextContent());
//			System.out.println("toString: " + docType.toString());
		}
		System.out.println();
	}

}
