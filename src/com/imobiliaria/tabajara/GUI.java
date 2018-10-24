package com.imobiliaria.tabajara;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    private  JTextField text_code,
                        text_area,
                        text_garages,
                        text_typeImmobile,
                        text_room,
                        text_price,
                        text_countBathroom;

    private JButton btn_previous,
                    btn_next,
                    btn_last,
                    btn_first;

    private int sizeColumn;


    public GUI(String title){

        super(title);

        JPanel panel          = new JPanel( new BorderLayout() );

        JPanel panelSection   = new JPanel( new FlowLayout(FlowLayout.LEFT) );
        JPanel panelFooter    = new JPanel( new FlowLayout() );

        panel.add(panelSection, BorderLayout.CENTER);

        this.sizeColumn = 12;

        JLabel textHeader = new JLabel("Imobiliária Tabajara \n");
        textHeader.setFont( new Font("Arial", Font.PLAIN, 24) );

        panel.add(textHeader, BorderLayout.NORTH);

        JLabel lbl_code          = new JLabel("Código");
        JLabel lbl_area          = new JLabel("Área");
        JLabel lbl_garages       = new JLabel("Garagens");
        JLabel typeImmobile      = new JLabel("Tipo do Móvel");
        JLabel lbl_room          = new JLabel("Quartos");
        JLabel lbl_price         = new JLabel("Preço do Imóvel");
        JLabel lbl_countBathroom = new JLabel("Nº de Banheiros");

        //Atribui configuraões aos componentes
        this.setComponents();

        panelSection.add(lbl_code);
        panelSection.add(this.text_code);
        panelSection.add(lbl_area);
        panelSection.add(this.text_area);
        panelSection.add(lbl_garages);
        panelSection.add(this.text_garages);
        panelSection.add(typeImmobile);
        panelSection.add(this.text_typeImmobile);
        panelSection.add(lbl_room);
        panelSection.add(this.text_room);
        panelSection.add(lbl_price);
        panelSection.add(this.text_price);
        panelSection.add(lbl_countBathroom);
        panelSection.add(this.text_countBathroom);

        panelFooter.add(this.btn_last);
        panelFooter.add(this.btn_previous);
        panelFooter.add(this.btn_next);
        panelFooter.add(this.btn_first);

        this.btn_last.addActionListener(this);
        this.btn_previous.addActionListener(this);
        this.btn_next.addActionListener(this);
        this.btn_first.addActionListener(this);

        panel.add(panelFooter, BorderLayout.SOUTH);

        getContentPane().add(panel);

    }

    public void  setComponents(){

        this.btn_first      = new JButton("Primeiro");
        this.btn_last       = new JButton("Último");
        this.btn_previous   = new JButton("Anterior");
        this.btn_next       = new JButton("Próximo");

        this.text_code          = new JTextField(this.sizeColumn);
        this.text_area          = new JTextField(this.sizeColumn);
        this.text_garages       = new JTextField(this.sizeColumn);
        this.text_typeImmobile  = new JTextField(this.sizeColumn);
        this.text_room          = new JTextField(this.sizeColumn);
        this.text_price         = new JTextField(this.sizeColumn);
        this.text_countBathroom = new JTextField(this.sizeColumn);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.btn_first){
            System.out.println("Primeiro");
        }

        if(e.getSource() == this.btn_last){
            System.out.println("Ùltimo");
        }

        if(e.getSource() == this.btn_previous){
            System.out.println("Anterior");
        }

        if(e.getSource() == this.btn_next){
            System.out.println("Próximo");
        }

    }
}
