package com.parasoft.bookstore;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Parasoft Jtest UTA: Test class for CartManager
 *
 * @author pteodor
 * @see CartManager
 */
public class CartManagerTest {
    /**
     * Parasoft Jtest UTA: Test for getItem()
     *
     * @author pteodor
     * @see CartManager#getItem()
     */
    @Test
    public void testGetItem() throws Throwable {
        // Given
        CartManager underTest = new CartManager();

        // When
        List<Order> result = underTest.getItem();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.size());
        // assertTrue(result.contains(null));
    }

    /**
     * Parasoft Jtest UTA: Test for getCartId()
     *
     * @author pteodor
     * @see CartManager#getCartId()
     */
    @Test
    public void testGetCartId() throws Throwable {
        // Given
        CartManager underTest = new CartManager();

        // When
        int result = underTest.getCartId();

        // Then
        // assertEquals(0, result);
    }
}