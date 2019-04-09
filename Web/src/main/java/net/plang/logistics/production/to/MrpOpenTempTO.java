package net.plang.logistics.production.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_mrpOpenTemp")
public class MrpOpenTempTO extends BaseTO {

    private String mpsNo;
    private String bomNo;
    private String itemClassification;
    private String itemCode;
    private String itemName;
    private String unitOfMrp;
    private String planAmount;
    private String orderDate;
    private String requiredDate;
    private String totalLossRate;
    private String caculatedAmount;
    private String requiredAmount;
}
