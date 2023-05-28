package com.revature.eMarket.services;

import com.revature.eMarket.daos.CartItemDAO;
import com.revature.eMarket.models.CartItems;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CartItemService {
    private final CartItemDAO cartItemDAO;

    public List<CartItems> getCartItemByCartId(String userId) {

    }
}
