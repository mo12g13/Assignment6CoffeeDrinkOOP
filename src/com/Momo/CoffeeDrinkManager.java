package com.Momo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class CoffeeDrinkManager {
    public static void main(String[] args) {
        //Declaring of variables to be used in my program
        FileWriter saleReport;
        String[] lineSplit;
        String coffeeName;

        double price, costToMake,  totalRevenue=0, totalExpenses=0, totalProfit=0;

        try {
            //A BufferedReader that reads the coffee.txt file from my directory
            BufferedReader read = new BufferedReader(new FileReader("coffee.txt"));
            String line = read.readLine();//A method that reads the each line of the file
            LinkedList<CofeeDrink> myShop = new LinkedList<>();//Initialing a linkedList and adding the CoffeeDrink as my Data type
            while (line != null) {
                lineSplit = line.split(";");//Splinting of the line in order to get each item out.
                coffeeName = lineSplit[0];//Assigning the coffee 1st item coffee name to the variable coffeeName
                costToMake = Double.parseDouble(lineSplit[1]);//parsing and assigning the 2nd item cost to make to variable costToMake
                price = Double.parseDouble(lineSplit[2]);////Assigning the third item price to the variable price
                myShop.add(new CofeeDrink(coffeeName, costToMake, price));//Adding my CoffeeDrink Object to my LinkList Object

                line = read.readLine();
            }

        read.close();

            saleReport = new FileWriter("SalesReport");//Inititalization of the saleReport File
        for(CofeeDrink ob: myShop){// Accessing my object from my linkLinked object and getting values of each item.
            String nameOfCoffee = ob.getCoffeeName();
            double costToMakeCoffee = ob.getCostToMake();
            double priceCharge = ob.getPriceTomake();
            int totalItemSold = ob.amountSold(nameOfCoffee);
            double toMakeExp = ob.expenses(totalItemSold);
            double toChargeRev = ob.revenue(totalItemSold);
            double profit = ob.profit(toChargeRev,toMakeExp);
            totalExpenses += toMakeExp;
            totalRevenue +=toChargeRev;
            totalProfit +=profit;
    //Writing to the salesReport file the necessary information that is needed to be written to the file.
            saleReport.write(String.format("%s: Sold %d, Expenses: $%.2f, Revenue: $%.2f, Profit: $%.2f%n%n", nameOfCoffee,

                    totalItemSold, toMakeExp, toChargeRev, profit));
        }

            saleReport.write(String.format("Total: Expenses: $%.2f%nTotal Revenue: $%.2f%nTotal Profit: $%.2f%n",
                    totalExpenses, totalRevenue,totalProfit ));
            saleReport.close();


    }catch (IOException e){

    }

    }





}








