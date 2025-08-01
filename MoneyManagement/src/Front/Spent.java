package Front;
import java.time.LocalDate;

public class Spent {

    private int id;
    private LocalDate data;
    private double spent;
    private String category;
    private String location;
    private String cardGreen;



    


    public Spent(int id, LocalDate data, double spent, String category, String location, String cardGreen) {
        this.id = id;
        this.data = data;
        this.spent = spent;
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
    public double getSpent() {
        return spent;
    }
    public String getCategory() {
        return category;
    }
    public String getLocation() {
        return location;
    }
    public String getCardGreen() {
        return cardGreen;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public void setSpent(double spent) {
        this.spent = spent;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setLocation(String location) {
        this.location = location;
    }
   @Override

  public String toString() {
    return String.format("  %-8s |  %-12s |   %-9.2f  |  %-11s | %-17s | %s", id, data.toString(), spent, category, location, cardGreen);
}
    
   

    
    


    
    
   

    

 
    


}
