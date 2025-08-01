package Header;

public class CalculatorData {

    private int id;
    private int five;
    private int ten;
    private int twenty;
    private int fifty;
    private int hundred;
    private int wallet;
    private int bank;


    public CalculatorData(int id, int five, int ten, int twenty, int fifty, int hundred, int wallet, int bank) {
        this.id = id;
        this.five = five;
        this.ten = ten;
        this.twenty = twenty;
        this.fifty = fifty;
        this.hundred = hundred;
        this.wallet = wallet;
        this.bank = bank;
    }


    public int getId() {
        return id;
    }
    public int getFive() {
        return five;
    }
    public int getTen() {
        return ten;
    }
    public int getTwenty() {
        return twenty;
    }
    public int getFifty() {
        return fifty;
    }
    public int getHundred() {
        return hundred;
    }
    public int getWallet() {
        return wallet;
    }
    public int getBank() {
        return bank;
    }
    
    @Override
    public String toString() {
        return "CalculatorData [id=" + id + ", five=" + five + ", ten=" + ten + ", twenty=" + twenty + ", fifty="
                + fifty + ", hundred=" + hundred + ", wallet=" + wallet + ", bank=" + bank + "]";
    }

    

    
    



    
    


}
