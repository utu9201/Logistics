package net.plang.logistics.business.dao;

import java.util.List;

import net.plang.logistics.business.to.EstimateDetailTO;
public interface EstimateDetailDAO {

	List<EstimateDetailTO> selectEstimateDetailList();
	
	void insertEstimateDetail(EstimateDetailTO estimateDetailTO);
	
	void updateEstimateDetail(EstimateDetailTO estimateDetailTO);
	
	void deleteEstimateDetail(EstimateDetailTO estimateDetailTO);
}
