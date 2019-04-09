package net.plang.logistics.business.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_estimate")
public class EstimateTO extends BaseTO {

    private String estimateNo;
    private String customerCode;
    private String estimateDate;
    private String contractStatus;
    private String estimateRequester;
    private String effectiveDate;
    private String personCodeInCharge;
    private String description;
}
