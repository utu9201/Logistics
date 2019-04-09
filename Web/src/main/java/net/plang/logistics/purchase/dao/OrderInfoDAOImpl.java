package net.plang.logistics.purchase.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.purchase.to.OrderInfoTO;

public class OrderInfoDAOImpl extends IbatisSupportDAO implements OrderInfoDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderInfoTO> selectOrderInfoList() {
        return (List<OrderInfoTO>) getSqlMapClientTemplate().queryForList("orderInfo.selectOrderInfoList");
    }

    @Override
    public void insertOrderInfo(OrderInfoTO orderInfoTO) {

        getSqlMapClientTemplate().insert("orderInfo.insertOrderInfo", orderInfoTO);

    }

    @Override
    public void updateOrderInfo(OrderInfoTO orderInfoTO) {
        getSqlMapClientTemplate().update("orderInfo.updateOrderInfo", orderInfoTO);
    }
}
