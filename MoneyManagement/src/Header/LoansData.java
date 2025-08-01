package Header;

import java.time.LocalDate;

public class LoansData {

    private int id;
    private LocalDate dLocalDateate;
    private String person;
    private double amount;
    private String givenback;



    public LoansData(int id, LocalDate dLocalDateate, String person, double amount, String givenback) {
        this.id = id;
        this.dLocalDateate = dLocalDateate;
        this.person = person;
        this.amount = amount;
        this.givenback = givenback;
    }


    

      public int getID() {
        return id;
    }

    public LocalDate getdLocalDateate() {
        return dLocalDateate;
    }



    public String getPerson() {
        return person;
    }



    public double getAmount() {
        return amount;
    }



    public String getGivenback() {
        return givenback;
    }



    @Override
    public String toString() {
        return String.format("  %-5d | %-5s | %-9s  | %-10.2f | %5s" , id,dLocalDateate,person,amount,givenback);
    }


    


    



}
