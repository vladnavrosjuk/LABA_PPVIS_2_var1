package com.company;



import com.company.control.DataBaseManipulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 14.05.2017.
 */
public class AddStudentView {
    private JDialog jDialog;
    private JDialog jdialoaddstudent;
    TableToolbar tableToolbar;

    private JTextField jtfnamestudent, jtfstudentgroup,jtfnameprew,jtfamile;
    private JComboBox comboBoxnameekz1,comboBoxnameekz2,comboBoxnameekz3,comboBoxvalueekz1,comboBoxvalueekz2,comboBoxvalueekz3;
    private JLabel label;

    private List<TextField> publicWorkFieldArray;
    private DataBaseManipulation dataBaseManipulation;
    public AddStudentView(DataBaseManipulation dataBaseManipulation, TableToolbar toolbar){
        this.tableToolbar = toolbar;
        this.dataBaseManipulation=dataBaseManipulation;
        jDialog=new JDialog();
        jdialoaddstudent = new JDialog();

        jDialog.getContentPane().setLayout(null);
        jDialog.setSize(500,500);
     /*   jDialog.setVisible(true);*/
        jdialoaddstudent.getContentPane().setLayout(null);
        jdialoaddstudent.setSize(270,300);
        jdialoaddstudent.setVisible(true);
        createElementsOfWindow2();
    }
    void createElementsOfWindow2(){
        jdialoaddstudent.setVisible(true);
        JLabel jlb;
        jlb = new JLabel("Имя :");
        jdialoaddstudent.add(jlb);
        jlb.setBounds(0,20,100,20);
        jtfnamestudent = new JTextField();
        jdialoaddstudent.add(jtfnamestudent);
        jtfnamestudent.setBounds(100,22,150,20);
        jlb = new JLabel("Фамилия :");
        jdialoaddstudent.add(jlb);
        jlb.setBounds(0,0,100,20);
        jtfamile = new JTextField();
        jdialoaddstudent.add(jtfamile);
        jtfamile.setBounds(100,2,150,20);
        jlb = new JLabel("Отчество :");
        jdialoaddstudent.add(jlb);
        jlb.setBounds(0,40,100,20);
        jtfnameprew = new JTextField();
        jdialoaddstudent.add(jtfnameprew);
        jtfnameprew.setBounds(100,42,150,20);
        jlb = new JLabel("Группа:");
        jdialoaddstudent.add(jlb);
        jlb.setBounds(0,60,100,20);
        jtfstudentgroup = new JTextField();
        jdialoaddstudent.add(jtfstudentgroup);
        jtfstudentgroup.setBounds(100,62,150,20);
        String[] professi = {
                "ППВИС",
                "МОИС",
                "ОТС"
        };
        String[] value = {
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10"
        };


        comboBoxnameekz1 = new JComboBox(professi);

        jlb = new JLabel("Экзамен 1:");
        jdialoaddstudent.add(jlb);
        jlb.setBounds(0,80,100,20);
        ;
        jdialoaddstudent.add(comboBoxnameekz1);
        comboBoxnameekz1.setBounds(100,82,150,20);
        jlb = new JLabel("Отметка:");
        jdialoaddstudent.add(jlb);
        jlb.setBounds(0,100,100,20);
        comboBoxvalueekz1 = new JComboBox(value);
        jdialoaddstudent.add(comboBoxvalueekz1);
        comboBoxvalueekz1.setBounds(100,102,150,20);

        jlb = new JLabel("Экзамен 2:");
        jdialoaddstudent.add(jlb);
        jlb.setBounds(0,120,120,20);
        comboBoxnameekz2 = new JComboBox(professi);
        jdialoaddstudent.add(comboBoxnameekz2);
        comboBoxnameekz2.setBounds(100,122,150,20);
        jlb = new JLabel("Отметка:");
        jdialoaddstudent.add(jlb);
        jlb.setBounds(0,140,150,20);
        comboBoxvalueekz2 = new JComboBox(value);
        jdialoaddstudent.add(comboBoxvalueekz2);
        comboBoxvalueekz2.setBounds(100,142,150,20);

        jlb = new JLabel("Экзамен 3:");
        jdialoaddstudent.add(jlb);
        jlb.setBounds(0,160,120,20);
        comboBoxnameekz3 = new JComboBox(professi);
        jdialoaddstudent.add(comboBoxnameekz3);
        comboBoxnameekz3.setBounds(100,162,150,20);
        jlb = new JLabel("Отметка:");
        jdialoaddstudent.add(jlb);
        jlb.setBounds(0,180,140,20);
        comboBoxvalueekz3 = new JComboBox(value);
        jdialoaddstudent.add(comboBoxvalueekz3);
        comboBoxvalueekz3.setBounds(100,182,150,20);

        JButton jButton = new JButton("Добавить");
        jButton.setBounds(0,208,250,40);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                               dataBaseManipulation.AddNewStudentInBase(AddStudentView.this);
                jdialoaddstudent.setVisible(false);
                tableToolbar.doClickLastPage();



                           }
        });
        jdialoaddstudent.add(jButton);



    }



    public JTextField getJtfnamestudent() {
        return jtfnamestudent;
    }

    public JTextField getJtfstudentgroup() {
        return jtfstudentgroup;
    }

    public JTextField getJtfnameprew() {
        return jtfnameprew;
    }

    public JTextField getJtfamile() {
        return jtfamile;
    }

    public JComboBox getComboBoxnameekz1() {
        return comboBoxnameekz1;
    }

    public JComboBox getComboBoxnameekz2() {
        return comboBoxnameekz2;
    }

    public JComboBox getComboBoxnameekz3() {
        return comboBoxnameekz3;
    }

    public JComboBox getComboBoxvalueekz1() {
        return comboBoxvalueekz1;
    }

    public JComboBox getComboBoxvalueekz2() {
        return comboBoxvalueekz2;
    }

    public JComboBox getComboBoxvalueekz3() {
        return comboBoxvalueekz3;
    }
}
