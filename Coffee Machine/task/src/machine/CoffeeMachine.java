package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int n = in.nextInt();
        System.out.println("For " + n + " cups of coffee you will need:");
        System.out.println(200 * n + " ml of water");
        System.out.println(50 * n + " ml of milk");
        System.out.println(15 * n + " g of coffee beans");
    }
}
