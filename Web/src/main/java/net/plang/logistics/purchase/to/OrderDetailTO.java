package net.plang.logistics.purchase.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_orderDetail")
@Alias("OrderDetailTO")
public class OrderDetailTO extends BaseTO {

    private String orderDetailNo;
    private String orderGatheringNo;
    private String orderNo;
    private String itemCode;
    private String itemName;
    private String unitOfOrder;
    private String orderDate;
    private String deliveryScheduleDate;
    private String orderAmount;
    private String unitPriceOfOrder;
    private String sumPriceOfOrder;
    private String description;
    private String mrpGatheringNo;
    private String orderDetailStatus;
    private String warehousingStatus;
}
