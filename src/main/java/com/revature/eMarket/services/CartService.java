package com.revature.eMarket.services;

import com.revature.eMarket.daos.CartDAO;
import com.revature.eMarket.daos.CartItemDAO;
import com.revature.eMarket.models.Cart;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CartService {
    private final CartDAO cartDAO;
    private final CartItemDAO cartItemDAO;

    public void createCart(Cart cart) {
        cartDAO.createCart(cart);;
    }

    public Cart findCartByCardId(String cartId) {
        return cartDAO.findCartByCartId(cartId);
    }

    public Optional<Cart> findCartByUserId(String id) {
        return cartDAO.findByUserId(id);
    }
    public void deleteCart(String cartId){
        cartDAO.deleteCart(cartId);

    }

//    public void deleteCartItem(String cartItemId){
//        cartItemDAO.deleteCartItem(cartItemId);
//    }

    public void updateCart(Cart cart){
        cartDAO.updateCart(cart);
    }


}
