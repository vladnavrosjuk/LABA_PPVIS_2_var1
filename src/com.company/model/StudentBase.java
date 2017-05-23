package com.company.model;

import com.company.SaveAndLoadBase.SaveAndLoad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 09.05.2017.
 */
public class StudentBase {
    private List<Student> students;
    public StudentBase(){
        students = new ArrayList<Student>();
    }
    public void addStudent(Student student){
        students.add(student);
        System.out.println(students.size());
    }
    public List<Student> getStudents() {
        return students;
    }
    public int removeStudents(List<Student> studentList){
        students.removeAll(studentList);
        return studentList.size();
    }
    public void saveStudentBase()
    {
        new SaveAndLoad().writeFile(students);
    }
    public void readStudentBase(){
        students=new SaveAndLoad().readFromFile();
    }
}
