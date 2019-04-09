package net.plang.hr.emp.sf;

import java.util.List;

import net.plang.hr.emp.to.EmployeeTO;

public interface EmpServiceFacade {

    List<EmployeeTO> findEmployeeList();

    void batchEmployeeList(List<EmployeeTO> employeeList);
}
