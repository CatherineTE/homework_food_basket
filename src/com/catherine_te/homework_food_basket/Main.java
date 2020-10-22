package com.catherine_te.homework_food_basket;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int NUMBER_OF_PURCHASE = 5;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Purchase[] purchases = inputPurchases();

        //не очень понятно зачем отдельный массив
        Purchase[] totalPurchases = Arrays.copyOf(purchases, NUMBER_OF_PURCHASE);     // массив итоговых покупок

        double totalCost = getTotalCost(totalPurchases);

        System.out.println("Общая стоимость покупки: " + totalCost);

    }

    private static double getTotalCost(Purchase[] totalPurchases) {
        double totalCost = 0;
        for (Purchase totalPurchase : totalPurchases) {
            double cost = totalPurchase.getAmount() * totalPurchase.getProduct().getCost();
            totalCost += cost;
        }
        return totalCost;
    }

    private static Purchase[] inputPurchases() {
        Purchase[] purchases = new Purchase[NUMBER_OF_PURCHASE];     //массив для покупок

        for (int i = 0; i < NUMBER_OF_PURCHASE; i++) {
            System.out.println("Введите наименование товара, цену и его количество:");
            String userInput = scanner.nextLine();     // ввод покупок из консоли

            if (userInput.equals("Q")) {
                System.out.println("Выход из консоли!");
                break;
            }

            String[] userInputParts = userInput.split(" ");

            String nameProduct = userInputParts[0];
            double cost = Double.parseDouble(userInputParts[1]);
            int amount = Integer.parseInt(userInputParts[2]);

            System.out.println("Вы ввели покупку №" + (i + 1) + " - наименование: " + nameProduct + ", цена: " + cost + ", количество: " + amount);

            Product product = new Product(nameProduct, cost);
            Purchase purchase = new Purchase(product, amount);

            purchases[i] = purchase;
        }
        return purchases;
    }
}
