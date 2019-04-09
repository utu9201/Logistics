package net.plang.logistics.purchase.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_stock")
public class StockTO extends BaseTO {

    private String warehouseCode;
    private String itemCode;
    private String deliveryNo;
    private String productionResultNo;
    private String inputItemNo;
    private String itemName;
    private String unitOfStock;
    private String safetyAllowanceAmount;
    private String stockAmount;
    private String description;
}
