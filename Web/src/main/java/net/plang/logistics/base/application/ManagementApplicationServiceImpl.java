package net.plang.logistics.base.application;

import java.util.List;

import net.plang.logistics.base.dao.CompanyDAO;
import net.plang.logistics.base.dao.DeptDAO;
import net.plang.logistics.base.dao.PositionDAO;
import net.plang.logistics.base.dao.WorkplaceDAO;
import net.plang.logistics.base.to.CompanyTO;
import net.plang.logistics.base.to.DeptTO;
import net.plang.logistics.base.to.PositionTO;
import net.plang.logistics.base.to.WorkplaceTO;

public class ManagementApplicationServiceImpl implements ManagementApplicationService {

    private DeptDAO deptDAO;
    private CompanyDAO companyDAO;
    private WorkplaceDAO workplaceDAO;
    private PositionDAO positionDAO;

    public void setDeptDAO(DeptDAO deptDAO) {
        this.deptDAO = deptDAO;
    }

    public void setCompanyDAO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public void setWorkplaceDAO(WorkplaceDAO workplaceDAO) {
        this.workplaceDAO = workplaceDAO;
    }

    public void setPositionDAO(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }

    @Override
    public List<DeptTO> findDeptList() {
        return deptDAO.selectDeptList();
    }

    @Override
    public List<CompanyTO> findCompanyList() {
        return companyDAO.selectCompanyList();
    }

    @Override
    public List<WorkplaceTO> findWorkplaceList() {
        return workplaceDAO.selectWorkplaceList();
    }

    @Override
    public List<PositionTO> findPositionList() {
        return positionDAO.selectPositionList();
    }

    @Override
    public void batchDepartmentList(List<DeptTO> batchDeptList) {
        for (DeptTO deptTo : batchDeptList) {

            switch (deptTo.getStatus()) {

                case "insert":
                    deptDAO.insertDepartment(deptTo);
                    break;

                case "update":
                    deptDAO.updateDepartment(deptTo);
                    break;

                case "delete":
                    deptDAO.deleteDepartment(deptTo);
                    break;
            }
        }

    }

    @Override
    public void batchCompanyList(List<CompanyTO> batchCompanyList) {
        for (CompanyTO CompTO : batchCompanyList) {

            switch (CompTO.getStatus()) {

                case "insert":
                    companyDAO.insertCompany(CompTO);
                    break;

                case "update":
                    companyDAO.updateCompany(CompTO);
                    break;

                case "delete":
                    companyDAO.deleteCompany(CompTO);
                    break;
            }
        }
    }

    public void batchWorkplaceList(List<WorkplaceTO> batchWorkplaceList) {
        for (WorkplaceTO wpTO : batchWorkplaceList) {

            switch (wpTO.getStatus()) {

                case "insert":
                    workplaceDAO.insertWorkplace(wpTO);
                    break;

                case "update":
                    workplaceDAO.updateWorkplace(wpTO);
                    break;

                case "delete":
                    workplaceDAO.deleteWorkplace(wpTO);
                    break;
            }
        }
    }

}
