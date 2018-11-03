package com.imobiliaria.tabajara;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;


public class ViewClientCreate extends JFrame implements ActionListener {

    private  JTextField txt_code,
					    txt_name,         
					    txt_email,
					    txt_address,
					    txt_complement,
					    txt_city,
					    txt_balance;

    private JFormattedTextField txt_cpf, 
    							txt_birthday,
    							txt_phone;

    private JButton btn_add,
                    btn_search;

    private JPanel panelHeader,
                    panelSectionAdd,
                    panelSectionShow,
                    panelSectionSearch;


    private static final int SIZECOLUMN = 12;

    private static final int HPAG = 3;

    private static final int VPAG = 15;

    public ViewClientCreate(String title){

        super(title);

        JPanel panel        = new JPanel( new BorderLayout() );

        this.panelHeader        = new JPanel( new GridLayout(2,1) );
        this.panelSectionAdd    = new JPanel( new FlowLayout( FlowLayout.LEFT, HPAG, VPAG) );
        this.panelSectionShow   = new JPanel( new FlowLayout( FlowLayout.LEFT, HPAG, VPAG) );
        this.panelSectionSearch = new JPanel( new FlowLayout( FlowLayout.LEFT, HPAG, VPAG) );

        JTabbedPane panelTabs = new JTabbedPane();
        panelTabs.setBounds(50,50,200,200);
        
        this.setPanelHeader();
        this.setPanelSectionAdd();
        this.setPanelSectionSearch();
        
        panelTabs.add("Adicionar", this.panelSectionAdd);
        panelTabs.add("Procurar", this.panelSectionSearch);
        panelTabs.add("Mostrar", this.panelSectionShow);

        panel.add(panelHeader, BorderLayout.NORTH);
        panel.add(panelTabs, BorderLayout.CENTER);

        getContentPane().add(panel);

    }

    private void setPanelHeader(){

        //Configuração do título do cabeçalho
        JLabel textHeader = new JLabel( this.getTitle() + "\n");
        textHeader.setHorizontalAlignment(SwingConstants.CENTER);
        textHeader.setFont( new Font("Arial", Font.BOLD, 36) );
        textHeader.setForeground(Color.RED);
        this.panelHeader.add(textHeader, BorderLayout.NORTH);

        //Configuração do subtítulo do cabeçalho
        JLabel subTextHeader = new JLabel("Talvez seu dinheiro esteja aqui");
        subTextHeader.setHorizontalAlignment(SwingConstants.CENTER);
        subTextHeader.setForeground(Color.getColor("255,255,255"));
        this.panelHeader.add(subTextHeader, BorderLayout.NORTH);
    }

    private void setPanelSectionAdd(){

    	//Cria e adiciona campo código
    	JLabel lbl_code         = new JLabel(" Código");
        this.txt_code           = new JTextField(SIZECOLUMN);
        this.panelSectionAdd.add(lbl_code);
        this.panelSectionAdd.add(this.txt_code);

        //Cria e adiciona campo nome
        JLabel lbl_name         = new JLabel(" Nome");
	    this.txt_name 			= new JTextField(SIZECOLUMN);
        this.panelSectionAdd.add(lbl_name);
        this.panelSectionAdd.add(this.txt_name);

        //Cria e adiciona CPF
	    JLabel lbl_cpf       	= new JLabel(" CPF");
	    try{
		    MaskFormatter  maskCPF = new MaskFormatter("###.###.###-##");
		    this.txt_cpf = new JFormattedTextField(maskCPF);
		    this.txt_cpf.setColumns(SIZECOLUMN);
	    }catch(ParseException e) {
	        System.out.println(e);
	    }
        this.panelSectionAdd.add(lbl_cpf);
        this.panelSectionAdd.add(this.txt_cpf);

        //Cria e adiciona campo sexo
	    JLabel lbl_sex			= new JLabel(" Sexo");
        ButtonGroup groupSex 	= new ButtonGroup();
        JRadioButton male		= new JRadioButton("Masculino", true);
        JRadioButton female		= new JRadioButton("Feminio", false);
	    groupSex.add(male);
	    groupSex.add(female);
        this.panelSectionAdd.add(lbl_sex);
        this.panelSectionAdd.add(female);
        this.panelSectionAdd.add(male);

        //Cria e adiciona campo e-mail
	    JLabel lbl_email        = new JLabel(" E-mail");
	    this.txt_email 			= new JTextField(SIZECOLUMN);
        this.panelSectionAdd.add(lbl_email);
        this.panelSectionAdd.add(this.txt_email);

        //Cria e adiciona campo data de nascimento
        JLabel lbl_birthday     = new JLabel(" Data de Nascimento");
	    try{
		    MaskFormatter  maskBirthday	= new MaskFormatter("##/##/####");
		    this.txt_birthday = new JFormattedTextField(maskBirthday);
		    this.txt_birthday.setColumns(SIZECOLUMN / 2);
	    }catch(ParseException e) {
	        System.out.println(e);
	    }
        this.panelSectionAdd.add(lbl_birthday);
        this.panelSectionAdd.add(this.txt_birthday);

        //Cria e adiciona campo endereço
        JLabel lbl_address     	= new JLabel(" Endereço");
        this.txt_address		= new JTextField(SIZECOLUMN * 2);
        this.panelSectionAdd.add(lbl_address);
        this.panelSectionAdd.add(this.txt_address);

        //Cria e adiciona campo complemento
        JLabel lbl_complement 	= new JLabel(" Complemento");
	    this.txt_complement		= new JTextField(SIZECOLUMN);
        this.panelSectionAdd.add(lbl_complement);
        this.panelSectionAdd.add(this.txt_complement);

        //Cria e adiciona campo cidade
	    JLabel lbl_city 		= new JLabel(" Cidade");
	    this.txt_city			= new JTextField(SIZECOLUMN);
        this.panelSectionAdd.add(lbl_city);
        this.panelSectionAdd.add(this.txt_city);

        //Cria e adiciona campo UF
	    JLabel lbl_uf 			= new JLabel(" Estado");
	    JComboBox comboStates   = new JComboBox();
        for (States value : States.values()) {
	    	comboStates.addItem( value.getName() );
        }
        this.panelSectionAdd.add(lbl_uf);
        this.panelSectionAdd.add(comboStates);

        //Cria e adiciona campo telefone
        JLabel lbl_phone 		= new JLabel(" Telefone");
	    try{
		    MaskFormatter  maskPhone	= new MaskFormatter("(##)####-####");
		    this.txt_phone = new JFormattedTextField(maskPhone);
		    this.txt_phone.setColumns(SIZECOLUMN);
	    }catch(ParseException e) {
	        System.out.println(e);
	    }
        this.panelSectionAdd.add(lbl_phone);
        this.panelSectionAdd.add(this.txt_phone);

        //Cria e adiciona campo saldo
	    JLabel lbl_balance 		= new JLabel(" Saldo(R$)");
	    this.txt_balance		= new JTextField(SIZECOLUMN);
        this.panelSectionAdd.add(lbl_balance);
        this.panelSectionAdd.add(this.txt_balance);


        this.btn_add      = new JButton("Cadastrar");
        this.panelSectionAdd.add(this.btn_add);
        this.btn_add.addActionListener(this);
    }

    private void setPanelSectionSearch(){

        JLabel lbl_search = new JLabel("Pesquisar");
        PlaceholderTextField txt_search = new PlaceholderTextField( SIZECOLUMN  + 5);
        txt_search.setPlaceholder("Digite o código do cliente");

        this.btn_search = new JButton("procurar");


        this.panelSectionSearch.add(lbl_search);
        this.panelSectionSearch.add(txt_search);
        this.panelSectionSearch.add(this.btn_search);
        this.btn_search.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.btn_add){
            System.out.println("Adicionar");
        }

        if(e.getSource() == this.btn_search){
            System.out.println("Procurar");
        }

    }
}
