package com.revature.eMarket.services;

import com.revature.eMarket.daos.CartDAO;
import com.revature.eMarket.daos.CartItemDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CartServiceTest {
    @Mock
    private CartDAO cartDAO;
    @Mock
    private CartItemDAO cartItemDAO;
    private CartService cartService;
    private CartItemService cartItemService;
    private UserService userService;
    private ProductService productService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);

        cartItemService = new CartItemService(cartItemDAO, productService);
        cartService = new CartService(cartDAO, cartItemService, userService);
    }

    //test asserts that a new cart is saved
    @Test
    public void testCreateCart() {
//        String user_id = "ad2a5623-16d0-4c36-a6b7-2f25792af676";
//
//        userService.findById(user_id);
//
//        verify(cartDAO, times(1)).save(any(Cart.class));
    }

    // testing for add
    @Test
    public void add() {
//        String user_id = "1";
//        String product_id = "1";
//        int count = 9;
//        Cart cart = new Cart("1", user_id, null);

//        cartDAO.save(cart);
//        //asserts will create cart if cart is empty
//        cartItemService.add(user_id, product_id, count);
//        verify(cartDAO, times(1)).save(any(Cart.class));
    }

    @Test
    public void findById() {
    }
}