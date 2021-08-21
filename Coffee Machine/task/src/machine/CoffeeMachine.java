package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");

            String action = in.nextLine();
            System.out.println();
            if (action.equals("buy")) {
                buy();
            }
            if (action.equals("fill")) {
                fill();
            }
            if (action.equals("take")) {
                take();
            }
            if (action.equals("remaining")) {
                remaining();
            }
            if (action.equals("exit")) {
                break;
            }
            System.out.println();
        }

    }
    static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water+" ml of water");
        System.out.println(milk+" ml of milk");
        System.out.println(coffee+" g of coffee beans");
        System.out.println(cups+" disposable cups");
        System.out.println("$" + money + " of money");
    }

    static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner in = new Scanner(System.in);
        String type = in.nextLine();
        int newWater = 0;
        int newMilk = 0;
        int newCoffee = 0;
        int newMoney = 0;
        int newCups = 0;
        switch (type) {
            case "1":
                newWater = water - 250;
                newMilk = milk;
                newCoffee = coffee - 16;
                newMoney = money + 4;
                break;
            case "2":
                newWater = water - 350;
                newMilk = milk - 75;
                newCoffee = coffee - 20;
                newMoney = money + 7;
                break;
            case "3":
                newWater = water - 200;
                newMilk = milk - 100;
                newCoffee = coffee - 12;
                newMoney = money + 6;
                break;
            case "back":
                return;
        }
        newCups = cups - 1;
        if (newWater < 0) {
            System.out.println("Sorry, not enough water!");
        }
        if (newMilk < 0) {
            System.out.println("Sorry, not enough milk!");
        }
        if (newCoffee < 0) {
            System.out.println("Sorry, not enough coffee beans!");
        }
        if (newCups < 0) {
            System.out.println("Sorry, not enough disposable cups!");
        }
        if (newWater >= 0 && newMilk >= 0 && newCoffee >= 0 && newCups >= 0) {
            System.out.println("I have enough resources, making you a coffee!");
            water = newWater;
            milk = newMilk;
            coffee = newCoffee;
            cups = newCups;
            money = newMoney;
        }
    }

    static void fill() {
        Scanner in = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        int newWater = in.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int newMilk = in.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int newCoffee = in.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int newCups = in.nextInt();

        water += newWater;
        milk += newMilk;
        coffee += newCoffee;
        cups += newCups;
    }

    static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }


}
