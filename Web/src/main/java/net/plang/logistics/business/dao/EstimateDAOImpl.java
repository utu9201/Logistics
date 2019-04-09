package net.plang.logistics.business.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.business.to.EstimateTO;

public class EstimateDAOImpl extends IbatisSupportDAO implements EstimateDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<EstimateTO> selectEstimateList(String empCode) {
        return (List<EstimateTO>) getSqlMapClientTemplate().queryForList("estimate.selectEstimateList", empCode);
    }

    @Override
    public void insertEstimate(EstimateTO estimateTO) {

        getSqlMapClientTemplate().insert("estimate.insertEstimate", estimateTO);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<EstimateTO> selectEstimateDialog() {

        return (List<EstimateTO>) getSqlMapClientTemplate().queryForList("estimate.selectEstimateDialog");

    }

    @Override
    public void updateEstimate(EstimateTO estimateTO) {
        getSqlMapClientTemplate().update("estimate.updateEstimate", estimateTO);
    }

    public void deleteEstimate(EstimateTO estimateTO) {
        getSqlMapClientTemplate().delete("estimate.deleteEstimate", estimateTO);
    }

    @Override
    public String selectEstimateNo(String personCodeInCharge) {

        return (String) getSqlMapClientTemplate().
                queryForObject("estimate.selectEstimateNo", personCodeInCharge);

    }

}
