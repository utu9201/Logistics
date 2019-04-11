package net.plang.logistics.business.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_completeDelivery")
@Alias("CompleteDeliveryResultTO")
public class CompleteDeliveryResultTO extends BaseTO {

    private String contractNo;
    private String contractDetailNo;
    private String customerCode;
    private String itemName;
    private String itemCode;
    private String contractAmount;
    private String unitPriceOfContract;
    private String mpsNo;
    private String rItemCode;
    private String rItemName;
    private String itemClassification;
    private String mpsPlanDate;
    private String workInstructionNo;
    private String mrpGatheringNo;
    private String deliveryNo;
    private String deliveryDate;
    private String deliveryAmount;
    private String dItemCode;
}
