package com.revature.eMarket.services;


import com.revature.eMarket.daos.CartItemDAO;
import com.revature.eMarket.models.Cart;
import com.revature.eMarket.models.CartItem;
import com.revature.eMarket.models.Product;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CartItemService {
    private final CartItemDAO cartItemDAO;
    private final ProductService productService;


    public void add(String product_id, int count, Cart cart) {
        Optional<Product> productOpt = productService.getProd(product_id);
        if (productOpt.isEmpty()) {
            System.out.println("Product not found");
        }

        for(CartItem cartItem : cart.getItems()){
            if(cartItem.getProduct_id() == product_id){
                cartItemDAO.update(product_id, cartItem.getQuantity() + count);
                return;
            }
        }
        CartItem cartItem = new CartItem(productOpt.get().getName(), cart.getItems().size(), 9, cart.getUser_id(), productOpt.get().getId());
        cartItemDAO.save(cartItem);
    }


    // remove cart item from user cart
    public void remove(String item) {
        cartItemDAO.delete(item);
    }

    public List<CartItem> findAllByCart(String cart_id) {
        return cartItemDAO.findAllByCart(cart_id);
    }

    // inserts cart item
    public void insert(CartItem product) {
        cartItemDAO.save(product);
    }

    /*************************** Helper methods *****************************************/

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}