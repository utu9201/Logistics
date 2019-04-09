package net.plang.logistics.purchase.dao;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.purchase.to.OrderGatheringTO;

import java.util.List;

public class OrderGatheringDAOImpl extends IbatisSupportDAO implements OrderGatheringDAO {
    @Override
    public void insertOrderGathering(OrderGatheringTO orderGatheringTO) {
        getSqlMapClientTemplate().insert("orderGathering.insertOrderGathering",
                orderGatheringTO);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderGatheringTO> selectOrderGatheringList() {

        return (List<OrderGatheringTO>) getSqlMapClientTemplate().queryForList("orderGathering.selectOrderGatheringList");
    }

    @Override
    public void updateOrderGathering(OrderGatheringTO orderGatheringTO) {
        //null에서 Y로만 바뀌게 만들어져있습니다.
        //y에서 null로 바꾸는건 프로시져에서 만들겁니다
        getSqlMapClientTemplate().update("orderGathering.updateOrderGatheringList"
                , orderGatheringTO);
    }

    @Override
    public String selectOrderGatheringNo() {
        return (String) getSqlMapClientTemplate().queryForObject("orderGathering.selectOrderGatheringNo");
    }
}
