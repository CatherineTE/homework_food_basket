package com.catherine_te.homework_food_basket;

public class Purchase {
    private Product product;
    private int amount;

    public Purchase(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }
}
