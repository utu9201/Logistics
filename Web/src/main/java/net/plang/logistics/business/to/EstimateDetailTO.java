package net.plang.logistics.business.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_estimateDetail")
public class EstimateDetailTO extends BaseTO {

    private String estimateDetailNo;
    private String estimateNo;
    private String itemCode;
    private String itemName;
    private String unitOfEstimate;
    private String dueDateOfEstimate;
    private String estimateAmount;
    private String unitPriceOfEstimate;
    private String sumPriceOfEstimate;
    private String description;
}
