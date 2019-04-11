package net.plang.logistics.base.sf;

import java.util.List;

import net.plang.logistics.base.application.ManagementApplicationService;
import net.plang.logistics.base.to.CompanyTO;
import net.plang.logistics.base.to.DeptTO;
import net.plang.logistics.base.to.PositionTO;
import net.plang.logistics.base.to.WorkplaceTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagementServiceFacadeImpl implements ManagementServiceFacade {
    @Autowired
    private ManagementApplicationService managementApplicationService;

    @Override
    public List<DeptTO> getDeptList() {
        return managementApplicationService.getDeptList();
    }

    @Override
    public List<CompanyTO> getCompanyList() {
        return managementApplicationService.getCompanyList();
    }

    @Override
    public List<WorkplaceTO> getWorkplaceList() {
        return managementApplicationService.getWorkplaceList();
    }

    @Override
    public List<PositionTO> getPositionList() {
        return managementApplicationService.getPositionList();
    }

    @Override
    public void batchDepartmentList(List<DeptTO> registDeptList) {
        managementApplicationService.batchDepartmentList(registDeptList);

    }

    @Override
    public void batchCompanyList(List<CompanyTO> batchCompanyList) {
        managementApplicationService.batchCompanyList(batchCompanyList);
    }

    @Override
    public void batchWorkplaceList(List<WorkplaceTO> batchWorkplaceList) {
        managementApplicationService.batchWorkplaceList(batchWorkplaceList);
    }
}
