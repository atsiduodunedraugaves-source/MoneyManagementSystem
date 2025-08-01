package Header;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;


import javax.swing.*;

import java.sql.*;



public class Loans extends JFrame implements ActionListener {

    static ArrayList<LoansData> deletechosen = new ArrayList<>();

    static ArrayList<String> UrlUserPassword = new ArrayList<>();


    static ArrayList<String> recents = new ArrayList<>();

    String url ;
    String user ;
    String password ;

  

    JScrollPane scroll = new JScrollPane();
    JTextArea info = new JTextArea();


    JTextArea recentloans = new JTextArea();
    JTextArea loancount = new JTextArea();

    JPanel box2 = new JPanel();
    JPanel center = new JPanel();
    JPanel boxadd = new JPanel();

    JPanel boxremove = new JPanel();

    JButton add = new JButton();
    JButton currentDate = new JButton();
    JTextField dateadd = new JTextField();
    JTextField personadd = new JTextField();
    JTextField amountadd = new JTextField();
    JTextField Problemsadd = new JTextField();
    JButton atiduotaNE = new JButton();
    JButton atiduotaTAIP = new JButton();
    int taipne = 0;
    JButton addindadd = new JButton();



    JButton remove = new JButton();
    JButton back = new JButton();
    JButton back2 = new JButton();


    JTextField inputremove;
    JButton searchButton;
    JTextField showinformation;
    JCheckBox suretodelete;
    JButton remItem;


    //default button color
    Color defaultColor = currentDate.getBackground();

    // info which can be seen and accessed by eveyone
    static ArrayList<LoansData> Information = new ArrayList<>();

    

    public Loans() {

        // preload stuff

        info = new JTextArea(); 
        
        // auto change mysql info if user changes in txt

        readPassURlROot();
            
        if(UrlUserPassword.size() >=3 ){
            url = UrlUserPassword.get(0);
            user = UrlUserPassword.get(1);
            password = UrlUserPassword.get(2);
        }

        // read info preload it 
        readinfo();

        MostTimesLoaned();
        
       

       //----------------------
      recentgivenloans();
      
       

       

         // preload stuff

    

        this.setLayout(new BorderLayout());
        this.setSize(910, 800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Skolos");


        // header
        JPanel box = new JPanel();
        box.setLayout(new FlowLayout(1,20,5));
        box.setPreferredSize(new Dimension(0, 50));
        box.setBackground(Color.yellow);

        JTextField text2 = new JTextField("Paskolinimų informacija");
        text2.setBackground(Color.yellow);
        text2.setBorder(null);
        text2.setEditable(false);
        text2.setFont(new Font("Monospaced", Font.BOLD, 20));

        back2 = new JButton("Išjungti");
        back2.setPreferredSize(new Dimension(200,40));
        back2.addActionListener(this);
        back2.setFocusable(false);
        
        box.add(text2);
        box.add(back2);


        // middle
        box2 = new JPanel();
        box2.setLayout(new GridLayout());
        box2.setPreferredSize(new Dimension(222, 0));
        box2.setBackground(Color.GREEN);

        info.setFont(new Font("Monospaced", Font.BOLD, 15));
        scroll = new JScrollPane(info);

        box2.add(scroll);

  


        //right side
        JPanel box3 = new JPanel();
        box3.setLayout(new GridLayout());
        box3.setPreferredSize(new Dimension(170, 0));
        box3.setBackground(Color.BLUE);

        
        loancount.setFont(new Font("Monospaced", Font.BOLD, 20));

        box3.add(loancount);


        // left side
        JPanel box4 = new JPanel();
        box4.setLayout(new GridLayout());
        box4.setPreferredSize(new Dimension(170, 0));
        box4.setBackground(Color.GRAY);

        
        recentloans.setFont(new Font("Monospaced", Font.BOLD, 20));

        box4.add(recentloans);


        // bottom
        JPanel box5 = new JPanel();
        box5.setLayout(new FlowLayout());
        box5.setPreferredSize(new Dimension(0, 150));

        add = new JButton("Add");
        add.setPreferredSize(new Dimension(200,50));
        add.addActionListener(this);
        add.setFocusable(false);

        remove = new JButton("Remove");
        remove.setPreferredSize(new Dimension(200,50));
        remove.addActionListener(this);
        remove.setFocusable(false);

        back = new JButton("Atgal");
        back.setPreferredSize(new Dimension(200,50));
        back.addActionListener(this);
        back.setFocusable(false);

        





        //boxadd

        

        JPanel givenbackadd = new JPanel();
        givenbackadd.setLayout(new GridLayout());
        givenbackadd.add(atiduotaTAIP);
        givenbackadd.add(atiduotaNE);
        

        atiduotaNE.setFocusPainted(false);
        atiduotaNE.addActionListener(this);
        atiduotaNE.setText("NE");

        atiduotaTAIP.setFocusPainted(false);
        atiduotaTAIP.addActionListener(this);
        atiduotaTAIP.setText("Taip");

        

        boxadd = new JPanel();
        boxadd.setLayout(new GridLayout(5,2,20,10));
        boxadd.setPreferredSize(new Dimension(222, 0));
        boxadd.setVisible(false);

        JTextField person = new JTextField();
        person.setText("Asmuo kuris skolinas");
        JTextField amount = new JTextField();
        amount.setText("Kiekis paskolinta");
        JTextField givenback = new JTextField();
        givenback.setText("Ar atiduota");

        Problemsadd.setForeground(Color.red);
        Problemsadd.setText("Neviskas užpildyta");


        addindadd = new JButton("Išsaugoti");
        addindadd.addActionListener(this);
        addindadd.setFocusable(false);
        
      

        JTextField[] addInfo = {dateadd,personadd,amountadd,person,Problemsadd,amount,givenback};

        for(JTextField s : addInfo){
            s.setPreferredSize(new Dimension(150,10));
            s.setFont(new Font("Monospaced", Font.BOLD, 20));
            s.setHorizontalAlignment(JTextField.CENTER);
        }
        
        person.setEditable(false);
        Problemsadd.setEditable(false);
        amount.setEditable(false);
        givenback.setEditable(false);

      
      

      

        currentDate = new JButton("Data (Paspaudus Dabartinė)");
        currentDate.addActionListener(this);
        currentDate.setFocusable(false);


        boxadd.add(currentDate);
        boxadd.add(dateadd);
        boxadd.add(person);
        boxadd.add(personadd);
        boxadd.add(amount);
        boxadd.add(amountadd);
        boxadd.add(givenback);
        boxadd.add(givenbackadd);
        boxadd.add(Problemsadd);
        boxadd.add(addindadd);
       

        JTextArea showinfo = new JTextArea();
        showinfo.setFont(new Font("Monospaced", Font.BOLD, 20));
        showinfo.setPreferredSize(new Dimension(110,100));
        

        JPanel b1 = new JPanel();
        
        b1.setLayout(new GridLayout(2,1));

        JTextField ifs = new JTextField();
        ifs.setText("Remove (item) write id to search for it");
        ifs.setFont(new Font("Monospaced", Font.BOLD, 15));
        ifs.setEditable(false);
        ifs.setBorder(null);
        
        JPanel b1e1 = new JPanel();
        b1e1.setLayout(new FlowLayout());
        
        ifs.setPreferredSize(new Dimension(300,50));
        b1e1.add(ifs);


        inputremove = new JTextField();
        inputremove.setFont(new Font("Monospaced", Font.BOLD, 20));
        inputremove.setHorizontalAlignment(JTextField.CENTER);
        inputremove.setPreferredSize(new Dimension(150,50));

        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        searchButton.setFocusable(false);
        searchButton.setPreferredSize(new Dimension(90,50));

        JPanel b1e2 = new JPanel();
        b1e2.setLayout(new FlowLayout(1,10,20));
        

        b1e2.add(inputremove);
        b1e2.add(searchButton);

        b1.add(b1e1);
        b1.add(b1e2);

        showinformation = new JTextField();
        showinformation.setFont(new Font("Monospaced", Font.BOLD, 15));
        showinformation.setHorizontalAlignment(JTextField.CENTER);
        showinformation.setPreferredSize(new Dimension(500,150));
        

        JPanel b2 = new JPanel();
        b2.setLayout(new FlowLayout());
        

        b2.add(showinformation);

        JPanel b3e1 = new JPanel();
        b3e1.setLayout(new FlowLayout(1,10,50));
        

        JPanel placeholder = new JPanel();
        

        suretodelete = new JCheckBox("Ar tikrai norite pasalinti");
        suretodelete.setPreferredSize(new Dimension(200,30));
        suretodelete.addActionListener(this);
        suretodelete.setEnabled(false);

        remItem = new JButton("Pasalinti");
        remItem.setPreferredSize(new Dimension(100,50));
        remItem.setFocusable(false);
        remItem.addActionListener(this);
        remItem.setEnabled(false);

        b3e1.add(suretodelete);
        b3e1.add(remItem);
        

        JPanel b3 = new JPanel();
        b3.setLayout(new GridLayout());
        b3.setBackground(Color.green);

        b3.add(placeholder);
        b3.add(b3e1);

        

        boxremove.setLayout(new GridLayout(3,1));

       
        boxremove.add(b1);

        boxremove.add(b2);

        boxremove.add(b3);

        


        // adding add remove change info into one which can be changed cool !!
        center = new JPanel();
        center.setLayout(new CardLayout());
        center.setPreferredSize(new Dimension(222, 0));
        center.add(box2, "Show-info");
        center.add(boxadd, "Add-info");
        center.add(boxremove, "remove-info");
        

        


        back.setVisible(false);


        box5.add(add);
        box5.add(remove);
        box5.add(back);

        

        
        

        this.add(box, BorderLayout.NORTH);
        this.add(center,BorderLayout.CENTER);
        this.add(box3, BorderLayout.EAST);
        this.add(box4, BorderLayout.WEST);
        this.add(box5, BorderLayout.SOUTH);


        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        CardLayout cl = (CardLayout) center.getLayout();

        if(e.getSource() == currentDate){
           LocalDate date = LocalDate.now();

           dateadd.setText(date.toString());
        }

        if(e.getSource() == add){
            
            cl.show(center,"Add-info");
            back.setVisible(true);
        }

         if(e.getSource() == addindadd){
            atiduotaTAIP.setBackground(defaultColor);
            atiduotaNE.setBackground(defaultColor);

            
            
          
            if(!dateadd.getText().isEmpty() && !personadd.getText().isEmpty() && !amountadd.getText().isEmpty() && taipne !=0 ){

                try {

                    String atiduota = "";

                    if(taipne == 1){
                        atiduota = "Taip";
                    }

                    else{
                        atiduota = "Ne";
                    }
                    addnewincome(LocalDate.parse(dateadd.getText()), personadd.getText(), Double.parseDouble(amountadd.getText()), atiduota);
                    
                     StringBuilder bd = new StringBuilder();

                    info.setText(String.format("  %-5s | %-10s | %-10s | %-10s | %-10s", "ID", "Data", "Asmuo", "Kiek(Eur)", "Atiduotas(?)\n"));
                    info.append("-------------------------------------------------------------\n");

                    for(LoansData s : Information){
                        
                    bd.append(s).append("\n");
                    }

                     info.append(bd.toString());
                    

                
               
                recentgivenloans();
                MostTimesLoaned();
               
                dateadd.setText("");
                personadd.setText("");
                amountadd.setText("");
                taipne = 0;



                cl.show(center,"Show-info");

                  } catch (NumberFormatException ez) {
                        for(int i = 0; i < 5; i++){
            
            final int index = i;

        new Timer(300 * index, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {

            switch (index) {
                case 1:
                case 3:
                amountadd.setBackground(Color.red);
              
                    break;


                case 2:
                case 4:
               amountadd.setBackground(Color.white);
                
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
                 catch (DateTimeParseException zz) {
                    error("Date");
            
            }

            }
           

            else{
                error2();
            }

               if(!dateadd.getText().isEmpty() && !personadd.getText().isEmpty() && !amountadd.getText().isEmpty() && taipne == 0){
               
                error("SktRaide");
            }

            if(dateadd.getText().length() < 10){
                 Problemsadd.setText("Data netinka");
                 Problemsadd.setForeground(Color.red);
            }







          

            

            

            
            
        }

         if(e.getSource() == atiduotaTAIP){
            taipne = 1;
            atiduotaTAIP.setBackground(Color.green);
            atiduotaNE.setBackground(defaultColor);
        }

         if(e.getSource() == atiduotaNE){
            taipne = 2;
            atiduotaNE.setBackground(Color.green);
            atiduotaTAIP.setBackground(defaultColor);
        }











         if(e.getSource() == remove){
            cl.show(center, "remove-info");
            back.setVisible(true);
              
        }


        if(e.getSource()== searchButton){

            deletechosen.clear();
            readinfo();

            Boolean rasta = false;
            
            for(LoansData s: Information){
                showinformation.setText("");

                if(inputremove.getText().equals(String.valueOf(s.getID()))){
                    showinformation.setForeground(Color.black);
                    showinformation.setText(s.toString());
                    rasta = true;

                    deletechosen.add(s);

                    suretodelete.setEnabled(true);

                }

                if(!rasta){
                    showinformation.setText("Informacijos nerasta pagal " + "[" + inputremove.getText() + "] Id");
                    suretodelete.setEnabled(false);
                    suretodelete.setSelected(false);
                    remItem.setEnabled(false);
                }


            }

            if(Information.isEmpty()){
                showinformation.setText("Informacijos nerasta duomenu nera");
            }

        }

        if(e.getSource() == suretodelete){
            remItem.setEnabled(suretodelete.isSelected());

        }

        if(e.getSource() == remItem){
            deletefromDataBase();
            suretodelete.setEnabled(false);
            suretodelete.setSelected(false);
            remItem.setEnabled(false);
            showinformation.setText("");
            inputremove.setText("");
            cl.show(center, "Show-info");

        }



    
        
        
         if(e.getSource() == back){
            cl.show(center, "Show-info");
            back.setVisible(false);

        }

         if(e.getSource() == back2){
            dispose();
            
        }
        
        
    }


    public void deletefromDataBase(){

        String id = "";

        for(LoansData s : deletechosen){
            id = (String.valueOf(s.getID()));
            
        }

    

        try(Connection con = DriverManager.getConnection(url, user, password)) {

        String query = "delete from loans where id = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1,id);
        ps.executeUpdate();

        } catch (SQLException  e) {
                e.printStackTrace();
        }
        
        readinfo();
            
    }

    //errors if not everything is filled or there is a mistake
    public void error2(){

       
        Problemsadd.setText("neuz visi laukai");
        Problemsadd.setForeground(Color.red);

        JTextField[] check = {dateadd,personadd,amountadd};

        for(JTextField s : check){
            
                if(s.getText().isEmpty()){
        
            for(int i = 0; i < 5; i++){
            
            final int index = i;

        new Timer(300 * index, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {

            switch (index) {
                case 1:
                case 3:
                s.setBackground(Color.orange);
              
                    break;


                case 2:
                case 4:
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
    
    //error with place indicator
    public void error(String place){

        if(place.equals("SktRaide")){
         Problemsadd.setText("Taip/Ne nepasirinktas");
                Problemsadd.setForeground(Color.red);

        

       
        
            for(int i = 0; i < 5; i++){
            
            final int index = i;

        new Timer(300 * index, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {

            switch (index) {
                case 1:
                case 3:
                atiduotaNE.setBackground(Color.orange);
                atiduotaTAIP.setBackground(Color.orange);
                    break;


                case 2:
                case 4:
                atiduotaNE.setBackground(defaultColor);
                atiduotaTAIP.setBackground(defaultColor);
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

   else {
    // datos klaida

    for(int i = 0; i < 5; i++){
        final int index = i;
    Timer timer = new Timer(300 * index, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
            switch (index) {
                case 1:
                case 3:
                dateadd.setBackground(Color.red);
                    
                    break;


                case 2:
                case 4:
                dateadd.setBackground(Color.white);
                    break;
            
                default:
                    break;
            }
            
        }
    });
        timer.setRepeats(false); 
     timer.start();         
}  
}

               
        
    }


    

    // read mysql info so it coult be accessed
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

    //recentloans
    public  void recentgivenloans(){
        
        recents.clear();
        
        
        int from = Information.size()-15;

        if(from < 0){
            from = 0;
        }
        
        int to = Information.size();

        

        for(int i = from; i < to; i++){
            recents.add(Information.get(i).getPerson());
            
        }

      recentloans.setText("----------------" + "\n");
       recentloans.append(" Top " + Math.abs(from - to) + " recent" + "\n");
       recentloans.append("----------------" + "\n");

       StringBuilder bd2 = new StringBuilder();

       for(int i = recents.size()-1; i >=0; i-- ){

        bd2.append("     "+recents.get(i)).append("\n");
       }
        recentloans.append(bd2.toString());

        


    }

    // loan counter with names and people 
    public void MostTimesLoaned(){

        

        ArrayList<String> UniquesNames = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        for(int i = 0; i < Information.size(); i++){
            boolean yra = false;
            for(int j = 0; j < UniquesNames.size(); j++){
                if(Information.get(i).getPerson().equals(UniquesNames.get(j))){
                    yra = true;
                }
            }
            if(!yra){
                UniquesNames.add(Information.get(i).getPerson());
            }

            
           
        }

        for(int i = 0; i < UniquesNames.size(); i++){
            int amount = 0;
            for(int j = 0; j < Information.size(); j++){
                if((UniquesNames.get(i).equals(Information.get(j).getPerson()))){
                    amount++;
                }
               
            }
            count.add(amount);
           
        }

        
             StringBuilder bd = new StringBuilder();

             for(int i = 0; i < UniquesNames.size(); i++){

                bd.append("   "+ UniquesNames.get(i) + " " + count.get(i)).append("\n");


             }

             loancount.setText("Paskolinimai\n");
             loancount.append("---------------\n");
             loancount.append(bd.toString());


    }

    // read info
    public void readinfo(){

        Information.clear();

         try(Connection con = DriverManager.getConnection(url, user, password)) {

             String query = "SELECT * FROM Loans order by id asc";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                LoansData items = new LoansData(
                    rs.getInt("id"),
                    rs.getDate("date").toLocalDate(),
                    rs.getString("person"),
                    rs.getDouble("amount"),
                    rs.getString("givenback")
                    
               
                );
                Information.add(items);

                
            }

            
          
            
        } catch (SQLException  e) {
                e.printStackTrace();
        }


        StringBuilder bd = new StringBuilder();

        info.setText(String.format("  %-5s | %-10s | %-10s | %-10s | %-10s", "ID", "Data", "Asmuo", "Kiek(Eur)", "Atiduotas(?)\n"));
        info.append("-------------------------------------------------------------\n");

        for(LoansData s : Information){
             
        bd.append(s).append("\n");
        }

       info.append(bd.toString());
        
    }

    // add new info
    public void addnewincome(LocalDate data, String person, double amount, String givenback){

        // index that alway increase
        int Info = Information.size()+1;

        

        // insert new value that user inserting
        try(Connection con = DriverManager.getConnection(url, user, password)) {

        String query = "INSERT INTo Loans (id, date, person, amount, givenback) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, Info);
            ps.setDate(2, java.sql.Date.valueOf(data));
            ps.setString(3, person);
            ps.setDouble(4, amount);
            ps.setString(5, givenback);

        ps.executeUpdate();

        } catch (SQLException  e) {
                e.printStackTrace();
        }

        

        // read info into file

       readinfo();
     }


        


}
