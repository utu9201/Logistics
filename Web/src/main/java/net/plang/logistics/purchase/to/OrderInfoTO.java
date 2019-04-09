package net.plang.logistics.purchase.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_orderInfo")
public class OrderInfoTO extends BaseTO {
    private String orderNo;
    private String customerCode;
    private String orderDate;
    private String personCodeInCharge;
    private String description;
    private String orderInfoStatus;

}
