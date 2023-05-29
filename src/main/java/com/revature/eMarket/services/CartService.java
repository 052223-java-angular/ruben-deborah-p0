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
//    private final ProductService productService;
    private final UserService userService;


    public void createCart(String user_id){
        Optional<User> userOpt = userService.findById(user_id);
        if(userOpt.isEmpty()){
            System.out.println("No user found!");
        }
        Cart cart = new Cart(userOpt.get().getId());
        cartDAO.save(cart);
    }
    public void add(String product_id, int count, Cart cart, String user_id) {
        Optional<Cart> cartOpt = cartDAO.findByUserId(user_id);
        if(cartOpt.isEmpty()){
            createCart(user_id);
        }
        cartItemService.add(product_id, count, cartOpt.get());
    }
    public void remove(String item_id) {
        cartItemService.remove(item_id);
    }

    public void modify(String item, int amount) {
        cartItemService.modify(item, amount);
    }

    public Optional<Cart> getCartByUserId(String user_id) {
        Optional<Cart> cart = cartDAO.findByUserId(user_id);
        if(!cart.isEmpty()){
            cart.get().setItems(cartItemService.getCartItemByCartId(cart.get().getId()));
        }
        return cart;
    }
    public void clear(String id) {
        cartItemService.clearByCartId(id);
    }
}
