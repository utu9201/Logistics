package net.plang.logistics.production.dao;

import java.util.List;
import java.util.Map;

import net.plang.logistics.production.to.MaterialCheckTempTO;
import net.plang.logistics.production.to.WorkInstructionTO;

public interface WorkInstructionDAO {

    List<WorkInstructionTO> selectWorkInstructionList();

    void insertWorkInstruction(WorkInstructionTO workInstructionTO);

    void updateWorkInstruction(WorkInstructionTO workInstructionTO);

    void deleteWorkInstruction(WorkInstructionTO workInstructionTO);

    List<MaterialCheckTempTO> materialCheckTempList(Map<String, Object> parameters);
}
