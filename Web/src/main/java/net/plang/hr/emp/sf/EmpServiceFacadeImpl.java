package net.plang.hr.emp.sf;

import java.util.List;

import net.plang.hr.emp.applicationService.EmpApplicationService;
import net.plang.hr.emp.to.EmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceFacadeImpl implements EmpServiceFacade {
    @Autowired
    private EmpApplicationService empApplicationService;

    public void setEmpApplicationService(EmpApplicationService empApplicationService) {
        this.empApplicationService = empApplicationService;
    }

    @Override
    public List<EmployeeTO> getEmployeeList() {

        return empApplicationService.getEmployeeList();

    }

    @Override
    public void batchEmployeeList(List<EmployeeTO> employeeList) {
        empApplicationService.batchEmployeeList(employeeList);
    }
}
