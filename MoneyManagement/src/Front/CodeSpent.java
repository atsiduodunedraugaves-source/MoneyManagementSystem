package Front;
import java.util.ArrayList;

import Header.SettingData;
import Header.Settings;

import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;


public class CodeSpent {

    static ArrayList<String> UrlUserPassword = new ArrayList<>();

    ArrayList<Spent> info = new ArrayList<>();


    ArrayList<Income> info2 = new ArrayList<>();

     
    CODE code;
    // user setttings
    Settings SETTINGSINFO;

    String url;
    String user;
    String password;

     //remove income
    ArrayList<Spent> salinti;
    
    boolean AutoCalculateIncome;
    

    CodeSpent(){

        UserSettings();

        readPassURlROot();
            
        if(UrlUserPassword.size() >=3 ){
            url = UrlUserPassword.get(0);
            user = UrlUserPassword.get(1);
            password = UrlUserPassword.get(2);
        }

        this.code = new CODE();
        this.info = new ArrayList<>();
        this.info2 = new ArrayList<>();
        add();

    }

    public void add(){
        
         try(Connection con = DriverManager.getConnection(url, user, password)) {

            String query = "SELECT * FROM spend_info";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Spent items = new Spent(
                    rs.getInt("spend_id"),
                    rs.getDate("spend_date").toLocalDate(),
                    rs.getDouble("spend_money"),
                    rs.getString("spend_category"),
                    rs.getString("spend_location"),
                    rs.getString("spend_cardgreen")
               
                );
                info.add(items);
            }

           
            



            
        } catch (SQLException  e) {
                e.printStackTrace();
        }
    }


    public ArrayList<Spent> searchSpend(String range1, String range2){

        
        LocalDate from = LocalDate.parse(range1);
        LocalDate to = LocalDate.parse(range2);

        ArrayList<Spent> incomesorted = new ArrayList<>();

        for(Spent s : info){
           
             LocalDate incomeDate = s.getData();

             if ((incomeDate.isEqual(from) || incomeDate.isAfter(from)) &&
                (incomeDate.isEqual(to) || incomeDate.isBefore(to))) {
                incomesorted.add(s);
            }
        }

        
        return incomesorted;

    }


    public ArrayList<Spent> showSPEND(){
        
        info.clear();
        try(Connection con = DriverManager.getConnection(url, user, password)) {

            String query = "SELECT * FROM spend_info order by spend_id asc";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Spent items = new Spent(
                    rs.getInt("spend_id"),
                    rs.getDate("spend_date").toLocalDate(),
                    rs.getDouble("spend_money"),
                    rs.getString("spend_category"),
                    rs.getString("spend_location"),
                    rs.getString("spend_cardgreen")
               
                );
                info.add(items);
            }

          
            



            
        } catch (SQLException  e) {
                e.printStackTrace();
        }

        return info;

    }


     public void addnewincome(String id, LocalDate data, double income, String category, String location, String cardGreen){
        
        String iddd = String.valueOf(info.size()+1);
        info.clear();


        try(Connection con = DriverManager.getConnection(url, user, password)) {

        String query = "INSERT INTo spend_info (spend_id, spend_date, spend_money, spend_category, spend_location, spend_cardgreen) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);

       

        

        ps.setString(1, iddd );
        ps.setDate(2, java.sql.Date.valueOf(data));
        ps.setDouble(3, income);
        ps.setString(4, category);
        ps.setString(5, location);
        ps.setString(6, cardGreen);

        ps.executeUpdate();
        

        } catch (SQLException  e) {
                e.printStackTrace();
        }

        showSPEND();


        LocalDate max = info.get(0).getData();
        //String ID = "";


        for(Spent s : info){
            if(max.isBefore(s.getData())){
                max = s.getData();
            }
        }


        Double value2 = 0.0;
        for(Spent s : info){
            if(max.equals(s.getData())){
                value2 = s.getSpent();
            }
        }

        
        

        info2.clear();
        try(Connection con = DriverManager.getConnection(url, user, password)) {

            String query = "SELECT * FROM income_info";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Income items = new Income(
                    rs.getInt("income_id"),
                    rs.getDate("income_date").toLocalDate(),
                    rs.getDouble("income_money"),
                    rs.getString("income_category"),
                    rs.getString("income_location"),
                    rs.getString("income_cargreen")
               
                );
                info2.add(items);
            }
            
        } catch (SQLException  e) {
                e.printStackTrace();
        }



        LocalDate max2 = info2.get(0).getData();
        for(Income s : info2){
            if(max2.isBefore(s.getData())){
                max2 = s.getData();
            }
        }

        Double value = 0.0;
        for(Income s : info2){
            if(max2.equals(s.getData())){
                value = s.getIncome();
            }
        }

        


        Double value3 = 0.0;
        
        if((value >= value2)){
            value3 = Math.abs(value2 - value);
        }
        
        else{
            value3 = 0.0;
        }


        
        if(AutoCalculateIncome){
        try(Connection con = DriverManager.getConnection(url, user, password)) {

        String query = "INSERT INTo income_info (income_id, income_date, income_money, income_category, income_location, income_cargreen) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);

        

        int ids = info2.size()+1;
       
        ps.setInt(1,ids);
        ps.setDate(2, java.sql.Date.valueOf(max));
        ps.setDouble(3, value3);
        ps.setString(4, "Auto");
        ps.setString(5, "Auto");
        ps.setString(6, "Auto");

        ps.executeUpdate();

        } catch (SQLException  e) {
                e.printStackTrace();
        }


        
    }
    }

     // rasti naujausa irasa apei finansus 
    public Double dabartinesuma(){

        
        
         Double suma = 0.0; 

        for(Spent s : info){

               suma += s.getSpent();
        }

         
        

        return suma;


    }

    //salinti

     public ArrayList<Spent> pasalintiinfo(int id){
        
        salinti = new ArrayList<>();
        

        for(Spent s : info){

            if(id == s.getId()){
                salinti.add(s);
            }

        }
        
        return salinti;
        

    }

    public void pasalinti(){
        
        int id = 0;

        for(Spent s: salinti){
            id = s.getId();
        }


        showSPEND();
        try(Connection con = DriverManager.getConnection(url, user, password)) {

        String query = "delete from spend_info where spend_id = ?";

        PreparedStatement ps = con.prepareStatement(query);

       
        ps.setInt(1,id);
       

        ps.executeUpdate();

        } catch (SQLException  e) {
                e.printStackTrace();
        }

    }

    // keisti info
    public ArrayList<Spent> cahageinfo(int id){
        
        salinti = new ArrayList<>();
        

        for(Spent s : info){

            if(id == s.getId()){
                salinti.add(s);
            }

        }
        
        return salinti;
        

    }

    public void changinginfo(String kakeisti, String change){
        
        switch (kakeisti) {
            case "DATA":
                MysqlKeitimas(change,"spend_date = ?");
                break;

            case "SUMA":
                MysqlKeitimas(change,"spend_money = ?");
                break;

            case "KATEGORIJA":
                MysqlKeitimas(change,"spend_category = ?");
                break;

            case "VIETA":
                MysqlKeitimas(change,"spend_location = ?");
                break;

            case "TIPAS":
                MysqlKeitimas(change,"spend_cardgreen = ?");
                break;    

                

        
            default:
                System.out.println("Problema nerastas dalykas fatal error Spend skyde");
                break;
        }


    }

    public void MysqlKeitimas(String change, String statment){

       

        //statment changes according to change

        int id = salinti.get(0).getId();
        
         try(Connection con = DriverManager.getConnection(url, user, password)) {

        String query = "update spend_info set " + statment + " where spend_id = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, change);
        ps.setInt(2, id);
        ps.executeUpdate();




     } catch (SQLException  e) {
                e.printStackTrace();
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
    
    // read settings
    public void UserSettings(){
        ArrayList<SettingData> storeInfo = new ArrayList<>();

        try (BufferedReader read = new BufferedReader(new FileReader("src\\Setting.txt"))) {

            String line;

            if((line = read.readLine()) !=null){
                String[] niam = line.split(" ");

                storeInfo.add(new SettingData(niam[0], niam[1]));

            }
            
        } catch (Exception e) {
            
        }

        for(SettingData s : storeInfo){
            if(s.getName().equals("AutoPlaceStuff")){
                if(s.getValue().equals("True")){
                    AutoCalculateIncome = true;
                }
                  if(s.getValue().equals("False")){
                    AutoCalculateIncome = false;
                }
            }
        }

        
    }



}
