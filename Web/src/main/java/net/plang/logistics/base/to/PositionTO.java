package net.plang.logistics.base.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_position")
@Alias("PositionTO")
public class PositionTO extends BaseTO {

    private String workplaceCode;
    private String deptCode;
    private String positionCode;
    private String positionName;
    private String description;
}
