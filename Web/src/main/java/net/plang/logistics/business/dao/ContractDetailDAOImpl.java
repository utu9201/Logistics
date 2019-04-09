package net.plang.logistics.business.dao;

import java.util.HashMap;
import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.business.to.ContractDetailTO;

public class ContractDetailDAOImpl extends IbatisSupportDAO implements ContractDetailDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<ContractDetailTO> selectContractDetailList() {
        return (List<ContractDetailTO>) getSqlMapClientTemplate().queryForList("contractDetail.selectContractDetailList");

    }

    @Override
    public void insertContractDetail(ContractDetailTO contractDetailTO) {
        getSqlMapClientTemplate().insert("contractDetail.insertContractDetail", contractDetailTO);
    }

    @Override
    public void updateContractDetail(ContractDetailTO contractDetailTO) {
        getSqlMapClientTemplate().update("contractDetail.updateContractDetail", contractDetailTO);
    }

    @Override
    public void deleteContractDetail(ContractDetailTO contractDetailTO) {
        getSqlMapClientTemplate().delete("contractDetail.deleteContractDetail", contractDetailTO);
    }

    @Override
    public List<ContractDetailTO> selectRangedContractDetailList(String fromDate, String toDate) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("fromDate", fromDate);
        map.put("toDate", toDate);
        return (List<ContractDetailTO>) getSqlMapClientTemplate().queryForList("contractDetail.selectRangedContractDetailList", map);
    }
}
