package net.plang.logistics.purchase.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_orderGathering")
@Alias("OrderGatheringTO")
public class OrderGatheringTO extends BaseTO {

    private String itemCode;
    private String unitOfOrder;
    private String deliveryScheduleDate;
    private String orderAmount;
    private String orderDetailStatus;
    private String description;
    private String orderGatheringNo;
    private String orderNo;
}
