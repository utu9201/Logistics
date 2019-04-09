package net.plang.hr.emp.dao;

import java.util.List;

import net.plang.hr.emp.to.EmployeeTO;

public interface EmployeeDAO {

    List<EmployeeTO> selectEmployeeList();

    EmployeeTO selectEmployee(String empCode);

    void insertEmployee(EmployeeTO employee);

    void updateEmployee(EmployeeTO employee);

    void deleteEmployee(EmployeeTO employee);
}
