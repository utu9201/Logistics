package net.plang.logistics.base.sf;

import java.util.List;

import net.plang.logistics.base.application.ManagementApplicationService;
import net.plang.logistics.base.to.CompanyTO;
import net.plang.logistics.base.to.DeptTO;
import net.plang.logistics.base.to.PositionTO;
import net.plang.logistics.base.to.WorkplaceTO;

public class ManagementServiceFacadeImpl implements ManagementServiceFacade {

    public void setManagementApplicationService(ManagementApplicationService managementApplicationService) {
        this.managementApplicationService = managementApplicationService;
    }

    private ManagementApplicationService managementApplicationService;

    @Override
    public List<DeptTO> findDeptList() {
        return managementApplicationService.findDeptList();
    }

    @Override
    public List<CompanyTO> findCompanyList() {
        return managementApplicationService.findCompanyList();
    }

    @Override
    public List<WorkplaceTO> findWorkplaceList() {
        return managementApplicationService.findWorkplaceList();
    }

    @Override
    public List<PositionTO> findPositionList() {
        return managementApplicationService.findPositionList();
    }

    @Override
    public void batchDepartmentList(List<DeptTO> registDeptList) {
        managementApplicationService.batchDepartmentList(registDeptList);

    }

    public void batchCompanyList(List<CompanyTO> batchCompanyList) {
        managementApplicationService.batchCompanyList(batchCompanyList);
    }

    public void batchWorkplaceList(List<WorkplaceTO> batchWorkplaceList) {
        managementApplicationService.batchWorkplaceList(batchWorkplaceList);
    }
}
