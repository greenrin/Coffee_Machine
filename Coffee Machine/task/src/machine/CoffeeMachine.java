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
        printState();
        System.out.println();
        System.out.println("Write action (buy, fill, take):");
        String action = in.nextLine();
        if (action.equals("buy")) {
            buy();
        }
        if (action.equals("fill")) {
            fill();
        }
        if (action.equals("take")) {
            take();
        }
        System.out.println();
        printState();

    }
    static void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water+" ml of water");
        System.out.println(milk+" ml of milk");
        System.out.println(coffee+" g of coffee beans");
        System.out.println(cups+" disposable cups");
        System.out.println("$" + money + " of money");
    }

    static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        Scanner in = new Scanner(System.in);
        int type = in.nextInt();
        switch (type) {
            case 1:
                water -= 250;
                coffee -= 16;
                money += 4;
                break;
            case 2:
                water -= 350;
                milk -= 75;
                coffee -= 20;
                money += 7;
                break;
            case 3:
                water -= 200;
                milk -= 100;
                coffee -= 12;
                money += 6;
                break;
        }
        cups--;
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
