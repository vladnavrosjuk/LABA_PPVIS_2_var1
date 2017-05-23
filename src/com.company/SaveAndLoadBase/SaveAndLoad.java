package com.company.SaveAndLoadBase;
import com.company.model.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 20.05.2017.
 */public class SaveAndLoad {
    public void writeFile(List<Student> studentArrayList){
        try
        {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();
            Element students = document.createElement("STUDENTS");
            document.appendChild(students);
             for(Student stud:studentArrayList) {
                 Element student = document.createElement("student");
                 students.appendChild(student);

                 Element firstName = document.createElement("firstName");
                 firstName.appendChild(document.createTextNode(stud.getFirstName()));//тута фамилию делать
                 student.appendChild(firstName);

                 Element middleName = document.createElement("middleName");
                 middleName.appendChild(document.createTextNode(stud.getMiddleName()));//тута имя делать
                 student.appendChild(middleName);

                 Element lastName = document.createElement("lastName");
                 lastName.appendChild(document.createTextNode(stud.getLastName()));//тута отчество делать
                 student.appendChild(lastName);

                 Element group = document.createElement("group");
                 group.appendChild(document.createTextNode(stud.getGroup()));
                 student.appendChild(group);

                 Element exam1 = document.createElement("exam1");
                 exam1.appendChild(document.createTextNode(stud.getNameekz1()));
                 student.appendChild(exam1);

                 Element valueekz1 = document.createElement("valueekz1");
                 valueekz1.appendChild(document.createTextNode(stud.getValueekz1()));
                 student.appendChild(valueekz1);

                 Element exam2 = document.createElement("exam2");
                 exam2.appendChild(document.createTextNode(stud.getNameekz2()));
                 student.appendChild(exam2);

                 Element valueekz2 = document.createElement("valueekz2");
                 valueekz2.appendChild(document.createTextNode(stud.getValuekz2()));
                 student.appendChild(valueekz2);


                 Element exam3 = document.createElement("exam3");
                 exam3.appendChild(document.createTextNode(stud.getNameekz3()));
                 student.appendChild(exam3);

                 Element valueekz3 = document.createElement("valueekz3");
                 valueekz3.appendChild(document.createTextNode(stud.getValueekz3()));
                 student.appendChild(valueekz3);

                 /*Element publicWork = document.createElement("publicWork");
                 student.appendChild(publicWork);
                 for (int i = 1; i <= 10; i++) {
                     Element semester = document.createElement("semester" + i);
                     semester.appendChild(document.createTextNode(stud.getPublicWork().get(i-1)));
                     publicWork.appendChild(semester);
                 }*/
             }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            JFileChooser jf = new JFileChooser();
            String fileName = null;
            int result = jf.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                fileName = jf.getSelectedFile().getAbsolutePath();
            }
            StreamResult streamResult = new StreamResult(new File(fileName));
            transformer.transform(domSource, streamResult);
        }
        catch (ParserConfigurationException pce)
        {
            System.out.println(pce.getLocalizedMessage());
            pce.printStackTrace();
        }
        catch (TransformerException te)
        {
            System.out.println(te.getLocalizedMessage());
            te.printStackTrace();
        }
    }
    public List<Student> readFromFile(){
        List<Student> studentArrayList= new ArrayList<Student>();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            FileHandler handler = new FileHandler(studentArrayList);
            JFileChooser jf = new JFileChooser();
            String fileName = null;
            int result = jf.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                fileName = jf.getSelectedFile().getAbsolutePath();
            }
            if(fileName!=null)
            saxParser.parse(new File(fileName), handler);
            //Get Employees list
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return studentArrayList;
    }
}
