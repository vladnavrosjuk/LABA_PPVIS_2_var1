package com.company;

import com.company.control.PageWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vlad on 14.05.2017.
 */
public class TableToolbar {
    PageWorker pageWorker;
    Window window;
    JButton leftButton;
    JButton rightButton;
    JButton leftButtonToEnd;
    JButton rightButtonToEnd;
    JButton resizeButton;
    Table table;
    JLabel jLabel;
    int posX,posY;
    public TableToolbar(int posX, int posY, PageWorker pageWorker, Window window, Table table){
        this.pageWorker = pageWorker;
        this.window=window;
        this.table=table;
        this.posX=posX;
        this.posY=posY;
        jLabel=new JLabel();
       // window.add(jLabel);
        leftButton = new JButton();
        rightButton = new JButton();
        leftButtonToEnd = new JButton();
        rightButtonToEnd = new JButton();
        resizeButton = new JButton(String.valueOf(pageWorker.getCountOfStudentOnLists()));
        leftButton.setIcon(new ImageIcon("src\\com.company\\resourses\\next1.png"));
        leftButton.setRolloverIcon(new ImageIcon("src\\com.company\\resourses\\next2.png"));
        rightButton.setIcon(new ImageIcon("src\\com.company\\resourses\\prew1.png"));
        rightButton.setRolloverIcon(new ImageIcon("src\\com.company\\resourses\\prew2.png"));
        leftButtonToEnd.setIcon(new ImageIcon("src\\com.company\\resourses\\next2.png"));
        rightButtonToEnd.setIcon(new ImageIcon("src\\com.company\\resourses\\prew2.png"));

        JPanel jPanelPage = new JPanel();
        jPanelPage.add(leftButtonToEnd);
        jPanelPage.add(leftButton);
        jPanelPage.add(rightButton);
        jPanelPage.add(rightButtonToEnd);
        JLabel jlab =new JLabel("На странице макс:");
        jPanelPage.add(jlab);
        jPanelPage.add(resizeButton);
        createJLable();
        jPanelPage.add(jLabel);
        jPanelPage.setBackground(Color.yellow);
        jPanelPage.setOpaque(false);
        jPanelPage.setBounds(posX,posY,700,50);
        setListeners();
        window.add(jPanelPage);
    }
    public void createJLable(){
        jLabel.setText("Страница "+ pageWorker.getNoOfPage()+" из " +
                pageWorker.getCountOfPages()+ "                     Всего студентов:"+ pageWorker.getCountOfAllStuden());
    }

    public void setPageWorker(PageWorker pageWorker) {
        this.pageWorker = pageWorker;
    }

    public void doClickLastPage(){
        rightButtonToEnd.doClick();
    }

    private void setListeners()
    {
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pageWorker.NextPage();
                createJLable();
                table.renderTable(pageWorker.returnPageOfStudents());
            }
        });
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pageWorker.PreviousPage();
                createJLable();
                table.renderTable(pageWorker.returnPageOfStudents());
            }
        });
        rightButtonToEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pageWorker.LastPage();
                createJLable();
                table.renderTable(pageWorker.returnPageOfStudents());
            }
        });
        leftButtonToEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pageWorker.FirstPage();
                createJLable();
                table.renderTable(pageWorker.returnPageOfStudents());
            }
        });

        resizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String number=JOptionPane.showInputDialog("Введите число студентов на странице");
                if(number!=""||number!=null) {
                    pageWorker.setCountOfStudentOnLists(Integer.parseInt(number));
                    createJLable();
                table.renderTable(pageWorker.returnPageOfStudents());
                    resizeButton.setText(String.valueOf(pageWorker.getCountOfStudentOnLists()));
                }
            }
        });
    }

    public JButton getLeftButton() {
        return leftButton;
    }

    public JButton getRightButton() {
        return rightButton;
    }

    public JButton getLeftButtonToEnd() {
        return leftButtonToEnd;
    }

    public JButton getRightButtonToEnd() {
        return rightButtonToEnd;
    }

    public JButton getResizeButton() {
        return resizeButton;
    }
}
