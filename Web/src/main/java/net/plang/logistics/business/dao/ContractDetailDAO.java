package net.plang.logistics.business.dao;

import java.util.List;

import net.plang.logistics.business.to.ContractDetailTO;

public interface ContractDetailDAO {

    List<ContractDetailTO> selectContractDetailList();

    List<ContractDetailTO> selectRangedContractDetailList(String fromDate, String toDate);

    void insertContractDetail(ContractDetailTO contractDetailTO);

    void updateContractDetail(ContractDetailTO contractDetailTO);

    void deleteContractDetail(ContractDetailTO contractDetailTO);
}
