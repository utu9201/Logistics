package net.plang.logistics.business.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_customer")
public class CustomerTO extends BaseTO {

    private String customerCode;
    private String workplaceCode;
    private String customerName;
    private String customerType;
    private String customerCeo;
    private String businessLicenseNumber;
    private String socialSecurityNumber;
    private String customerBusinessConditions;
    private String customerBusinessItems;
    private String customerZipCode;
    private String customerBasicAddress;
    private String customerDetailAddress;
    private String customerTelNumber;
    private String customerFaxNumber;
    private String customerNote;
}
