package com.revature.eMarket.services;

import com.revature.eMarket.daos.CartDAO;
import com.revature.eMarket.models.Cart;
import com.revature.eMarket.models.CartItems;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CartService {
    private final CartDAO cartDAO;
//    private final CartItemService cartItemService;
//    private final UserService userService;
    public List<CartItems> findAllCartItemsByCartId(String cartId){
        List<CartItems> cartItems = cartDAO.findAllCartItemsByCardId(cartId);
        return cartItems;
    }
//
//    public Optional<Cart> getCartByUserId(String user_id) {
//        Optional<Cart> cart = cartDAO.findByUserId(user_id);
//        if(!cart.isEmpty()){
//            cart.get().setItems(cartItemService.getCartItemByCartId(cart.get().getUser_id()));
//        }
//        return cart;
//    }

    public Cart findCartByCardId(String cartId) {
        return null;
    }

    public Optional<Cart> findCartByUserId(String id) {
        return cartDAO.findByUserId(id);
    }
}
