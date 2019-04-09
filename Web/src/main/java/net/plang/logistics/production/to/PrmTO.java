package net.plang.logistics.production.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_prm")
public class PrmTO extends BaseTO {

    private String productionResultNo;
    private String workInstructionNo;
    private String productionDate;
    private String productionAmount;
    private String itemCode;
    private String itemName;
    private String unitOfProductionResult;
    private String description;
}
