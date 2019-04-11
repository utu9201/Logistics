package net.plang.base.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_menu")
@Alias("MenuTO")
public class MenuTO extends BaseTO {

    private String workplaceCode;
    private String menuCode;
    private String parentMenuCode;
    private String menuName;
    private String menuOrder;
    private String url;
    private String description;
}
