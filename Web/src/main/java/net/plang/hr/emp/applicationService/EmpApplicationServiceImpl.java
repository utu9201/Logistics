package net.plang.hr.emp.applicationService;

import java.util.List;

import net.plang.hr.emp.dao.EmployeeDAO;
import net.plang.hr.emp.to.EmployeeTO;

public class EmpApplicationServiceImpl implements EmpApplicationService {

    private EmployeeDAO employeeDAO;

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<EmployeeTO> findEmployeeList() {
        return employeeDAO.selectEmployeeList();
    }

    @Override
    public void batchEmployeeList(List<EmployeeTO> employeeList) {
        for (EmployeeTO employee : employeeList) {

            switch (employee.getStatus()) {

                case "insert":
                    employeeDAO.insertEmployee(employee);
                    break;
                case "update":
                    employeeDAO.updateEmployee(employee);
                    break;
                case "delete":
                    employeeDAO.deleteEmployee(employee);
                    break;

            }
        }
    }

}
