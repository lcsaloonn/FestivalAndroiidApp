package com.example.myapplication.Management;

import com.example.myapplication.Domain.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartManagement {
    public List<Cart> cartHoodieList = new ArrayList<>();
    public List<Cart> cartTicketList = new ArrayList<>();

    public CartManagement() {
    }

    //    public boolean add(Cart cart){
//        if(cartHoodieList.contains(cart)){
//            return false;
//        }
//        else {
//            cartHoodieList.add(cart);
//            return true;
//        }
//    }
//
//    public void remove (Cart cart){
//        if(cartHoodieList.contains(cart)){
//            cartHoodieList.remove(cart);
//        }
//    }
//
//    public List<Cart> getCartHoodieList() {
//        return cartHoodieList;
//    }
//    public void setCartHoodieList(List<Cart> cartHoodieList) {
//        this.cartHoodieList = cartHoodieList;
//    }
}
