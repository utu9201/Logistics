package net.plang.logistics.base.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
@Data
@Dataset(name = "gds_workplace")
public class WorkplaceTO extends BaseTO {

    private String workplaceCode;
    private String companyCode;
    private String workplaceName;
    private String businessLicenseNumber;
    private String corporationLicenseNumber;
    private String workplaceCeoName;
    private String workplaceBusinessConditions;
    private String workplaceBusinessItems;
    private String workplaceZipCode;
    private String workplaceBasicAddress;
    private String workplaceDetailAddress;
    private String workplaceTelNubmer;
    private String workplaceFaxNumber;
    private String workplaceEstablishDate;
    private String workplaceOpenDate;
    private String workplaceCloseDate;
    private String isMainOffice;
}
