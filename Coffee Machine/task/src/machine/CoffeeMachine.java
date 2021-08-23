package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Machine machine = new Machine();

        while (true) {
            machine.prompt();
            String string = in.nextLine();
            if (!machine.input(string)) {
                break;
            }
        }
    }
}
