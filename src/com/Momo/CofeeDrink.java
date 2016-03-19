package com.Momo;
import java.util.Scanner;

/**
 * Created by Momo Johnson on 3/14/2016.
 */
public class CofeeDrink  {
    protected String coffeeName;
    protected double costToMake;
    protected double price;

    public CofeeDrink(String coffeeName, double costToMake, double price){
        this.coffeeName = coffeeName;
        this.costToMake = costToMake;
        this.price = price;

    }


   public double expenses(int amountsold){
       double revsale = amountsold * costToMake;
       return revsale;
   }

    public double revenue(int amountSold){
        double expsale = amountSold*price;
        return expsale;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public double getCostToMake() {
        return costToMake;
    }

    public void setCostToMake(double costToMake) {
        this.costToMake = costToMake;
    }

    public double getPriceTomake() {
        return price;
    }

    public void Price(double priceTomake) {
        this.price = priceTomake;
    }

    public double profit(double revenue, double expenses){
        double coffeeProfit = revenue -expenses;
        return coffeeProfit;
    }

    public static int amountSold(String cupSolds){
        Scanner input = new Scanner(System.in);
        System.out.println("How many "+ cupSolds + " "+ "did sold today: ");
        String sold = input.nextLine();
        while (true){
            try{
            int soldAmount = Integer.parseInt(sold);
            if(soldAmount <0){
                System.out.println("Please enter a positive integer for amount sold");
                sold = input.nextLine();
                continue;
            }
            break;
        }catch (NumberFormatException inputMismatch){
                System.out.println("Please enter a positive integer for amount sold");
                sold = input.nextLine();
            }
        }
        int soldcoffeeAmount = Integer.parseInt(sold);
        return soldcoffeeAmount;
    }
}
