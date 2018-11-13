package com.imobiliaria.tabajara;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;


public class ViewClient extends JFrame implements ActionListener {


    private  JTextField txt_AddCode,
                        txt_AddName,
                        txt_AddEmail,
                        txt_AddAddress,
                        txt_AddComplement,
                        txt_AddCity,
                        txt_AddBalance,

                        txt_UptCode,
                        txt_UptName,
                        txt_UptEmail,
                        txt_UptAddress,
                        txt_UptComplement,
                        txt_UptCity,
                        txt_UptBalance;

    private JComboBox addComboStates, uptComboStates;

    private ButtonGroup addGroupSex, uptGroupSex;

    private JFormattedTextField txt_AddCpf,
            txt_AddBirthday,
            txt_AddPhone,

            txt_UptCpf,
            txt_UptBirthday,
            txt_UptPhone;

    private JRadioButton addSexMale, addSexFemale, uptSexMale, uptSexFemale;

    private JLabel  lbl_AddCode,
            lbl_AddName,
            lbl_AddCpf,
            lbl_AddSex,
            lbl_AddEmail,
            lbl_AddBirthday,
            lbl_AddAddress,
            lbl_AddComplement,
            lbl_AddCity,
            lbl_AddUf,
            lbl_AddPhone,
            lbl_AddBalance,

            lbl_UptCode,
            lbl_UptName,
            lbl_UptCpf,
            lbl_UptSex,
            lbl_UptEmail,
            lbl_UptBirthday,
            lbl_UptAddress,
            lbl_UptComplement,
            lbl_UptCity,
            lbl_UptUf,
            lbl_UptPhone,
            lbl_UptBalance;

    private JButton btn_add,
                    btn_remove,
                    btn_update,
                    btn_search;

    private JPanel panelHeader,
                    panelSectionAdd,
                    panelSectionShow,
                    panelSectionSearch;

    private PlaceholderTextField txt_search;

    private ClientRepository clientRepository;

    private DefaultTableModel modelTableClient;

    private JTable tableClient;

    private static final int SIZECOLUMN = 12;

    private static final int HPAG = 5;

    private static final int VPAG = 15;


    public ViewClient(String title){

        super(title);

        this.clientRepository = new ClientRepository(50);

        JPanel panel        = new JPanel( new BorderLayout() );

        this.panelHeader        = new JPanel( new GridLayout(2,1) );
        this.panelSectionAdd    = new JPanel(  new BorderLayout() );
        this.panelSectionShow   = new JPanel( new FlowLayout( FlowLayout.LEFT, HPAG, VPAG) );
        this.panelSectionSearch = new JPanel(  new BorderLayout() );

        JTabbedPane panelTabs = new JTabbedPane();
        panelTabs.setBounds(50,50,200,200);

        this.setLabels();
        
        this.setPanelHeader();
        this.setPanelSectionSearch(null);
        this.setPanelSectionAdd();
        this.setPanelSectionShow();

        panelTabs.add("Adicionar", this.panelSectionAdd);
        panelTabs.add("Atualizar", this.panelSectionSearch);
        panelTabs.add("Exibir", this.panelSectionShow);

        panel.add(panelHeader, BorderLayout.NORTH);
        panel.add(panelTabs, BorderLayout.CENTER);


        getContentPane().add(panel);

    }

    private void setLabels(){
        String code = " Nº da Conta*";
        String name =   " Nome*";
        String cpf =  " CPF*";
        String sex = " Sexo";
        String email =   " E-mail" ;
        String birthday = " Data de Nascimento" ;
        String address = " Endereço";
        String complement = " Complemento" ;
        String city = " Cidade";
        String uf = " Estado";
        String phone = " Telefone";
        String balance = " Saldo(R$)";

        this.lbl_AddCode        = new JLabel(code);
        this.lbl_AddName        = new JLabel(name);
        this.lbl_AddCpf         = new JLabel(cpf);
        this.lbl_AddSex         = new JLabel(sex);
        this.lbl_AddEmail       = new JLabel(email);
        this.lbl_AddBirthday    = new JLabel(birthday);
        this.lbl_AddAddress     = new JLabel(address);
        this.lbl_AddComplement  = new JLabel(complement);
        this.lbl_AddCity        = new JLabel(city);
        this.lbl_AddUf          = new JLabel(uf);
        this.lbl_AddPhone       = new JLabel(phone);
        this.lbl_AddBalance     = new JLabel(balance);

        this.lbl_UptCode         = new JLabel(code);
        this.lbl_UptName         = new JLabel(name);
        this.lbl_UptCpf          = new JLabel(cpf);
        this.lbl_UptSex          = new JLabel(sex);
        this.lbl_UptEmail        = new JLabel(email);
        this.lbl_UptBirthday     = new JLabel(birthday);
        this.lbl_UptAddress      = new JLabel(address);
        this.lbl_UptComplement   = new JLabel(complement);
        this.lbl_UptCity         = new JLabel(city);
        this.lbl_UptUf           = new JLabel(uf);
        this.lbl_UptPhone        = new JLabel(phone);
        this.lbl_UptBalance      = new JLabel(balance);
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
        GridLayout gridLayout = new GridLayout(12,2);
        JPanel formPanel = new JPanel();
        formPanel.setLayout(gridLayout);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);

        //Cria e adiciona campo código
        this.txt_AddCode       = new JTextField(SIZECOLUMN);
        formPanel.add(this.lbl_AddCode);
        formPanel.add(this.txt_AddCode);

        //Cria e adiciona campo nome
        this.txt_AddName       = new JTextField(SIZECOLUMN);
        formPanel.add(this.lbl_AddName);
        formPanel.add(this.txt_AddName);

        //Cria e adiciona CPF
        try{
            MaskFormatter  maskCPF = new MaskFormatter("###.###.###-##");
            this.txt_AddCpf = new JFormattedTextField(maskCPF);
            this.txt_AddCpf.setColumns(SIZECOLUMN);
        }catch(ParseException e) {
            System.out.println(e);
        }
        formPanel.add(this.lbl_AddCpf);
        formPanel.add(this.txt_AddCpf);

        //Cria e adiciona campo sexo
        JPanel panel = new JPanel();
        this.addGroupSex           = new ButtonGroup();
        this.addSexMale            = new JRadioButton("Masculino", true);
        this.addSexFemale          = new JRadioButton("Feminio", false);

        this.addGroupSex.add(this.addSexMale);
        this.addGroupSex.add(this.addSexFemale);

        panel.add(this.addSexMale);
        panel.add(this.addSexFemale);

        formPanel.add(this.lbl_AddSex);
        formPanel.add(panel);

        //Cria e adiciona campo e-mail
        this.txt_AddEmail       = new JTextField(SIZECOLUMN);
        formPanel.add(this.lbl_AddEmail);
        formPanel.add(this.txt_AddEmail);

        //Cria e adiciona campo data de nascimento
        try{
            MaskFormatter  maskBirthday = new MaskFormatter("##/##/####");
            this.txt_AddBirthday = new JFormattedTextField(maskBirthday);
            this.txt_AddBirthday.setColumns(SIZECOLUMN / 2);
        }catch(ParseException e) {
            System.out.println(e);
        }
        formPanel.add(this.lbl_AddBirthday);
        formPanel.add(this.txt_AddBirthday);

        //Cria e adiciona campo endereço
        this.txt_AddAddress                = new JTextField(SIZECOLUMN * 2);
        formPanel.add(this.lbl_AddAddress);
        formPanel.add(this.txt_AddAddress);

        //Cria e adiciona campo complemento
        this.txt_AddComplement             = new JTextField(SIZECOLUMN);
        formPanel.add(this.lbl_AddComplement);
        formPanel.add(this.txt_AddComplement);

        //Cria e adiciona campo cidade
        this.txt_AddCity                   = new JTextField(SIZECOLUMN);
        formPanel.add(this.lbl_AddCity);
        formPanel.add(this.txt_AddCity);

        //Cria e adiciona campo UF
        this.addComboStates   = new JComboBox();
        for (States value : States.values()) {
            this.addComboStates.addItem( value.getName() );
        }
        formPanel.add(this.lbl_AddUf);
        formPanel.add(this.addComboStates);

        //Cria e adiciona campo telefone
        try{
            MaskFormatter  maskPhone    = new MaskFormatter("(##)####-####");
            this.txt_AddPhone = new JFormattedTextField(maskPhone);
            this.txt_AddPhone.setColumns(SIZECOLUMN);
        }catch(ParseException e) {
            System.out.println(e);
        }
        formPanel.add(this.lbl_AddPhone);
        formPanel.add(this.txt_AddPhone);

        //Cria e adiciona campo saldo
        this.txt_AddBalance                = new JTextField(SIZECOLUMN);
        this.txt_AddBalance.setText("0.0");
        formPanel.add(this.lbl_AddBalance);
        formPanel.add(this.txt_AddBalance);

        this.panelSectionAdd.add(formPanel, BorderLayout.CENTER);
        //SpringUtilities.makeGrid(formPanel, 12, 2, 10, 10, HPAG, HPAG );


        JPanel panelButton = new JPanel( new FlowLayout(FlowLayout.RIGHT,10,10) );
        this.btn_add      = new JButton("Cadastrar");
        this.btn_add.setPreferredSize(new Dimension(200, 30));
        panelButton.add(this.btn_add);
        this.panelSectionAdd.add(panelButton, BorderLayout.SOUTH);
        this.btn_add.addActionListener(this);

    }

    private void setPanelSectionSearch(Client client){

        JPanel panelHeader = new JPanel( new FlowLayout() );

        this.panelSectionSearch.removeAll();

        JLabel lbl_search = new JLabel("Pesquisar");

        txt_search = new PlaceholderTextField( SIZECOLUMN  + 5);
        txt_search.setPlaceholder("Digite o código do cliente");

        this.btn_search = new JButton("procurar");

        panelHeader.add(lbl_search);
        panelHeader.add(this.txt_search);
        panelHeader.add(this.btn_search);

        this.panelSectionSearch.add(panelHeader, BorderLayout.NORTH);


        if(client == null) {
            JPanel panel = new JPanel();
            JLabel lbl_wearning = new JLabel("Nada encontrado");
            panel.add(lbl_wearning);
            panelSectionSearch.add(panel, BorderLayout.CENTER);

        }else{

            String code =  client.getNumber();
            String name =   client.getName();
            String cpf =  client.getCPF();
            char sex =  client.getSex();
            String email =     client.getEmail();
            String birthday =   client.getBirthday();
            String address =  client.getAddress();
            String complement =  client.getComplement();
            String city =  client.getCity();
            String uf =  client.getUf();
            String phone =  client.getPhone();
            double balance =  client.getBalance();

            GridLayout gridLayout = new GridLayout(12,2);
            JPanel formPanel = new JPanel();
            formPanel.setLayout(gridLayout);
            gridLayout.setHgap(10);
            gridLayout.setVgap(10);

            //Cria e adiciona campo código
            this.txt_UptCode = new JTextField(SIZECOLUMN);
            this.txt_UptCode.setText( code );
            formPanel.add(this.lbl_UptCode);
            formPanel.add(this.txt_UptCode);

            //Cria e adiciona campo nome
            this.txt_UptName = new JTextField(SIZECOLUMN);
            this.txt_UptName.setText(name);
            formPanel.add(this.lbl_UptName);
            formPanel.add(this.txt_UptName);

            //Cria e adiciona CPF
            try {
                MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");
                this.txt_UptCpf = new JFormattedTextField(maskCPF);
                this.txt_UptCpf.setColumns(SIZECOLUMN);
                this.txt_UptCpf.setText(cpf);
            } catch (ParseException e) {
                System.out.println(e);
            }
            formPanel.add(this.lbl_UptCpf);
            formPanel.add(this.txt_UptCpf);

            //Cria e adiciona campo sexo
            JPanel panel = new JPanel();

            this.uptGroupSex = new ButtonGroup();

            this.uptSexMale = new JRadioButton("Masculino", sex == 'm' ? true : false );
            this.uptSexFemale = new JRadioButton("Feminio", sex == 'f' ? true : false);

            this.uptGroupSex.add(this.uptSexMale);
            this.uptGroupSex.add(this.uptSexFemale);

            formPanel.add(this.lbl_UptSex);

            panel.add(this.uptSexMale);
            panel.add(this.uptSexFemale);

            formPanel.add(panel);

            //Cria e adiciona campo e-mail
            this.txt_UptEmail = new JTextField(SIZECOLUMN);
            this.txt_UptEmail.setText(email);
            formPanel.add(this.lbl_UptEmail);
            formPanel.add(this.txt_UptEmail);

            //Cria e adiciona campo data de nascimento
            try {
                MaskFormatter maskBirthday = new MaskFormatter("##/##/####");
                this.txt_UptBirthday = new JFormattedTextField(maskBirthday);
                this.txt_UptBirthday.setColumns(SIZECOLUMN / 2);
                this.txt_UptBirthday.setText(birthday);
            } catch (ParseException e) {
                System.out.println(e);
            }
            formPanel.add(this.lbl_UptBirthday);
            formPanel.add(this.txt_UptBirthday);

            //Cria e adiciona campo endereço
            this.txt_UptAddress = new JTextField(SIZECOLUMN * 2);
            this.txt_UptAddress.setText(address);
            formPanel.add(this.lbl_UptAddress);
            formPanel.add(this.txt_UptAddress);

            //Cria e adiciona campo complemento
            this.txt_UptComplement = new JTextField(SIZECOLUMN);
            this.txt_UptComplement.setText(complement);
            formPanel.add(this.lbl_UptComplement);
            formPanel.add(this.txt_UptComplement);

            //Cria e adiciona campo cidade
            this.txt_UptCity = new JTextField(SIZECOLUMN);
            this.txt_UptCity.setText(city);
            formPanel.add(this.lbl_UptCity);
            formPanel.add(this.txt_UptCity);

            //Cria e adiciona campo UF
            int selectedState = 0 , i = 0;
            this.uptComboStates = new JComboBox();
            for (States value : States.values()) {

                if( value.getUF().equalsIgnoreCase(uf) )
                    selectedState = i;

                this.uptComboStates.addItem(value.getName());

                i++;
            }

            this.uptComboStates.setSelectedIndex(selectedState);
            formPanel.add(this.lbl_UptUf);
            formPanel.add(this.uptComboStates);

            //Cria e adiciona campo telefone
            try {
                MaskFormatter maskPhone = new MaskFormatter("(##)####-####");
                this.txt_UptPhone = new JFormattedTextField(maskPhone);
                this.txt_UptPhone.setColumns(SIZECOLUMN);
                this.txt_UptPhone.setText(phone);
            } catch (ParseException e) {
                System.out.println(e);
            }
            formPanel.add(this.lbl_UptPhone);
            formPanel.add(this.txt_UptPhone);

            //Cria e adiciona campo saldo
            this.txt_UptBalance = new JTextField(SIZECOLUMN);
            this.txt_UptBalance.setText( String.valueOf(balance) );
            formPanel.add(this.lbl_UptBalance);
            formPanel.add(this.txt_UptBalance);


            this.panelSectionSearch.add(formPanel, BorderLayout.CENTER);

            //Botão de atualizar
            JPanel panelButton = new JPanel( new FlowLayout(FlowLayout.RIGHT,10,10) );
            this.btn_update = new JButton("Atualizar");
            this.btn_update.setPreferredSize(new Dimension(200, 30));
            this.btn_update.addActionListener(this);
            panelButton.add(this.btn_update);

            this.panelSectionSearch.add(panelButton, BorderLayout.SOUTH);

        }

        this.btn_search.addActionListener(this);
    }

    private void setPanelSectionShow() {

        this.panelSectionShow.removeAll();

        this.btn_remove = new JButton("Remover");
        this.panelSectionShow.add(this.btn_remove);
        this.btn_remove.addActionListener(this);

        this.tableClient = new JTable();

        String[] namesColumns = {"Código", "Nome", "CPF", "Saldo"};

        //essa lista terá as linhas da sua JTable
        Client[] allClient = this.clientRepository.getItems();

        //essa lista terá as linhas da sua JTable, preenchi abaixo apenas como exemplo
        ArrayList<String[]> lista = new ArrayList<String[]>();

        if (allClient != null){
            //aqui você fará um while percorrendo seu result set e adicionando na lista
            for (Client client : allClient) {
                lista.add(new String[]{client.getNumber(), client.getName(), client.getCPF(), Double.toString(client.getBalance())});
            }
        }

        //crie um defaultablemodel com as informações acima
        this.modelTableClient = new DefaultTableModel(
                        lista.toArray(new String[lista.size()][]), namesColumns);
        //define o model da sua tabela
        this.tableClient.setModel(this.modelTableClient);

        //adiciona no contentpane, coloque dentro de um JScrollPane pois caso
        //contrário não aparecerão os nomes das colunas
        this.panelSectionShow.add(new JScrollPane(this.tableClient), BorderLayout.CENTER);
    }

    private void setCleanFieldsUpt(Client client){

        this.txt_UptCode.setText( " " );
        this.txt_UptName.setText("");
        this.txt_UptCpf.setText("");
        this.uptGroupSex.clearSelection();
        this.txt_UptBirthday.setText("");
        this.txt_UptEmail.setText("");
        this.txt_UptAddress.setText("");
        this.txt_UptComplement.setText("");
        this.txt_UptCity.setText("");
        this.uptComboStates.setSelectedItem(0);
        this.txt_UptPhone.setText("");
        this.txt_UptBalance.setText( "0.0" );

        this.txt_UptName.requestFocus();

    }

    private void setCleanFieldsAdd(){

        this.txt_AddCode.setText("");
        this.txt_AddName.setText("");
        this.txt_AddCpf.setText("");
        this.addGroupSex.clearSelection();
        this.txt_AddBirthday.setText("");
        this.txt_AddEmail.setText("");
        this.txt_AddAddress.setText("");
        this.txt_AddComplement.setText("");
        this.txt_AddCity.setText("");
        this.addComboStates.setSelectedItem(0);
        this.txt_AddPhone.setText("");
        this.txt_AddBalance.setText( "0.0" );

        this.txt_AddName.requestFocus();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.btn_add){

            String number       = this.txt_AddCode.getText().trim();
            String name         = this.txt_AddName.getText().trim();
            String cpf          = this.txt_AddCpf.getText().trim();
            char sex            = this.addSexMale.isSelected() ? 'm' : 'f';
            String birthday     = this.txt_AddBirthday.getText().trim();
            String email        = this.txt_AddEmail.getText().trim();
            String address      = this.txt_AddAddress.getText().trim();
            String complement   = this.txt_AddComplement.getText().trim();
            String city         = this.txt_AddCity.getText().trim();
            String uf           = States.search( this.addComboStates.getSelectedItem().toString() )[0] ;
            String phone        = this.txt_AddPhone.getText().trim();
            double balance      = Double.parseDouble( this.txt_AddBalance.getText().trim() );

            Client client = new Client(number, name, cpf,sex, birthday, email, address, complement, city, uf, phone,  balance);

            try {
                if (!name.isEmpty() && !cpf.isEmpty() && !number.isEmpty()) {

                    this.clientRepository.add(client);
                    this.setPanelSectionShow();
                    this.setCleanFieldsAdd();
                    JOptionPane.showMessageDialog(null, "Conta criada!");
                } else
                    JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos obrigatórios!", "Alerta", JOptionPane.WARNING_MESSAGE);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Conta já existe!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        if( e.getSource() == this.btn_update ){
            System.out.println("Atualizar");
            String number       = this.txt_UptCode.getText().trim();
            String name         = this.txt_UptName.getText().trim();
            String cpf          = this.txt_UptCpf.getText().trim();
            char sex            = this.uptSexMale.isSelected() ? 'm' : 'f';
            String birthday     = this.txt_UptBirthday.getText().trim();
            String email        = this.txt_UptEmail.getText().trim();
            String address      = this.txt_UptAddress.getText().trim();
            String complement   = this.txt_UptComplement.getText().trim();
            String city         = this.txt_UptCity.getText().trim();
            String uf           = States.search( this.uptComboStates.getSelectedItem().toString() )[0] ;
            String phone        = this.txt_UptPhone.getText().trim();
            double balance      = Double.parseDouble( this.txt_UptBalance.getText().trim() );

            Client client = new Client(number, name, cpf,sex, birthday, email, address, complement, city, uf, phone,  balance);

            try {
                if (!name.isEmpty() && !cpf.isEmpty() && !number.isEmpty()) {
                    this.clientRepository.update(client);
                    this.setPanelSectionShow();
                    this.setCleanFieldsAdd();
                    JOptionPane.showMessageDialog(null, "Conta atualizada!");
                } else
                    JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos!", "Alerta", JOptionPane.WARNING_MESSAGE);
            }catch (NullPointerException ex){
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Conta já existe!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(e.getSource() == this.btn_remove){

            try {

                System.out.println("Remover");

                //recebe o índice da linha  selecionada
                int line = this.tableClient.getSelectedRow();

                //Verifica se uma linha foi selecionada
                if( line >= 0) {
                    //pega o valor da primeira coluna, na linha que está selecionada
                    String code = (String) this.tableClient.getValueAt(line, 0);

                    //remove a linha na tabela
                    ((DefaultTableModel) this.tableClient.getModel()).removeRow(line);

                    //remove o objeto client no repositório
                    this.clientRepository.remove(code);
                }

            }catch(NullPointerException ex){
                System.out.println(ex);
            }
        }

        if(e.getSource() == this.btn_search){
            System.out.println("Procurar");

            String code = this.txt_search.getText().trim();

            Client client = clientRepository.search(code);


            this.setPanelSectionSearch(client);
        }

    }
}
