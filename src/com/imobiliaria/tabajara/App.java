package com.imobiliaria.tabajara;

import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {

        ViewClient gui = new ViewClient("Tabajara Bank");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(480, 750);
        gui.setVisible(true);

    }
}
