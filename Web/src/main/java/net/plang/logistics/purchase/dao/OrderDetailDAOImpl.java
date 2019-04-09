package net.plang.logistics.purchase.dao;

import java.util.HashMap;
import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.purchase.to.OrderDetailTO;

public class OrderDetailDAOImpl extends IbatisSupportDAO implements OrderDetailDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderDetailTO> selectOrderDetailList() {
        return (List<OrderDetailTO>) getSqlMapClientTemplate().queryForList("orderDetail.selectOrderDetailList");
    }

    @Override
    public void insertOrderDetail(OrderDetailTO orderDetailTO) {

        getSqlMapClientTemplate().insert("orderDetail.insertOrderDetail", orderDetailTO);
    }

    @Override
    public void updateOrderDetail(OrderDetailTO orderDetailTO) {

        getSqlMapClientTemplate().update("orderDetail.updateOrderDetail", orderDetailTO);

    }

    @Override
    public HashMap<String, String> callCancelOrder(OrderDetailTO orderDetailTO, String empCode) {
        HashMap<String, Object> param = new HashMap<>();
        HashMap<String, String> result = new HashMap<>();
        param.put("orderDetailNo", orderDetailTO.getOrderDetailNo());
        param.put("orderNo", orderDetailTO.getOrderNo());
        param.put("orderGatheringNo", orderDetailTO.getOrderGatheringNo());
        param.put("empCode", empCode);
        getSqlMapClientTemplate().queryForObject(
                "orderDetail.callCancelOrder", param);
        result.put("errorCode", param.get("errorCode") + "");
        result.put("errorMsg", (String) param.get("errorMsg"));
        return result;
    }
}
