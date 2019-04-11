package net.plang.logistics.purchase.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_materialPayment")
@Alias("MaterialPaymentTO")
public class MaterialPaymentTO extends BaseTO {

    private String itemCode;
    private String paymentDate;
    private String workInstructionNo;
    private String itemName;
    private String paymentAmount;
    private String unitPayment;
    private String description;
    private String inputItemNo;
    private String releaseNo;
}
