package com.revature.eMarket.services;

import com.revature.eMarket.daos.CartDAO;
import com.revature.eMarket.daos.CartItemDAO;
import com.revature.eMarket.models.CartItems;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CartItemService {
    private final CartDAO cartDAO;
    private final CartItemDAO cartItemDAO;
    public List<CartItems> findAllCartItemsByCartId(String cartId){
        List<CartItems> cartItems = cartItemDAO.findAllCartItemsByCardId(cartId);
        return cartItems;
    }

    public void createCartItem(CartItems cartItems) {
        cartItemDAO.createCartItem(cartItems);
    }

    public void deleteCartItem(String cartItemId){
        cartItemDAO.deleteCartItem(cartItemId);
    }

    public void updateCartItem(CartItems cartItems){
        cartItemDAO.updateCartItem(cartItems);
    }

//    private boolean isValidNumber(String possibleNum) {
//        if (possibleNum.length() == 0 || !Pattern.matches("[0-9]+", possibleNum)) {
//            return false;
//        }
//        return true;
//    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
