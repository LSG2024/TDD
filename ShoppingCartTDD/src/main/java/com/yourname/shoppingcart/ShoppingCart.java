package com.yourname.shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addItem(String item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public void removeItem(String item) {
        if (!items.containsKey(item)) {
            throw new IllegalArgumentException("Item not found in cart.");
        }
        items.remove(item);
    }

    public void changeQuantity(String item, int quantity) {
        if (!items.containsKey(item)) {
            throw new IllegalArgumentException("Item not found in cart.");
        }
        if (quantity <= 0) {
            removeItem(item);
        } else {
            items.put(item, quantity);
        }
    }

    public void dropCart() {
        items.clear();
    }

    public boolean checkout() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot checkout an empty cart.");
        }
        return true;
    }

    public Map<String, Integer> getItems() {
        return items;
    }
}
