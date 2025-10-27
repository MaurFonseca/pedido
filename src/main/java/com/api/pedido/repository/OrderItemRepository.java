package com.api.pedido.repository;

import com.api.pedido.model.OrderItem;
import com.api.pedido.model.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}
