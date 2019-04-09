package net.plang.logistics.production.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_mrp")
public class MrpTO extends BaseTO {

    private String mrpNo;
    private String mpsNo;
    private String mrpGatheringNo;
    private String itemClassifcation;
    private String itemCode;
    private String itemName;
    private String unitOfMrp;
    private String requiredAmount;
    private String orderDate;
    private String requiredDate;
    private String mrpGatheringStatus;
}
