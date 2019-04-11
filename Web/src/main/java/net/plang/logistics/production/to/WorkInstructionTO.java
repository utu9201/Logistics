package net.plang.logistics.production.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_workInstruction")
@Alias("WorkInstructionTO")
public class WorkInstructionTO extends BaseTO {

    private String workInstructionNo;
    private String mrpGatheringNo;
    private String itemCode;
    private String itemName;
    private String instructionDate;
    private String unitOfWorkInstruction;
    private String workInstructionAmount;
    private String productionStatus;
    private String description;
    private String workInstructionStatus;
}
