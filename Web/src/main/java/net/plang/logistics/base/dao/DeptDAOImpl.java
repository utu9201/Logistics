package net.plang.logistics.base.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;

import net.plang.logistics.base.to.DeptTO;

public class DeptDAOImpl extends IbatisSupportDAO implements DeptDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<DeptTO> selectDeptList() {
        return (List<DeptTO>) getSqlMapClientTemplate().queryForList("department.selectDeptList");
    }

    @Override
    public void insertDepartment(DeptTO deptTo) {
        getSqlMapClientTemplate().insert("department.insertDept", deptTo);
    }

    @Override
    public void updateDepartment(DeptTO deptTo) {
        getSqlMapClientTemplate().update("department.updateDept", deptTo);
    }

    @Override
    public void deleteDepartment(DeptTO deptTo) {
        getSqlMapClientTemplate().delete("department.deleteDept", deptTo);
    }
}
