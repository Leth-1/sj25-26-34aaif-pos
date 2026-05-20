public class Kunde {
    private String name = "Mustermann";
    private int number = 1000;
    private int purchases = 0;
    private double revenue = 0.0;
    private double credit = 0.0;


    public Kunde() {
    }

    public Kunde(int number, String name) {
        this.number = number;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number < 1000) {
            throw new IllegalArgumentException("Number can't be less then 1000");
        }
        this.number = number;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        if (purchases < 0) {
            throw new IllegalArgumentException("Purchases can't be less then 0");
        }
        this.purchases = purchases;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        if (revenue < 0) {
            throw new IllegalArgumentException("revenue can't be less then 0");

        }
        this.revenue = revenue;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        if (credit < 0) {
            throw new IllegalArgumentException("credit can't be less then 0");
        }
        this.credit = credit;
    }

    public void useCredit() {
        credit = 0;
    }

    public double newPurchase(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("You can't be 0");
        }
        revenue += amount;
        purchases++;
        if (purchases % 5 == 0) {
            credit += 5;
        }
        if (amount > 100) {
            credit += 5.0;
        }
        if (amount > 50) {
            credit += 3.0;
        }
        return  credit;
    }

    public void printToConsole(){
        System.out.println(name);
        System.out.println("Kundennr. "+ number);
        System.out.println("Guthaben:"+ credit);
        System.out.println("Einkaufe: " + purchases + "Umsatz: " + revenue);

    }
}

