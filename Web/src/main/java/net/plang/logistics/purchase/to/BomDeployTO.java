package net.plang.logistics.purchase.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_bomDeploy")
@Alias("BomDeployTO")
public class BomDeployTO extends BaseTO {

    private String itemCode;
    private String parentItemCode;
    private String itemName;
    private String itemClassification;
    private String leadTime;
    private String lossRate;
    private String netAmount;
    private String standardUnitPrice;
    private String parentItemName;
}
