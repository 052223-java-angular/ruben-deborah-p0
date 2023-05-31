package com.revature.eMarket.services;

import com.revature.eMarket.daos.CartDAO;
import com.revature.eMarket.models.Cart;
import com.revature.eMarket.models.Product;
import com.revature.eMarket.models.User;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class CartService {
    private final CartDAO cartDAO;
    private final CartItemService cartItemService;
    private final UserService userService;


    // creates a cart when user registers
    public void createCart(String user_id){
        Optional<User> userOpt = userService.findById(user_id);
        if(userOpt.isEmpty()){
            System.out.println("No user found!");
        }
        Cart cart = new Cart(userOpt.get().getId());
        cartDAO.save(cart);
    }
    // adds cart item to cart
    public void add(String product_id, int count, Cart cart, String user_id) {
        Optional<Cart> cartOpt = cartDAO.findByUserId(user_id);
        if(cartOpt.isEmpty()){
            createCart(user_id);
        }
        cartItemService.add(product_id, count, cartOpt.get());
    }

    // query for existing cart, for use with cart items
    public Optional<Cart> findById(String user_id) {
        Optional<Cart> cart = cartDAO.findById(user_id);
        return cart;
    }

}
