package net.plang.logistics.purchase.dao;

import java.util.HashMap;
import java.util.List;

import net.plang.logistics.purchase.to.OrderDetailTO;

public interface OrderDetailDAO {

    List<OrderDetailTO> selectOrderDetailList();

    void insertOrderDetail(OrderDetailTO orderDetailTO);

    void updateOrderDetail(OrderDetailTO orderDetailTO);

    HashMap<String, String> callCancelOrder(OrderDetailTO orderDetailTO, String empCode);
}
