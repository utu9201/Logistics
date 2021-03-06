package net.plang.logistics.business.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_contract")
@Alias("ContractTO")
public class ContractTO extends BaseTO {
    private String contractNo;
    private String estimateNo;
    private String contractType;
    private String customerCode;
    private String contractDate;
    private String contractRequester;
    private String personCodeInCharge;
    private String description;
    private String deliveryResultStatus;
}
