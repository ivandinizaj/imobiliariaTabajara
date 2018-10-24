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
                        text_countRoom,
                        text_price,
                        text_countBathroom;

    private JButton btn_previous,
                    btn_next,
                    btn_last,
                    btn_first;

    private JPanel panelHeader,
                    panelSection,
                    panelFooter;

    private static final int SIZECOLUMN = 12;

    private static final int HPAG = 3;

    private static final int VPAG = 15;

    public GUI(String title){

        super(title);

        JPanel panel        = new JPanel( new BorderLayout() );

        this.panelHeader    = new JPanel( new GridLayout(2,1) );
        this.panelSection   = new JPanel( new FlowLayout(FlowLayout.LEFT, HPAG, VPAG) );
        this.panelFooter    = new JPanel( new FlowLayout() );

        this.setPanelHeader();
        this.setPanelSection();
        this.setPanelFooter();

        panel.add(panelHeader, BorderLayout.NORTH);
        panel.add(panelSection, BorderLayout.CENTER);
        panel.add(panelFooter, BorderLayout.SOUTH);

        getContentPane().add(panel);

    }

    private void setPanelHeader(){

        //Configuração do título do cabeçalho
        JLabel textHeader = new JLabel("Imobiliária Tabajara \n");
        textHeader.setHorizontalAlignment(SwingConstants.CENTER);
        textHeader.setFont( new Font("Arial", Font.BOLD, 36) );
        textHeader.setForeground(Color.RED);
        this.panelHeader.add(textHeader, BorderLayout.NORTH);

        //Configuração do subtítulo do cabeçalho
        JLabel subTextHeader = new JLabel("Seu imóvel está aqui");
        subTextHeader.setHorizontalAlignment(SwingConstants.CENTER);
        subTextHeader.setForeground(Color.RED);
        this.panelHeader.add(subTextHeader, BorderLayout.NORTH);
    }

    private void setPanelSection(){

        this.text_code          = new JTextField(SIZECOLUMN / 2);
        this.text_area          = new JTextField( SIZECOLUMN );
        this.text_garages       = new JTextField(SIZECOLUMN / 2);
        this.text_typeImmobile  = new JTextField( SIZECOLUMN );
        this.text_countRoom     = new JTextField(SIZECOLUMN / 2);
        this.text_price         = new JTextField( SIZECOLUMN );
        this.text_countBathroom = new JTextField(SIZECOLUMN / 2);

        JLabel lbl_code          = new JLabel(" Código");
        JLabel lbl_area          = new JLabel(" Área");
        JLabel lbl_garages       = new JLabel(" Garagens");
        JLabel typeImmobile      = new JLabel(" Tipo do Móvel");
        JLabel lbl_countRoom     = new JLabel(" Nº de Quartos");
        JLabel lbl_price         = new JLabel(" Preço do Imóvel");
        JLabel lbl_countBathroom = new JLabel(" Nº de Banheiros");

        panelSection.add(lbl_code);
        panelSection.add(this.text_code);

        panelSection.add(typeImmobile);
        panelSection.add(this.text_typeImmobile);

        panelSection.add(lbl_area);
        panelSection.add(this.text_area);

        panelSection.add(lbl_garages);
        panelSection.add(this.text_garages);

        panelSection.add(lbl_countRoom);
        panelSection.add(this.text_countRoom);

        panelSection.add(lbl_countBathroom);
        panelSection.add(this.text_countBathroom);

        panelSection.add(lbl_price);
        panelSection.add(this.text_price);
    }

    private void setPanelFooter(){

        this.btn_first      = new JButton("Primeiro");
        this.btn_last       = new JButton("Último");
        this.btn_previous   = new JButton("Anterior");
        this.btn_next       = new JButton("Próximo");

        this.panelFooter.add(this.btn_last);
        this.panelFooter.add(this.btn_previous);
        this.panelFooter.add(this.btn_next);
        this.panelFooter.add(this.btn_first);

        this.btn_last.addActionListener(this);
        this.btn_previous.addActionListener(this);
        this.btn_next.addActionListener(this);
        this.btn_first.addActionListener(this);

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
