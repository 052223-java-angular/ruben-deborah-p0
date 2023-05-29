package com.revature.eMarket.services;

import com.revature.eMarket.daos.CartDAO;
import com.revature.eMarket.daos.CartItemDAO;
import com.revature.eMarket.models.Cart;
import lombok.AllArgsConstructor;

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
    public Cart findCartByUserId(String userId){
        // found cart
        Cart cartExist = cartDAO.findCartByUserId(userId);
        return cartExist;
    }



    public void deleteCart(String cartId){
        cartDAO.deleteCart(cartId);
    }

    public void deleteCartItem(String cartItemId){
        cartItemDAO.deleteCartItem(cartItemId);
    }

    public void updateCart(Cart cart){
        cartDAO.updateCart(cart);
    }


}
