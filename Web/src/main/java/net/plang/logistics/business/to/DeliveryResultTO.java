package net.plang.logistics.business.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_deliveryResult")
@Alias("DeliveryResultTO")
public class DeliveryResultTO extends BaseTO {

    private String deliveryNo;
    private String contractDetailNo;
    private String warehouseCode;
    private String itemCode;
    private String itemName;
    private String unitOfDeliveryResult;
    private String deliveryDate;
    private String deliveryAmount;
    private String description;
    private String customerCode;
}
