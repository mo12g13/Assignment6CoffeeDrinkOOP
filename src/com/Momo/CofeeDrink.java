package com.Momo;
import java.util.Scanner;

/**
 * Created by Momo Johnson on 3/14/2016.
 */
public class CofeeDrink  {
    protected String coffeeName;
    protected double costToMake;
    protected double price;
//Initiliazing various element to the constructor
    public CofeeDrink(String coffeeName, double costToMake, double price){
        this.coffeeName = coffeeName;
        this.costToMake = costToMake;
        this.price = price;

    }

//A method that calculates the expenses
   public double expenses(int amountsold){
       double revsale = amountsold * costToMake;
       return revsale;
   }

    //A method that calculates the revenue
    public double revenue(int amountSold){
        double expsale = amountSold*price;
        return expsale;
    }

    // A method that return the name of the coffee
    public String getCoffeeName() {
        return coffeeName;
    }
//A method that sets the name of the coffee
    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }
//A method that get the cost to make a coffee
    public double getCostToMake() {
        return costToMake;
    }
//A methos that sets the cost to make coffee
    public void setCostToMake(double costToMake) {
        this.costToMake = costToMake;
    }

    // A method that gets a the price to make a coffee
    public double getPriceTomake() {
        return price;
    }

    public void Price(double priceTomake) {
        this.price = priceTomake;
    }
//A method that calculates the profit
    public double profit(double revenue, double expenses){
        double coffeeProfit = revenue -expenses;
        return coffeeProfit;
    }

    // A method that does input validation in order to make sure the user enter the right input
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
