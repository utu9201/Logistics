package net.plang.logistics.purchase.dao;

import java.util.List;

import net.plang.logistics.purchase.to.StockTO;

public interface StockDAO {

    List<StockTO> selectStockList();

    void insertStock(StockTO stockTO);

    void updateStock(StockTO stockTO);

    void deleteStock(StockTO stockTO);

}
