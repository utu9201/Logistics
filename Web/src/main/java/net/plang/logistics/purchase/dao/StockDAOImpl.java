package net.plang.logistics.purchase.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.purchase.to.StockTO;

public class StockDAOImpl extends IbatisSupportDAO implements StockDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<StockTO> selectStockList() {
        return (List<StockTO>) getSqlMapClientTemplate().queryForList("stock.selectStockList");
    }

    @Override
    public void insertStock(StockTO stockTO) {
        getSqlMapClientTemplate().insert("stock.insertStock", stockTO);
    }

    @Override
    public void updateStock(StockTO stockTO) {
        getSqlMapClientTemplate().update("stock.updateStock", stockTO);
    }

    @Override
    public void deleteStock(StockTO stockTO) {
        getSqlMapClientTemplate().delete("stock.deleteStock", stockTO);
    }

}
