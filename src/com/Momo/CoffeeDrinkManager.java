package com.Momo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Scanner;

public class CoffeeDrinkManager {



    public static void main(String[] args) {
        FileWriter saleReport;
        String[] lineSplit;
        String coffeeName;
        double priceToMake, costToMake,  totalRevenue=0, totalExpenses=0, totalProfit=0;


        try {
            BufferedReader read = new BufferedReader(new FileReader("coffee.txt"));
            String line = read.readLine();
            LinkedList<CofeeDrink> myShop = new LinkedList<>();
            while (line != null) {
                lineSplit = line.split(";");
                coffeeName = lineSplit[0];
                costToMake = Double.parseDouble(lineSplit[1]);
                priceToMake = Double.parseDouble(lineSplit[2]);
                myShop.add(new CofeeDrink(coffeeName, costToMake, priceToMake));

                line = read.readLine();
            }

        read.close();

            saleReport = new FileWriter("SalesReport");
        for(CofeeDrink ob: myShop){
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
            System.out.println(profit);
           //System.out.println(totalExpenses);
            System.out.println( toMakeExp);
           //System.out.println(toChargeRev);


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









       /* Scanner input = new Scanner(System.in);
        boolean istrue = true;
        String teaName;
        Double priceOfTea;
        int numberItem=0;
        double totalProfit =0.0;
        double revenueTotal =0.0;
        double expensesTotal = 0.0;
        double total1 =0.0;
        double total2 =0.0;


        String[] lineSeperate;
        Double cost;

        try {
            //Reading of the coffee file by the reader
            FileReader readThisFile = new FileReader("coffee.txt");
            // reading of the filereader file by the bufferReader
            BufferedReader report = new BufferedReader(readThisFile);
            String line = report.readLine();
            FileWriter mySalesReport = new FileWriter("saleReport.txt");

            while (line != null) {
                //Assigning the variable for the coffee.txt
                lineSeperate = line.split(";");
                teaName = lineSeperate[0];
                String line2 = lineSeperate[1];
                cost = Double.parseDouble(line2);
                String line3 = lineSeperate[2];
                priceOfTea = Double.parseDouble(line3);

                do {
                    try {
                        System.out.println("How many " + teaName + " did you today?");

                        numberItem = input.nextInt();


                        istrue = false;

                    } catch (InputMismatchException e) {
                        input.nextLine();
                        System.out.println("Please enter right number");
                        istrue = true;
                    }
                    catch (NoSuchElementException e){
                        System.out.println(" Please enter positive integers");
                    }
                }while (istrue);
                mySalesReport.write(String.format("%s sold: %d, Expenses: $%.2f, Revenue: $%.2f, Profit: $%.2f%n", teaName,
                        numberItem, expenses(cost, numberItem),  totalRevnue(priceOfTea, numberItem ), totalRevnue(priceOfTea, numberItem)-expenses(cost,numberItem) ));
                total1 = totalRevnue(priceOfTea, numberItem);
                revenueTotal = revenueTotal+total1;
                total2  = expenses(cost, numberItem);
                expensesTotal = expensesTotal+total2;
                totalProfit = revenueTotal-expensesTotal;
                line = report.readLine();
            }
            mySalesReport.write(String.format("Total Revenue: $%.2f%n", revenueTotal ));
            mySalesReport.write(String.format("Total Expenses: $%.2f%n", expensesTotal));
            mySalesReport.write(String.format("Total Profit:  $%.2f%n",  totalProfit));

            mySalesReport.close();
            report.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
    //A method that calculates and returns the expenses
    public static double expenses(double cost, int typeSold ){
        double totalExpeses = cost*typeSold;
        return totalExpeses;
    }
    //A method that calculate and returns the total revenue.
    public static  double totalRevnue(Double price, int amountSold){
        double totalRev = price*amountSold;
        return totalRev;


    }*/



