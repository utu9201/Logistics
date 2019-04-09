package net.plang.logistics.business.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.business.to.EstimateDetailTO;

public class EstimateDetailDAOImpl extends IbatisSupportDAO implements EstimateDetailDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<EstimateDetailTO> selectEstimateDetailList() {
        return (List<EstimateDetailTO>) getSqlMapClientTemplate().queryForList("estimateDetail.selectEstimateDetailList");
    }

    @Override
    public void insertEstimateDetail(EstimateDetailTO estimateDetailTO) {
        System.out.println(estimateDetailTO.getEstimateNo());
        getSqlMapClientTemplate().insert("estimateDetail.insertEstimateDetail", estimateDetailTO);
    }

    public void updateEstimateDetail(EstimateDetailTO estimateDetailTO) {

        System.out.println(estimateDetailTO.getEstimateNo());
        getSqlMapClientTemplate().update("estimateDetail.updateEstimateDetail", estimateDetailTO);
    }


    public void deleteEstimateDetail(EstimateDetailTO estimateDetailTO) {

        System.out.println(estimateDetailTO.getEstimateNo());
        getSqlMapClientTemplate().delete("estimateDetail.deleteEstimateDetail", estimateDetailTO);
    }

}
