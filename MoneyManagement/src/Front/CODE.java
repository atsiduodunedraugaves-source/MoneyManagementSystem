package Front;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class CODE {

    static ArrayList<String> UrlUserPassword = new ArrayList<>();

    ArrayList<Income> info = new ArrayList<>();

    String url;
    String user;
    String password;

    //remove income
    ArrayList<Income> salinti;

    CODE(){

        readPassURlROot();
            
        if(UrlUserPassword.size() >=3 ){
            url = UrlUserPassword.get(0);
            user = UrlUserPassword.get(1);
            password = UrlUserPassword.get(2);
        }

        this.info = new ArrayList<>();

        add();
        
    }

    


    // prideti duomenis
    public void add(){

           try(Connection con = DriverManager.getConnection(url, user, password)) {

             String query = "SELECT * FROM income_info order by income_date asc";

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
                info.add(items);
            }

            
        } catch (SQLException  e) {
                e.printStackTrace();
        }


    }

    // let user to add new thing
    public void addnewincome(LocalDate data, double income, String category, String location, String cardGreen){

        String IndexOfInformaton = String.valueOf(info.size()+1);

        
        // insert new value that user inserting
        try(Connection con = DriverManager.getConnection(url, user, password)) {

        String query = "INSERT INTo income_info (income_id, income_date, income_money, income_category, income_location, income_cargreen) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);

       
            ps.setString(1,IndexOfInformaton);
            ps.setDate(2, java.sql.Date.valueOf(data));
            ps.setDouble(3, income);
            ps.setString(4, category);
            ps.setString(5, location);
            ps.setString(6, cardGreen);

        ps.executeUpdate();

        } catch (SQLException  e) {
                e.printStackTrace();
        }



        // read info into file

        info.clear();

        try(Connection con = DriverManager.getConnection(url, user, password)) {

            String query = "SELECT * FROM income_info order by income_date asc";

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
                info.add(items);
            }   
        } catch (SQLException  e) {
                e.printStackTrace();
        }

     }

    // Jieskoti pagal nuo iki duomenis
    public ArrayList<Income> searchINCOME(String range1, String range2){

        LocalDate from = LocalDate.parse(range1);
        LocalDate to = LocalDate.parse(range2);

        ArrayList<Income> incomesorted = new ArrayList<>();

        for(Income s : info){
           
             LocalDate incomeDate = s.getData();

             if ((incomeDate.isEqual(from) || incomeDate.isAfter(from)) &&
                (incomeDate.isEqual(to) || incomeDate.isBefore(to))) {

                incomesorted.add(s);
            }
        }

        return incomesorted;

    }
   
    // nadojamas iskarto pakrauti duomenis i langa kad netrodytu toks tuscias
     public ArrayList<Income> show(){


            info.clear();

        try(Connection con = DriverManager.getConnection(url, user, password)) {

            String query = "SELECT * FROM income_info order by income_date asc";

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
                info.add(items);
            }

           
            



            
        } catch (SQLException  e) {
                e.printStackTrace();
        }


        return info;
    }

    // rasti naujausa irasa apei finansus 
    
    public Double dabartinesuma(){
         LocalDate max = info.get(0).getData();
         int pagal = 0;
         Double suma = 0.0; 

        for(Income s : info){

                if(max.isBefore(s.getData())){
                        pagal = s.getId();
                }
        }

        

          for(Income s : info){

                if(pagal == s.getId()){
                        suma += s.getIncome();
                }
        }

        return suma;


    }

    // Find a information according to ID and display it to user
    public ArrayList<Income> pasalintiinfo(int id){
        
        salinti = new ArrayList<>();
        

        for(Income s : info){

            if(id == s.getId()){
                salinti.add(s);
            }

        }
        
        return salinti;
        

    }

    // remove the given id if its actually exists
    public void pasalinti(){

        // Remove id every time the method starts to avoid collisions
        int id = 0;

        for(Income s: salinti){
            id = s.getId();
        }

        //show info in the data place
        show();

        // deletis the given ID from user
        try(Connection con = DriverManager.getConnection(url, user, password)) {

        String query = "delete from income_info where income_id = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1,id);
        ps.executeUpdate();

        } catch (SQLException  e) {
                e.printStackTrace();
        }

    }

    //rasti info ir ja duoti i change
    public ArrayList<Income> cahageinfo(int id){
        
        salinti = new ArrayList<>();
        

        for(Income s : info){

            if(id == s.getId()){
                salinti.add(s);
            }

        }
        
        return salinti;
        

    }

    public void changinginfo(String kakeisti, String change){

        switch (kakeisti) {
            case "DATA":
                MysqlKeitimas(change,"income_date = ?");
                break;

            case "SUMA":
                MysqlKeitimas(change,"income_money = ?");
                break;

            case "KATEGORIJA":
                MysqlKeitimas(change,"income_category = ?");
                break;

            case "VIETA":
                MysqlKeitimas(change,"income_location = ?");
                break;

            case "TIPAS":
                MysqlKeitimas(change,"income_cargreen = ?");
                break;    

                

        
            default:
                System.out.println("Problema nerastas dalykas fatal error Income skyde");
                break;
        }


    }

    public void MysqlKeitimas(String change, String statment){

        

        //statment changes according to change

        int id = salinti.get(0).getId();
        
         try(Connection con = DriverManager.getConnection(url, user, password)) {

        String query = "update income_info set " + statment + " where income_id = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, change);
        ps.setInt(2, id);
        ps.executeUpdate();




     } catch (SQLException  e) {
                e.printStackTrace();
        }
    }

    //Password
    public String pp(){
       
        String items = "";
         try(Connection con = DriverManager.getConnection(url, user, password)) {

            String query = "SELECT * FROM pass";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                 items = (
                    rs.getString("pass")
                 
               
                );
                
            }

            
        } catch (SQLException  e) {
                e.printStackTrace();
        }

        return items;

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

}


