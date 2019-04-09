package net.plang.base.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_menu")
public class MenuTO extends BaseTO {

    private String workplaceCode;
    private String menuCode;
    private String parentMenuCode;
    private String menuName;
    private String menuOrder;
    private String url;
    private String description;
}
