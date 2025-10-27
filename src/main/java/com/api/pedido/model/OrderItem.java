package com.api.pedido.model;

import com.api.pedido.model.pk.OrderItemPk;
import jakarta.persistence.EmbeddedId;

public class OrderItem {

    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();

    private Integer quantity;

    private Double price;

    public OrderItem(Product product, Order order, Integer quantity, Double price){
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Product getProduct(){
       return id.getProduct();
    }

    public void setProduct(){
        id.setProduct(getProduct());
    }

    public double subTotal(){
        return this.quantity * this.price;
    }
}
