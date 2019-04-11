package net.plang.logistics.purchase.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_warehousing")
@Alias("WarehousingTO")
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
