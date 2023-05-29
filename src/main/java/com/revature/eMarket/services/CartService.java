package com.revature.eMarket.services;

import com.revature.eMarket.daos.CartDAO;
import com.revature.eMarket.models.Cart;
import com.revature.eMarket.models.Product;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class CartService {
    private final CartDAO cartDAO;
    private final CartItemService cartItemService;
    private final ProductService productService;


    public void add(String product_id, int count, Cart cart) {
        Optional<Product> productOpt = productService.getProduct(product_id);
        if(productOpt.isEmpty()){
            System.out.println("No product found");
        }

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
