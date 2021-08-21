package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = in.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = in.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = in.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = in.nextInt();
        int maxCupsWater = water / 200;
        int maxCupsMilk = milk / 50;
        int maxCupsCoffee = coffee / 15;
        int maxCups = Math.min(Math.min(maxCupsWater, maxCupsMilk), maxCupsCoffee);
        if (maxCups == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        }
        else if (maxCups > cups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (maxCups - cups) + " more than that)");
        }
        else {
            System.out.println("No, I can make only "+ maxCups +" cup(s) of coffee");
        }
    }
}
