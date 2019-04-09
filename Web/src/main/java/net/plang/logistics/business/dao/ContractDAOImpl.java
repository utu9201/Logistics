package net.plang.logistics.business.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.business.to.ContractTO;

public class ContractDAOImpl extends IbatisSupportDAO implements ContractDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<ContractTO> selectContractList() {
        return (List<ContractTO>) getSqlMapClientTemplate().queryForList("contract.selectContractList");
    }

    @Override
    public void insertContract(ContractTO contractTO) {
        getSqlMapClientTemplate().insert("contract.insertContract", contractTO);
    }

    @Override
    public void updateContract(ContractTO contractTO) {
        getSqlMapClientTemplate().update("contract.updateContract", contractTO);
    }

    @Override
    public void deleteContract(ContractTO contractTO) {
        getSqlMapClientTemplate().delete("contract.deleteContract", contractTO);
    }

    @Override
    public String selectContractNo(String personCodeInCharge) {
        return (String) getSqlMapClientTemplate().
                queryForObject("contract.selectContractNo", personCodeInCharge);
    }

}
