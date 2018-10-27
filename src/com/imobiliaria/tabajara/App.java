package com.imobiliaria.tabajara;

import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {

        ViewClientCreate gui = new ViewClientCreate("Tabajara Imobiliária");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(550, 280);
        gui.setVisible(true);

    }
}
