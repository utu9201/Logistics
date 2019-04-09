package net.plang.base.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_codeDetail")
public class CodeDetailTO extends BaseTO {

    String divisionCodeNo;
    String detailCode;
    String detailCodeName;
    String codeUseCheck;
    String description;
}
