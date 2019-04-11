package net.plang.base.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_post")
@Alias("PostTO")
public class PostTO {
    private String zipNO;
    private String lnmAdres;
    private String rnAdres;
}
