package net.plang.base.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;

@Data
@Dataset(name = "gds_post")
public class PostTO {
    private String zipNO;
    private String lnmAdres;
    private String rnAdres;
}
