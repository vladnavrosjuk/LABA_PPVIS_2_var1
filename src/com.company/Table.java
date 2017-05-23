package com.company;

import com.company.TableToolbar;
import com.company.model.Student;
import table.GroupableTableHeader;
import table.ColumnGroup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Vlad o n 14.05.2017.
 */
public class Table {
    private int widh=130;
    private int heigth=20;
    private int heigthAligment=50;
    //JFrame jFrame;
    private Window window;
    private JLabel fio;
    private JLabel group;
    private JLabel publicWorsk;
    private JLabel[] jLable;
    JTable table;
    private ArrayList<Component> componentArrayList;
    private TableToolbar tableToolbar;
    public Table(Window window){
        componentArrayList=new ArrayList<Component>();
        this.window=window;
        jLable= new JLabel[10];
    }
    public Table(int heigthAligment, Window window){
        componentArrayList=new ArrayList<Component>();
        this.window=window;
        jLable= new JLabel[10];
        this.heigthAligment=heigthAligment;
        renderTable(null);
    }
    public void setTableToolbar(TableToolbar tableToolbar) {
        this.tableToolbar = tableToolbar;
    }

    public void renderTable(List<Student> studentArrayList) {
        DefaultTableModel dm = new DefaultTableModel(new Object[]{"<html>ФИО<br>студента</html>", "Группа", "наим", "Балл", "наим", "Балл", "наим", "Балл"},0);
        table = new JTable(dm) {
            protected JTableHeader createDefaultTableHeader() {
                return new GroupableTableHeader(columnModel);
            }
        };

        TableColumnModel cm = table.getColumnModel();
        ColumnGroup exam = new ColumnGroup("Экзамены");
        ColumnGroup exam2 = new ColumnGroup("1");
        exam.add(exam2);
        exam2.add(cm.getColumn(2));
        exam2.add(cm.getColumn(3));
        ColumnGroup exam3 = new ColumnGroup("2");
        exam.add(exam3);
        exam3.add(cm.getColumn(4));
        exam3.add(cm.getColumn(5));
        ColumnGroup exam4 = new ColumnGroup("3");
        exam.add(exam4);
        exam4.add(cm.getColumn(7));
        exam4.add(cm.getColumn(6));
//
        GroupableTableHeader header = (GroupableTableHeader) table.getTableHeader();
        header.addColumnGroup(exam);
//        header.addColumnGroup(exam2);
//        header.addColumnGroup(exam3);
        header.setBackground(Color.WHITE);


        JScrollPane scroll = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        scroll.setBackground(Color.WHITE);
        scroll.setPreferredSize(new Dimension(1360,500));
        JPanel jPanel = new JPanel();
        //jPanel.setPreferredSize(new Dimension(500, 500));
        jPanel.setOpaque(true);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanel.add(scroll, BorderLayout.EAST);
        jPanel.setBounds(0,heigthAligment,1360,500);
        window.add(jPanel);
/*        jPanel.updateUI();*/
        jPanel.validate();
        window.validate();
     /*   window.update(window.getGraphics());*/
     if(studentArrayList!=null)
        for (Student student:studentArrayList)
        {DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            Object objects[] = {student.getFirstName()+" "+student.getMiddleName()+" "+student.getLastName(),
                    student.getGroup(),student.getNameekz1(),student.getExamList().get(0),student.getNameekz2(),student.getValuekz2(),student.getNameekz3(),
                            student.getValueekz3()
            };
            tableModel.addRow(objects);
        }

    }
    public void add(Student student){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        Object objects[] = {student.getFirstName()+" "+student.getMiddleName()+" "+student.getLastName(),
                student.getGroup()
        };
        tableModel.addRow(objects);
        table.setModel(tableModel);
    }
}
