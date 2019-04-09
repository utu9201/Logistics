package net.plang.logistics.purchase.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.purchase.to.WarehousingTO;

public class WarehousingDAOImpl extends IbatisSupportDAO implements WarehousingDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<WarehousingTO> selectWarehousingList() {
        return (List<WarehousingTO>) getSqlMapClientTemplate().queryForList("warehousing.selectWarehousingList");
    }

    @Override
    public void insertWarehousing(WarehousingTO warehousingTO) {
        getSqlMapClientTemplate().insert("warehousing.insertWarehousing", warehousingTO);
    }

    @Override
    public void updateWarehousing(WarehousingTO warehousingTO) {
        getSqlMapClientTemplate().update("warehousing.updateWarehousing", warehousingTO);
    }

}
