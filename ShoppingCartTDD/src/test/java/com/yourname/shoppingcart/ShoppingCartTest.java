package com.yourname.shoppingcart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void testAddItemSuccess() {
        cart.addItem("Apple", 2);
        assertEquals(2, cart.getItems().get("Apple"));
    }

    @Test
    void testAddItemFailure() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Apple", 0);
        });
        assertEquals("Quantity must be greater than zero.", exception.getMessage());
    }

    @Test
    void testRemoveItemSuccess() {
        cart.addItem("Banana", 3);
        cart.removeItem("Banana");
        assertFalse(cart.getItems().containsKey("Banana"));
    }

    @Test
    void testRemoveItemFailure() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.removeItem("Orange");
        });
        assertEquals("Item not found in cart.", exception.getMessage());
    }

    @Test
    void testChangeQuantitySuccess() {
        cart.addItem("Grapes", 5);
        cart.changeQuantity("Grapes", 3);
        assertEquals(3, cart.getItems().get("Grapes"));
    }

    @Test
    void testChangeQuantityFailure() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.changeQuantity("Pineapple", 2);
        });
        assertEquals("Item not found in cart.", exception.getMessage());
    }

    @Test
    void testDropCart() {
        cart.addItem("Milk", 2);
        cart.dropCart();
        assertTrue(cart.getItems().isEmpty());
    }

    @Test
    void testCheckoutSuccess() {
        cart.addItem("Bread", 1);
        assertTrue(cart.checkout());
    }

    @Test
    void testCheckoutFailure() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            cart.checkout();
        });
        assertEquals("Cannot checkout an empty cart.", exception.getMessage());
    }
}
