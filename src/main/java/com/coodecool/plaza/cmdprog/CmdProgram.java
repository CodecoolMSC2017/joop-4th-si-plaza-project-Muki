package com.coodecool.plaza.cmdprog;

import com.coodecool.plaza.api.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CmdProgram {

    private List<Product> cart;
    private Scanner scan = new Scanner(System.in);
    SimpleDateFormat date = new SimpleDateFormat("mm-dd-yyyy");

    public CmdProgram(String[] args) {
    }

    public CmdProgram() {
        cart = new ArrayList<Product>();
    }

    public void run() {
        PlazaImpl myPlaza;
        String owner;
        label:
        while (true) {
            System.out.println("There's no plaza.\nPress(1) to create one\nPress(2) to exit");
            String choice = scan.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter the owner of the Plaza:");
                    owner = scan.nextLine();
                    System.out.println("Enter the name of the Plaza:");
                    String plazaName = scan.nextLine();
                    myPlaza = new PlazaImpl(owner, plazaName);
                    runPlazaMenu(myPlaza);
                    break label;
                case "2":
                    System.out.println("See you next time.");
                    System.exit(0);
                default:
                    System.out.println("Try (1) or (2)!");
                    break;
            }
        }
    }

    public void runPlazaMenu(PlazaImpl myPlaza) {
        while (true) {
            int number;
            ShopImpl myShop;
            String tempShop;
            String tempOwner;

            while (true) {
                System.out.println("\nWelcome to " + myPlaza.getOwner() + "'s " + myPlaza.getName() + "!");
                System.out.println("Press\n" + "1) to list all shops.\n" +
                        "2) to add a new shop.\n" +
                        "3) to remove an existing shop.\n" +
                        "4) enter a shop by name.\n" +
                        "5) to open the plaza.\n" +
                        "6) to close the plaza.\n" +
                        "7) to check if the plaza is open or not.\n" +
                        "0) leave plaza.");
                String option = scan.nextLine();
                try {
                    number = Integer.parseInt(option);
                    break;
                } catch (NumberFormatException numex) {
                    System.out.println("Only numbers!");
                }
            }
            try {
                switch (number) {
                    case 1:
                        for (Shop shop : myPlaza.getShops()) {
                            System.out.println(shop.getOwner() + "'s " + shop.getName());
                        }
                        break;
                    case 2:
                        System.out.println("Enter the owner of the shop");
                        tempOwner = scan.nextLine();
                        System.out.println("Enter the name of the shop");
                        tempShop = scan.nextLine();
                        try {
                            myPlaza.addShop(new ShopImpl(tempShop, tempOwner));
                        } catch (ShopAlreadyExistsException sae) {
                            System.out.println(sae.getMessage());
                        }
                        break;
                    case 3:
                        for (Shop shop : myPlaza.getShops()) {
                            System.out.println(shop.getName());
                        }
                        System.out.println("Which shop do you want to remove?");
                        tempShop = scan.nextLine();
                        try {
                            myPlaza.removeShop(myPlaza.findShopByName(tempShop));
                            System.out.println(tempShop + " is removed from the plaza");
                        } catch (NoSuchShopException nsse) {
                            System.out.println(nsse.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("Which shop do you want to go in?");
                        tempShop = scan.nextLine();
                        try {
                            myShop = (ShopImpl) myPlaza.findShopByName(tempShop);
                            break;
                        } catch (NoSuchShopException nsse) {
                            System.out.println(nsse.getMessage());
                        }
                        break;
                    case 5:
                        myPlaza.open();
                        System.out.println("You have opened the Plaza\n");
                        break;
                    case 6:
                        myPlaza.close();
                        System.out.println("You have closed the Plaza\n");
                        break;
                    case 7:
                        if (myPlaza.isOpen()) {
                            System.out.println(myPlaza.getName() + " is open");
                        } else {
                            System.out.println(myPlaza.getName() + " is closed");
                        }
                        break;
                    case 0:
                        System.out.println("Goodbye");
                        System.exit(0);

                }
            } catch (PlazaIsClosedException pice) {
                System.out.println(pice.getMessage());
            }
        }
    }
}
