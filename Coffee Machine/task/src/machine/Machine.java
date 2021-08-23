package machine;

public class Machine {

    enum State {
        MAIN,
        BUY,
        FILL_WATER,
        FILL_MILK,
        FILL_COFFEE,
        FILL_CUPS
    }
    State state = State.MAIN;
    int water = 400;
    int milk = 540;
    int coffee = 120;
    int cups = 9;
    int money = 550;

    public boolean input(String action) {
        boolean result = true;
        switch (state) {
            case MAIN:
                //System.out.println();
                result = main(action);
                break;
            case BUY:
                buy(action);
                break;
            case FILL_WATER:
                fillWater(action);
                break;
            case FILL_MILK:
                fillMilk(action);
                break;
            case FILL_COFFEE:
                fillCoffee(action);
                break;
            case FILL_CUPS:
                fillCups(action);
                break;
            }
        //System.out.println();
        return result;
    }


    void fillWater(String action) {
        water += Integer.parseInt(action);
        state = State.FILL_MILK;
    }
    void fillMilk(String action) {
        milk += Integer.parseInt(action);
        state = State.FILL_COFFEE;
    }
    void fillCoffee(String action) {
        coffee += Integer.parseInt(action);
        state = State.FILL_CUPS;
    }
    void fillCups(String action) {
        cups += Integer.parseInt(action);
        state = State.MAIN;
    }
    boolean main(String action) {

        if (action.equals("buy")) {
            state = State.BUY;
        }
        if (action.equals("fill")) {
            state = State.FILL_WATER;
        }
        if (action.equals("take")) {
            take();
        }
        if (action.equals("remaining")) {
            remaining();
        }
        return !action.equals("exit");
    }


    public void prompt() {
        if (state == State.MAIN) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
        }
        if (state == State.BUY) {
            System.out.println();
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        }
        if (state == State.FILL_WATER) {
            System.out.println();
            System.out.println("Write how many ml of water you want to add:");
        }
        if (state == State.FILL_MILK) {
            System.out.println("Write how many ml of milk you want to add:");
        }
        if (state == State.FILL_COFFEE) {
            System.out.println("Write how many grams of coffee beans you want to add:");
        }
        if (state == State.FILL_CUPS) {
            System.out.println("Write how many disposable cups of coffee you want to add:");
        }
    }


    void remaining() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water+" ml of water");
        System.out.println(milk+" ml of milk");
        System.out.println(coffee+" g of coffee beans");
        System.out.println(cups+" disposable cups");
        System.out.println("$" + money + " of money");
    }

    void buy(String type) {
        int newWater = 0;
        int newMilk = 0;
        int newCoffee = 0;
        int newMoney = 0;
        int newCups;
        state = State.MAIN;
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

    void take() {
        System.out.println();
        System.out.println("I gave you $" + money);
        money = 0;
    }

}
