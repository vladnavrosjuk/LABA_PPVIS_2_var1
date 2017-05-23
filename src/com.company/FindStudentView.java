package com.company;

import com.company.control.DataBaseManipulation;
import com.company.control.PageWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vlad on 11.05.2017.
 */
public class FindStudentView {
    private JDialog jDialog;
    private int higthAligment=20;
    private int heigth=20;
    private int width=300;
    int leftAligment = 350;

    private JRadioButton findByNameAndGroupButton;
    private JRadioButton findByNameAndWorkButton;
    private JRadioButton findNameNumberOfWorkButton;
    private DataBaseManipulation dataBaseManipulation;

    private JLabel jLabel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private TextField firstData;
    private TextField secondData;
    private TextField thirdData;
    private TextField forthData;
    private ActionListener totalAcionListener;
    private JButton actionButton ;
    private JComboBox exams;
    public FindStudentView(DataBaseManipulation dataBaseManipulation){
        this.dataBaseManipulation=dataBaseManipulation;
        jDialog=new JDialog();
        jLabel=new JLabel();
        jLabel1= new JLabel("от");
        jLabel2= new JLabel("до");
        firstData = new TextField();
        secondData = new TextField();
        thirdData = new TextField();
        forthData = new TextField();
        actionButton = new JButton();
        String[] professi = {
                "ППВИС",
                "МОИС",
                "ОТС"
        };
        exams=new JComboBox(professi);
        //createElementsOfWindow("");
    }
   void createElementsOfWindow(final String findButtonName) {
       ButtonGroup jrb = new ButtonGroup();

        jDialog.getContentPane().setLayout(null);
        jDialog.setVisible(true);
        jDialog.setBounds(200, 250, 900, 900);
        findByNameAndGroupButton = new JRadioButton(findButtonName+" по группе и фамилии");
        findByNameAndGroupButton.setBounds(20, higthAligment , width, heigth);
        jDialog.add(findByNameAndGroupButton);
        findByNameAndWorkButton = new JRadioButton(findButtonName+" по фамилии среднему баллу");
        findByNameAndWorkButton.setBounds(20, higthAligment + 30, width, heigth);
        jDialog.add(findByNameAndWorkButton);
        findNameNumberOfWorkButton = new JRadioButton(findButtonName+" по фамилии и баллу по экзамену");
        findNameNumberOfWorkButton.setBounds(20, higthAligment + 60, width, heigth);
        jDialog.add(findNameNumberOfWorkButton);
        jrb.add(findByNameAndGroupButton);
       jrb.add(findNameNumberOfWorkButton);
       jrb.add(findByNameAndWorkButton);




        //findByNameAndGroupButton.addActionListener(new FindByNameAndGroupListener(this, dataBaseManipulation,findButtonName));

       // findByNameAndWorkButton.addActionListener(new FindByNameAndWorkListener(this, dataBaseManipulation));
        //findNameNumberOfWorkButton.addActionListener(new FindByNameAndNumberOfWorkListener(this, dataBaseManipulation));
    }

    public void removeElements() {
        jDialog.remove(jLabel1);
        jDialog.remove(jLabel2);
        jDialog.remove(thirdData);
        jDialog.remove(firstData);
        jDialog.remove(secondData);
        jDialog.remove(jLabel);
        jDialog.remove(exams);
        firstData.setText("");
        secondData.setText("");
        thirdData.setText("");
        jDialog.remove(actionButton);
        if(totalAcionListener!=null)
        actionButton.removeActionListener(totalAcionListener);
    }

    public void addFindByNameAndGroupElemens(String btnName, ActionListener actionForButton){
        totalAcionListener=actionForButton;


        jLabel.setText("Введите фамилию студента и группу");


        jLabel.setBounds(leftAligment, higthAligment - 10, 300, 20);
        getjDialog().add(jLabel);
        firstData.setBounds(leftAligment, higthAligment+30, width/3, heigth);
        getjDialog().add(firstData);
        secondData.setBounds(leftAligment+130, higthAligment+30, width/3, heigth);
        getjDialog().add(secondData);
        actionButton.setText(btnName);
        actionButton.setBounds(leftAligment+60, higthAligment + 70, 80, 20);
        getjDialog().add(actionButton);
        getjDialog().update(getjDialog().getGraphics());
        actionButton.addActionListener(actionForButton);
    }

    public void addFindByNameAndWorkElemens(String btnName, ActionListener actionForButton){
        addFindByNameAndGroupElemens(btnName,actionForButton);

        jLabel.setText("Введите фамилию студента, экзамен и диапазон среднего балла");
        actionButton.setBounds(leftAligment+120, higthAligment + 70, 80, 20);
        jLabel1.setBounds(leftAligment+120,higthAligment+30,20,heigth);
        getjDialog().add(jLabel1);
        secondData.setBounds(leftAligment+140, higthAligment+30,width/9,heigth);
        exams.setBounds(leftAligment+40, higthAligment + 70, 80, 20);
        jLabel2.setBounds(leftAligment+180,higthAligment+30,20,heigth);
        getjDialog().add(jLabel2);
        getjDialog().add(exams);
        thirdData.setBounds(leftAligment+200, higthAligment+30,width/9,heigth);
        getjDialog().add(thirdData);
    }

    public void addFindByNameAndNumberOfWorkElemens(String btnName, ActionListener actionForButton){
        //removeElements();
        addFindByNameAndGroupElemens(btnName,actionForButton);

        jLabel.setText("Введите фамилию студента и диапазон среднего балла");

        jLabel1.setBounds(leftAligment+120,higthAligment+30,20,heigth);
        getjDialog().add(jLabel1);
        secondData.setBounds(leftAligment+140, higthAligment+30,width/9,heigth);

        jLabel2.setBounds(leftAligment+180,higthAligment+30,20,heigth);
        getjDialog().add(jLabel2);
        thirdData.setBounds(leftAligment+200, higthAligment+30,width/9,heigth);
        getjDialog().add(thirdData);
    }


    public void createFindWindow(){
        createElementsOfWindow("Поиск");
        final Table table = new Table(higthAligment+150,getjDialog());
        final PageWorker pageWorker = new PageWorker();
        TableToolbar tableToolbar = new TableToolbar(600, 0, pageWorker, getjDialog(), table);
        table.setTableToolbar(tableToolbar);
        table.renderTable(pageWorker.returnPageOfStudents());
        getjDialog().setBounds(0, 0, 1600, 900);

        findByNameAndGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                removeElements();
                addFindByNameAndGroupElemens("Поиск",new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        pageWorker.setStudentList(dataBaseManipulation.findStudentByNameAndGrop(firstData.getText(), secondData.getText()));
                        table.renderTable(pageWorker.returnPageOfStudents());
                        tableToolbar.doClickLastPage();

                        //getjDialog().update(getjDialog().getGraphics());
                    }
                });
            }
        });

        findByNameAndWorkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                removeElements();
                addFindByNameAndWorkElemens("Поиск", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        pageWorker.setStudentList(dataBaseManipulation.findStudentByNameAndBallEkz(firstData.getText(),(String)exams.getSelectedItem(), secondData.getText(),thirdData.getText()));
                        table.renderTable(pageWorker.returnPageOfStudents());
                        tableToolbar.doClickLastPage();
                        //getjDialog().update(getjDialog().getGraphics());
                    }
                });
            }
        });

        findNameNumberOfWorkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                removeElements();
                addFindByNameAndNumberOfWorkElemens("Поиск", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        pageWorker.setStudentList(dataBaseManipulation.findStudentByNameAndSrBall(firstData.getText(),secondData.getText(),thirdData.getText()));
                        table.renderTable(pageWorker.returnPageOfStudents());
                       // getjDialog().update(getjDialog().getGraphics());
                    }
                });
            }
        });

    }

    public JDialog getjDialog() {
        return jDialog;
    }

    public TextField getFirstData() {
        return firstData;
    }

    public TextField getSecondData() {
        return secondData;
    }

    public TextField getThirdData() {
        return thirdData;
    }

    public TextField getForthData() {
        return forthData;
    }

    public JComboBox getExams() {
        return exams;
    }

    public JRadioButton getFindByNameAndGroupButton() {
        return findByNameAndGroupButton;
    }

    public JRadioButton getFindByNameAndWorkButton() {
        return findByNameAndWorkButton;
    }

    public JRadioButton getFindByNameNumberOfWorkButton() {
        return findNameNumberOfWorkButton;
    }
}
