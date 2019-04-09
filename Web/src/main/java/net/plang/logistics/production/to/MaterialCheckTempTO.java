package net.plang.logistics.production.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_materialCheck")
public class MaterialCheckTempTO extends BaseTO {
    private String itemCode;
    private String itemName;
    private String stocktaking;
    private String safetyStocktaking;
    private String stockStatus;
    private String safetyStockStatus;
}
