package exp2;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
class Student {
    private Integer id;
    private String name;
    private String gender;
    private String birth;
    private String major;
    public Student() {

    }
    public Student(Integer id, String name, String gender, String birth, String major) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.major = major;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    @Override
    public String toString() {
        return id + " " +
                name + " " +
                gender + " " +
                birth + " " +
                major + " ";
    }
}
public class Exp2 {
    public static void writeFile1(String path, List<Student> list) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element students = doc.createElement("students");
            for (int i = 0; i < list.size(); i++) {
                Element student = doc.createElement("student");
                student.setAttribute("id", String.valueOf(list.get(i).getId()));
                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(list.get(i).getName()));
                student.appendChild(name);
                Element gender = doc.createElement("gender");
                gender.appendChild(doc.createTextNode(list.get(i).getGender()));
                student.appendChild(gender);
                Element birth = doc.createElement("birth");
                birth.appendChild(doc.createTextNode(list.get(i).getBirth()));
                student.appendChild(birth);
                Element major = doc.createElement("major");
                major.appendChild(doc.createTextNode(list.get(i).getMajor()));
                student.appendChild(major);
                students.appendChild(student);
            }
            doc.appendChild(students);
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(new File(path)));
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public static void readFile1(String path) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(path);
            NodeList nodeList1 = doc.getChildNodes();
            for (int i = 0; i < nodeList1.getLength(); i++) {
                if (nodeList1.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    NodeList nodeList2 = nodeList1.item(i).getChildNodes();
                    for (int j = 0; j < nodeList2.getLength(); j++) {
                        if (nodeList2.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element elem = (Element) nodeList2.item(j);
                            System.out.print(elem.getAttribute("id") + " ");
                            NodeList nodeList3 = nodeList2.item(j).getChildNodes();
                            for (int k = 0; k < nodeList3.getLength(); k++) {
                                if (nodeList3.item(k).getNodeType() == Node.ELEMENT_NODE) {
                                    System.out.print(nodeList3.item(k).getTextContent() + " ");
                                }
                            }
                        }
                        System.out.println();
                    }
                }
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public static void writeFile2(String path, List<Student> list) {
        try {
            XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileWriter(path));
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("students");
            for (int i = 0; i < list.size(); i++) {
                xmlStreamWriter.writeStartElement("student");
                xmlStreamWriter.writeAttribute("id", String.valueOf(list.get(i).getId()));
                xmlStreamWriter.writeStartElement("name");
                xmlStreamWriter.writeCharacters(list.get(i).getName());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeStartElement("gender");
                xmlStreamWriter.writeCharacters(list.get(i).getGender());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeStartElement("birth");
                xmlStreamWriter.writeCharacters(list.get(i).getBirth());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeStartElement("major");
                xmlStreamWriter.writeCharacters(list.get(i).getMajor());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeEndElement();
            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public static void readFile2(String path) {
        try {
            XMLStreamReader xmlStreamReader = XMLInputFactory.newFactory().createXMLStreamReader(new FileReader(path));
            while (xmlStreamReader.hasNext() == true) {
                int next = xmlStreamReader.next();
                if (next == XMLStreamConstants.START_ELEMENT) {
                    if (Objects.equals(String.valueOf(xmlStreamReader.getName()), "student") == true) {
                        System.out.print(xmlStreamReader.getAttributeValue(0) + " ");
                    }
                    else if (Objects.equals(String.valueOf(xmlStreamReader.getName()), "name") == true) {
                        System.out.print(xmlStreamReader.getElementText() + " ");
                    }
                    else if (Objects.equals(String.valueOf(xmlStreamReader.getName()), "gender") == true) {
                        System.out.print(xmlStreamReader.getElementText() + " ");
                    }
                    else if (Objects.equals(String.valueOf(xmlStreamReader.getName()), "birth") == true) {
                        System.out.print(xmlStreamReader.getElementText() + " ");
                    }
                    else if (Objects.equals(String.valueOf(xmlStreamReader.getName()), "major") == true) {
                        System.out.println(xmlStreamReader.getElementText());
                    }
                }
            }
            xmlStreamReader.close();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String path1 = "./src/main/resources/list1.xml";
        String path2 = "./src/main/resources/list2.xml";
        List<Student> list = new ArrayList<>();
        list.add(new Student(20210001, "张三", "男", "2003/09/15", "软件工程"));
        list.add(new Student(20210002, "李四", "男", "2004/08/20", "软件工程"));
        list.add(new Student(20210003, "晓红", "女", "2005/03/25", "软件工程"));
        list.add(new Student(20210004, "小鹿", "女", "2003/12/12", "软件工程"));
        writeFile1(path1, list);
        readFile1(path1);
        writeFile2(path2, list);
        readFile2(path2);
    }
}