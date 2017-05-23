package com.company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 09.05.2017.
 */
public class Student {
    String firstName="";
    String lastName="";
    String middleName="";
    String group="";
    List<String> examList;
    List<String> valueList;

    String namestudnt, groupstudent, nameekz2, nameekz1, nameekz3;
    String valueekz1, valuekz2, valueekz3;

    public Student(){
    examList=new ArrayList<>();
    valueList=new ArrayList<>();


    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getValueList() {
        return valueList;
    }

    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }


    public void setNamestudnt(String namestudnt) {
        this.namestudnt = namestudnt;
    }

    public void setGroupstudent(String groupstudent) {
        this.groupstudent = groupstudent;
    }

    public void setNameekz2(String nameekz2) {
        this.nameekz2 = nameekz2;
    }
    public void setExamList(List<String> examList){
        this.examList=examList;
    }

    public List<String> getExamList() {
        return examList;
    }

    public void setNameekz1(String nameekz1) {
        this.nameekz1 = nameekz1;
    }

    public void setNameekz3(String nameekz3) {
        this.nameekz3 = nameekz3;
    }

    public void setValueekz1(String valueekz1) {
        this.valueekz1 = valueekz1;
    }

    public void setValuekz2(String valuekz2) {
        this.valuekz2 = valuekz2;
    }

    public void setValueekz3(String valueekz3) {
        this.valueekz3 = valueekz3;
    }

    public String getNameekz2() {
        return nameekz2;
    }

    public String getNameekz1() {
        return nameekz1;
    }

    public String getNameekz3() {
        return nameekz3;
    }

    public String getValueekz1() {
        return valueekz1;
    }

    public String getValuekz2() {
        return valuekz2;
    }

    public String getValueekz3() {        return valueekz3;    }

    public int getSrBall(){
        return ((Integer.parseInt(valueList.get(0))+Integer.parseInt(valueList.get(1))+Integer.parseInt(valueList.get(2)))/3);
    }



}
