package net.plang.logistics.base.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;
import org.apache.ibatis.type.Alias;

@Data
@Dataset(name = "gds_company")
@Alias("CompanyTO")
public class CompanyTO extends BaseTO {

    private String companyCode;
    private String companyName;
    private String companyDivision;
    private String businessLicenseNumber;
    private String corporationLicenseNumber;
    private String companyCeoName;
    private String companyBusinessConditions;
    private String companyBusinessItems;
    private String companyZipCode;
    private String companyBasicAddress;
    private String companyDetailAddress;
    private String companyTelNumber;
    private String companyFaxNumber;
    private String companyEstablishmentDate;
    private String companyOpenDate;
    private String homepage;
}
