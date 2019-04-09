package net.plang.logistics.purchase.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_item")
public class ItemTO extends BaseTO {

    private String itemCode;
    private String itemName;
    private String itemGroupCode;
    private String itemClassification;
    private String unitOfStock;
    private String lossRate;
    private String leadTime;
    private String standardUnitPrice;
    private String description;
    private String lev;
}
