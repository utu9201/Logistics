package net.plang.logistics.purchase.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.purchase.to.MaterialPaymentTO;

public class MaterialPaymentDAOImpl extends IbatisSupportDAO implements MaterialPaymentDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<MaterialPaymentTO> selectMaterialPaymentList() {
        return (List<MaterialPaymentTO>) getSqlMapClientTemplate().queryForList("materialPayment.selectMaterialPaymentList");
    }

    @Override
    public void insertMaterialPayment(MaterialPaymentTO materialPaymentTO) {
        getSqlMapClientTemplate().insert("materialPayment.insertMaterialPayment", materialPaymentTO);
    }

}
