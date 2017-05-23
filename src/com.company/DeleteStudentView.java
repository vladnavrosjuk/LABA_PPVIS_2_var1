package com.company;

import com.company.control.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vlad on 19.05.2017.
 */
public class DeleteStudentView {
    private DataBaseManipulation dataBaseManipulation;
    private FindStudentView findStudentView;
    public DeleteStudentView(DataBaseManipulation dataBaseManipulation){
        findStudentView =new FindStudentView(dataBaseManipulation);
        this.dataBaseManipulation=dataBaseManipulation;
    }
    public void createDeleteWindow(){
           findStudentView.createElementsOfWindow("Удаление");
           findStudentView.getjDialog().setBounds(0, 0, 1600, 900);

           findStudentView.getFindByNameAndGroupButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   findStudentView.removeElements();
                   findStudentView.addFindByNameAndGroupElemens("Удаление",new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent actionEvent) {
                           int count = dataBaseManipulation.deleteStudentByNameAndGrop(findStudentView.getFirstData().getText(), findStudentView.getSecondData().getText());
                           findStudentView.getjDialog().setVisible(false);
                           if (count != 0) {
                               JOptionPane.showMessageDialog(new JFrame(), "Записей найдено и удалено " + count);
                           } else JOptionPane.showMessageDialog(new JFrame(), "Записей не найдено");
                       }
                   });
               }
           });

       /*findStudentView.getFindByNameAndWorkButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   findStudentView.removeElements();
                   findStudentView.addFindByNameAndWorkElemens("Удаление", new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent actionEvent) {
                           findStudentView.removeElements();
                           findStudentView.addFindByNameAndWorkElemens("Удаление",new ActionListener() {
                               @Override
                               public void actionPerformed(ActionEvent actionEvent) {
                                   int count = dataBaseManipulation.deleteStudentByNameAndWork(findStudentView.getFirstData().getText(), findStudentView.getSecondData().getText());
                                   findStudentView.getjDialog().setVisible(false);
                                   if (count != 0) {
                                       JOptionPane.showMessageDialog(new JFrame(), "Записей найдено и удалено " + count);
                                   } else JOptionPane.showMessageDialog(new JFrame(), "Записей не найдено");
                               }
                           });
                       }
                   });
               }
           });
*/
       findStudentView.getFindByNameNumberOfWorkButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   findStudentView.removeElements();
                   findStudentView.addFindByNameAndNumberOfWorkElemens("Удаление", new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent actionEvent) {
                           int count=dataBaseManipulation.deleteStudentByNameAndSrBall(findStudentView.getFirstData().getText(), findStudentView.getSecondData().getText(), findStudentView.getThirdData().getText());
                           findStudentView.getjDialog().setVisible(false);
                           if (count!=0){
                               JOptionPane.showMessageDialog(new JFrame(), "Записей найдено и удалено "+count);
                           }
                           else JOptionPane.showMessageDialog(new JFrame(), "Записей не найдено");
                       }
                   });
               }
           });


    }

}
