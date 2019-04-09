package net.plang.hr.emp.to;

import lombok.Data;
import net.plang.common.annotation.Dataset;
import net.plang.common.to.BaseTO;

@Data
@Dataset(name = "gds_employee")
public class EmployeeTO extends BaseTO {

    private String empCode;
    private String empName;
    private String companyCode;
    private String workplaceCode;
    private String deptCode;
    private String positionCode;
    private String socialSecurityNumber;
    private String birthDate;
    private String gender;
    private String email;
    private String phoneNumber;
    private String image;
    private String userPw;
    private String zipCode;
    private String basicAddress;
    private String detailAddress;
    private String levelOfEducation;
    private String userOrNot;
}
