package net.plang.base.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_code")
public class CodeTO extends BaseTO {

    private String divisionCodeNo;
    private String codeType;
    private String divisionCodeName;
    private String codeChangeAvailable;
    private String description;
}
