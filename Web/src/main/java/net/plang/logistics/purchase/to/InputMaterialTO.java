package net.plang.logistics.purchase.to;

import lombok.Data;
import net.plang.common.to.BaseTO;

@Data
public class InputMaterialTO extends BaseTO {
    private String inputItemNo;
    private String itemCode;
    private String itemName;
    private String unitOfInputMaterials;
    private String inputAmount;
    private String warehouseCode;
    private String inputDate;
}
