package net.plang.logistics.purchase.dao;

import net.plang.logistics.purchase.to.OrderGatheringTO;

import java.util.List;


public interface OrderGatheringDAO {

    void insertOrderGathering(OrderGatheringTO orderGatheringTO);

    List<OrderGatheringTO> selectOrderGatheringList();

    void updateOrderGathering(OrderGatheringTO orderGatheringTO);

    String selectOrderGatheringNo();
}
