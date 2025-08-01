package Header;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.*;

import java.sql.*;


public class calculator extends JFrame implements ActionListener {

    String url;
    String user;
    String password;


    JButton clear;
    JButton save;
    JButton Close;
    JTextField output;
    JTextField t1TEXT;
    JTextField t2TEXT;
    JTextField t3TEXT;
    JTextField t4TEXT;
    JTextField t5TEXT;

    JTextField bank;
    JTextField wallet;

    int sum = 0;

    static ArrayList<String> UrlUserPassword = new ArrayList<>();

    ArrayList<CalculatorData> saved = new ArrayList<>();

     public calculator(){


        readPassURlROot();
            
        if(UrlUserPassword.size() >=3 ){
            url = UrlUserPassword.get(0);
            user = UrlUserPassword.get(1);
            password = UrlUserPassword.get(2);
        }

        // add info into array to use later
        addinfointoARRAY();

        saved = new ArrayList<>();

        this.setLayout(new BorderLayout());
        this.setSize(700,500);
        this.setTitle("Skaičiuotuvas");
         
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel box = new JPanel();
        box.setLayout(new GridLayout(2,5,5,5));
        
        


        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();
         t1TEXT = new JTextField();
         t2TEXT = new JTextField();
         t3TEXT = new JTextField();
         t4TEXT = new JTextField();
         t5TEXT = new JTextField();
         t1TEXT.setPreferredSize(new Dimension(200, 80));


        JTextField[] information = {t1,t2,t3,t4,t5};

        for(JTextField field : information){

         if(field == t1){
            field.setText("5");
         }

         if(field == t2){
            field.setText("10");
         }

         if(field == t3){
            field.setText("20");
         }

         if(field == t4){
            field.setText("50");
         }

        if(field == t5){
            field.setText("100");
        }
        
         field.setFont(new Font("Monospaced", Font.BOLD, 30));
         field.setHorizontalAlignment(JTextField.CENTER);
         field.setEditable(false);
        }

        box.add(t1);
        box.add(t2);
        box.add(t3);
        box.add(t4);
        box.add(t5);

        box.add(t1TEXT);
        box.add(t2TEXT);
        box.add(t3TEXT);
        box.add(t4TEXT);
        box.add(t5TEXT);


        JPanel box2 = new JPanel();
        box2.setLayout(new FlowLayout());

        JTextField Info = new JTextField();
        Info.setEditable(false);
        Info.setText("Suma: ");
        Info.setPreferredSize(new Dimension(150,80));
        Info.setFont(new Font("Monospaced", Font.BOLD, 30));
        Info.setHorizontalAlignment(JTextField.CENTER);

        clear = new JButton();
        clear.setText("Remove");
        clear.addActionListener(this);
        clear.setPreferredSize(new Dimension(150,80));
        clear.setFocusable(false);

        save = new JButton();
        save.setText("Save");
        save.addActionListener(this);
        save.setPreferredSize(new Dimension(100,50));
        save.setFocusable(false);
        


        output = new JTextField();
        output.setEditable(false);
        output.setFont(new Font("Monospaced", Font.BOLD, 30));
        output.setHorizontalAlignment(JTextField.CENTER);
        output.setPreferredSize(new Dimension(150,80));
        output.setText("0");


        JPanel box3 = new JPanel();
        
        box3.setLayout(new GridLayout(1,2,200,100));

        Close = new JButton("Išjungti");
        Close.setFocusable(false);
        Close.addActionListener(this);


        JPanel box4 = new JPanel();
        box4.setLayout(new FlowLayout());

        JTextField bankname = new JTextField();
        bankname.setFont(new Font("Monospaced", Font.BOLD, 30));
        bankname.setPreferredSize(new Dimension(150,80));
        bankname.setEditable(false);
        bankname.setText("Bank: ");

        bank = new JTextField();
        bank.setFont(new Font("Monospaced", Font.BOLD, 30));
        bank.setPreferredSize(new Dimension(150,80));

        JTextField walletname = new JTextField();
        walletname.setPreferredSize(new Dimension(150,80));
        walletname.setEditable(false);
        walletname.setFont(new Font("Monospaced", Font.BOLD, 30));
        walletname.setText("Wallet: ");
        
        wallet = new JTextField();
        wallet.setFont(new Font("Monospaced", Font.BOLD, 30));
        wallet.setPreferredSize(new Dimension(150,80));

        

        JTextField[] information2 = {t1TEXT,t2TEXT,t3TEXT,t4TEXT,t5TEXT,wallet,bank};

        for(JTextField field : information2){

         field.setFont(new Font("Monospaced", Font.BOLD, 30));
         field.setHorizontalAlignment(JTextField.CENTER);
         
        }

        // realiu laiku rodyti suma suskaiciuota

        for(JTextField field : information2){

           
            
         field.getDocument().addDocumentListener(new DocumentListener() {
            
            public void changedUpdate(DocumentEvent e) {
                updateLabel();
            }
            public void removeUpdate(DocumentEvent e) {
                updateLabel();
            }
            public void insertUpdate(DocumentEvent e) {
                updateLabel();
            }

            public void updateLabel() {

                sum = 0;

    
                    try {
                        
                int f1 = t1TEXT.getText().isEmpty() ? 0 : Integer.parseInt(t1TEXT.getText());
                int f2 = t2TEXT.getText().isEmpty() ? 0 : Integer.parseInt(t2TEXT.getText());
                int f3 = t3TEXT.getText().isEmpty() ? 0 : Integer.parseInt(t3TEXT.getText());
                int f4 = t4TEXT.getText().isEmpty() ? 0 : Integer.parseInt(t4TEXT.getText());
                int f5 = t5TEXT.getText().isEmpty() ? 0 : Integer.parseInt(t5TEXT.getText());
                int f6 = wallet.getText().isEmpty() ? 0 : Integer.parseInt(wallet.getText());
                int f7 = bank.getText().isEmpty() ? 0 : Integer.parseInt(bank.getText());
                
                // add everythin together to sum up
                sum += f1*5 + f2*10+ f3*20 + f4*50 + f5*100 + f6 + f7;

                output.setText("" + sum);


                        
                    } catch (NumberFormatException  e) {
                        
                }
            }
        });
    }


 



        // add stuff to parents    

        box3.add(Close);
        box3.add(save);
        box2.add(walletname);
        box2.add(wallet);
        box2.add(bankname);
        box2.add(bank);
        box2.add(Info);
        box2.add(output);
        box2.add(clear);


        this.add(box, BorderLayout.NORTH);
        this.add(box2, BorderLayout.CENTER);
        this.add(box3, BorderLayout.SOUTH);
    
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        


    }

    @Override
    public void actionPerformed(ActionEvent e) {


        // isaugoti mygtukas
        if(e.getSource() == save){

            try {
                
            if(!t1TEXT.getText().isEmpty() && !t2TEXT.getText().isEmpty() && !t3TEXT.getText().isEmpty() && !t4TEXT.getText().isEmpty() && !t5TEXT.getText().isEmpty() && !wallet.getText().isEmpty() && !bank.getText().isEmpty()){
            Color Originalcolor = Color.white;
            saved.clear();
            addinfointoARRAY();
            addCalculatorinfo(saved.size()+1,Integer.parseInt(t1TEXT.getText()), Integer.parseInt(t2TEXT.getText()), Integer.parseInt(t3TEXT.getText()), Integer.parseInt(t4TEXT.getText()), Integer.parseInt(t5TEXT.getText()), Integer.parseInt(wallet.getText()), Integer.parseInt(bank.getText()));

            output.setText("Saved");

             JTextField[] information2 = {t1TEXT,t2TEXT,t3TEXT,t4TEXT,t5TEXT,wallet,bank};

             

             for(JTextField s : information2){
                s.setBackground(Color.green);
             }

            for(int i = 0; i < 7; i++){
                final int index=  i;
                

            int showsaved = 1500;
            
            int timer = 100 * (index + 1) + showsaved;
            showsaved *= 0;
            

            new Timer(timer, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {

             information2[index].setBackground(Originalcolor);
             information2[index].setText("");
             
            }
            
        }) {{
            setRepeats(false);
            start();
        }};
        
    }


        }

        else{
            error();
        }

  


       
        } catch (NumberFormatException  g) {

                 

              JTextField[] information2 = {t1TEXT,t2TEXT,t3TEXT,t4TEXT,t5TEXT,wallet,bank};

            for(int i = 0; i < information2.length; i++){
                final int  in = i ;
                
                String check = information2[i].getText();

                try {
                    Integer.parseInt(check);
                } catch (NumberFormatException gg) {
                    
                    

                    for(int j = 0 ; j < 8; j++){

                final int index = j;
        new Timer(300 * index, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {


            switch (index) {
                case 0:
                    information2[in].setBackground(Color.red);
                    break;

                    case 1:
                    information2[in].setBackground(Color.white);
                    break;

                    case 2:
                    information2[in].setBackground(Color.red);
                    break;

                    case 3:
                    information2[in].setBackground(Color.white);
                    break;
            
                default:
                    break;
            }
            
           
            
             
            }
            
        }) {{
            setRepeats(false);
            start();
        }};
    }


                }
            }

        
                
            }
        
    }

        // isvalyti info mygktukas
        if(e.getSource() == clear){
        
        
         JTextField[] information2 = {t1TEXT,t2TEXT,t3TEXT,t4TEXT,t5TEXT,wallet,bank};

        for(JTextField field : information2){
        field.setText("");
        output.setText("0");

        }
        saved.clear();
        addinfointoARRAY();
    

      

       }
   

        // isjugti skaiciuoti langa
       if(e.getSource() == Close){
            dispose();
       }
    }


    // add users information if he/she requests
    public void addCalculatorinfo(int id, int five, int ten, int twenty, int fifty, int hundred,int wallet, int bank){

         try(Connection con = DriverManager.getConnection(url, user, password)) {

        String query = "INSERT INTO calculator (idCalculator, five, ten, twenty, fifty, hundred, w, b) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);

       
            ps.setInt(1,id);
            ps.setInt(2,five);
            ps.setInt(3, ten);
            ps.setInt(4, twenty);
            ps.setInt(5, fifty);
            ps.setInt(6, hundred);
            ps.setInt(7, wallet);
            ps.setInt(8, bank);

        ps.executeUpdate();

        } catch (SQLException  e) {
                e.printStackTrace();
        }

    }

    // add info to array to use later
    public void addinfointoARRAY(){
                  
        try(Connection con = DriverManager.getConnection(url, user, password)) {

             String query = "SELECT * FROM calculator order by idCalculator asc";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                CalculatorData items = new CalculatorData(
                    rs.getInt("idCalculator"),
                    rs.getInt("five"),
                    rs.getInt("ten"),
                    rs.getInt("twenty"),
                    rs.getInt("fifty"),
                    rs.getInt("hundred"),
                    rs.getInt("w"),
                    rs.getInt("b")
               
                );
                saved.add(items);
            }

            
        } catch (SQLException  e) {
                e.printStackTrace();
        }
    }
   
    // error if there are null values
    public void error(){

         JTextField[] information2 = {t1TEXT,t2TEXT,t3TEXT,t4TEXT,t5TEXT,wallet,bank};

         for(JTextField s : information2){
            if(s.getText().isEmpty()){
                
                for(int i = 0; i < 7; i++){
                    final int index = i;

                // animacija
        new Timer(300 * index, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {

            switch (index) {
                case 0:
                    s.setBackground(Color.orange);
                    break;

                    case 1:
                    s.setBackground(Color.white);
                    break;

                    case 2:
                    s.setBackground(Color.orange);
                    break;

                    case 3:
                    s.setBackground(Color.white);
                    break;
            
                default:
                    break;
            }
            
             
            }
            
        }) {{
            setRepeats(false);
            start();
        }};

       
    }
      
            }
            
         }
    }


    // get pass for my sql
     public void readPassURlROot(){

        try(BufferedReader read = new BufferedReader(new FileReader("src\\MySQL.txt"))) {

            String line;

            while((line = read.readLine()) != null){
                String[] niam = line.split(" ");

                for(int i = 0; i < niam.length; i++){
                UrlUserPassword.add(niam[i]);
                }
                
            }

           

            
            
        } catch (Exception e) {
            System.out.println(e);
        }
       // UrlUserPassword
    }

}
