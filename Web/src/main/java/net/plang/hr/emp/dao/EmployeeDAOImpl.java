package net.plang.hr.emp.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.hr.emp.to.EmployeeTO;

public class EmployeeDAOImpl extends IbatisSupportDAO implements EmployeeDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<EmployeeTO> selectEmployeeList() {
        return (List<EmployeeTO>) getSqlMapClientTemplate().queryForList("emp.selectEmployeeList");
    }

    @Override
    public EmployeeTO selectEmployee(String empCode) {
        return (EmployeeTO) getSqlMapClientTemplate().queryForObject("emp.selectEmployee", empCode);

    }

    @Override
    public void insertEmployee(EmployeeTO employee) {
        getSqlMapClientTemplate().insert("emp.insertEmployee", employee);
    }

    @Override
    public void updateEmployee(EmployeeTO employee) {
        getSqlMapClientTemplate().update("emp.updateEmployee", employee);
    }

    @Override
    public void deleteEmployee(EmployeeTO employee) {
        getSqlMapClientTemplate().delete("emp.deleteEmployee", employee);
    }
}
