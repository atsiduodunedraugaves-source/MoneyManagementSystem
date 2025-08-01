package Front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvwwww
import javax.swing.*;

import Header.Loans;
import Header.SettingData;
import Header.Settings;
import Header.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import java.awt.Font;
import java.awt.GridLayout;



public class GUI extends JFrame implements ActionListener {

    boolean triggered =  false;

    //kartai kiek bandyta
    static int bandyta = 0;
    static int galimabadyti = 2;
    static int Multiplier = 1;
    static int removeExses =0;

    
    


    String changing = "";
    int kiek = 0;
    double suma = 0;

    int kiek2 = 0;
    double suma2 = 0;

  // Time that can be modified to extend the penalty for password incorect
   static int Time = 2000;

// masyvas matomas visiem tam kad galeciau nadoti kituose if statmentuose
    ArrayList<Income> in2 = new ArrayList<>();
    ArrayList<Spent> in2s = new ArrayList<>();


        CODE code;
        
        CodeSpent codeSpend;

        


      JTextField IncomeTEXT;
      JTextField SavedTEXT;


    JPanel header;
    JPanel Income;
    JPanel Spent;
    JPanel SpentFROMto;
    JPanel IncomeFROMto;
    JPanel SpentExtra;
    JPanel IncomeExtra;
    JTextField s1;
    JTextField s2;
    JButton s3;
    JButton s4;

    JTextField i1;
    JTextField i2;
    JButton i3;
    JButton i4;

    JScrollPane scrollPane;
    JScrollPane scrollPane2;
    JTextArea SpentData;
    JTextArea IncomeData;


    JButton calculator;
    JButton potential;
    JButton loans;
    JButton Atsijungti;

    JTextField kiekIncome;
    JTextField totalIncome;
    JButton IncomeADD;
    JButton IncomeREMOVE;
    JButton IncomeCHANGE;
    
    JTextField kiekSpent;
    JTextField TotalSpent;
    JButton SpentADD;
    JButton SpentREMOVE;
    JButton SpentCHANGE;

    JButton Atsaukti;
    JButton Atsaukti2;
    JButton Atsaukti3;
    JButton IncomeCancel;
    JButton IncomeCancel2;
    JButton IncomeCancel3;



    JButton AtsauktiSPEND;
    JButton Atsaukti2SPEND;
    JButton Atsaukti3SPEND;
    JButton IncomeCancelSPEND;
    JButton IncomeCancel2SPEND;
    JButton IncomeCancel3SPEND;

    JPanel infoForIncome;
    JPanel infoForSpend;

    // income add
    JTextField B6;
    JButton B11button;
    JTextField B11field;
    JTextField B22;
    JTextField B33;
    JTextField B44;
    JButton B55button1;
    JButton B55button2;
    JButton B55button3;
    JCheckBox agreetoadd;

    JPanel ADD;
    JPanel ADDextenction1;
    JPanel ADDextenction2;
     // income add


     // SPEND ADD

      JTextField B6SPEND;
    JButton B11buttonSPEND;
    JTextField B11fieldSPEND;
    JTextField B22SPEND;
    JTextField B33SPEND;
    JTextField B44SPEND;
    JButton B55button1SPEND;
    JButton B55button2SPEND;
    JCheckBox agreetoaddSPEND;

    JPanel ADDSPEND;
    JPanel ADDextenction1SPEND;
    JPanel ADDextenction2SPEND;

     // SPEND ADD

    String gryniarkortele = "";


    //Income remove
    JPanel Income2ND;
    JPanel incoRem1st;
    JPanel incoDATA;
    JPanel incoCHECKBOXPLACE;
    
    JTextField Incoremdata;
    JTextArea InforRemoveADDinfo;
    JButton removeButtREm;
    JButton Incoremdbutton;
    JCheckBox InfoREMcheck;
    JTextField Seartchincotoremove;
    JButton searchtheid;
    //Income remove


    //Spend remove

    JPanel Income2NDSPEND;
    JPanel incoRem1stSPEND;
    JPanel incoDATASPEND;
    JPanel incoCHECKBOXPLACESPEND;
    
    JTextField IncoremdataSPEND;
    JTextArea InforRemoveADDinfoSPEND;
    JButton removeButtREmSPEND;
    JButton IncoremdbuttonSPEND;
    JCheckBox InfoREMcheckSPEND;
    JTextField SeartchincotoremoveSPEND;
    JButton searchtheidSPEND;

    //Spend remove

    //icncome change

    JPanel Income2NDCHANGE;
    JPanel incoRem1stCHANGE;
    JPanel incoDATACHANGE;
    JPanel incoCHECKBOXPLACECHANGE;
    
    JTextField IncoremdataCHANGE;
    JTextArea InforRemoveADDinfoCHANGE;
    JButton removeButtREmCHANGE;
    JButton IncoremdbuttonCHANGE;
    JCheckBox InfoREMcheckCHANGE;
    JTextField SeartchincotoremoveCHANGE;
    JButton searchtheidCHANGE;


    JPanel infoABOUT;
    
    JPanel ChooseChange;
    JTextField inputaboutchange;
    JTextField problems;
    JTextField keisti;

    JPanel butpanel;
    JButton but1;
    JButton but2;
    JButton but3;
    JButton but4;
    JButton but5;

    JButton keistiinfosubuuton;

    JTextField text2;

    //icncome change


    // spend change
    JPanel Income2NDCHANGESPEND;
    JPanel incoRem1stCHANGESPEND;
    JPanel incoDATACHANGESPEND;
    JPanel incoCHECKBOXPLACECHANGESPEND;
    
    JTextField IncoremdataCHANGESPEND;
    JTextArea InforRemoveADDinfoCHANGESPEND;
    JButton removeButtREmCHANGESPEND;
    JButton IncoremdbuttonCHANGESPEND;
    JCheckBox InfoREMcheckCHANGESPEND;
    JTextField SeartchincotoremoveCHANGESPEND;
    JButton searchtheidCHANGESPEND;


    JPanel infoABOUTSPEND;
    
    JPanel ChooseChangeSPEND;
    JTextField inputaboutchangeSPEND;
    JTextField problemsSPEND;
    JTextField keistiSPEND;

    JPanel butpanelSPEND;
    JButton but1SPEND;
    JButton but2SPEND;
    JButton but3SPEND;
    JButton but4SPEND;
    JButton but5SPEND;

    JButton keistiinfosubuutonSPEND;

    JTextField text2SPEND;

    static StringBuilder pass = new StringBuilder();



        //passwword

        JPanel password;
        JPanel password2;
        static JTextArea input;
        static JButton p1;
        static JButton p2;
        static JButton p3;
        static JButton p4;
        static JButton p5;
        static JButton p6;
        static JButton p7;
        static JButton p8;
        static JButton p9;
        static JButton p10;
        static JButton p11;
        static JButton p12;


        // password

// spend change

    
    GUI(){

        //pasword punishmend etc
        UserSettings();

        this.setLayout(new BorderLayout());
 
        //Other codes functions

        this.code = new CODE();
        this.codeSpend = new CodeSpent();

        //Other codes functions









        // preload info -----------------------------------------
       
        // info data loading INCOME

        IncomeData = new JTextArea();
        IncomeData.setFont(new Font("Monospaced", Font.BOLD, 14));
        IncomeData.setBounds(70,200,700,400);

        ArrayList<Income> income = code.show();
        StringBuilder bd = new StringBuilder();


        for(Income s : income){
        bd.append(s).append("\n");
        }

        IncomeData.append(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
        IncomeData.append("------------------------------------------------------------------------------------\n");

        IncomeData.append(bd.toString());
                 


        SpentData = new JTextArea();
        SpentData.setBounds(810,200,700,400);
        SpentData.setFont(new Font("Monospaced", Font.BOLD, 14));
      

        ArrayList<Spent> InfoSpend = codeSpend.showSPEND();
        StringBuilder bdSpend = new StringBuilder();

       for(Spent s : InfoSpend){
        bdSpend.append(s).append("\n");
        }

         // info data loading INCOME


         // info data loading SPend
         
        SpentData.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
        SpentData.append("------------------------------------------------------------------------------------\n");

        SpentData.append(bdSpend.toString());


        kiekSpent = new JTextField();
        kiekSpent.setEditable(false);
        kiekSpent.setPreferredSize(new Dimension(300,60));
        kiekSpent.setFont(new Font("Monospaced", Font.BOLD, 20));
        kiekSpent.setText("Rasta: " + InfoSpend.size());
        kiekSpent.setHorizontalAlignment(JTextField.CENTER);

        TotalSpent = new JTextField();
        TotalSpent.setEditable(false);
        TotalSpent.setPreferredSize(new Dimension(300,60));
        TotalSpent.setFont(new Font("Monospaced", Font.BOLD, 20));
        TotalSpent.setHorizontalAlignment(JTextField.CENTER);

        

        for(Spent s : InfoSpend){
                suma2+= s.getSpent();
        }
        TotalSpent.setText("Iš viso: " + suma2 + "Eur ");
        kiekSpent.setText("Rasta: " + InfoSpend.size());

        // info data loading SPend



        // income jiesko kiek rasta informacijos total kieki
        kiekIncome = new JTextField();
        kiekIncome.setPreferredSize(new Dimension(300,60));
        kiekIncome.setFont(new Font("Monospaced", Font.BOLD, 20));
        kiekIncome.setText(String.valueOf("Rasta: "+ income.size()));
        kiekIncome.setEditable(false);
        kiekIncome.setHorizontalAlignment(JTextField.CENTER);




        // income jiesko kiek rasta informacijos apie total suma
        totalIncome = new JTextField();
        totalIncome.setPreferredSize(new Dimension(300,60));
        totalIncome.setFont(new Font("Monospaced", Font.BOLD, 20));
        totalIncome.setHorizontalAlignment(JTextField.CENTER);
        totalIncome.setEditable(false);

       

        totalIncome.setText("M: " + code.dabartinesuma()  + "Eur ");

        
        // preload info -----------------------------------------


      //Change income

        Income2NDCHANGE = new JPanel();
        Income2NDCHANGE.setBounds(810, 135, 700, 550);
        Income2NDCHANGE.setLayout(null);
        Income2NDCHANGE.setVisible(false);

        incoRem1stCHANGE = new JPanel();
        incoRem1stCHANGE.setBounds(0, 80, 700, 100);
        incoRem1stCHANGE.setLayout(new FlowLayout());

        text2 = new JTextField();
        text2.setBorder(null);
        text2.setText("ID ");
        text2.setEditable(false);
        text2.setPreferredSize(new Dimension(50, 60));
        text2.setFont(new Font("Monospaced", Font.BOLD, 30));
        text2.setHorizontalAlignment(JTextField.CENTER);

        ImageIcon Rr = new ImageIcon("C:\\Users\\spina\\OneDrive\\Desktop\\JAVA\\MoneyManagement\\src\\delete.png");
        Image Ss = Rr.getImage();
        Image Aa = Ss.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon SSS = new ImageIcon(Aa);

        removeButtREmCHANGE = new JButton(SSS);
        removeButtREmCHANGE.addActionListener(this);
        removeButtREmCHANGE.setPreferredSize(new Dimension(50, 60));

        SeartchincotoremoveCHANGE = new JTextField();
        SeartchincotoremoveCHANGE.setFont(new Font("Monospaced", Font.BOLD, 20));
        SeartchincotoremoveCHANGE.setHorizontalAlignment(JTextField.CENTER);
        SeartchincotoremoveCHANGE.setPreferredSize(new Dimension(200, 60));

        searchtheidCHANGE = new JButton();
        searchtheidCHANGE.addActionListener(this);
        searchtheidCHANGE.setText("Jieskoti");
        searchtheidCHANGE.setFocusable(false);
        searchtheidCHANGE.setPreferredSize(new Dimension(100, 60));

        incoDATACHANGE = new JPanel();
        incoDATACHANGE.setBounds(0, 190, 700, 80);
        incoDATACHANGE.setLayout(new GridLayout());

        InforRemoveADDinfoCHANGE = new JTextArea();
        InforRemoveADDinfoCHANGE.setEditable(false);
        InforRemoveADDinfoCHANGE.setFont(new Font("Monospaced", Font.BOLD, 14));

        incoDATACHANGE.add(InforRemoveADDinfoCHANGE);

        incoCHECKBOXPLACECHANGE = new JPanel();
        incoCHECKBOXPLACECHANGE.setBounds(400, 500, 350, 100);
        incoCHECKBOXPLACECHANGE.setLayout(new FlowLayout(3));

        InfoREMcheckCHANGE = new JCheckBox("Ar tikrai norite pasalinti pasirinkta informacija ?");
        InfoREMcheckCHANGE.setPreferredSize(new Dimension(350, 60));
        InfoREMcheckCHANGE.setFocusable(false);
        InfoREMcheckCHANGE.setEnabled(false);
        InfoREMcheckCHANGE.addActionListener(this);

        incoCHECKBOXPLACECHANGE.add(InfoREMcheckCHANGE);

        infoABOUT = new JPanel();
        infoABOUT.setBounds(0, 290, 700, 40);
        infoABOUT.setLayout(new FlowLayout());
        

        JTextField ttt = new JTextField();
        ttt.setText("Ka norite pakeisti ?");
        ttt.setPreferredSize(new Dimension(700,40));
        ttt.setFont(new Font("Monospaced", Font.BOLD, 25));
        ttt.setHorizontalAlignment(JTextField.CENTER);
        ttt.setBackground(null);
        ttt.setBorder(null);
        infoABOUT.add(ttt);

        Income2NDCHANGE.add(infoABOUT);


        butpanel = new JPanel();
        butpanel.setBounds(0, 335, 700, 70);
        butpanel.setLayout(new GridLayout(1,5,5,10));

        but1 = new JButton();
        but1.setText("Data");
        but1.addActionListener(this);
        but2 = new JButton();
        but2.setText("Suma");
        but2.addActionListener(this);
        but3 = new JButton();
        but3.setText("Kategorija");
        but3.addActionListener(this);
        but4 = new JButton();
        but4.setText("Vieta");
        but4.addActionListener(this);
        but5 = new JButton();
        but5.setText("Tipas");
        but5.addActionListener(this);

        butpanel.add(but1);
        butpanel.add(but2);
        butpanel.add(but3);
        butpanel.add(but4);
        butpanel.add(but5);


        ChooseChange = new JPanel();
        ChooseChange.setBounds(0, 410, 700, 100);
        ChooseChange.setLayout(new FlowLayout(3,2,10));


        problems = new JTextField();
        problems.setPreferredSize(new Dimension(300,80));
        problems.setFont(new Font("Monospaced", Font.BOLD, 20));
        problems.setHorizontalAlignment(JTextField.CENTER);
        problems.setBackground(null);
        problems.setBorder(null);
        problems.setForeground(Color.red);
        problems.setText("Nepasirenkta");

        
        inputaboutchange = new JTextField();
        inputaboutchange.setPreferredSize(new Dimension(300,80));
        inputaboutchange.setHorizontalAlignment(JTextField.CENTER);
        inputaboutchange.setFont(new Font("Monospaced", Font.BOLD, 25));

        keistiinfosubuuton = new JButton();
        keistiinfosubuuton.setPreferredSize(new Dimension(90,80));
        keistiinfosubuuton.addActionListener(this);
        keistiinfosubuuton.setFocusable(false);
        keistiinfosubuuton.setText("Keisti");

        ChooseChange.add(problems);
        ChooseChange.add(inputaboutchange);
        ChooseChange.add(keistiinfosubuuton);
        
        Income2NDCHANGE.add(ChooseChange);
        
        Income2NDCHANGE.add(butpanel);
        Income2NDCHANGE.add(incoRem1stCHANGE);
        Income2NDCHANGE.add(incoDATACHANGE);
        Income2NDCHANGE.add(incoCHECKBOXPLACECHANGE);

        incoRem1stCHANGE.add(text2);
        incoRem1stCHANGE.add(SeartchincotoremoveCHANGE);
        incoRem1stCHANGE.add(searchtheidCHANGE);
        incoRem1stCHANGE.add(removeButtREmCHANGE);

        //Change income




        // spend Change

        Income2NDCHANGESPEND = new JPanel();
        Income2NDCHANGESPEND.setBounds(70, 135, 700, 550);
        Income2NDCHANGESPEND.setLayout(null);
        Income2NDCHANGESPEND.setVisible(false);

        incoRem1stCHANGESPEND = new JPanel();
        incoRem1stCHANGESPEND.setBounds(0, 80, 700, 100);
        incoRem1stCHANGESPEND.setLayout(new FlowLayout());

        text2SPEND = new JTextField();
        text2SPEND.setBorder(null);
        text2SPEND.setText("ID ");
        text2SPEND.setEditable(false);
        text2SPEND.setPreferredSize(new Dimension(50, 60));
        text2SPEND.setFont(new Font("Monospaced", Font.BOLD, 30));
        text2SPEND.setHorizontalAlignment(JTextField.CENTER);

        ImageIcon Rrrr = new ImageIcon("C:\\Users\\spina\\OneDrive\\Desktop\\JAVA\\MoneyManagement\\src\\delete.png");
        Image Sss = Rrrr.getImage();
        Image Aas = Sss.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon SSSs = new ImageIcon(Aas);

        removeButtREmCHANGESPEND = new JButton(SSSs);
        removeButtREmCHANGESPEND.addActionListener(this);
        removeButtREmCHANGESPEND.setPreferredSize(new Dimension(50, 60));

        SeartchincotoremoveCHANGESPEND = new JTextField();
        SeartchincotoremoveCHANGESPEND.setFont(new Font("Monospaced", Font.BOLD, 20));
        SeartchincotoremoveCHANGESPEND.setHorizontalAlignment(JTextField.CENTER);
        SeartchincotoremoveCHANGESPEND.setPreferredSize(new Dimension(200, 60));

        searchtheidCHANGESPEND = new JButton();
        searchtheidCHANGESPEND.addActionListener(this);
        searchtheidCHANGESPEND.setText("Jieskoti");
        searchtheidCHANGESPEND.setFocusable(false);
        searchtheidCHANGESPEND.setPreferredSize(new Dimension(100, 60));

        incoDATACHANGESPEND = new JPanel();
        incoDATACHANGESPEND.setBounds(0, 190, 700, 80);
        incoDATACHANGESPEND.setLayout(new GridLayout());

        InforRemoveADDinfoCHANGESPEND = new JTextArea();
        InforRemoveADDinfoCHANGESPEND.setEditable(false);
        InforRemoveADDinfoCHANGESPEND.setFont(new Font("Monospaced", Font.BOLD, 14));

        incoDATACHANGESPEND.add(InforRemoveADDinfoCHANGESPEND);

        incoCHECKBOXPLACECHANGESPEND = new JPanel();
        incoCHECKBOXPLACECHANGESPEND.setBounds(400, 500, 350, 100);
        incoCHECKBOXPLACECHANGESPEND.setLayout(new FlowLayout(3));

        InfoREMcheckCHANGESPEND = new JCheckBox("Ar tikrai norite pakeisti pasirinkta informacija ?");
        InfoREMcheckCHANGESPEND.setPreferredSize(new Dimension(350, 60));
        InfoREMcheckCHANGESPEND.setFocusable(false);
        InfoREMcheckCHANGESPEND.setEnabled(false);
        InfoREMcheckCHANGESPEND.addActionListener(this);

        incoCHECKBOXPLACECHANGESPEND.add(InfoREMcheckCHANGESPEND);

        // info pasako kas tai yra
        infoABOUTSPEND = new JPanel();
        infoABOUTSPEND.setBounds(0, 290, 700, 40);
        infoABOUTSPEND.setLayout(new FlowLayout());

        JTextField ttts = new JTextField();
        ttts.setText("Ka norite pakeisti ?");
        ttts.setPreferredSize(new Dimension(700,40));
        ttts.setFont(new Font("Monospaced", Font.BOLD, 25));
        ttts.setHorizontalAlignment(JTextField.CENTER);
        ttts.setBackground(null);
        ttts.setBorder(null);
        infoABOUTSPEND.add(ttts);

        Income2NDCHANGESPEND.add(infoABOUTSPEND);

        butpanelSPEND = new JPanel();
        butpanelSPEND.setBounds(0, 335, 700, 70);
        butpanelSPEND.setLayout(new GridLayout(1,5,5,10));

        but1SPEND = new JButton();
        but1SPEND.setText("Data");
        but1SPEND.addActionListener(this);

        but2SPEND = new JButton();
        but2SPEND.setText("Suma");
        but2SPEND.addActionListener(this);

        but3SPEND = new JButton();
        but3SPEND.setText("Kategorija");
        but3SPEND.addActionListener(this);

        but4SPEND = new JButton();
        but4SPEND.setText("Vieta");
        but4SPEND.addActionListener(this);

        but5SPEND = new JButton();
        but5SPEND.setText("Tipas");
        but5SPEND.addActionListener(this);

        butpanelSPEND.add(but1SPEND);
        butpanelSPEND.add(but2SPEND);
        butpanelSPEND.add(but3SPEND);
        butpanelSPEND.add(but4SPEND);
        butpanelSPEND.add(but5SPEND);

        ChooseChangeSPEND = new JPanel();
        ChooseChangeSPEND.setBounds(0, 410, 700, 100);
        ChooseChangeSPEND.setLayout(new FlowLayout(3,2,10));

        problemsSPEND = new JTextField();
        problemsSPEND.setPreferredSize(new Dimension(300,80));
        problemsSPEND.setFont(new Font("Monospaced", Font.BOLD, 20));
        problemsSPEND.setHorizontalAlignment(JTextField.CENTER);
        problemsSPEND.setBackground(null);
        problemsSPEND.setBorder(null);
        problemsSPEND.setForeground(Color.red);
        problemsSPEND.setText("Nepasirenkta");

        inputaboutchangeSPEND = new JTextField();
        inputaboutchangeSPEND.setPreferredSize(new Dimension(300,80));
        inputaboutchangeSPEND.setHorizontalAlignment(JTextField.CENTER);
        inputaboutchangeSPEND.setFont(new Font("Monospaced", Font.BOLD, 25));

        keistiinfosubuutonSPEND = new JButton();
        keistiinfosubuutonSPEND.setPreferredSize(new Dimension(90,80));
        keistiinfosubuutonSPEND.addActionListener(this);
        keistiinfosubuutonSPEND.setFocusable(false);
        keistiinfosubuutonSPEND.setText("Keisti");

        ChooseChangeSPEND.add(problemsSPEND);
        ChooseChangeSPEND.add(inputaboutchangeSPEND);
        ChooseChangeSPEND.add(keistiinfosubuutonSPEND);

        Income2NDCHANGESPEND.add(ChooseChangeSPEND);
        Income2NDCHANGESPEND.add(butpanelSPEND);
        Income2NDCHANGESPEND.add(incoRem1stCHANGESPEND);
        Income2NDCHANGESPEND.add(incoDATACHANGESPEND);
        Income2NDCHANGESPEND.add(incoCHECKBOXPLACECHANGESPEND);

        incoRem1stCHANGESPEND.add(text2SPEND);
        incoRem1stCHANGESPEND.add(SeartchincotoremoveCHANGESPEND);
        incoRem1stCHANGESPEND.add(searchtheidCHANGESPEND);
        incoRem1stCHANGESPEND.add(removeButtREmCHANGESPEND);

        



        // spend change



        // REMOVE Income

        Income2ND = new JPanel();
        Income2ND.setBounds(810, 135, 700, 550);
        Income2ND.setLayout(null);
        



        incoRem1st = new JPanel();
        incoRem1st.setBounds(0, 80, 700, 100);
        incoRem1st.setLayout(new FlowLayout());
        

        JTextField text = new JTextField();
        text.setBorder(null);
        text.setText("ID ");
        text.setEditable(false);
        text.setPreferredSize(new Dimension(50,60));
        text.setFont(new Font("Monospaced", Font.BOLD, 30));
        text.setHorizontalAlignment(JTextField.CENTER);


        ImageIcon R = new ImageIcon("C:\\Users\\spina\\OneDrive\\Desktop\\JAVA\\MoneyManagement\\src\\delete.png");
        Image S = R.getImage(); 
        Image A = S.getScaledInstance(40, 40, Image.SCALE_SMOOTH); 
        ImageIcon SS = new ImageIcon(A);

        removeButtREm = new JButton(SS);
        removeButtREm.addActionListener(this);
        removeButtREm.setPreferredSize(new Dimension(50,60));
       

        

        Seartchincotoremove = new JTextField();
        Seartchincotoremove.setFont(new Font("Monospaced", Font.BOLD, 20));
        Seartchincotoremove.setHorizontalAlignment(JTextField.CENTER);
        Seartchincotoremove.setPreferredSize(new Dimension(200,60));


        searchtheid = new JButton();
        searchtheid.addActionListener(this);
        searchtheid.setText("Jieskoti");
        searchtheid.setFocusable(false);
        searchtheid.setPreferredSize(new Dimension(100,60));
    


        incoDATA = new JPanel();
        incoDATA.setBounds(0, 190, 700, 80);
        incoDATA.setLayout(new GridLayout());
        

        InforRemoveADDinfo = new JTextArea();
        InforRemoveADDinfo.setEditable(false);
        InforRemoveADDinfo.setFont(new Font("Monospaced", Font.BOLD, 14));

        incoDATA.add(InforRemoveADDinfo);


        

        incoCHECKBOXPLACE = new JPanel();
        incoCHECKBOXPLACE.setBounds(400, 265, 350, 100);
        incoCHECKBOXPLACE.setLayout(new FlowLayout(3));

        InfoREMcheck = new JCheckBox("Ar tikrai norite pasalinti pasirinkta informacija ?");
        InfoREMcheck.setPreferredSize(new Dimension(350,60));
        InfoREMcheck.setFocusable(false);
        InfoREMcheck.setEnabled(false);
        InfoREMcheck.addActionListener(this);

        incoCHECKBOXPLACE.add(InfoREMcheck);

        Income2ND.add(incoRem1st);
        Income2ND.add(incoDATA);
        Income2ND.add(incoCHECKBOXPLACE);

        
        
        incoRem1st.add(text);
        incoRem1st.add(Seartchincotoremove);
        incoRem1st.add(searchtheid);
        incoRem1st.add(removeButtREm);


        // REMOVE Income
       
        


        // ADD Income

        ADD = new JPanel();
        ADD.setBounds(810, 135, 700, 550);
        ADD.setLayout(null);
        ADD.setVisible(false);
        

        ADDextenction1 = new JPanel();
        ADDextenction1.setBounds(0, 0, 350, 500);
        ADDextenction1.setLayout(new GridLayout(6,1,20,0));
        ADDextenction1.setVisible(true);

         JTextField B1 = new JTextField();
         B1.setText("Data");
         B1.setFont(new Font("Monospaced", Font.BOLD, 30));
         B1.setHorizontalAlignment(JTextField.CENTER);
         B1.setEditable(false);

         JTextField B2 = new JTextField();
         B2.setText("Suma Eurais");
         B2.setFont(new Font("Monospaced", Font.BOLD, 30));
         B2.setHorizontalAlignment(JTextField.CENTER);
         B2.setEditable(false);

         JTextField B3 = new JTextField();
         B3.setText("Kategorija");
         B3.setFont(new Font("Monospaced", Font.BOLD, 30));
         B3.setHorizontalAlignment(JTextField.CENTER);
         B3.setEditable(false);

         JTextField B4 = new JTextField();
         B4.setText("Vieta");
         B4.setFont(new Font("Monospaced", Font.BOLD, 30));
         B4.setHorizontalAlignment(JTextField.CENTER);
         B4.setEditable(false);

         JTextField B5 = new JTextField();
         B5.setText("Tipas");
         B5.setFont(new Font("Monospaced", Font.BOLD, 30));
         B5.setHorizontalAlignment(JTextField.CENTER);
         B5.setEditable(false);
         JButton but = new JButton();
         B5.add(but);

         B6 = new JTextField();
         B6.setForeground(Color.red);
         B6.setText("Neviskas uzpildyta");
         B6.setFont(new Font("Monospaced", Font.BOLD, 30));
         B6.setHorizontalAlignment(JTextField.CENTER);
         B6.setEditable(false);
         B6.setBorder(null);
                 

         

        ADDextenction1.add(B1);
        ADDextenction1.add(B2);
        ADDextenction1.add(B3);
        ADDextenction1.add(B4);
        ADDextenction1.add(B5);
        ADDextenction1.add(B6);

        

        ADDextenction2 = new JPanel();
        ADDextenction2.setBounds(350, 0, 350, 500);
        ADDextenction2.setVisible(false);
        ADDextenction2.setLayout(new GridLayout(6,1,20,0));
         

        JPanel B11 = new JPanel();
         B11.setLayout(new GridLayout(1, 2));

         B11button = new JButton();
         B11button.addActionListener(this);
         B11button.setText("Darbartinė data");
         B11button.setFocusPainted(false);

         B11field = new JTextField();
         B11field.setText("");
         B11field.setFont(new Font("Monospaced", Font.BOLD, 20));
         B11field.setHorizontalAlignment(JTextField.CENTER);

         B11.add(B11button);
         B11.add(B11field);

         B22 = new JTextField();
         B22.setFont(new Font("Monospaced", Font.BOLD, 20));
         B22.setHorizontalAlignment(JTextField.CENTER);

         B33 = new JTextField();
         B33.setFont(new Font("Monospaced", Font.BOLD, 20));
         B33.setHorizontalAlignment(JTextField.CENTER);

         B44 = new JTextField();
         B44.setFont(new Font("Monospaced", Font.BOLD, 20));
         B44.setHorizontalAlignment(JTextField.CENTER);

         JPanel B55 = new JPanel();
         B55.setLayout(new GridLayout(1,2));
         B55.setBackground(Color.yellow);

         B55button1 = new JButton();
         B55button1.addActionListener(this);
         B55button1.setText("Grynais");

         B55button2 = new JButton();
         B55button2.addActionListener(this);
         B55button2.setText("Kortele");

         B55button3 = new JButton();
         B55button3.addActionListener(this);
         B55button3.setText("Abiems");

         B55.add(B55button1);
         B55.add(B55button2);
         B55.add(B55button3);

         JPanel B66 = new JPanel();
         B66.setLayout(new GridLayout());

        // ADD Income

         // CHECK BOX
        agreetoadd = new JCheckBox("Ar tikrai informacija yra teisinga ?");
        agreetoadd.setEnabled(false);
        agreetoadd.addActionListener(this);
        agreetoadd.setHorizontalAlignment(JCheckBox.CENTER);
         

        ADDextenction2.add(B11);
        ADDextenction2.add(B22);
        ADDextenction2.add(B33);
        ADDextenction2.add(B44);
        ADDextenction2.add(B55);
        ADDextenction2.add(B66);
        B66.add(agreetoadd);
       

        ADD.add(ADDextenction1);
        ADD.add(ADDextenction2);

        // ADD Income



        // remove spend

        Income2NDSPEND = new JPanel();
        Income2NDSPEND.setBounds(70, 135, 700, 550);
        Income2NDSPEND.setLayout(null);

        incoRem1stSPEND = new JPanel();
        incoRem1stSPEND.setBounds(0, 80, 700, 100);
        incoRem1stSPEND.setLayout(new FlowLayout());

        JTextField texts = new JTextField();
        texts.setBorder(null);
        texts.setText("ID ");
        texts.setEditable(false);
        texts.setPreferredSize(new Dimension(50,60));
        texts.setFont(new Font("Monospaced", Font.BOLD, 30));
        texts.setHorizontalAlignment(JTextField.CENTER);

        ImageIcon Rrr = new ImageIcon("C:\\Users\\spina\\OneDrive\\Desktop\\JAVA\\MoneyManagement\\src\\delete.png");
        Image Sr = Rrr.getImage(); 
        Image Ar = Sr.getScaledInstance(40, 40, Image.SCALE_SMOOTH); 
        ImageIcon SSr = new ImageIcon(Ar);

        removeButtREmSPEND = new JButton(SSr);
        removeButtREmSPEND.addActionListener(this);
        removeButtREmSPEND.setPreferredSize(new Dimension(50,60));

        SeartchincotoremoveSPEND = new JTextField();
        SeartchincotoremoveSPEND.setFont(new Font("Monospaced", Font.BOLD, 20));
        SeartchincotoremoveSPEND.setHorizontalAlignment(JTextField.CENTER);
        SeartchincotoremoveSPEND.setPreferredSize(new Dimension(200,60));

        searchtheidSPEND = new JButton();
        searchtheidSPEND.addActionListener(this);
        searchtheidSPEND.setText("Jieskoti");
        searchtheidSPEND.setFocusable(false);
        searchtheidSPEND.setPreferredSize(new Dimension(100,60));

        incoDATASPEND = new JPanel();
        incoDATASPEND.setBounds(0, 190, 700, 80);
        incoDATASPEND.setLayout(new GridLayout());

        InforRemoveADDinfoSPEND = new JTextArea();
        InforRemoveADDinfoSPEND.setEditable(false);
        InforRemoveADDinfoSPEND.setFont(new Font("Monospaced", Font.BOLD, 14));

        incoDATASPEND.add(InforRemoveADDinfoSPEND);

        incoCHECKBOXPLACESPEND = new JPanel();
        incoCHECKBOXPLACESPEND.setBounds(400, 265, 350, 100);
        incoCHECKBOXPLACESPEND.setLayout(new FlowLayout(3));

        InfoREMcheckSPEND = new JCheckBox("Ar tikrai norite pasalinti pasirinkta informacija ?");
        InfoREMcheckSPEND.setPreferredSize(new Dimension(350,60));
        InfoREMcheckSPEND.setFocusable(false);
        InfoREMcheckSPEND.setEnabled(false);
        InfoREMcheckSPEND.addActionListener(this);

        incoCHECKBOXPLACESPEND.add(InfoREMcheckSPEND);

        // Add subpanels to main panel
        Income2NDSPEND.add(incoRem1stSPEND);
        Income2NDSPEND.add(incoDATASPEND);
        Income2NDSPEND.add(incoCHECKBOXPLACESPEND);

        // Add input components to input panel
        incoRem1stSPEND.add(text);
        incoRem1stSPEND.add(SeartchincotoremoveSPEND);
        incoRem1stSPEND.add(searchtheidSPEND);
        incoRem1stSPEND.add(removeButtREmSPEND);



        // remove spend


          // ADD SPEND

        ADDSPEND = new JPanel();
        ADDSPEND.setBounds(70, 135, 700, 550);
        ADDSPEND.setLayout(null);
        ADDSPEND.setVisible(false);

        ADDextenction1SPEND = new JPanel();
        ADDextenction1SPEND.setBounds(0, 0, 350, 500);
        ADDextenction1SPEND.setLayout(new GridLayout(6, 1, 20, 0));
        ADDextenction1SPEND.setVisible(true);

        JTextField B1S = new JTextField();
        B1S.setText("Data");
        B1S.setFont(new Font("Monospaced", Font.BOLD, 30));
        B1S.setHorizontalAlignment(JTextField.CENTER);
        B1S.setEditable(false);

        JTextField B2S = new JTextField();
        B2S.setText("Suma Eurais");
        B2S.setFont(new Font("Monospaced", Font.BOLD, 30));
        B2S.setHorizontalAlignment(JTextField.CENTER);
        B2S.setEditable(false);

        JTextField B3S = new JTextField();
        B3S.setText("Kategorija");
        B3S.setFont(new Font("Monospaced", Font.BOLD, 30));
        B3S.setHorizontalAlignment(JTextField.CENTER);
        B3S.setEditable(false);

        JTextField B4S = new JTextField();
        B4S.setText("Vieta");
        B4S.setFont(new Font("Monospaced", Font.BOLD, 30));
        B4S.setHorizontalAlignment(JTextField.CENTER);
        B4S.setEditable(false);

        JTextField B5S = new JTextField();
        B5S.setText("Tipas");
        B5S.setFont(new Font("Monospaced", Font.BOLD, 30));
        B5S.setHorizontalAlignment(JTextField.CENTER);
        B5S.setEditable(false);

        JButton butS = new JButton();
        B5S.add(butS);

        B6SPEND = new JTextField();
        B6SPEND.setForeground(Color.red);
        B6SPEND.setText("Neviskas uzpildyta");
        B6SPEND.setFont(new Font("Monospaced", Font.BOLD, 30));
        B6SPEND.setHorizontalAlignment(JTextField.CENTER);
        B6SPEND.setEditable(false);
        B6SPEND.setBorder(null);

        ADDextenction1SPEND.add(B1S);
        ADDextenction1SPEND.add(B2S);
        ADDextenction1SPEND.add(B3S);
        ADDextenction1SPEND.add(B4S);
        ADDextenction1SPEND.add(B5S);
        ADDextenction1SPEND.add(B6SPEND);

        ADDextenction2SPEND = new JPanel();
        ADDextenction2SPEND.setBounds(350, 0, 350, 500);
        ADDextenction2SPEND.setVisible(false);
        ADDextenction2SPEND.setLayout(new GridLayout(6, 1, 20, 0));

        JPanel B11S = new JPanel();
        B11S.setLayout(new GridLayout(1, 2));

        B11buttonSPEND = new JButton();
        B11buttonSPEND.addActionListener(this);
        B11buttonSPEND.setText("Darbartinė data");
        B11buttonSPEND.setFocusPainted(false);

        B11fieldSPEND = new JTextField();
        B11fieldSPEND.setText("");
        B11fieldSPEND.setFont(new Font("Monospaced", Font.BOLD, 20));
        B11fieldSPEND.setHorizontalAlignment(JTextField.CENTER);

        B11S.add(B11buttonSPEND);
        B11S.add(B11fieldSPEND);

        B22SPEND = new JTextField();
        B22SPEND.setFont(new Font("Monospaced", Font.BOLD, 20));
        B22SPEND.setHorizontalAlignment(JTextField.CENTER);

        B33SPEND = new JTextField();
        B33SPEND.setFont(new Font("Monospaced", Font.BOLD, 20));
        B33SPEND.setHorizontalAlignment(JTextField.CENTER);

        B44SPEND = new JTextField();
        B44SPEND.setFont(new Font("Monospaced", Font.BOLD, 20));
        B44SPEND.setHorizontalAlignment(JTextField.CENTER);

        JPanel B55S = new JPanel();
        B55S.setLayout(new GridLayout(1, 2));
        B55S.setBackground(Color.yellow);

        B55button1SPEND = new JButton();
        B55button1SPEND.addActionListener(this);
        B55button1SPEND.setText("Grynais");

        B55button2SPEND = new JButton();
        B55button2SPEND.addActionListener(this);
        B55button2SPEND.setText("Kortele");

        B55S.add(B55button1SPEND);
        B55S.add(B55button2SPEND);

        JPanel B66S = new JPanel();
        B66S.setLayout(new GridLayout());

        // CHECK BOX
        agreetoaddSPEND = new JCheckBox("Ar tikrai informacija yra teisinga ?");
        agreetoaddSPEND.setEnabled(false);
        agreetoaddSPEND.addActionListener(this);
        agreetoaddSPEND.setHorizontalAlignment(JCheckBox.CENTER);

        ADDextenction2SPEND.add(B11S);
        ADDextenction2SPEND.add(B22SPEND);
        ADDextenction2SPEND.add(B33SPEND);
        ADDextenction2SPEND.add(B44SPEND);
        ADDextenction2SPEND.add(B55S);
        ADDextenction2SPEND.add(B66S);
        B66S.add(agreetoaddSPEND);

        ADDSPEND.add(ADDextenction1SPEND);
        ADDSPEND.add(ADDextenction2SPEND);



        // ADD SPEND


        // INFORMATION DISPLAYED 

        infoForIncome = new JPanel();
        infoForIncome.setBounds(70, 80, 700, 50);
        infoForIncome.setLayout(new FlowLayout(1));
        
        
        infoForSpend = new JPanel();
        infoForSpend.setBounds(810, 80, 700, 50);
        

        IncomeTEXT = new JTextField();
        IncomeTEXT.setFont(new Font("Monospaced", Font.BOLD, 30));
        IncomeTEXT.setText("Net Current");
        IncomeTEXT.setEditable(false);
        IncomeTEXT.setBorder(null);
        IncomeTEXT.setCursor(null);
        IncomeTEXT.setHorizontalAlignment(JTextField.CENTER);
        IncomeTEXT.setPreferredSize(new Dimension(400,40));
        infoForIncome.add(IncomeTEXT);
        


         
        SavedTEXT = new JTextField();
        SavedTEXT.setFont(new Font("Monospaced", Font.BOLD, 30));
        SavedTEXT.setText("Net Spend");
        SavedTEXT.setEditable(false);
        SavedTEXT.setBorder(null);
        SavedTEXT.setCursor(null);
        SavedTEXT.setHorizontalAlignment(JTextField.CENTER);
        SavedTEXT.setPreferredSize(new Dimension(400,40));
        infoForSpend.add(SavedTEXT);

        // Information for  Spend ir Income fields 

        
        // main frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1600, 800);
        




        // atsaukti sutikti
        
        Atsaukti = new JButton();
        Atsaukti.setBounds(1470,710,100,50);
        Atsaukti.setText("Atsaukti");
        Atsaukti.addActionListener(this);
        Atsaukti.setVisible(false);

        IncomeCancel = new JButton();
        IncomeCancel.setBounds(1350,710,100,50);
        IncomeCancel.setText("Prideti");
        IncomeCancel.setEnabled(false);
        IncomeCancel.addActionListener(this);
        IncomeCancel.setVisible(false);



        Atsaukti2 = new JButton();
        Atsaukti2.setBounds(1470,710,100,50);
        Atsaukti2.setText("Atsaukti");
        Atsaukti2.addActionListener(this);
        Atsaukti2.setVisible(false);

        IncomeCancel2 = new JButton();
        IncomeCancel2.setBounds(1350,710,100,50);
        IncomeCancel2.setText("Atimti");
        IncomeCancel2.setFocusable(false);
        IncomeCancel2.addActionListener(this);
        IncomeCancel2.setEnabled(false);
        IncomeCancel2.setVisible(false);



        Atsaukti3 = new JButton();
        Atsaukti3.setBounds(1470,710,100,50);
        Atsaukti3.setText("Atsaukti");
        Atsaukti3.addActionListener(this);
        Atsaukti3.setVisible(false);

        IncomeCancel3 = new JButton();
        IncomeCancel3.setBounds(1350,710,100,50);
        IncomeCancel3.setText("Pakeisti");
        IncomeCancel3.setFocusable(false);
        IncomeCancel3.addActionListener(this);
        IncomeCancel3.setEnabled(false);
        IncomeCancel3.setVisible(false);


        // SPend buttons

        //heeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
        IncomeCancelSPEND = new JButton();
        IncomeCancelSPEND.setBounds(140,710,100,50);
        IncomeCancelSPEND.setText("Prideti");
        IncomeCancelSPEND.setEnabled(false);
        IncomeCancelSPEND.addActionListener(this);
        IncomeCancelSPEND.setVisible(false);


        IncomeCancel2SPEND = new JButton();
        IncomeCancel2SPEND.setBounds(140,710,100,50);
        IncomeCancel2SPEND.setText("Atimti");
        IncomeCancel2SPEND.setEnabled(false);
        IncomeCancel2SPEND.addActionListener(this);
        IncomeCancel2SPEND.setVisible(false);

        IncomeCancel3SPEND = new JButton();
        IncomeCancel3SPEND.setBounds(140,710,100,50);
        IncomeCancel3SPEND.setText("Pakeisti");
        IncomeCancel3SPEND.setEnabled(false);
        IncomeCancel3SPEND.addActionListener(this);
        IncomeCancel3SPEND.setVisible(false);



        AtsauktiSPEND = new JButton();
        AtsauktiSPEND.setBounds(20,710,100,50);
        AtsauktiSPEND.setText("Atsaukti");
        AtsauktiSPEND.addActionListener(this);
        AtsauktiSPEND.setVisible(false);

        Atsaukti2SPEND = new JButton();
        Atsaukti2SPEND.setBounds(20,710,100,50);
        Atsaukti2SPEND.setText("Atsaukti");
        Atsaukti2SPEND.addActionListener(this);
        Atsaukti2SPEND.setVisible(false);

        Atsaukti3SPEND = new JButton();
        Atsaukti3SPEND.setBounds(20,710,100,50);
        Atsaukti3SPEND.setText("Atsaukti");
        Atsaukti3SPEND.addActionListener(this);
        Atsaukti3SPEND.setVisible(false);



        // SPend buttons

        // atsaukti sutikti
        




        // header
        header = new JPanel();
        header.setLayout(new FlowLayout(1));
        header.setBackground(Color.ORANGE);

        // header buttons
        calculator = new JButton();
        calculator.addActionListener(this);
        potential = new JButton();
        potential.addActionListener(this);
        loans = new JButton();
        loans.addActionListener(this);
        Atsijungti = new JButton();
        

        calculator.setPreferredSize(new Dimension(300,60));
        potential.setPreferredSize(new Dimension(300,60));
        loans.setPreferredSize(new Dimension(300,60));
        Atsijungti.setPreferredSize(new Dimension(300,60));

        calculator.setText("Skaičiuoti");
        calculator.setFocusable(false);

        potential.setText("Settings");
        
        potential.setFocusable(false);
        
        loans.setText("Loans");
        loans.setFocusable(false);

        Atsijungti.setText("Atsijungti");
        Atsijungti.addActionListener(this);
        Atsijungti.setFocusable(false);
        

        // header       


        // info display -----------------------------------------------
        Income = new JPanel();
        Income.setBounds(70,200,700,400);
        Income.setLayout(null);
        

       

        scrollPane = new JScrollPane(IncomeData);
        scrollPane.setBounds(0,0,700,400);

        Spent = new JPanel();
        Spent.setBounds(810,200,700,400);
        Spent.setLayout(null);
        



        scrollPane2 = new JScrollPane(SpentData);
        scrollPane2.setBounds(0,0,700,400);

        // info display -----------------------------------------------

        
       


        
    
         //Income --------------------- buttons
        IncomeFROMto = new JPanel();
        IncomeFROMto.setBounds(70,130,700,70);


        i1 = new JTextField();
        i1.setPreferredSize(new Dimension(200,60));
        i1.setText("Nuo");
        i1.setFont(new Font("Monospaced", Font.BOLD, 20));
        i1.setHorizontalAlignment(JTextField.CENTER);
        i2 = new JTextField();
        i2.setPreferredSize(new Dimension(200,60));
        i2.setText("Iki");
        i2.setFont(new Font("Monospaced", Font.BOLD, 20));
        i2.setHorizontalAlignment(JTextField.CENTER);
        i3 = new JButton();
        i3.setPreferredSize(new Dimension(200,60));
        i3.setText("Jieskoti");
        i3.addActionListener(this);
        i3.setFocusable(false);
        
        ImageIcon removeIcon = new ImageIcon("C:\\Users\\spina\\OneDrive\\Desktop\\JAVA\\MoneyManagement\\src\\delete.png");
        Image image = removeIcon.getImage(); 
        Image newImg = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
        ImageIcon resizedIcon = new ImageIcon(newImg);


        i4 = new JButton(resizedIcon);
        i4.setPreferredSize(new Dimension(70, 60)); // size of the button
        i4.addActionListener(this);
        i4.setFocusable(false);
        

        

        // Income ---------------------- buttons



       

        //spent --------------------- buttons

        SpentFROMto = new JPanel();
        SpentFROMto.setBounds(810,130,700,70);
        SpentFROMto.setLayout(new FlowLayout());

        s1 = new JTextField();
        s1.setPreferredSize(new Dimension(200,60));
        s1.setText("Nuo");
        s1.setFont(new Font("Monospaced", Font.BOLD, 20));
        s1.setHorizontalAlignment(JTextField.CENTER);
        s2 = new JTextField();
        s2.setPreferredSize(new Dimension(200,60));
        s2.setText("Iki");
        s2.setFont(new Font("Monospaced", Font.BOLD, 20));
        s2.setHorizontalAlignment(JTextField.CENTER);

        s3 = new JButton();
        s3.setPreferredSize(new Dimension(200,60));
        s3.setText("Jieskoti");
        s3.addActionListener(this);
        s3.setFocusable(false);


        s4 = new JButton(resizedIcon);
        s4.setPreferredSize(new Dimension(70, 60)); // size of the button
        s4.addActionListener(this);
        s4.setFocusable(false);

       

        // spent ---------------------- buttons


        // extra stuff
        IncomeExtra = new JPanel();
        IncomeExtra.setBounds(70,600,700,150);
        IncomeExtra.setLayout(new FlowLayout());

        IncomeADD = new JButton();
        IncomeADD.addActionListener(this);
        IncomeADD.setFocusable(false);

        IncomeREMOVE = new JButton();
        IncomeREMOVE.addActionListener(this);
        IncomeREMOVE.setFocusable(false);

        IncomeCHANGE = new JButton();
        IncomeCHANGE.addActionListener(this);
        IncomeCHANGE.setFocusable(false);

        
        IncomeADD.setPreferredSize(new Dimension(200,60));
        IncomeREMOVE.setPreferredSize(new Dimension(200,60));
        IncomeCHANGE.setPreferredSize(new Dimension(200,60));

        IncomeADD.setText("ADD");
        IncomeREMOVE.setText("REMOVE");
        IncomeCHANGE.setText("CHANGE");






        SpentExtra = new JPanel();
        SpentExtra.setBounds(810,600,700,150);
        

        SpentADD = new JButton();
        SpentADD.addActionListener(this);
        SpentADD.setFocusable(false);
        

        SpentREMOVE = new JButton();
        SpentREMOVE.addActionListener(this);
        SpentREMOVE.setFocusable(false);

        SpentCHANGE = new JButton();
        SpentCHANGE.addActionListener(this);
        SpentCHANGE.setFocusable(false);

       
        SpentADD.setPreferredSize(new Dimension(200,60));
        SpentREMOVE.setPreferredSize(new Dimension(200,60));
        SpentCHANGE.setPreferredSize(new Dimension(200,60));

        SpentADD.setText("ADD");
        SpentREMOVE.setText("REMOVE");
        SpentCHANGE.setText("CHANGE");


       // extra stuff





       // password

        password = new JPanel();
        password.setBackground(Color.black);
        password.setLayout(new FlowLayout(1,10,10));
        password.setBounds(650, 100, 300, 400);

        password2 = new JPanel();
        password2.setBounds(660, 120, 310, 400);
        password2.setBackground(Color.darkGray);


        input = new JTextArea();
        input.setFont(new Font("Monospaced", Font.BOLD, 30));
        input.setEditable(false);
        input.setPreferredSize(new Dimension(260,50));

        p1 = new JButton("1");
        p1.setFocusable(false);
        p1.addActionListener(this);
        p1.setPreferredSize(new Dimension(80,70));

        p2 = new JButton("2");
        p2.setFocusable(false);
        p2.addActionListener(this);
        p2.setPreferredSize(new Dimension(80,70));

        p3 = new JButton("3");
        p3.setFocusable(false);
        p3.addActionListener(this);
        p3.setPreferredSize(new Dimension(80,70));

        p4 = new JButton("4");
        p4.setFocusable(false);
        p4.addActionListener(this);
        p4.setPreferredSize(new Dimension(80,70));

        p5 = new JButton("5");
        p5.setFocusable(false);
        p5.addActionListener(this);
        p5.setPreferredSize(new Dimension(80,70));

        p6 = new JButton("6");
        p6.setFocusable(false);
        p6.addActionListener(this);
        p6.setPreferredSize(new Dimension(80,70));

        p7 = new JButton("7");
        p7.setFocusable(false);
        p7.addActionListener(this);
        p7.setPreferredSize(new Dimension(80,70));

        p8 = new JButton("8");
        p8.setFocusable(false);
        p8.addActionListener(this);
        p8.setPreferredSize(new Dimension(80,70));

        p9 = new JButton("9");
        p9.setFocusable(false);
        p9.addActionListener(this);
        p9.setPreferredSize(new Dimension(80,70));

        p10 = new JButton("Rem");
        p10.setFocusable(false);
        p10.addActionListener(this);
        p10.setPreferredSize(new Dimension(80,70));

        p11 = new JButton("0");
        p11.setFocusable(false);
        p11.addActionListener(this);
        p11.setPreferredSize(new Dimension(80,70));

        p12 = new JButton("OK");
        p12.setFocusable(false);
        p12.addActionListener(this);
        p12.setPreferredSize(new Dimension(80,70));

      

        
        password.add(input);
        password.add(p1);
        password.add(p2);
        password.add(p2);
        password.add(p3);
        password.add(p4);
        password.add(p5);
        password.add(p6);
        password.add(p7);
        password.add(p8);
        password.add(p9);
        password.add(p10);
        password.add(p11);
        password.add(p12);

       // password


        // ADD THINGS TO THE PANELS

        IncomeExtra.add(kiekIncome);
        IncomeExtra.add(totalIncome);
        IncomeExtra.add(IncomeADD);
        IncomeExtra.add(IncomeREMOVE);
        IncomeExtra.add(IncomeCHANGE);

        SpentExtra.add(kiekSpent);
        SpentExtra.add(TotalSpent);
        SpentExtra.add(SpentADD);
        SpentExtra.add(SpentREMOVE);
        SpentExtra.add(SpentCHANGE);


        

        Income.add(scrollPane);

        Spent.add(scrollPane2);

        SpentFROMto.add(s1);
        SpentFROMto.add(s2);
        SpentFROMto.add(s3);
        SpentFROMto.add(s4);

        IncomeFROMto.add(i1);
        IncomeFROMto.add(i2);
        IncomeFROMto.add(i3);
        IncomeFROMto.add(i4);

        header.add(calculator);
        header.add(loans);
        header.add(potential);
        header.add(Atsijungti);

        this.setTitle("Money Management System");
    
        this.add(ADD);
        this.add(ADDSPEND);
        this.add(infoForSpend);
        this.add(infoForIncome);
        this.add(IncomeFROMto);
        this.add(SpentFROMto);
        this.add(SpentExtra);
        this.add(IncomeExtra);
        this.add(Spent);
        
        this.add(Income);
        this.add(Atsaukti);
        this.add(IncomeCancel);
        this.add(IncomeCancelSPEND);
        this.add(AtsauktiSPEND);
        this.add(IncomeCancel2SPEND);
        this.add(Atsaukti2SPEND);
        this.add(IncomeCancel3SPEND);
        this.add(Atsaukti3SPEND);
        this.add(Atsaukti2);
        this.add(Atsaukti3);
        this.add(IncomeCancel2);
        this.add(IncomeCancel3);
        this.add(Income2ND);
        this.add(Income2NDSPEND);
        this.add(Income2NDCHANGE);
        this.add(Income2NDCHANGESPEND);
        this.add(password);
        this.add(password2);
        this.add(header, BorderLayout.NORTH);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // make everything not visble

        header.setVisible(false);
        IncomeTEXT.setVisible(false);
        IncomeFROMto.setVisible(false);
        IncomeData.setVisible(false);
        IncomeExtra.setVisible(false);
        scrollPane.setBorder(null);


        SavedTEXT.setVisible(false);
        SpentFROMto.setVisible(false);
        SpentData.setVisible(false);
        SpentExtra.setVisible(false);
        scrollPane2.setVisible(false);


        // Panels
        header.setVisible(false);
        Income.setVisible(false);
        Spent.setVisible(false);
        SpentFROMto.setVisible(false);
        IncomeFROMto.setVisible(false);
        SpentExtra.setVisible(false);
        IncomeExtra.setVisible(false);
        infoForIncome.setVisible(false);
        infoForSpend.setVisible(false);
        ADD.setVisible(false);
        ADDextenction1.setVisible(false);
        ADDextenction2.setVisible(false);
        ADDSPEND.setVisible(false);
        ADDextenction1SPEND.setVisible(false);
        ADDextenction2SPEND.setVisible(false);
        Income2ND.setVisible(false);
        incoRem1st.setVisible(false);
        incoDATA.setVisible(false);
        incoCHECKBOXPLACE.setVisible(false);
        Income2NDSPEND.setVisible(false);
        incoRem1stSPEND.setVisible(false);
        incoDATASPEND.setVisible(false);
        incoCHECKBOXPLACESPEND.setVisible(false);
        Income2NDCHANGE.setVisible(false);
        incoRem1stCHANGE.setVisible(false);
        incoDATACHANGE.setVisible(false);
        incoCHECKBOXPLACECHANGE.setVisible(false);
        Income2NDCHANGESPEND.setVisible(false);
        incoRem1stCHANGESPEND.setVisible(false);
        incoDATACHANGESPEND.setVisible(false);
        incoCHECKBOXPLACECHANGESPEND.setVisible(false);
        infoABOUT.setVisible(false);
        ChooseChange.setVisible(false);
        butpanel.setVisible(false);
        infoABOUTSPEND.setVisible(false);
        ChooseChangeSPEND.setVisible(false);
        butpanelSPEND.setVisible(false);

    }

    
    @Override
    public void actionPerformed(ActionEvent e) {



        //password

        if(e.getSource() == p1){


            if(triggered == true){
                triggered = false;
                input.setFont(new Font("Monospaced", Font.BOLD, 30));
                input.setForeground(Color.black);
                input.setText("");
                pass.setLength(0);
                pass.append(1);
                input.append("*");
            }
            
            else if(pass.length() != 14){
            input.append("*");
            pass.append(1);
            }

             
            
        }

        if(e.getSource() == p2){

                 if(triggered == true){
                triggered = false;
                input.setFont(new Font("Monospaced", Font.BOLD, 30));
                input.setForeground(Color.black);
                input.setText("");
                pass.setLength(0);
                pass.append(2);
                input.append("*");
            }

            else if(pass.length() != 14){
            input.append("*");
            pass.append(2);
             }
            
        }

        if(e.getSource() == p3){

             if(triggered == true){
                triggered = false;
                input.setFont(new Font("Monospaced", Font.BOLD, 30));
                input.setForeground(Color.black);
                input.setText("");
                pass.setLength(0);
                pass.append(3);
                input.append("*");
            }

             else if(pass.length() != 14){
            input.append("*");
            pass.append(3);
             }
            
        
    }

         if(e.getSource() == p4){

             if(triggered == true){
                triggered = false;
                input.setFont(new Font("Monospaced", Font.BOLD, 30));
                input.setForeground(Color.black);
                input.setText("");
                pass.setLength(0);
                pass.append(4);
                input.append("*");
            }

            else if(pass.length() != 14){
            input.append("*");
            pass.append(4);
             }
            
             
        }

         if(e.getSource() == p5){

             if(triggered == true){
                triggered = false;
                input.setFont(new Font("Monospaced", Font.BOLD, 30));
                input.setForeground(Color.black);
                input.setText("");
                pass.setLength(0);
                pass.append(5);
                input.append("*");
            }

             else if(pass.length() != 14){
            input.append("*");
            pass.append(5);
             
         }
            
        }

         if(e.getSource() == p6){

             if(triggered == true){
                triggered = false;
                input.setFont(new Font("Monospaced", Font.BOLD, 30));
                input.setForeground(Color.black);
                input.setText("");
                pass.setLength(0);
                pass.append(6);
                input.append("*");
            }

             else if(pass.length() != 14){
            input.append("*");
            pass.append(6);
            
         }
            
        }

         if(e.getSource() == p7){

             if(triggered == true){
                triggered = false;
                input.setFont(new Font("Monospaced", Font.BOLD, 30));
                input.setForeground(Color.black);
                input.setText("");
                pass.setLength(0);
                pass.append(7);
                input.append("*");
            }

            else if(pass.length() != 14){
            input.append("*");
            pass.append(7);
             }
            
        }

         if(e.getSource() == p8){


             if(triggered == true){
                triggered = false;
                input.setFont(new Font("Monospaced", Font.BOLD, 30));
                input.setForeground(Color.black);
                input.setText("");
                pass.setLength(0);
                pass.append(8);
                input.append("*");
            }

            else if(pass.length() != 14){
            input.append("*");
            pass.append(8);
             }
            
        }

         if(e.getSource() == p9){

             if(triggered == true){
                triggered = false;
                input.setFont(new Font("Monospaced", Font.BOLD, 30));
                input.setForeground(Color.black);
                input.setText("");
                pass.setLength(0);
                pass.append(9);
                input.append("*");
            }


            else if(pass.length() != 14){
            input.append("*");
            pass.append(9);
             }
            
        }

         if(e.getSource() == p11){

             if(triggered == true){
                triggered = false;
                input.setFont(new Font("Monospaced", Font.BOLD, 30));
                input.setForeground(Color.black);
                input.setText("");
                pass.setLength(0);
                pass.append(0);
                input.append("*");
            }


            else if(pass.length() != 14){
            input.append("*");
            pass.append(0);
             }
            
        }

         if(e.getSource() == p10){
            
            
            String current = input.getText();
            if(pass.length() > 0){
            pass.delete(pass.length()-1,pass.length());
            input.setText(current.substring(0,current.length() - 1));
           
            
            }

            

           
            
        }

         if(e.getSource() == p12){

            
            if(pass.toString().equals(code.pp())){
            
            bandyta = 0;
            Multiplier = 0;


            SpentADD.setVisible(true);
            SpentCHANGE.setVisible(true);
            SpentREMOVE.setVisible(true);

            p12.setBackground(Color.green);

            input.setForeground(Color.green);
            password.setVisible(false);
            password2.setVisible(false);

            header.setVisible(true);

            Income.setVisible(true);
            Spent.setVisible(true);
            s1.setVisible(true);
            s2.setVisible(true);
            s3.setVisible(true);
            s4.setVisible(true);
            i1.setVisible(true);
            i2.setVisible(true);
            i3.setVisible(true);
            i4.setVisible(true);

            TotalSpent.setVisible(true);
            kiekSpent.setVisible(true);
            kiekIncome.setVisible(true);
            totalIncome.setVisible(true);
            IncomeTEXT.setVisible(true);
            SavedTEXT.setVisible(true);
            infoForIncome.setVisible(true);
            infoForSpend.setVisible(true);
           
            IncomeFROMto.setVisible(true);
            IncomeData.setVisible(true);
            IncomeExtra.setVisible(true);
            scrollPane.setVisible(true);
             
                
            
            SpentFROMto.setVisible(true);
            SpentData.setVisible(true);
            SpentExtra.setVisible(true);
            scrollPane2.setVisible(true);




           

                
            }

            else{

                // animacijos ir blokavimas
                

                p12.setEnabled(false);
                
                       extraPASS();
                    int ShowInfo = 0;
                       if(bandyta <= 2){
                         ShowInfo = bandyta;
                       }

                       else{
                        ShowInfo = galimabadyti;
                       }

                input.setForeground(Color.red);
                input.setFont(new Font("Monospaced", Font.BOLD, 17));
                input.setText("Bandymas:[" + ShowInfo + "]" + " Galimi:[" + galimabadyti + "]" );
                  if(bandyta == galimabadyti+1){
                     input.setText("Pasiektas Limitas" );
                  }
                triggered =  true;

                
               
                  



                   

            }
        }


        //password



        //Income CHANGE

        if(e.getSource() == IncomeCHANGE){

            SpentData.setVisible(false);
            SpentExtra.setVisible(false);
            Spent.setVisible(false);
            SpentFROMto.setVisible(false);


            ADD.setVisible(false);
            ADDextenction1.setVisible(false);
            ADDextenction2.setVisible(false);

            IncomeCancel3.setVisible(true);
            Atsaukti3.setVisible(true);


            SpentData.setVisible(false);
            SpentExtra.setVisible(false);
            Spent.setVisible(false);
            SpentFROMto.setVisible(false);

            IncomeCancel2.setVisible(false);
            Atsaukti2.setVisible(false);

            IncomeCancel.setVisible(false);
            Atsaukti.setVisible(false);

            Income2ND.setVisible(false);
            incoRem1st.setVisible(false);
            incoDATA.setVisible(false);
            incoCHECKBOXPLACE.setVisible(false);

        Income2NDCHANGE.setVisible(true);
        incoRem1stCHANGE.setVisible(true);
        incoDATACHANGE.setVisible(true);
        incoCHECKBOXPLACECHANGE.setVisible(true);

        butpanel.setVisible(true);
        ChooseChange.setVisible(true);



    }

        if(e.getSource() == removeButtREmCHANGE) {

    InforRemoveADDinfoCHANGE.setText("");
    SeartchincotoremoveCHANGE.setText("");
    InfoREMcheckCHANGE.setSelected(false);
    InfoREMcheckCHANGE.setEnabled(false);
    IncomeCancel3.setEnabled(false);

}

        if(e.getSource() == searchtheidCHANGE) {

        in2 = code.cahageinfo(Integer.parseInt(SeartchincotoremoveCHANGE.getText()));

    InforRemoveADDinfoCHANGE.setFont(new Font("Monospaced", Font.BOLD, 14));
    InforRemoveADDinfoCHANGE.setForeground(Color.black);

    if(!in2.isEmpty()) {

        InforRemoveADDinfoCHANGE.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
        InforRemoveADDinfoCHANGE.append("------------------------------------------------------------------------------------\n");

        StringBuilder bd = new StringBuilder();
        for(Income s : in2){
            bd.append(s).append("\n");
        }

        InforRemoveADDinfoCHANGE.append(bd.toString());
        

    } else {

        InforRemoveADDinfoCHANGE.setFont(new Font("Monospaced", Font.BOLD, 20));
        InforRemoveADDinfoCHANGE.setForeground(Color.RED);
        InforRemoveADDinfoCHANGE.setText("\n                  Informacijos nerasta ! ");

        InfoREMcheckCHANGE.setSelected(false);
        InfoREMcheckCHANGE.setEnabled(false);
        IncomeCancel3.setEnabled(false);
    }
}

        if(e.getSource() == but1){
                changing = "DATA";
                problems.setForeground(Color.green);
                problems.setText("Keiciama DATA į");
                InfoREMcheckCHANGE.setEnabled(false);
                InfoREMcheckCHANGE.setSelected(false);
                IncomeCancel3.setEnabled(false);
                inputaboutchange.setText("");

                

                
        }

        if(e.getSource() == but2){
                 changing = "SUMA";
                 problems.setForeground(Color.green);
                 problems.setText("Keiciama SUMA į");
                 InfoREMcheckCHANGE.setEnabled(false);
                 InfoREMcheckCHANGE.setSelected(false);
                 IncomeCancel3.setEnabled(false);
                 inputaboutchange.setText("");
        }

        if(e.getSource() == but3){
                changing = "KATEGORIJA";
                problems.setForeground(Color.green);
                 problems.setText("Keiciama KATEGORIJA į" );
                 InfoREMcheckCHANGE.setEnabled(false);
                 InfoREMcheckCHANGE.setSelected(false);
                 IncomeCancel3.setEnabled(false);
                 inputaboutchange.setText("");
        }

        if(e.getSource() == but4){
                changing = "VIETA";
                problems.setForeground(Color.green);
                 problems.setText("Keiciama VIETA į");
                 problems.setForeground(Color.green);
                 InfoREMcheckCHANGE.setEnabled(false);
                 InfoREMcheckCHANGE.setSelected(false);
                 IncomeCancel3.setEnabled(false);
                 inputaboutchange.setText("");
        }

        if(e.getSource() == but5){
                changing = "TIPAS";
                problems.setForeground(Color.green);
                 problems.setText("Keiciamas TIPAS į");
                 InfoREMcheckCHANGE.setEnabled(false);
                 InfoREMcheckCHANGE.setSelected(false);
                 IncomeCancel3.setEnabled(false);
                 inputaboutchange.setText("");
                 
        }

        if(e.getSource() == keistiinfosubuuton){


                if(in2.isEmpty()){
                        problems.setForeground(Color.red);
                        problems.setText("Informacija nerasta");
                        text2.setBackground(Color.red);
                        text2.setForeground(Color.white);
                        InfoREMcheckCHANGE.setEnabled(false);
                        IncomeCancel3.setEnabled(false);
                        

                }
                


                if(!inputaboutchange.getText().isEmpty() && !in2.isEmpty() ){

                        text2.setBackground(null);
                        text2.setForeground(Color.black);
                     
                        if(changing.equals("DATA")){
                                InfoREMcheckCHANGE.setEnabled(false);
                                if(inputaboutchange.getText().length() < 10 || inputaboutchange.getText().length() > 10){

                                problems.setForeground(Color.red);
                                problems.setText("Bloga data pvz 2025-06-26");
                                
                                InfoREMcheckCHANGE.setEnabled(false);
                                
                                }
                                else{
                                        problems.setForeground(Color.green);
                                     problems.setText("Data tinka !");   
                                     InfoREMcheckCHANGE.setEnabled(true);
                                }


                        }


                            if(changing.equals("SUMA")){


                                
                                        
                               InfoREMcheckCHANGE.setEnabled(false);
                                if(inputaboutchange.getText().length() > 12){

                                problems.setForeground(Color.red);
                                problems.setText("Suma yra per ilga");
                                InfoREMcheckCHANGE.setEnabled(false);
                                
                                }

                                 
                                else{
                                    InfoREMcheckCHANGE.setEnabled(true);    
                                }
                       
                        }


                             if(changing.equals("KATEGORIJA")){

                                InfoREMcheckCHANGE.setEnabled(false);
                                if(inputaboutchange.getText().length() > 20){

                                problems.setForeground(Color.red);
                                problems.setText("Kategorija yra per ilga");
                                InfoREMcheckCHANGE.setEnabled(false);
                                
                                }

                                else{
                                     InfoREMcheckCHANGE.setEnabled(true);   
                                }

                       
                        }


                        if(changing.equals("VIETA")){


                                InfoREMcheckCHANGE.setEnabled(false);
                                
                                if(inputaboutchange.getText().length() > 20){

                                problems.setForeground(Color.red);
                                problems.setText("Vieta yra per ilga");
                                InfoREMcheckCHANGE.setEnabled(false);
                                
                                }

                                else{
                                        InfoREMcheckCHANGE.setEnabled(true);
                                }

        

                       
                        }


                           if(changing.equals("TIPAS")){


                                
                                InfoREMcheckCHANGE.setEnabled(false);        
                               
                                if(inputaboutchange.getText().length() > 20){

                                problems.setForeground(Color.red);
                                problems.setText("TIPAS yra per ilgas");
                                InfoREMcheckCHANGE.setEnabled(false);
                                
                                }

                
                                else{
                                   InfoREMcheckCHANGE.setEnabled(true);
                                }
                       
                        }


                        



                        //InfoREMcheckCHANGE.setEnabled(true);
                }

        }

        if(e.getSource() == InfoREMcheckCHANGE) {
                
        IncomeCancel3.setEnabled(InfoREMcheckCHANGE.isSelected());
}

        if(e.getSource() == IncomeCancel3) {

                 try {
                Boolean ok = false;


                    text2.setBackground(null);
                        text2.setForeground(Color.black);
                     
                        if(changing.equals("DATA")){
                                InfoREMcheckCHANGE.setEnabled(false);
                                ok = false;
                                if(inputaboutchange.getText().length() < 10 || inputaboutchange.getText().length() > 10){

                                problems.setForeground(Color.red);
                                problems.setText("Bloga data pvz 2025-06-26");
                                InfoREMcheckCHANGE.setEnabled(false);
                                InfoREMcheckCHANGE.setSelected(false);
                                IncomeCancel3.setEnabled(false);
                                
                                
                                }
                                else{
                                    problems.setForeground(Color.green);
                                     problems.setText("Data tinka !");   
                                     InfoREMcheckCHANGE.setEnabled(true);
                                     ok = true;
                                }


                        }


                            if(changing.equals("SUMA")){


                                ok = false;
                                        
                               InfoREMcheckCHANGE.setEnabled(false);
                                if(inputaboutchange.getText().length() > 12){

                                problems.setForeground(Color.red);
                                problems.setText("Suma yra per ilga");
                                InfoREMcheckCHANGE.setEnabled(false);
                                InfoREMcheckCHANGE.setSelected(false);
                                IncomeCancel3.setEnabled(false);
                                
                                }

                                 
                                else{
                                    InfoREMcheckCHANGE.setEnabled(true);   
                                    ok = true; 
                                }
                       
                        }


                             if(changing.equals("KATEGORIJA")){
                                ok = false;
                                InfoREMcheckCHANGE.setEnabled(false);
                                if(inputaboutchange.getText().length() > 20){

                                problems.setForeground(Color.red);
                                problems.setText("Kategorija yra per ilga");
                                InfoREMcheckCHANGE.setEnabled(false);
                                InfoREMcheckCHANGE.setSelected(false);
                                IncomeCancel3.setEnabled(false);
                                
                                }

                                else{
                                     InfoREMcheckCHANGE.setEnabled(true);   
                                     ok = true;
                                }

                       
                        }


                        if(changing.equals("VIETA")){

                                ok = false;
                                InfoREMcheckCHANGE.setEnabled(false);
                                
                                if(inputaboutchange.getText().length() > 20){

                                problems.setForeground(Color.red);
                                problems.setText("Vieta yra per ilga");
                                InfoREMcheckCHANGE.setEnabled(false);
                                InfoREMcheckCHANGE.setSelected(false);
                                IncomeCancel3.setEnabled(false);
                                
                                }

                                else{
                                        InfoREMcheckCHANGE.setEnabled(true);
                                        ok = true;
                                }

        

                       
                        }


                           if(changing.equals("TIPAS")){

                                ok = false;
                                
                                InfoREMcheckCHANGE.setEnabled(false);        
                               
                                if(inputaboutchange.getText().length() > 20){

                                problems.setForeground(Color.red);
                                problems.setText("TIPAS yra per ilgas");
                                InfoREMcheckCHANGE.setEnabled(false);
                                InfoREMcheckCHANGE.setSelected(false);
                                IncomeCancel3.setEnabled(false);
                                
                                }

                
                                else{
                                   InfoREMcheckCHANGE.setEnabled(true);
                                   ok = true;
                                }
                       
                        }

                        if(ok){
                        code.changinginfo(changing, inputaboutchange.getText());
                        
       
       
                
       



        
         problems.setForeground(Color.red);
        problems.setText("Nepasirenkta");
        inputaboutchange.setText("");


    ArrayList<Income> info = code.show();
    StringBuilder bd = new StringBuilder();

    kiek = 0;

    for(Income s : info){
        bd.append(s).append("\n");
        kiek++;
    }


    IncomeData.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
    IncomeData.append("------------------------------------------------------------------------------------\n");
    IncomeData.append(bd.toString());

    // atnaujinti kieki ir naujausa
    kiekIncome.setText("Rasta: " + kiek);
    totalIncome.setText("M: " + code.dabartinesuma().toString() +"Eur");
    // atnaujinti kieki ir naujausa

    text2.setBackground(null);
    text2.setForeground(Color.black);
    InfoREMcheckCHANGE.setEnabled(false);
    InfoREMcheckCHANGE.setSelected(false);
    IncomeCancel2.setEnabled(false);
    SeartchincotoremoveCHANGE.setText("");
    InforRemoveADDinfoCHANGE.setText("");

    SpentData.setVisible(true);
    SpentExtra.setVisible(true);
    Spent.setVisible(true);
    SpentFROMto.setVisible(true);

    IncomeCancel2.setVisible(false);
    Atsaukti2.setVisible(false);

    IncomeCancel3.setVisible(false);
    IncomeCancel3.setEnabled(false);
    Atsaukti3.setVisible(false);

    Income2NDCHANGE.setVisible(false);
    incoRem1stCHANGE.setVisible(false);
    incoDATACHANGE.setVisible(false);
    incoCHECKBOXPLACECHANGE.setVisible(false);

         
}

  } catch (DateTimeParseException ez) {
                System.out.println(ez);
                 problems.setForeground(Color.red);
                problems.setText("Bloga data pvz 2025-06-26");
                InfoREMcheckCHANGE.setEnabled(false);
                InfoREMcheckCHANGE.setSelected(false);
                IncomeCancel3.setEnabled(false);
         }  

         catch (NumberFormatException ez2) {
                System.out.println(ez2);
                 problems.setForeground(Color.red);
                problems.setText("err suma [" + inputaboutchange.getText() + "]" );
                InfoREMcheckCHANGE.setEnabled(false);
                InfoREMcheckCHANGE.setSelected(false);
                IncomeCancel3.setEnabled(false);
         }  

         


}

        if(e.getSource() == Atsaukti3) {



        problems.setForeground(Color.red);
        problems.setText("Nepasirenkta");
        inputaboutchange.setText("");

        text2.setBackground(null);
        text2.setForeground(Color.black);


        InfoREMcheckCHANGE.setEnabled(false);
        InfoREMcheckCHANGE.setSelected(false);
        IncomeCancel2.setEnabled(false);
        SeartchincotoremoveCHANGE.setText("");
        InforRemoveADDinfoCHANGE.setText("");

        SpentData.setVisible(true);
        SpentExtra.setVisible(true);
        Spent.setVisible(true);
        SpentFROMto.setVisible(true);

        IncomeCancel2.setVisible(false);
        Atsaukti2.setVisible(false);

        IncomeCancel3.setVisible(false);
        Atsaukti3.setVisible(false);

        Income2NDCHANGE.setVisible(false);
        incoRem1stCHANGE.setVisible(false);
        incoDATACHANGE.setVisible(false);
        incoCHECKBOXPLACECHANGE.setVisible(false);
        }

        //Income CHANGE


        //Income remove

        if(e.getSource() == removeButtREm){

                
                InforRemoveADDinfo.setText("");
                Seartchincotoremove.setText("");
                InfoREMcheck.setSelected(false);
                InfoREMcheck.setEnabled(false);
                IncomeCancel2.setEnabled(false);

        }

        if(e.getSource() == searchtheid){

            try {
                
           
                ArrayList<Income> in = code.pasalintiinfo(Integer.parseInt(Seartchincotoremove.getText()));

               InforRemoveADDinfo.setFont(new Font("Monospaced", Font.BOLD, 14));
               InforRemoveADDinfo.setForeground(Color.black);

                if(!in.isEmpty()){

                InforRemoveADDinfo.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
                InforRemoveADDinfo.append("------------------------------------------------------------------------------------\n");

                StringBuilder bd = new StringBuilder();
                for(Income s: in){
                        bd.append(s).append("\n");
                }

                InforRemoveADDinfo.append(bd.toString());
                InfoREMcheck.setEnabled(true);


               
               
        }
        else{
               InforRemoveADDinfo.setFont(new Font("Monospaced", Font.BOLD, 20));
               InforRemoveADDinfo.setForeground(Color.RED);
               InforRemoveADDinfo.setText("\n                  Informacijos nerasta ! "); 

               InfoREMcheck.setSelected(false);
               InfoREMcheck.setEnabled(false);
               IncomeCancel2.setEnabled(false);
        }

         } catch (Exception ee) {
                
            }

        }

        if(e.getSource() == InfoREMcheck){
                IncomeCancel2.setEnabled(InfoREMcheck.isSelected());
                }

        if(e.getSource() == IncomeCancel2){

                 code.pasalinti();

                 ArrayList<Income> info = code.show();
                 StringBuilder bd = new StringBuilder();

                        kiek = 0;

                 for(Income s : info){
                        bd.append(s).append("\n");
                        kiek++;
                 }

                IncomeData.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
                IncomeData.append("------------------------------------------------------------------------------------\n");
                IncomeData.append(bd.toString());


                 // atnaujinti kieki ir naujausa
                kiekIncome.setText("Rasta: " + kiek);
                totalIncome.setText("M: " + code.dabartinesuma().toString());
                 // atnaujinti kieki ir naujausa

        
                InfoREMcheck.setEnabled(false);
                InfoREMcheck.setSelected(false);
                IncomeCancel2.setEnabled(false);
                Seartchincotoremove.setText("");
                InforRemoveADDinfo.setText("");


        
            

            SpentData.setVisible(true);
            SpentExtra.setVisible(true);
            Spent.setVisible(true);
            SpentFROMto.setVisible(true);

            IncomeCancel2.setVisible(false);
            Atsaukti2.setVisible(false);

            IncomeCancel3.setVisible(false);
            Atsaukti3.setVisible(false);

            Income2ND.setVisible(false);
            incoRem1st.setVisible(false);
            incoDATA.setVisible(false);
            incoCHECKBOXPLACE.setVisible(false);

            

    }           

        if(e.getSource() == Atsaukti2){

                InfoREMcheck.setEnabled(false);
                InfoREMcheck.setSelected(false);
                IncomeCancel2.setEnabled(false);
                Seartchincotoremove.setText("");
                InforRemoveADDinfo.setText("");



                

            SpentData.setVisible(true);
            SpentExtra.setVisible(true);
            Spent.setVisible(true);
            SpentFROMto.setVisible(true);

            IncomeCancel2.setVisible(false);
            Atsaukti2.setVisible(false);

            IncomeCancel3.setVisible(false);
            Atsaukti3.setVisible(false);

            Income2ND.setVisible(false);
            incoRem1st.setVisible(false);
            incoDATA.setVisible(false);
            incoCHECKBOXPLACE.setVisible(false);

            
    }

        if(e.getSource() == IncomeREMOVE){

             SpentData.setVisible(false);
            SpentExtra.setVisible(false);
            Spent.setVisible(false);
            SpentFROMto.setVisible(false);


            
            ADD.setVisible(false);
            ADDextenction1.setVisible(false);
            ADDextenction2.setVisible(false);
                
            IncomeCancel.setVisible(false);
            Atsaukti.setVisible(false);

            Income2ND.setVisible(true);
            incoRem1st.setVisible(true);
            incoDATA.setVisible(true);
            incoCHECKBOXPLACE.setVisible(true);

            

            Income2NDCHANGE.setVisible(false);
            incoRem1stCHANGE.setVisible(false);
            incoDATACHANGE.setVisible(false);
            incoCHECKBOXPLACECHANGE.setVisible(false);

            IncomeCancel2.setVisible(true);
            Atsaukti2.setVisible(true);

            IncomeCancel3.setVisible(false);
            Atsaukti3.setVisible(false);
    }

        //Income remove


        
        // add income 

        if(e.getSource() == IncomeADD){



                


            SpentData.setVisible(false);
            SpentExtra.setVisible(false);
            Spent.setVisible(false);
            SpentFROMto.setVisible(false);


            
            ADD.setVisible(true);
            ADDextenction1.setVisible(true);
            ADDextenction2.setVisible(true);

            IncomeCancel.setVisible(true);
            Atsaukti.setVisible(true);

            Income2ND.setVisible(false);
            incoRem1st.setVisible(false);
            incoDATA.setVisible(false);
            incoCHECKBOXPLACE.setVisible(false);


            Income2NDCHANGE.setVisible(false);
            incoRem1stCHANGE.setVisible(false);
            incoDATACHANGE.setVisible(false);
            incoCHECKBOXPLACECHANGE.setVisible(false);

            IncomeCancel2.setVisible(false);
            Atsaukti2.setVisible(false);

            IncomeCancel3.setVisible(false);
            Atsaukti3.setVisible(false);


        }

        if(e.getSource() == Atsaukti){

                //reset info
                B11field.setText("");
                B22.setText("");
                B33.setText("");
                B44.setText("");
                agreetoadd.setEnabled(false);
                agreetoadd.setSelected(false);
                IncomeCancel.setEnabled(false);
                B6.setText("Neviskas uzpildyta");
                B6.setForeground(Color.RED);

            SpentData.setVisible(true);
            SpentExtra.setVisible(true);
            Spent.setVisible(true);
            SpentFROMto.setVisible(true);
            IncomeCancel.setVisible(false);
            Atsaukti.setVisible(false);

            ADD.setVisible(false);
            ADDextenction1.setVisible(false);
            ADDextenction2.setVisible(false);
    }

        if(e.getSource() == IncomeCancel){

                
                try {
                
            SpentData.setVisible(true);
            SpentExtra.setVisible(true);
            Spent.setVisible(true);
            SpentFROMto.setVisible(true);
            IncomeCancel.setVisible(false);
            Atsaukti.setVisible(false);

            code.addnewincome( LocalDate.parse(B11field.getText()), Double.parseDouble(B22.getText()) , B33.getText(), B44.getText(), gryniarkortele);

            ADD.setVisible(false);
            ADDextenction1.setVisible(false);
            ADDextenction2.setVisible(false);
            
            ArrayList<Income> income = code.show();


            // extra information
            kiek = income.size();

            kiekIncome.setText(String.valueOf("Rasta: " + kiek));

            totalIncome.setText("M: " + code.dabartinesuma().toString());
            

            StringBuilder bd = new StringBuilder();

            for(Income s: income){
                bd.append(s).append("\n");
            }
             IncomeData.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
                         IncomeData.append("------------------------------------------------------------------------------------\n");
            IncomeData.append(bd.toString());

                
                
                B11field.setText("Data");
                B22.setText("");
                B33.setText("");
                B44.setText("");
                B6.setText("Neviskas uzpildyta");
                B6.setForeground(Color.RED);
                agreetoadd.setEnabled(false);
                agreetoadd.setSelected(false);
                IncomeCancel.setEnabled(false);

            

           
              } catch (NumberFormatException  ee) {
                B6.setText("err suma [" + B22.getText() + "]");
                B6.setForeground(Color.RED);
                 agreetoadd.setEnabled(false);
                 agreetoadd.setSelected(false);
                 IncomeCancel.setEnabled(false);

                 SpentData.setVisible(false);
                 SpentExtra.setVisible(false);
                 Spent.setVisible(false);
                 SpentFROMto.setVisible(false);
                 IncomeCancel.setVisible(true);
                 Atsaukti.setVisible(true);
                }

    }

        if(e.getSource() == B11button){

                LocalDate date = LocalDate.now();
                
                B11field.setText(date.toString());
        }

        if(e.getSource() == B55button1 || e.getSource() == B55button2 || e.getSource() == B55button3 ){

                



  

        if(B44.getText().isEmpty()){
                        B6.setText("Vietos nera");

                }

        if(B33.getText().isEmpty()){
                        B6.setText("Kategorijos nera");

                }
                
        if(B22.getText().isEmpty()){
                        B6.setText("Sumos nera");

                }

        if(B11field.getText().isEmpty()){
                        B6.setText("Datos nera");

                }
                
        if(B22.getText().length() >= 12){
                                B6.setForeground(Color.red);
                                agreetoadd.setEnabled(false);
                                B6.setText("Per didele suma");
                         }

        else if(!B11field.getText().isEmpty() && !B22.getText().isEmpty() && !B33.getText().isEmpty()  && !B44.getText().isEmpty()){
                        
                                if(B11field.getText().length() != 10){
                         B6.setForeground(Color.red);
                         B6.setText("Data netinka");
                         }


                         else{
                         B6.setForeground(Color.green);
                         B6.setText("Viskas uzpildyta");
                         agreetoadd.setEnabled(true);
                         }
                         

                }

               
                
               
        
        }

        if(e.getSource() == agreetoadd){
               IncomeCancel.setEnabled(agreetoadd.isSelected());
        }

        if(e.getSource() == B55button1){

                gryniarkortele = "Grynais";

        }

        if(e.getSource() == B55button2){

                gryniarkortele = "Kortele";

        }

          if(e.getSource() == B55button3){

                gryniarkortele = "Abiems";

        }
        // add income 
        



        // SPent add

        if(e.getSource() == SpentADD){
            codeSpend.UserSettings();
        IncomeFROMto.setVisible(false);
        IncomeExtra.setVisible(false);
        Income.setVisible(false);
        IncomeCancelSPEND.setVisible(true);
        AtsauktiSPEND.setVisible(true);
        ADDSPEND.setVisible(true);
        ADDextenction1SPEND.setVisible(true);
        ADDextenction2SPEND.setVisible(true);

        IncomeCancel2SPEND.setVisible(false);
        Atsaukti2SPEND.setVisible(false);

        IncomeCancel3SPEND.setVisible(false);
        Atsaukti3SPEND.setVisible(false);

          Income2NDSPEND.setVisible(false);
        incoRem1stSPEND.setVisible(false);
        incoDATASPEND.setVisible(false);
        incoCHECKBOXPLACESPEND.setVisible(false);


        ADDSPEND.setVisible(false);
        ADDextenction1SPEND.setVisible(false);
        ADDextenction2SPEND.setVisible(false);
        }

        if (e.getSource() == SpentADD) {
            codeSpend.UserSettings();
    Income.setVisible(false);
    Income2ND.setVisible(false);
    IncomeFROMto.setVisible(false);
    IncomeCancel.setVisible(false);
    Atsaukti.setVisible(false);

    ADDSPEND.setVisible(true);
    ADDextenction1SPEND.setVisible(true);
    ADDextenction2SPEND.setVisible(true);

    IncomeData.setVisible(false);
    IncomeExtra.setVisible(false);
    Income.setVisible(false);
    IncomeFROMto.setVisible(false);

    IncomeCancel2.setVisible(false);
    Atsaukti2.setVisible(false);
    IncomeCancel3.setVisible(false);
    Atsaukti3.setVisible(false);
    IncomeCancelSPEND.setVisible(true);
    AtsauktiSPEND.setVisible(true);


    IncomeCancel2SPEND.setVisible(false);
    Atsaukti2SPEND.setVisible(false);

    IncomeCancel3SPEND.setVisible(false);
    Atsaukti3SPEND.setVisible(false);

        Income2NDSPEND.setVisible(false);
        incoRem1stSPEND.setVisible(false);
        incoDATASPEND.setVisible(false);
        incoCHECKBOXPLACESPEND.setVisible(false);


        Income2NDCHANGESPEND.setVisible(false);
    incoRem1stCHANGESPEND.setVisible(false);
    incoDATACHANGESPEND.setVisible(false);
    incoCHECKBOXPLACECHANGESPEND.setVisible(false);
        


}

        if (e.getSource() == AtsauktiSPEND) {

    // reset info
    B11fieldSPEND.setText("");
    B22SPEND.setText("");
    B33SPEND.setText("");
    B44SPEND.setText("");
    agreetoaddSPEND.setEnabled(false);
    agreetoaddSPEND.setSelected(false);
    IncomeCancelSPEND.setEnabled(false);
    B6SPEND.setText("Neviskas uzpildyta");
    B6SPEND.setForeground(Color.RED);

    IncomeData.setVisible(true);
    IncomeExtra.setVisible(true);
    Income.setVisible(true);
    IncomeFROMto.setVisible(true);
    IncomeCancelSPEND.setVisible(false);
    AtsauktiSPEND.setVisible(false);

    ADDSPEND.setVisible(false);
    ADDextenction1SPEND.setVisible(false);
    ADDextenction2SPEND.setVisible(false);
}

        if (e.getSource() == IncomeCancelSPEND) {
    try {
        IncomeData.setVisible(true);
        IncomeExtra.setVisible(true);
        Income.setVisible(true);
        IncomeFROMto.setVisible(true);
        IncomeCancelSPEND.setVisible(false);
        AtsauktiSPEND.setVisible(false);

        codeSpend.addnewincome("iddd", LocalDate.parse(B11fieldSPEND.getText()), Double.parseDouble(B22SPEND.getText()), B33SPEND.getText(), B44SPEND.getText(), gryniarkortele);

        ADDSPEND.setVisible(false);
        ADDextenction1SPEND.setVisible(false);
        ADDextenction2SPEND.setVisible(false);

        ArrayList<Spent> spend = codeSpend.showSPEND();
        kiek = spend.size();
     

        kiekSpent.setText("Rasta: " + kiek);
        TotalSpent.setText("Iš viso: " + codeSpend.dabartinesuma().toString() + "Eur");


          ArrayList<Income> income = code.show();

            kiek = income.size();

           

            kiekIncome.setText(String.valueOf("Rasta: " + kiek));

            totalIncome.setText("M: " + code.dabartinesuma().toString());
            

            StringBuilder bd = new StringBuilder();

            for(Income s: income){
                bd.append(s).append("\n");
            }
            IncomeData.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
            IncomeData.append("------------------------------------------------------------------------------------\n");
            IncomeData.append(bd.toString());


        StringBuilder bd2 = new StringBuilder();
        for (Spent s : spend) {
            bd2.append(s).append("\n");
        }

        SpentData.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "Spend", "category", "  location", "Type\n"));
        SpentData.append("------------------------------------------------------------------------------------\n");
        SpentData.append(bd2.toString());

        // Reset form
        B11fieldSPEND.setText("Data");
        B22SPEND.setText("");
        B33SPEND.setText("");
        B44SPEND.setText("");
        B6SPEND.setText("Neviskas uzpildyta");
        B6SPEND.setForeground(Color.RED);
        agreetoaddSPEND.setEnabled(false);
        agreetoaddSPEND.setSelected(false);
        IncomeCancelSPEND.setEnabled(false);

    } catch (NumberFormatException ee) {
        B6SPEND.setText("err suma [" + B22SPEND.getText() + "]");
        B6SPEND.setForeground(Color.RED);
        agreetoaddSPEND.setEnabled(false);
        agreetoaddSPEND.setSelected(false);
        IncomeCancelSPEND.setEnabled(false);

        IncomeData.setVisible(false);
        IncomeExtra.setVisible(false);
        Income.setVisible(false);
        IncomeFROMto.setVisible(false);
        IncomeCancelSPEND.setVisible(true);
        AtsauktiSPEND.setVisible(true);
    }
}

        if (e.getSource() == B11buttonSPEND) {
    LocalDate date = LocalDate.now();
    B11fieldSPEND.setText(date.toString());
}

        if (e.getSource() == B55button1SPEND || e.getSource() == B55button2SPEND) {

    if (B44SPEND.getText().isEmpty()) {
        B6SPEND.setText("Vietos nera");
    }

    if (B33SPEND.getText().isEmpty()) {
        B6SPEND.setText("Kategorijos nera");
    }

    if (B22SPEND.getText().isEmpty()) {
        B6SPEND.setText("Sumos nera");
    }

    if (B11fieldSPEND.getText().isEmpty()) {
        B6SPEND.setText("Datos nera");
    }

    if (B22SPEND.getText().length() >= 12) {
        B6SPEND.setForeground(Color.RED);
        agreetoaddSPEND.setEnabled(false);
        B6SPEND.setText("Per didele suma");
    } else if (!B11fieldSPEND.getText().isEmpty() && !B22SPEND.getText().isEmpty() &&
               !B33SPEND.getText().isEmpty() && !B44SPEND.getText().isEmpty()) {

        if (B11fieldSPEND.getText().length() != 10) {
            B6SPEND.setForeground(Color.RED);
            B6SPEND.setText("Data netinka");
        } else {
            B6SPEND.setForeground(Color.GREEN);
            B6SPEND.setText("Viskas uzpildyta");
            agreetoaddSPEND.setEnabled(true);
        }
    }
}

        if (e.getSource() == agreetoaddSPEND) {
    IncomeCancelSPEND.setEnabled(agreetoaddSPEND.isSelected());
}

        if (e.getSource() == B55button1SPEND) {
    gryniarkortele = "Grynais";
}

        if (e.getSource() == B55button2SPEND) {
    gryniarkortele = "Kortele";
}


        // SPent add



        // SPEND REMOVE

        if(e.getSource() == removeButtREmSPEND){

        InforRemoveADDinfoSPEND.setText("");
        SeartchincotoremoveSPEND.setText("");
        InfoREMcheckSPEND.setSelected(false);
        InfoREMcheckSPEND.setEnabled(false);
        IncomeCancel2.setEnabled(false);

        }

        if(e.getSource() == searchtheidSPEND){

            try{
        ArrayList<Spent> in = codeSpend.pasalintiinfo(Integer.parseInt(SeartchincotoremoveSPEND.getText()));

        InforRemoveADDinfoSPEND.setFont(new Font("Monospaced", Font.BOLD, 14));
        InforRemoveADDinfoSPEND.setForeground(Color.black);

        if(!in.isEmpty()){

                InforRemoveADDinfoSPEND.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
                InforRemoveADDinfoSPEND.append("------------------------------------------------------------------------------------\n");

                StringBuilder bd = new StringBuilder();
                for(Spent s: in){
                bd.append(s).append("\n");
                }

                InforRemoveADDinfoSPEND.append(bd.toString());
                InfoREMcheckSPEND.setEnabled(true);

        } else {
                InforRemoveADDinfoSPEND.setFont(new Font("Monospaced", Font.BOLD, 20));
                InforRemoveADDinfoSPEND.setForeground(Color.RED);
                InforRemoveADDinfoSPEND.setText("\n                  Informacijos nerasta ! "); 

                InfoREMcheckSPEND.setSelected(false);
                InfoREMcheckSPEND.setEnabled(false);
                IncomeCancel2.setEnabled(false);
        }

    }
        catch(NumberFormatException ee){

        }
        }

        if(e.getSource() == InfoREMcheckSPEND){
        IncomeCancel2SPEND.setEnabled(InfoREMcheckSPEND.isSelected());
        }

        if(e.getSource() == IncomeCancel2SPEND){

        codeSpend.pasalinti();

        ArrayList<Spent> info = codeSpend.showSPEND();
        StringBuilder bd = new StringBuilder();

        kiek = 0;

        for(Spent s : info){
                bd.append(s).append("\n");
                kiek++;
        }

        SpentData.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
        SpentData.append("------------------------------------------------------------------------------------\n");
        SpentData.append(bd.toString());

         if(info.isEmpty()){
                TotalSpent.setText("Iš viso: 0.0Eur");
        }

        kiekSpent.setText("Rasta: " + kiek);
        TotalSpent.setText("M: " + codeSpend.dabartinesuma().toString());

       
        InfoREMcheckSPEND.setEnabled(false);
        InfoREMcheckSPEND.setSelected(false);
        IncomeCancel2.setEnabled(false);
        SeartchincotoremoveSPEND.setText("");
        InforRemoveADDinfoSPEND.setText("");

        SpentData.setVisible(true);
        SpentExtra.setVisible(true);
        Spent.setVisible(true);
        SpentFROMto.setVisible(true);

        IncomeFROMto.setVisible(true);
        IncomeExtra.setVisible(true);
        IncomeData.setVisible(true);
        Income.setVisible(true);
        

        IncomeCancel2.setVisible(false);
        Atsaukti2.setVisible(false);

        IncomeCancel2SPEND.setVisible(false);
        Atsaukti2SPEND.setVisible(false);

        IncomeCancel3.setVisible(false);
        Atsaukti3.setVisible(false);
        

        Income2NDSPEND.setVisible(false);
        incoRem1stSPEND.setVisible(false);
        incoDATASPEND.setVisible(false);
        incoCHECKBOXPLACESPEND.setVisible(false);
        }

        if(e.getSource() == Atsaukti2SPEND){

        InfoREMcheckSPEND.setEnabled(false);
        InfoREMcheckSPEND.setSelected(false);
        IncomeCancel2.setEnabled(false);
        SeartchincotoremoveSPEND.setText("");
        InforRemoveADDinfoSPEND.setText("");

        IncomeFROMto.setVisible(true);
        IncomeExtra.setVisible(true);
        Income.setVisible(true);
        IncomeData.setVisible(true);

        IncomeCancel2.setVisible(false);
        Atsaukti2.setVisible(false);

        IncomeCancel2SPEND.setVisible(false);
        Atsaukti2SPEND.setVisible(false);

        IncomeCancel3.setVisible(false);
        Atsaukti3.setVisible(false);

        Income2NDSPEND.setVisible(false);
        incoRem1stSPEND.setVisible(false);
        incoDATASPEND.setVisible(false);
        incoCHECKBOXPLACESPEND.setVisible(false);
        }

        if(e.getSource() == SpentREMOVE){

        IncomeFROMto.setVisible(false);
        IncomeExtra.setVisible(false);
        Income.setVisible(false);
        IncomeData.setVisible(false);


        Income2NDSPEND.setVisible(true);
        incoRem1stSPEND.setVisible(true);
        incoDATASPEND.setVisible(true);
        incoCHECKBOXPLACESPEND.setVisible(true);

        Income2NDCHANGE.setVisible(false);
        incoRem1stCHANGE.setVisible(false);
        incoDATACHANGE.setVisible(false);
        incoCHECKBOXPLACECHANGE.setVisible(false);

        ADDSPEND.setVisible(false);
        ADDextenction1SPEND.setVisible(false);
        ADDextenction2SPEND.setVisible(false);


         Income2NDCHANGESPEND.setVisible(false);
    incoRem1stCHANGESPEND.setVisible(false);
    incoDATACHANGESPEND.setVisible(false);
    incoCHECKBOXPLACECHANGESPEND.setVisible(false);


        IncomeCancelSPEND.setVisible(false);
        AtsauktiSPEND.setVisible(false);

        IncomeCancel2SPEND.setVisible(true);
        Atsaukti2SPEND.setVisible(true);

        IncomeCancel3SPEND.setVisible(false);
        Atsaukti3SPEND.setVisible(false);        
        
        }

        // SPEND REMOVE



        // SPEND change

        if(e.getSource() == SpentCHANGE){


           
                IncomeFROMto.setVisible(false);
                IncomeExtra.setVisible(false);
                Income.setVisible(false);
                IncomeData.setVisible(false);
        
            IncomeCancelSPEND.setVisible(false);
            AtsauktiSPEND.setVisible(false);

            IncomeCancel2SPEND.setVisible(false);
            Atsaukti2SPEND.setVisible(false);

            IncomeCancel3SPEND.setVisible(true);
            Atsaukti3SPEND.setVisible(true);

            Income2ND.setVisible(false);
            incoRem1st.setVisible(false);
            incoDATA.setVisible(false);
            incoCHECKBOXPLACE.setVisible(false);

            Income2NDCHANGESPEND.setVisible(true);
            incoRem1stCHANGESPEND.setVisible(true);
            incoDATACHANGESPEND.setVisible(true);
            incoCHECKBOXPLACECHANGESPEND.setVisible(true);

                Income2NDSPEND.setVisible(false);
                incoRem1stSPEND.setVisible(false);
                incoDATASPEND.setVisible(false);
                incoCHECKBOXPLACESPEND.setVisible(false);


                ADDSPEND.setVisible(false);
                ADDextenction1SPEND.setVisible(false);
                ADDextenction2SPEND.setVisible(false);


                butpanelSPEND.setVisible(true);
                ChooseChangeSPEND.setVisible(true);
            
        }

        if(e.getSource() == removeButtREmCHANGESPEND) {

            InforRemoveADDinfoCHANGESPEND.setText("");
            SeartchincotoremoveCHANGESPEND.setText("");
            InfoREMcheckCHANGESPEND.setSelected(false);
            InfoREMcheckCHANGESPEND.setEnabled(false);
            IncomeCancel3SPEND.setEnabled(false);
        }

        if(e.getSource() == searchtheidCHANGESPEND) {

            in2s = codeSpend.cahageinfo(Integer.parseInt(SeartchincotoremoveCHANGESPEND.getText()));

            InforRemoveADDinfoCHANGESPEND.setFont(new Font("Monospaced", Font.BOLD, 14));
            InforRemoveADDinfoCHANGESPEND.setForeground(Color.black);

            if(!in2s.isEmpty()) {

                InforRemoveADDinfoCHANGESPEND.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
                InforRemoveADDinfoCHANGESPEND.append("------------------------------------------------------------------------------------\n");

                StringBuilder bd = new StringBuilder();
                for(Spent s : in2s){
                    bd.append(s).append("\n");
                }

                InforRemoveADDinfoCHANGESPEND.append(bd.toString());

            } else {
                InforRemoveADDinfoCHANGESPEND.setFont(new Font("Monospaced", Font.BOLD, 20));
                InforRemoveADDinfoCHANGESPEND.setForeground(Color.RED);
                InforRemoveADDinfoCHANGESPEND.setText("\n                  Informacijos nerasta ! ");

                InfoREMcheckCHANGESPEND.setSelected(false);
                InfoREMcheckCHANGESPEND.setEnabled(false);
                IncomeCancel3.setEnabled(false);
            }
        }

        if(e.getSource() == but1SPEND){
            changing = "DATA";
            problemsSPEND.setForeground(Color.green);
            problemsSPEND.setText("Keiciama DATA į");
            InfoREMcheckCHANGESPEND.setEnabled(false);
            InfoREMcheckCHANGESPEND.setSelected(false);
            IncomeCancel3.setEnabled(false);
            inputaboutchangeSPEND.setText("");
        }

        if(e.getSource() == but2SPEND){
            changing = "SUMA";
            problemsSPEND.setForeground(Color.green);
            problemsSPEND.setText("Keiciama SUMA į");
            InfoREMcheckCHANGESPEND.setEnabled(false);
            InfoREMcheckCHANGESPEND.setSelected(false);
            IncomeCancel3.setEnabled(false);
            inputaboutchangeSPEND.setText("");
        }

        if(e.getSource() == but3SPEND){
            changing = "KATEGORIJA";
            problemsSPEND.setForeground(Color.green);
            problemsSPEND.setText("Keiciama KATEGORIJA į");
            InfoREMcheckCHANGESPEND.setEnabled(false);
            InfoREMcheckCHANGESPEND.setSelected(false);
            IncomeCancel3.setEnabled(false);
            inputaboutchangeSPEND.setText("");
        }

        if(e.getSource() == but4SPEND){
            changing = "VIETA";
            problemsSPEND.setForeground(Color.green);
            problemsSPEND.setText("Keiciama VIETA į");
            InfoREMcheckCHANGESPEND.setEnabled(false);
            InfoREMcheckCHANGESPEND.setSelected(false);
            IncomeCancel3.setEnabled(false);
            inputaboutchangeSPEND.setText("");
        }

        if(e.getSource() == but5SPEND){
            changing = "TIPAS";
            problemsSPEND.setForeground(Color.green);
            problemsSPEND.setText("Keiciamas TIPAS į");
            InfoREMcheckCHANGESPEND.setEnabled(false);
            InfoREMcheckCHANGESPEND.setSelected(false);
            IncomeCancel3.setEnabled(false);
            inputaboutchangeSPEND.setText("");
        }

        if(e.getSource() == keistiinfosubuutonSPEND){

            if(in2s.isEmpty()){
                problemsSPEND.setForeground(Color.red);
                problemsSPEND.setText("Informacija nerasta");
                text2SPEND.setBackground(Color.red);
                text2SPEND.setForeground(Color.white);
                InfoREMcheckCHANGESPEND.setEnabled(false);
                IncomeCancel3.setEnabled(false);
            }

            if(!inputaboutchangeSPEND.getText().isEmpty() && !in2s.isEmpty()){

                text2SPEND.setBackground(null);
                text2SPEND.setForeground(Color.black);

                if(changing.equals("DATA")){
                    InfoREMcheckCHANGESPEND.setEnabled(false);
                    if(inputaboutchangeSPEND.getText().length() != 10){
                        problemsSPEND.setForeground(Color.red);
                        problemsSPEND.setText("Bloga data pvz 2025-06-26");
                    } else {
                        problemsSPEND.setForeground(Color.green);
                        problemsSPEND.setText("Data tinka !");
                        InfoREMcheckCHANGESPEND.setEnabled(true);
                    }
                }

                if(changing.equals("SUMA")){
                    InfoREMcheckCHANGESPEND.setEnabled(false);
                    if(inputaboutchangeSPEND.getText().length() > 12){
                        problemsSPEND.setForeground(Color.red);
                        problemsSPEND.setText("Suma yra per ilga");
                    } else {
                        InfoREMcheckCHANGESPEND.setEnabled(true);
                    }
                }

                if(changing.equals("KATEGORIJA")){
                    InfoREMcheckCHANGESPEND.setEnabled(false);
                    if(inputaboutchangeSPEND.getText().length() > 20){
                        problemsSPEND.setForeground(Color.red);
                        problemsSPEND.setText("Kategorija yra per ilga");
                    } else {
                        InfoREMcheckCHANGESPEND.setEnabled(true);
                    }
                }

                if(changing.equals("VIETA")){
                    InfoREMcheckCHANGESPEND.setEnabled(false);
                    if(inputaboutchangeSPEND.getText().length() > 20){
                        problemsSPEND.setForeground(Color.red);
                        problemsSPEND.setText("Vieta yra per ilga");
                    } else {
                        InfoREMcheckCHANGESPEND.setEnabled(true);
                    }
                }

                if(changing.equals("TIPAS")){
                    InfoREMcheckCHANGESPEND.setEnabled(false);
                    if(inputaboutchangeSPEND.getText().length() > 20){
                        problemsSPEND.setForeground(Color.red);
                        problemsSPEND.setText("TIPAS yra per ilgas");
                    } else {
                        InfoREMcheckCHANGESPEND.setEnabled(true);
                    }
                }
            }
        }

        if(e.getSource() == InfoREMcheckCHANGESPEND) {
            IncomeCancel3SPEND.setEnabled(InfoREMcheckCHANGESPEND.isSelected());
        }

        if(e.getSource() == IncomeCancel3SPEND) {

            try {
                Boolean ok = false;

                text2SPEND.setBackground(null);
                text2SPEND.setForeground(Color.black);

                if(changing.equals("DATA")){
                    InfoREMcheckCHANGESPEND.setEnabled(false);
                    ok = false;
                    if(inputaboutchangeSPEND.getText().length() != 10){
                        problemsSPEND.setForeground(Color.red);
                        problemsSPEND.setText("Bloga data pvz 2025-06-26");
                        InfoREMcheckCHANGESPEND.setEnabled(false);
                        InfoREMcheckCHANGESPEND.setSelected(false);
                        IncomeCancel3.setEnabled(false);
                    } else {
                        problemsSPEND.setForeground(Color.green);
                        problemsSPEND.setText("Data tinka !");
                        InfoREMcheckCHANGESPEND.setEnabled(true);
                        ok = true;
                    }
                }

                if(changing.equals("SUMA")){
                    ok = false;
                    InfoREMcheckCHANGESPEND.setEnabled(false);
                    if(inputaboutchangeSPEND.getText().length() > 12){
                        problemsSPEND.setForeground(Color.red);
                        problemsSPEND.setText("Suma yra per ilga");
                        InfoREMcheckCHANGESPEND.setEnabled(false);
                        InfoREMcheckCHANGESPEND.setSelected(false);
                        IncomeCancel3.setEnabled(false);
                    } else {
                        InfoREMcheckCHANGESPEND.setEnabled(true);
                        ok = true;
                    }
                }

                if(changing.equals("KATEGORIJA")){
                    ok = false;
                    InfoREMcheckCHANGESPEND.setEnabled(false);
                    if(inputaboutchangeSPEND.getText().length() > 20){
                        problemsSPEND.setForeground(Color.red);
                        problemsSPEND.setText("Kategorija yra per ilga");
                        InfoREMcheckCHANGESPEND.setEnabled(false);
                        InfoREMcheckCHANGESPEND.setSelected(false);
                        IncomeCancel3.setEnabled(false);
                    } else {
                        InfoREMcheckCHANGESPEND.setEnabled(true);
                        ok = true;
                    }
                }

                if(changing.equals("VIETA")){
                    ok = false;
                    InfoREMcheckCHANGESPEND.setEnabled(false);
                    if(inputaboutchangeSPEND.getText().length() > 20){
                        problemsSPEND.setForeground(Color.red);
                        problemsSPEND.setText("Vieta yra per ilga");
                        InfoREMcheckCHANGESPEND.setEnabled(false);
                        InfoREMcheckCHANGESPEND.setSelected(false);
                        IncomeCancel3.setEnabled(false);
                    } else {
                        InfoREMcheckCHANGESPEND.setEnabled(true);
                        ok = true;
                    }
                }

                if(changing.equals("TIPAS")){
                    ok = false;
                    InfoREMcheckCHANGESPEND.setEnabled(false);
                    if(inputaboutchangeSPEND.getText().length() > 20){
                        problemsSPEND.setForeground(Color.red);
                        problemsSPEND.setText("TIPAS yra per ilgas");
                        InfoREMcheckCHANGESPEND.setEnabled(false);
                        InfoREMcheckCHANGESPEND.setSelected(false);
                        IncomeCancel3.setEnabled(false);
                    } else {
                        InfoREMcheckCHANGESPEND.setEnabled(true);
                        ok = true;
                    }
                }

                if(ok){
                    codeSpend.changinginfo(changing, inputaboutchangeSPEND.getText());

                    problemsSPEND.setForeground(Color.red);
                    problemsSPEND.setText("Nepasirenkta");
                    inputaboutchangeSPEND.setText("");

                    ArrayList<Spent> info = codeSpend.showSPEND();
                    StringBuilder bd = new StringBuilder();
                    kiek = 0;

                    for(Spent s : info){
                        bd.append(s).append("\n");
                        kiek++;
                    }

                    SpentData.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
                    SpentData.append("------------------------------------------------------------------------------------\n");
                    SpentData.append(bd.toString());

                    kiekSpent.setText("Rasta: " + kiek);
                    TotalSpent.setText("Iš viso: " + codeSpend.dabartinesuma().toString() + "Eur");

                    
              
                    
                    
            InfoREMcheckCHANGESPEND.setEnabled(false);
            InfoREMcheckCHANGESPEND.setSelected(false);
            

            inputaboutchangeSPEND.setText("");
            SeartchincotoremoveCHANGESPEND.setText("");
            InforRemoveADDinfoCHANGESPEND.setText("");
            problemsSPEND.setText("Nepasirinkta");
            problemsSPEND.setForeground(Color.red);

            text2SPEND.setBackground(null);
            text2SPEND.setForeground(Color.black);
            

            IncomeFROMto.setVisible(true);
            IncomeExtra.setVisible(true);
            Income.setVisible(true);
            IncomeData.setVisible(true);
                

            IncomeCancel3SPEND.setVisible(false);
            IncomeCancel3SPEND.setEnabled(false);
            Atsaukti3SPEND.setVisible(false);




            IncomeCancel2.setVisible(false);
            Atsaukti2.setVisible(false);

            IncomeCancel3.setVisible(false);
            IncomeCancel3.setEnabled(false);
           
            Atsaukti3.setVisible(false);

            

            Income2NDCHANGESPEND.setVisible(false);
            incoRem1stCHANGESPEND.setVisible(false);
            incoDATACHANGESPEND.setVisible(false);
            incoCHECKBOXPLACECHANGESPEND.setVisible(false);
                    
                }

            } catch (DateTimeParseException ez) {
                System.out.println(ez);
                problemsSPEND.setForeground(Color.red);
                problemsSPEND.setText("Bloga data pvz 2025-06-26");
                InfoREMcheckCHANGESPEND.setEnabled(false);
                InfoREMcheckCHANGESPEND.setSelected(false);
                IncomeCancel3.setEnabled(false);

            } catch (NumberFormatException ez2) {
                System.out.println(ez2);
                problemsSPEND.setForeground(Color.red);
                problemsSPEND.setText("err suma [" + inputaboutchangeSPEND.getText() + "]");
                InfoREMcheckCHANGESPEND.setEnabled(false);
                InfoREMcheckCHANGESPEND.setSelected(false);
                IncomeCancel3.setEnabled(false);
            }
        }

        if(e.getSource() == Atsaukti3SPEND) {

            InfoREMcheckCHANGESPEND.setEnabled(false);
            InfoREMcheckCHANGESPEND.setSelected(false);
            

            inputaboutchangeSPEND.setText("");
            SeartchincotoremoveCHANGESPEND.setText("");
            InforRemoveADDinfoCHANGESPEND.setText("");
            problemsSPEND.setText("Nepasirinkta");
            problemsSPEND.setForeground(Color.red);

            text2SPEND.setBackground(null);
            text2SPEND.setForeground(Color.black);
            

            IncomeFROMto.setVisible(true);
                IncomeExtra.setVisible(true);
                Income.setVisible(true);
                IncomeData.setVisible(true);
                

                IncomeCancel3SPEND.setVisible(false);
                    Atsaukti3SPEND.setVisible(false);
                    
            IncomeCancel3SPEND.setVisible(false);


            IncomeCancel3SPEND.setEnabled(false);
            IncomeCancel2.setVisible(false);
            Atsaukti2.setVisible(false);

            IncomeCancel3.setVisible(false);
            IncomeCancel3.setEnabled(false);
            Atsaukti3.setVisible(false);

            Income2NDCHANGESPEND.setVisible(false);
            incoRem1stCHANGESPEND.setVisible(false);
            incoDATACHANGESPEND.setVisible(false);
            incoCHECKBOXPLACECHANGESPEND.setVisible(false);
        }

        // SPEND change


        // jeiskojimo mygtukai

        if(e.getSource() == s4){

                kiek2 = 0;
                suma2 = 0;
                ArrayList<Spent> inco = codeSpend.showSPEND();

                StringBuilder bd = new StringBuilder();

               
                

                 for(Spent s : inco){
                        suma2 += s.getSpent();
                        kiek2++;
                bd.append(s).append("\n");

                }
                SpentData.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
                SpentData.append("------------------------------------------------------------------------------------\n");

                 SpentData.append(bd.toString());
                 TotalSpent.setText("Iš viso: " + suma2 + "Eur ");
                 kiekSpent.setText(String.valueOf("Rasta: "+ kiek2));  

        s1.setText("");
        s2.setText("");

        }
         
        if(e.getSource() == s3){
                try{
        
                kiek2 = 0;
                suma2 = 0;

                if(!s1.getText().isEmpty() || !s2.getText().isEmpty()){
                ArrayList<Spent> spend = codeSpend.searchSpend(s1.getText().trim(), s2.getText().trim());

                StringBuilder bd = new StringBuilder();

                for(Spent s : spend){
                        suma2 += s.getSpent();
                        kiek2++;
                bd.append(s).append("\n");

                }
                SpentData.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
                SpentData.append("------------------------------------------------------------------------------------\n");

                SpentData.append(bd.toString());
                TotalSpent.setText("Iš viso: " + suma2 + "Eur ");
                kiekSpent.setText("Rasta: " + kiek2);
        }

        if(s1.getText().isEmpty() || s2.getText().isEmpty()){

                kiek2 = 0;
                suma2 = 0;

                ArrayList<Spent> ss = codeSpend.showSPEND();

                StringBuilder bd = new StringBuilder();
               for(Spent s : ss){
                        suma2 += s.getSpent();
                        kiek2++;
                bd.append(s).append("\n");

                }
                SpentData.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
                SpentData.append("------------------------------------------------------------------------------------\n");

                 SpentData.append(bd.toString());
                TotalSpent.setText("Iš viso: " + suma2 + "Eur ");
                kiekSpent.setText("Rasta: " + kiek2);
        }

                } catch (DateTimeParseException  fp) {

                LocalDate data = LocalDate.now();
                data = data.minusMonths(4);
                LocalDate data2 = LocalDate.now();
                s1.setText("Pvz: " + data);
                s2.setText("Pvz: " + data2);
                
                System.out.println("Klaida bandymas filtruoti duomenis pagal netinkama formata Spend bloke ");
                       
                }

        }

        if(e.getSource() == i4){
                kiek = 0;
                suma = 0;
                ArrayList<Income> inco = code.show();

                StringBuilder bd = new StringBuilder();

                for(Income s : inco){
                        bd.append(s).append("\n");
                        kiek++;
                }
               IncomeData.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));
                         
                         IncomeData.append("------------------------------------------------------------------------------------\n");

                 IncomeData.append(bd.toString());
                
                kiekIncome.setText(String.valueOf("Rasta: "+ kiek));  

        i1.setText("");
        i2.setText("");

        }

        if(e.getSource() == i3){
         
                 try {
                        
              kiek = 0;
              suma = 0;
                if(!i1.getText().isEmpty() || !i2.getText().isEmpty()){


                ArrayList<Income> SortedINCOME  = code.searchINCOME(i1.getText().trim(), i2.getText().trim());

                StringBuilder bd = new StringBuilder();

                for(Income s : SortedINCOME){
                        bd.append(s).append("\n");
                        kiek++;
                }
                IncomeData.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));

                         IncomeData.append("------------------------------------------------------------------------------------\n");

                 IncomeData.append(bd.toString());
               kiekIncome.setText(String.valueOf("Rasta: "+ kiek));  

                  
        }

        // if empty show all 
        if(i1.getText().isEmpty() || i2.getText().isEmpty()){

                kiek = 0;
                suma = 0;
                ArrayList<Income> income = code.show();
                StringBuilder bd = new StringBuilder();

        for(Income s : income){
        bd.append(s).append("\n");
        kiek++;
        }
        IncomeData.setText(String.format("  %-8s |  %-12s |   %-9s  |  %-11s | %-17s | %s", " ID's", "   Date", "income", "category", "  location", "Type\n"));

        IncomeData.append("------------------------------------------------------------------------------------\n");

        IncomeData.append(bd.toString());

        kiekIncome.setText(String.valueOf("Rasta: "+ kiek));    
                
        }



      
         } catch (DateTimeParseException  fp) {

                LocalDate data = LocalDate.now();
                data = data.minusMonths(2);
                LocalDate data2 = LocalDate.now();
                i1.setText("Pvz: " + data);
                i2.setText("Pvz: " + data2);
                
                System.out.println("Klaida bandymas filtruoti duomenis pagal netinkama formata Earned bloke ");
                       
                }
                
                
         }

        // jeiskojimo mygtukai

        
        // atsijunti mygktukas
        if(e.getSource() == Atsijungti){

            Multiplier = 1;
            bandyta = 0;
            removeExses = 0;
            pass.setLength(0);

            SpentADD.setVisible(false);
            SpentCHANGE.setVisible(false);
            SpentREMOVE.setVisible(false);

            input.setForeground(Color.black);
            password.setVisible(true);
            password2.setVisible(true);

            p1.setEnabled(true);
            p2.setEnabled(true);
            p3.setEnabled(true);
            p4.setEnabled(true);
            p5.setEnabled(true);
            p6.setEnabled(true);
            p7.setEnabled(true);
            p8.setEnabled(true);
            p9.setEnabled(true);
            p10.setEnabled(true);
            p11.setEnabled(true);
            p12.setEnabled(true);




            header.setVisible(false);

            Income.setVisible(false);
            Spent.setVisible(false);
            s1.setVisible(false);
            s2.setVisible(false);
            s3.setVisible(false);
            s4.setVisible(false);
            i1.setVisible(false);
            i2.setVisible(false);
            i3.setVisible(false);
            i4.setVisible(false);

            TotalSpent.setVisible(false);
            kiekSpent.setVisible(false);
            kiekIncome.setVisible(false);
            totalIncome.setVisible(false);
            IncomeTEXT.setVisible(false);
            SavedTEXT.setVisible(false);
            infoForIncome.setVisible(false);
            infoForSpend.setVisible(false);
           
            IncomeFROMto.setVisible(false);
            IncomeData.setVisible(false);
            IncomeExtra.setVisible(false);
            scrollPane.setVisible(false);
            
            SpentFROMto.setVisible(false);
            SpentData.setVisible(false);
            SpentExtra.setVisible(false);
            scrollPane2.setVisible(false);
            
            Color originalColor = p1.getBackground();
            for(int i = 0; i < 12; i++){
            
            final int index = i;

            int value = 100 * (index + 1);

            //store all buttons
            JButton[] Buttons = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12};

            // make all buttons red
            for(JButton s : Buttons){
                s.setBackground(Color.red);
            }
            
            new Timer(value, new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
            Buttons[index].setBackground(originalColor);
        
            
            p12.setEnabled(false);

            if(Buttons[index] == p12){
                Buttons[index].setEnabled(true);
                input.setText("");
                
            }
            
                       
            }
            }) {{
                    setRepeats(false);
                    start();
            }};

            }



        }
       
         if(e.getSource() == calculator){
            new calculator();
        }

           if(e.getSource() == loans){
            new Loans();
        }

         if(e.getSource() == potential){

            new Settings();
         }
        
        
    }
         // animation for password when failed
        public static void extraPASS(){

        Color originalColor = p1.getBackground();

        bandyta++;

        if(bandyta <= galimabadyti ){

            for(int i = 0; i < 12; i++){
            
            final int index = i;

            int value = 100 * (index + 1);

            //store all buttons
            JButton[] Buttons = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12};

            // make all buttons red
            for(JButton s : Buttons){
                s.setBackground(Color.red);
            }
            
            new Timer(value, new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
            Buttons[index].setBackground(originalColor);
        
            
            p12.setEnabled(false);

            if(Buttons[index] == p12){
                Buttons[index].setEnabled(true);
                input.setText("");
                
            }
            
                       
            }
            }) {{
                    setRepeats(false);
                    start();
            }};

            }

            }

                
             
        else{

            for(int i = 0; i < 12; i++){
            final int index = i;
            int value = Time * (index + 1) * Multiplier;

            int IntervalToRemoveNum = (((Time * 12) / 1000) * Multiplier) /11;
            
            // dinamic formula that extends dislpayed time of penalty
            int TimeToWait = ((((Time * 12) / 1000) * Multiplier) -2) -removeExses;
            
            // 
            final int TimeShown = (TimeToWait)-(IntervalToRemoveNum * index);


            // store all buttons to use later
            JButton[] Buttons = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12};

            //make all buttons red
            for(JButton s : Buttons){
                s.setBackground(Color.red);
                s.setEnabled(false);
            }
            
            new Timer(value, new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
            Buttons[index].setBackground(originalColor);

            input.setText("Užblokuota: " + String.valueOf(TimeShown) + " Sec");
            
          
            if(Buttons[index] == p12){

                for(JButton s : Buttons){

                    s.setEnabled(true);

                }
                input.setText("");
                
                
            }
                 
            }
            }) {{
                    setRepeats(false);
                    start();
            }};
             
            }
        

             Multiplier++;
             removeExses += 2;
    }


       



    

    


}


 // read settings
    public void UserSettings(){
   
        ArrayList<SettingData> storeInfo = new ArrayList<>();

        try (BufferedReader read = new BufferedReader(new FileReader("src\\Setting.txt"))) {

            String line;

            while((line = read.readLine()) !=null){

                String[] niam = line.split(" ");

                storeInfo.add(new SettingData(niam[0], niam[1]));

            }
            
        } catch (Exception e) {
            e.printStackTrace();

        }

        for(SettingData s : storeInfo){

            if(s.getName().equals("CanTryPass")){

                galimabadyti = Integer.parseInt(s.getValue());
                
            }

            if(s.getName().equals("PunishmentforMistake")){

                Multiplier = Integer.parseInt(s.getValue());
                

            }

              
               
                

            


            

        }
       
        
    }


    

}
