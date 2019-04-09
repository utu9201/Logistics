package net.plang.logistics.production.dao;

import java.util.List;
import java.util.Map;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.production.to.MaterialCheckTempTO;
import net.plang.logistics.production.to.WorkInstructionTO;

public class WorkInstructionDAOImpl extends IbatisSupportDAO implements WorkInstructionDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<WorkInstructionTO> selectWorkInstructionList() {
        return (List<WorkInstructionTO>) getSqlMapClientTemplate().queryForList("workInstruction.selectWorkInstructionList");
    }

    @Override
    public void insertWorkInstruction(WorkInstructionTO workInstructionTO) {
        getSqlMapClientTemplate().insert("workInstruction.insertWorkInstruction", workInstructionTO);
    }

    @Override
    public void updateWorkInstruction(WorkInstructionTO workInstructionTO) {
        getSqlMapClientTemplate().update("workInstruction.updateWorkInstruction", workInstructionTO);
    }

    @Override
    public void deleteWorkInstruction(WorkInstructionTO workInstructionTO) {
        getSqlMapClientTemplate().delete("workInstruction.deleteWorkInstruction", workInstructionTO);
    }

    //안씁니다
    @Override
    public List<MaterialCheckTempTO> materialCheckTempList(Map<String, Object> parameters) {
        return (List<MaterialCheckTempTO>) getSqlMapClientTemplate().queryForList("workInstruction.materialCheckTempList");

    }

}
