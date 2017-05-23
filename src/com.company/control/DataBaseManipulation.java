package com.company.control;

import com.company.AddStudentView;
import com.company.MainWindow;
import com.company.Table;
import com.company.model.Student;
import com.company.model.StudentBase;

import java.util.ArrayList;

/**
 * Created by Vlad on 15.05.2017.
 */
public class DataBaseManipulation {
    StudentBase studentBase;
    MainWindow mainWindow;
    PageWorker pageWorker;
    Table table;


    public DataBaseManipulation(StudentBase studentBase, MainWindow mainWindow){
        this.studentBase=studentBase;
        this.mainWindow = mainWindow;

    }
    public void AddNewStudentInBase(AddStudentView addStudentView){
        Student newStudent= new Student();
        newStudent.setFirstName(addStudentView.getJtfnamestudent().getText());
        newStudent.setMiddleName(addStudentView.getJtfamile().getText());
        newStudent.setLastName(addStudentView.getJtfnameprew().getText());
        newStudent.setGroup(addStudentView.getJtfstudentgroup().getText());
        ArrayList<String > exam =new ArrayList();
        ArrayList<String > value =new ArrayList();
        exam.add((String)addStudentView.getComboBoxnameekz1().getSelectedItem());
        exam.add((String)addStudentView.getComboBoxnameekz2().getSelectedItem());
        exam.add((String)addStudentView.getComboBoxnameekz3().getSelectedItem());
        newStudent.setExamList(exam);
        value.add((String)addStudentView.getComboBoxvalueekz1().getSelectedItem());
        value.add((String)addStudentView.getComboBoxvalueekz2().getSelectedItem());
        value.add((String)addStudentView.getComboBoxvalueekz3().getSelectedItem());
        newStudent.setValueList(value);
   /*     newStudent.setNameekz1((String) addStudentView.getComboBoxnameekz1().getSelectedItem());
        newStudent.setValueekz1((String ) addStudentView.getComboBoxvalueekz1().getSelectedItem());
        newStudent.setNameekz2((String) addStudentView.getComboBoxnameekz2().getSelectedItem());
        newStudent.setValuekz2((String ) addStudentView.getComboBoxvalueekz2().getSelectedItem());
        newStudent.setNameekz3((String) addStudentView.getComboBoxnameekz3().getSelectedItem());
        newStudent.setValueekz3((String) addStudentView.getComboBoxvalueekz3().getSelectedItem());*/

        studentBase.addStudent(newStudent);
        mainWindow.renderTable();

    }

    public ArrayList<Student> findStudentByNameAndGrop(String name, String group){
        ArrayList<Student> findStudentArrayList = new ArrayList<Student>();
        for(Student student: studentBase.getStudents()){
            if(student.getGroup().equalsIgnoreCase(group)&&student.getFirstName().equalsIgnoreCase(name))
            {
                findStudentArrayList.add(student);
            }
            else if(group.equalsIgnoreCase("")&&student.getFirstName().equalsIgnoreCase(name)){
                findStudentArrayList.add(student);
            }
            else if(student.getGroup().equalsIgnoreCase(group)&&name.equalsIgnoreCase("")){
                findStudentArrayList.add(student);
            }
        }

        return  findStudentArrayList;
    }

    /*public ArrayList<Student> findStudentByNameAndSrednBall(String name, String studWork){
        ArrayList<Student> findStudentArrayList = new ArrayList<Student>();
        for(Student student: studentBase.getStudents()){
            if(student.getFirstName().equalsIgnoreCase(name)||name.equalsIgnoreCase(""))
            {
               *//* for(String work:student.getPublicWork()){
                    if(work.equalsIgnoreCase(studWork)){
                    findStudentArrayList.add(student);
                    break;
                    }
                }*//*
            } else if (studWork.equalsIgnoreCase("")&&student.getFirstName().equalsIgnoreCase(name)){
                findStudentArrayList.add(student);
            }
        }
        return  findStudentArrayList;
    }
*/


    public ArrayList<Student> findStudentByNameAndSrBall(String name, String lowerLimit, String upperLimit){
        ArrayList<Student> findStudentArrayList = new ArrayList<Student>();
        for(Student student: studentBase.getStudents()){
            if(student.getFirstName().equalsIgnoreCase(name)||name.equalsIgnoreCase(""))
            {   if(student.getSrBall()>Integer.parseInt(lowerLimit)&&student.getSrBall()<Integer.parseInt(upperLimit))
                    findStudentArrayList.add(student);
            }else if (lowerLimit.equalsIgnoreCase("")&&upperLimit.equalsIgnoreCase("")&&student.getFirstName().equalsIgnoreCase(name)){
                findStudentArrayList.add(student);
            }
        }


        return  findStudentArrayList;
    }

    public ArrayList<Student> findStudentByNameAndBallEkz(String name, String exam, String lowerLimit, String upperLimit){
        ArrayList<Student> findStudentArrayList = new ArrayList<Student>();
        for(Student student: studentBase.getStudents()){
            if(student.getFirstName().equalsIgnoreCase(name)||name.equalsIgnoreCase(""))
            {   if(student.getExamList().get(0).equalsIgnoreCase(exam))
                {if(Integer.parseInt(student.getValueList().get(0))>Integer.parseInt(lowerLimit)&&Integer.parseInt(student.getValueList().get(0))<Integer.parseInt(upperLimit))
                findStudentArrayList.add(student);}
                else if(student.getExamList().get(1).equalsIgnoreCase(exam))
            {if(Integer.parseInt(student.getValueList().get(1))>Integer.parseInt(lowerLimit)&&Integer.parseInt(student.getValueList().get(1))<Integer.parseInt(upperLimit))
                findStudentArrayList.add(student);}
                else if(student.getExamList().get(2).equalsIgnoreCase(exam))
            {if(Integer.parseInt(student.getValueList().get(2))>Integer.parseInt(lowerLimit)&&Integer.parseInt(student.getValueList().get(2))<Integer.parseInt(upperLimit))
                findStudentArrayList.add(student);}

            }

            else if (lowerLimit.equalsIgnoreCase("")&&upperLimit.equalsIgnoreCase("")&&student.getFirstName().equalsIgnoreCase(name)){
                findStudentArrayList.add(student);
            }
        }
        return  findStudentArrayList;
    }

    public int deleteStudentByNameAndGrop(String name, String group){
        int coll=studentBase.removeStudents(findStudentByNameAndGrop(name,group));
        mainWindow.renderTable();
        return coll;
    }
  /*  public int deleteStudentByNameAndWork(String name, String group){
        int coll=studentBase.removeStudents(findStudentByNameAndSrednBall(name,group));
        mainWindow.renderTable();
        return coll;
    }*/
    public int deleteStudentByNameAndSrBall(String name, String lowerLimit, String upperLimit){
        int coll=studentBase.removeStudents(findStudentByNameAndSrBall(name,lowerLimit,upperLimit));
        mainWindow.renderTable();
        return coll;
    }

    public int deleteStudentByNameAndBallEkz(String name, String exam, String lowerLimit, String upperLimit){
        int coll=studentBase.removeStudents(findStudentByNameAndBallEkz(name,exam, lowerLimit,upperLimit));
        System.out.println("s ;fdijs;lgksfd  "+coll);
        mainWindow.renderTable();
        return coll;
    }

}


