package net.plang.logistics.business.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_contractDetail")
public class ContractDetailTO extends BaseTO {

    private String contractDetailNo;
    private String contractNo;
    private String itemCode;
    private String itemName;
    private String unitOfContract;
    private String dueDateOfContract;
    private String contractAmount;
    private String unitPriceOfContract;
    private String sumPriceOfContract;
    private String mpsApplyStatus;
    private String deliveryStatus;
    private String description;
    private String deliveryRemain;
}
