package net.plang.logistics.business.dao;

import java.util.List;

import net.plang.logistics.business.to.EstimateTO;

public interface EstimateDAO {

    List<EstimateTO> selectEstimateList(String empCode);

    List<EstimateTO> selectEstimateDialog();

    void insertEstimate(EstimateTO estimateTO);

    void updateEstimate(EstimateTO estimateTO);

    void deleteEstimate(EstimateTO estimateTO);

    String selectEstimateNo(String personCodeInCharge);

}
