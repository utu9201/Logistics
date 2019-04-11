package net.plang.logistics.purchase.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_bom")
@Alias("BomTO")
public class BomTO extends BaseTO {

    private String no;
    private String itemCode;
    private String parentItemCode;
    private String netAmount;
    private String description;
    private String lev;
}
