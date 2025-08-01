package Front;
import java.time.LocalDate;

public class Income {

    private int id;
    private LocalDate data;
    private double income;
    private String category;
    private String location;
    private String cardGreen;
   


    
    
    public Income(int id, LocalDate data, double income, String category, String location, String cardGreen) {
        this.id = id;
        this.data = data;
        this.income = income;
        this.category = category;
        this.location = location;
        this.cardGreen = cardGreen;
    }





    public int getId() {
        return id;
    }





    public LocalDate getData() {
        return data;
    }





    public double getIncome() {
        return income;
    }





    public String getCategory() {
        return category;
    }





    public String getLocation() {
        return location;
    }



       public void setID(int id) {
        this.id = id;
    }







    public void setData(LocalDate data) {
        this.data = data;
    }





    public void setIncome(double income) {
        this.income = income;
    }





    public void setCategory(String category) {
        this.category = category;
    }





    public void setLocation(String location) {
        this.location = location;
    }





    
public void setCardGreen(String cardGreen) {
        this.cardGreen = cardGreen;
    }





    //String id, LocalDate data, double income, String category, String location, String cardGreen
    @Override

public String toString() {
    return String.format("  %-8s |  %-12s |   %-9.2f  |  %-9s | %-12s | %s", id, data.toString(), income, category, location, cardGreen);
}





    public void setId(int id) {
        this.id = id;
    }


    

 
    


}
