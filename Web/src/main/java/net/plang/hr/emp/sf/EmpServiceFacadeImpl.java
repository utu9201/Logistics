package net.plang.hr.emp.sf;

import java.util.List;

import net.plang.hr.emp.applicationService.EmpApplicationService;
import net.plang.hr.emp.to.EmployeeTO;

public class EmpServiceFacadeImpl implements EmpServiceFacade {

    private EmpApplicationService empApplicationService;

    public void setEmpApplicationService(EmpApplicationService empApplicationService) {
        this.empApplicationService = empApplicationService;
    }

    @Override
    public List<EmployeeTO> findEmployeeList() {

        return empApplicationService.findEmployeeList();

    }

    @Override
    public void batchEmployeeList(List<EmployeeTO> employeeList) {
        empApplicationService.batchEmployeeList(employeeList);
    }
}
