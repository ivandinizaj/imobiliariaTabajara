package com.imobiliaria.tabajara;

import javax.swing.JFrame;

public class main {

    public static void main(String[] args) {

        GUI gui = new GUI("Tabajara Imobiliária");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(600, 220);
        gui.setVisible(true);

    }
}
