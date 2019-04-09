package net.plang.logistics.purchase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.purchase.to.BomDeployTO;
import net.plang.logistics.purchase.to.BomTO;

public class BomDAOImpl extends IbatisSupportDAO implements BomDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<BomTO> selectBomList() {
        return (List<BomTO>) getSqlMapClientTemplate().queryForList("bom.selectBomList");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BomDeployTO> selectBomDeployList(String itemCode, String deployCondition) {

        Map<String, Object> map = new HashMap<>();
        map.put("itemCode", itemCode);
        map.put("deployCondition", deployCondition);

        return (List<BomDeployTO>) getSqlMapClientTemplate().queryForList("bom.selectBomDeployList2", map);
    }

}
