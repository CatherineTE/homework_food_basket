package com.catherine_te.homework_food_basket;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        Purchase[] purchases = new Purchase[5];     //массив для покупок

        int j = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Введите наименование товара, цену и его количество:");
            String userInput = scanner.nextLine();     // ввод покупок из консоли

            if (userInput.equals("Q")) {
                System.out.println("Выход из консоли!");
                break;
            }

            String[] userInputParts = userInput.split( " ");

            String nameProduct = userInputParts[0];
            double cost = Double.parseDouble(userInputParts[1]);
            int amount = Integer.parseInt(userInputParts[2]);

            System.out.println("Вы ввели покупку №" + (i+1) + " - наименование: " + nameProduct + ", цена: " + cost + ", количество: " + amount );

            Product product = new Product(nameProduct, cost);
            Purchase purchase = new Purchase(product, amount);

            purchases [i] = purchase;
            j++;
        }
        Purchase[] totalPurchases = new Purchase[j];     // массив итоговых покупок
        System.arraycopy(purchases, 0, totalPurchases, 0, totalPurchases.length);

        double totalCost = 0;
        for (int i = 0; i < totalPurchases.length; i++) {
            double cost = totalPurchases[i].amount * totalPurchases[i].product.cost;
            totalCost += cost;
        }
        System.out.println("Общая стоимость покупки: " + totalCost);

    }
}
