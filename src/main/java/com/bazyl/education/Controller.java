package com.bazyl.education;

import com.bazyl.education.Model.Item;

import java.util.Scanner;

public class Controller {

    Item item;

    /**
     * main controller function
     */
    public void proccessUser() {
        Scanner sc = new Scanner(System.in);
        constructAndValidateItem(sc);
        View.printMessage(item.toString());
    }

    /**
     * construct Item entity if there is no exceptions
     *
     * @param sc
     */
    private void constructAndValidateItem(Scanner sc) {
        while (true) {
            try {
                item = new Item(getInput(sc, View.TYPE_INPUT), getInput(sc, View.PRICE_INPUT),
                        getInput(sc, View.PRODUCER_INPUT));
                return;
            } catch (IllegalArgumentException ex) {
                View.printMessage("Input correct values!");
            }
        }
    }


    /**
     * gets user input from console
     *
     * @param scanner
     * @param msg     dialog message
     * @return result of user input
     */
    private String getInput(Scanner scanner, String msg) {
        View.printMessage(msg);
        while (!scanner.hasNextLine()) {
            scanner.next();
        }
        return scanner.nextLine();
    }

}
