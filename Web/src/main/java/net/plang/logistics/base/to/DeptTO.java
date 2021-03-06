package net.plang.logistics.base.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_dept")
@Alias("DeptTO")
public class DeptTO extends BaseTO {

    private String workplaceCode;
    private String deptCode;
    private String deptName;
    private String workplaceName;
    private String companyCode;
    private String companyName;
    private String deptStartDate;
    private String deptEndDate;
}
