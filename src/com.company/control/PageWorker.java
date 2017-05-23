package com.company.control;

import com.company.model.Student;
import com.company.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 15.05.2017.
 */
public class PageWorker {
    private List<Student> studentList;
    private int countOfStudentOnLists=5;
    private int noOfPage =0;

    public PageWorker(List<Student> studentList){
        this.studentList=studentList;

    }
    public PageWorker(){
        studentList=new ArrayList<>();

    }
    public int getCountOfAllStuden(){
        return studentList.size();
    }
    public int getCountOfSudentsOnMainPage(){
        return studentList.size()-noOfPage*countOfStudentOnLists;
    }
    public void setCountOfStudentOnLists(int countOfStudentOnLists) {
        this.countOfStudentOnLists = countOfStudentOnLists;
        noOfPage=0;
    }
    public int getCountOfStudentOnLists(){
        return countOfStudentOnLists;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> returnPageOfStudents(){
        List<Student> pageOfStudents= new ArrayList<Student>();
            for(int i = noOfPage *countOfStudentOnLists; i<(noOfPage +1)*countOfStudentOnLists&&i<studentList.size(); i++)
                pageOfStudents.add(studentList.get(i));
        return pageOfStudents;
    }
    public void NextPage() {
        if (countOfStudentOnLists*(noOfPage +1)<studentList.size())
        {   noOfPage++;

        }
    }
    public void PreviousPage(){
        if(noOfPage !=0){
            noOfPage--;

        }
    }
    public void FirstPage(){
        noOfPage =0;

    }
    public void LastPage(){
        int countOfPages= studentList.size() /countOfStudentOnLists;
        if (countOfStudentOnLists*(countOfPages)<studentList.size())
        {   noOfPage =countOfPages;
       // System.out.println(countOfStudentOnLists*(countOfPages));
            ;
        }
        else noOfPage=countOfPages-1;

    }
    public int getNoOfPage() {
        int countOfPages= studentList.size() /countOfStudentOnLists;
        if (countOfStudentOnLists*(countOfPages)==0)
            return 0;
        if (countOfStudentOnLists*(countOfPages)==studentList.size())
            return noOfPage+1;
        else return noOfPage+1;
    }
    public int getCountOfPages(){
        int countOfPages= studentList.size() /countOfStudentOnLists;
        if (countOfStudentOnLists*(countOfPages)<studentList.size())
        return countOfPages+1;
        else
            if(countOfPages!=0)
                return countOfPages;
            else return 0;
    }
}
