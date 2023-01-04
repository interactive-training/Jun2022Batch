package com.InteractiveTrainingAcademy.utility;
import javax.swing.JOptionPane;

public class Msgbox {
    public static void Msgbox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void Msgbox(String infoMessage)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: Title goes here", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String args[]){

        Msgbox("Pramod");
    }



}
//
// class test{
//
//    public static void main(String args[]){
//        System.out.println("outline");
//
//        Msgbox("Where are you");
//
//    }
//}