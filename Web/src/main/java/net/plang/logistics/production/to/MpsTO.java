package net.plang.logistics.production.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_mps")
@Alias("MpsTO")
public class MpsTO extends BaseTO {

    private String mpsNo;
    private String mpsPlanClassification;
    private String contractDetailNo;
    private String salesPlanNo;
    private String itemCode;
    private String itemName;
    private String unitOfMps;
    private String mpsPlanDate;
    private String mpsPlanAmount;
    private String dueDateOfMps;
    private String scheduledEndDate;
    private String mrpApplyStatus;
    private String description;
}
