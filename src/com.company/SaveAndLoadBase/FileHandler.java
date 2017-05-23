package com.company.SaveAndLoadBase;

import com.company.model.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

/**
 * Created by Vlad on 20.05.2017.
 */
public class FileHandler extends DefaultHandler{
    String tempData;
    Student tempStudent;
    List<Student> studentArrayList;
    FileHandler(List<Student> studentArrayList){
        tempStudent=new Student();
        this.studentArrayList=studentArrayList;
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tempData="";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(tempData+" - - - - - -");
        if (qName.equalsIgnoreCase("firstName"))
            tempStudent.setFirstName(tempData);
        if (qName.equalsIgnoreCase("middleName"))
            tempStudent.setMiddleName(tempData);
        if (qName.equalsIgnoreCase("lastName"))
            tempStudent.setLastName(tempData);
        if (qName.equalsIgnoreCase("group"))
            tempStudent.setGroup(tempData);
        if (qName.equalsIgnoreCase("exam1"))
            tempStudent.setNameekz1(tempData);
        if (qName.equalsIgnoreCase("valueekz1"))
            tempStudent.setValueekz1(tempData);
        if (qName.equalsIgnoreCase("exam2"))
            tempStudent.setNameekz2(tempData);
        if (qName.equalsIgnoreCase("valueekz2")){
            tempStudent.setValuekz2(tempData);
            System.out.println(tempData+" - - - - - -");
        }
        if (qName.equalsIgnoreCase("exam3"))
            tempStudent.setNameekz3(tempData);
        if (qName.equalsIgnoreCase("valueekz3"))
            tempStudent.setValueekz3(tempData);




        if (qName.equalsIgnoreCase("student")) {
            studentArrayList.add(tempStudent);
            tempStudent=new Student();
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        tempData=new String(ch,start,length);
        //System.out.println(tempData);
    }
}

