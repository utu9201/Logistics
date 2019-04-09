package net.plang.logistics.business.dao;

import java.util.List;

import net.plang.logistics.business.to.ContractTO;

public interface ContractDAO {
    List<ContractTO> selectContractList();

    void insertContract(ContractTO contractTO);

    void updateContract(ContractTO contractTO);

    void deleteContract(ContractTO contractTO);

    String selectContractNo(String personCodeInCharge);
}
