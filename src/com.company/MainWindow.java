package com.company;

import com.company.control.DataBaseManipulation;
import com.company.control.PageWorker;
import com.company.model.StudentBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vlad on 14.05.2017.
 */
public class MainWindow {

    JFrame jFrame;
    JButton findButton;
    JButton addButton;
    JButton deleteButton;
    JButton saveButton;
    JButton loadButton;

    Table table;
    StudentBase studentBase;
    DataBaseManipulation dataBaseManipulation;
    PageWorker pageWorker;
    TableToolbar tableToolbar;
   public MainWindow(){
       jFrame= new JFrame();
       jFrame.setResizable(false);
       jFrame.getContentPane().setLayout(null);
       studentBase= new StudentBase();
       dataBaseManipulation= new DataBaseManipulation(studentBase,this);
       JLabel JLABLE = new JLabel();
       table= new Table(jFrame);
       pageWorker =new PageWorker(studentBase.getStudents());
       tableToolbar =new TableToolbar(600,0, pageWorker,jFrame,table);
       table.setTableToolbar(tableToolbar);
       JLABLE.setBounds(0,0,1600,900);
        jFrame.add(JLABLE);
       jFrame.setSize(1360,800);
       jFrame.setVisible(true);
       findButton = new JButton();
       addButton = new JButton();
        deleteButton = new JButton();
        saveButton=new JButton();
        loadButton=new JButton();
       findButton.setIcon(new ImageIcon("src\\com.company\\resourses\\search.png"));
       addButton.setIcon(new ImageIcon("src\\com.company\\resourses\\add1.png"));
       addButton.setRolloverIcon(new ImageIcon("src\\com.company\\resourses\\add2.png"));
       deleteButton.setIcon(new ImageIcon("src\\com.company\\resourses\\delete.png"));
       saveButton.setIcon(new ImageIcon("src\\com.company\\resourses\\save.png"));
       loadButton.setIcon(new ImageIcon("src\\com.company\\resourses\\load.png"));
       creatingTolbar();
       creatingMenu();
       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //jFrame.getContentPane().setLayout());
       renderTable();
   }

    public Table getTable() {
        return table;
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    private void creatingTolbar() {
        final JToolBar toolbar = new JToolBar("Toolbar", JToolBar.HORIZONTAL);
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new FindStudentView(dataBaseManipulation).createFindWindow();
            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new AddStudentView(dataBaseManipulation, tableToolbar);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new DeleteStudentView(dataBaseManipulation).createDeleteWindow();
                renderTable();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                studentBase.saveStudentBase();

            }
        });
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                studentBase.readStudentBase();
                pageWorker.setStudentList(studentBase.getStudents());
                tableToolbar.setPageWorker(pageWorker);
                tableToolbar.doClickLastPage();
                renderTable();
            }
        });
        toolbar.add(addButton);
        toolbar.add(findButton);
        toolbar.add(deleteButton);
        toolbar.add(saveButton);
        toolbar.add(loadButton);

        toolbar.setBounds(0,0,1600,50);
        jFrame.add(toolbar);
        jFrame.update(jFrame.getGraphics());

        jFrame.getContentPane().setLayout(null);
        toolbar.setBounds(0,0,1600,50);
        jFrame.add(toolbar);
        jFrame.update(jFrame.getGraphics());
        //jFrame.getContentPane().setLayout(null);
    }
    private void creatingMenu(){
        JMenuBar menuBar = new JMenuBar();
        jFrame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);
        fileMenu.add(new JMenuItem(new AbstractAction("Сохранить как...") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveButton.doClick();
            }
        }));
        fileMenu.add(new JMenuItem(new AbstractAction("Загрузить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loadButton.doClick();
            }
        }));

        JMenu dataBase = new JMenu("Cтудент");
        menuBar.add(dataBase);
        dataBase.add(new JMenuItem(new AbstractAction("Добавить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addButton.doClick();
            }
        }));
        dataBase.add(new JMenuItem(new AbstractAction("Удалить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            deleteButton.doClick();
            }
        }));
        dataBase.add(new JMenuItem(new AbstractAction("Поиск") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                findButton.doClick();
            }
        }));

        JMenu table = new JMenu("Страница");
        menuBar.add(table);
        table.add(new JMenuItem(new AbstractAction("Следующая страница") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                tableToolbar.getRightButton().doClick();
            }
        }));
        table.add(new JMenuItem(new AbstractAction("Предыдущая страница") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tableToolbar.getLeftButton().doClick();
            }
        }));
        table.add(new JMenuItem(new AbstractAction("Первая страница") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tableToolbar.getLeftButtonToEnd().doClick();
            }
        }));
        table.add(new JMenuItem(new AbstractAction("Последняя страница") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tableToolbar.getRightButtonToEnd().doClick();
            }
        }));
        table.add(new JMenuItem(new AbstractAction("Изменить размер страницы") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tableToolbar.getResizeButton().doClick();
            }
        }));
    }
   public void renderTable(){
        table.renderTable(pageWorker.returnPageOfStudents());
    }
}
