package net.plang.logistics.purchase.dao;

import java.util.List;

import net.plang.logistics.purchase.to.OrderInfoTO;

public interface OrderInfoDAO {

    List<OrderInfoTO> selectOrderInfoList();

    void insertOrderInfo(OrderInfoTO orderInfoTO);

    void updateOrderInfo(OrderInfoTO orderInfoTO);

}
