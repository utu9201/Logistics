package net.plang.logistics.business.dao;

import java.util.HashMap;
import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.business.to.CompleteDeliveryResultTO;
import net.plang.logistics.business.to.DeliveryResultTO;

public class DeliveryResultDAOImpl extends IbatisSupportDAO implements DeliveryResultDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<DeliveryResultTO> selectDeliveryResultList() {
        return (List<DeliveryResultTO>) getSqlMapClientTemplate().queryForList("deliveryResult.selectDeliveryResultList");
    }

    @Override
    public void insertDeliveryResult(DeliveryResultTO selectDeliveryTO) {

        getSqlMapClientTemplate().insert("deliveryResult.insertDeliveryResult", selectDeliveryTO);

    }

    @Override
    public void updateDeliveryResult(DeliveryResultTO selectDeliveryTO) {

    }

    @Override
    public void callRegistDeliveryResult(String contractDetailNo, String deliveryAmount, String description) {
        HashMap<String, Object> param = new HashMap<>();
//		HashMap<String, String> resultMap = new HashMap<>();
        param.put("contractDetailNo", contractDetailNo);
        param.put("deliveryAmount", deliveryAmount);
        param.put("description", description);
        getSqlMapClientTemplate().queryForObject(
                "deliveryResult.callRegistDeliveryResult", param);
        System.out.println("여기는 DAO입니다 : " + param.get("errorCode"));
        System.out.println(param.get("errorMsg"));
        //		resultMap.put("errorCode",param.get("errorCode"));
        //		resultMap.put("errorMsg",param.get("errorMsg"));
    }

    @Override
    public List<CompleteDeliveryResultTO> selectCompleteDeliveryResultList() {
        return (List<CompleteDeliveryResultTO>) getSqlMapClientTemplate().queryForList("deliveryResult.selectCompleteDeliveryResultList");

    }

}
