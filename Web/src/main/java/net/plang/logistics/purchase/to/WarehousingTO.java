package net.plang.logistics.purchase.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_warehousing")
public class WarehousingTO extends BaseTO {

    private String itemCode;
    private String orderNo;
    private String itemName;
    private String orderAmount;
    private String warehousingAmount;
    private String unitWarehousing;
    private String customer;
    private String description;
    private String warehousingDate;
    private String warehousingNo;
}
