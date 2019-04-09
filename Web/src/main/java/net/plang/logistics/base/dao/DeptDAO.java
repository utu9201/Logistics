package net.plang.logistics.base.dao;

import java.util.List;

import net.plang.logistics.base.to.DeptTO;

public interface DeptDAO {

    List<DeptTO> selectDeptList();

    void insertDepartment(DeptTO deptTo);

    void updateDepartment(DeptTO deptTo);

    void deleteDepartment(DeptTO deptTo);

}
