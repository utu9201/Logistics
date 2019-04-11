package net.plang.hr.emp.applicationService;

import java.util.List;

import net.plang.hr.emp.to.EmployeeTO;

public interface EmpApplicationService {

    List<EmployeeTO> getEmployeeList();

    void batchEmployeeList(List<EmployeeTO> employeeList);
}
