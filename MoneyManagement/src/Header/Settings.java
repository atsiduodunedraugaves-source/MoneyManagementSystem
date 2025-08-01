package Header;
import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class Settings extends JFrame implements ActionListener {

    ArrayList<SettingData> info = new ArrayList<>();

    JTextField inputmain;
    
    JTextField Problems;

    JTextField text2;

    JTextField Input1;
    JTextField Input2;

    JButton save;
    JButton tikrinti;
    JButton exit;

    // apsauga nuo brutefroce
    int times = 0;  
    

    boolean visaksok;

    public Settings() {

        
        
        this.setTitle("Nustatymai");
        this.setLayout(new BorderLayout());
        this.setSize(900, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        save = new JButton("Save");
        save.setFocusable(false);
        save.addActionListener(this);

        tikrinti = new JButton("Tikrinti");
        tikrinti.setVisible(false);
        tikrinti.addActionListener(this);

        exit = new JButton("Back");
        exit.addActionListener(this);

        // header
        JPanel box1 = new JPanel();
        box1.setLayout(new FlowLayout(1, 10, 10));
        box1.setPreferredSize(new Dimension(0, 70));

        // header stuff
        JTextField NameOFtheBlock = new JTextField("Nustatymai");
        NameOFtheBlock.setHorizontalAlignment(JTextField.CENTER);
        NameOFtheBlock.setFont(new Font("Arial", Font.BOLD, 18));
        NameOFtheBlock.setPreferredSize(new Dimension(200, 50));
        NameOFtheBlock.setBorder(null);
        NameOFtheBlock.setEditable(false);
       

        box1.add(NameOFtheBlock);
         box1.setBackground(Color.yellow);

        // left side
        JPanel box2 = new JPanel();
        box2.setLayout(new FlowLayout());
        box2.setPreferredSize(new Dimension(450, 0));

        // main skydas

        JTextField textmain = new JTextField("Pagrindinis skydas");
        textmain.setPreferredSize(new Dimension(400, 30));

        JTextField text2main = new JTextField("Auto informacija");
        text2main.setPreferredSize(new Dimension(200, 50));

        inputmain = new JTextField();
        inputmain.setPreferredSize(new Dimension(200, 50));

        // loans
        JTextField text1 = new JTextField("Slaptžodžio info");
        text1.setPreferredSize(new Dimension(400, 30));

        text2 = new JTextField("Kiek galima bandyti");
        text2.setPreferredSize(new Dimension(200, 50));

        Input1 = new JTextField();
        Input1.setPreferredSize(new Dimension(200, 50));

        JTextField text3 = new JTextField("Kiek laukti (suklydimas)");
        text3.setPreferredSize(new Dimension(200, 50));

        Input2 = new JTextField();
        Input2.setPreferredSize(new Dimension(200, 50));

        readinfo();
        addstuff();

        box2.add(textmain);
        box2.add(text2main);
        box2.add(inputmain);
        box2.add(text1);
        box2.add(text2);
        box2.add(Input1);
        box2.add(text3);
        box2.add(Input2);

        // right side
        JPanel box3 = new JPanel();
        box3.setPreferredSize(new Dimension(450, 0));

        // center
        JPanel box23 = new JPanel();
        box23.setLayout(new GridLayout());
        box23.add(box2);
        box23.add(box3);

        
        Problems = new JTextField();
        Problems.setFont(new Font("Arial", Font.BOLD, 18));
        Problems.setHorizontalAlignment(JTextField.CENTER);
        Problems.setText("Viskas Gerai");

        JPanel boxBOTTOM1 = new JPanel();
        boxBOTTOM1.setLayout(new GridLayout());

        boxBOTTOM1.add(Problems);
        



        JPanel boxBOTTOM2 = new JPanel();
        boxBOTTOM2.setLayout(new GridLayout(1, 2));

        boxBOTTOM2.add(exit);
        boxBOTTOM2.add(tikrinti);
        boxBOTTOM2.add(save);
        

        // bottom
        JPanel box4 = new JPanel();
        box4.setLayout(new GridLayout(2, 1));
        box4.setPreferredSize(new Dimension(0, 200));

        box4.add(boxBOTTOM1);
        box4.add(boxBOTTOM2);

        JTextField[] stuff = { text1, text2, Input1, text3, Input2, textmain, text2main, inputmain };
        // put the stuff on that is being use eveywhere
        for (int i = 0; i < stuff.length; i++) {
            stuff[i].setFont(new Font("Arial", Font.BOLD, 18));
            stuff[i].setHorizontalAlignment(JTextField.CENTER);
        }

        this.add(box1, BorderLayout.NORTH);
        this.add(box23, BorderLayout.CENTER);
        this.add(box4, BorderLayout.SOUTH);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String[] NamesOfSettings = { "AutoPlaceStuff", "CanTryPass", "PunishmentforMistake" };
        String[] ValuesOfNames = { inputmain.getText(), Input1.getText(), Input2.getText() };

        if (e.getSource() == exit) {
            dispose();
        }

        if (e.getSource() == save) {

            boolean ok = false;


             for (int i = 0; i < info.size(); i++) {
                    if(NamesOfSettings[i].equals("AutoPlaceStuff")){

                        if(inputmain.getText().equalsIgnoreCase("true")){
                       inputmain.setText("True");
                       ok = true;
                        }

                        if(inputmain.getText().equalsIgnoreCase("false")){
                       inputmain.setText("False");
                       
                       ok = true;
                        }



                        else{
                          Problems.setForeground(Color.red);
                          Problems.setText("AutoPlaceStuff gali buti tik True/False");
                        }

                    }

                     if(NamesOfSettings[i].equals("CanTryPass")){
                        try {

                            Integer.parseInt(ValuesOfNames[i]);
                            
                        } catch (NumberFormatException ee) {
                            Problems.setForeground(Color.red);
                            Problems.setText("Negalima išsaugoti raidžių su skaičiais (Kiek galima bandyti) ");
                            ok  = false;
                        }
                     }


                      if(NamesOfSettings[i].equals("PunishmentforMistake") ){
                        try {

                            Integer.parseInt(ValuesOfNames[i]);
                            
                        } catch (NumberFormatException ee) {
                               Problems.setForeground(Color.red);
                                Problems.setText("Negalima išsaugoti raidžių su skaičiais (Kiek laukti) ");
                                ok  = false;
                        }
                     }
                }

            if(ok){

                Problems.setForeground(Color.black);
                Problems.setText("Įveskite programos slaptažodį kad išsaugotute pakeitimus: ");

                save.setEnabled(false);

                tikrinti.setVisible(true);

                






               if(visaksok){
                Problems.setForeground(Color.green);
                Problems.setText("Išsaugota sėkmingai !");

                 save.setEnabled(true);

                tikrinti.setVisible(false);
                visaksok = false;

            try (BufferedWriter write = new BufferedWriter(new FileWriter("src\\Setting.txt"))) {

                for (int i = 0; i < info.size(); i++) {
                   
                    write.write(NamesOfSettings[i] + " " + ValuesOfNames[i]);
                    write.newLine();

                    }
                

            } catch (Exception ee) {
                System.out.println(ee);
            }
        }
    }
}


        if(e.getSource() == tikrinti){

                      

            if(Problems.getText().contains(String.valueOf(settingpasswordgen()))){
                visaksok = true;
                save.setEnabled(true);
                tikrinti.setVisible(false);
                 Problems.setForeground(Color.green);
                Problems.setText("Slaptažodis teisingas ! duota prieeiga išsaugoti");
            }

            else{
                 Problems.setForeground(Color.red);
                Problems.setText("Slaptažodis neteisingas bandykite darkarta: ");
                times++;
            }


             if(times == 4){
                 Problems.setForeground(Color.red);
                Problems.setText("paskutinis kartas settings skydas bus išjunktas ");
            }

            if(times == 5){
                dispose();
                
            }

          

        }

       

        
}
    

    

       




    public void readinfo() {
        try (BufferedReader read = new BufferedReader(new FileReader("src\\Setting.txt"))) {

            String line;

            while ((line = read.readLine()) != null) {

                String[] niam = line.split(" ");
                info.add(new SettingData(niam[0], (niam[1])));

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    

    }

    public void addstuff() {

        for (SettingData a : info) {
            if (a.getName().equals("AutoPlaceStuff")) {

                inputmain.setText(String.valueOf(a.getValue()));

            }

            if (a.getName().equals("CanTryPass")) {

                Input1.setText(String.valueOf(a.getValue()));

            }

            if (a.getName().equals("PunishmentforMistake")) {

                Input2.setText(String.valueOf(a.getValue()));

            }
        }

    }


    public int settingpasswordgen(){

      LocalDate time = LocalDate.now();

       String year = time.toString().substring(0,4);

       String month = time.toString().substring(5,7);

       String day = time.toString().substring(8,10);


       int pass = Integer.parseInt(year) + Integer.parseInt(month) * Integer.parseInt(day);
        

        return pass;

        

        
    }
}
