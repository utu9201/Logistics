package net.plang.logistics.production.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_mrpGathering")
public class MrpGatheringTO extends BaseTO {

    private String mrpGatheringNo;
    private String orderOrProductionStatus;
    private String itemCode;
    private String itemName;
    private String unitOfMrpGathering;
    private String necessaryAmount;
    private String dueDate;
    private String claimDate;
    private String onGoingProcessStatus;
}
