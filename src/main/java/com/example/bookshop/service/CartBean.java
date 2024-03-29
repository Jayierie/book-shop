package com.example.bookshop.service;

import com.example.bookshop.dto.CartItem;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;
import java.util.stream.Collectors;

@Component
@SessionScope
public class CartBean {
    private Set<CartItem> cartItems = new LinkedHashSet<>();

    public void addCartItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public Integer cartSize() {
        return cartItems.size();
    }

    public Set<CartItem> getCartItems() {
        return this.cartItems;
    }
    public void deleteCartItem(int id,String isbn) {
        this.cartItems = this.cartItems.stream()
                .filter(c->c.getId() != id && c.getIsbn() != isbn)
                .collect(Collectors.toSet());
    }

    public void clearCart() {
        cartItems.clear();
    }
}
