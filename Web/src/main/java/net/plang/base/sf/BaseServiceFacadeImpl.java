package net.plang.base.sf;

import java.util.HashMap;
import java.util.List;

import net.plang.base.applicationService.BaseApplicationService;
import net.plang.base.exception.DeptCodeNotFoundException;
import net.plang.base.exception.IdNotFoundException;
import net.plang.base.exception.PwMissmatchException;
import net.plang.base.to.CodeDetailTO;
import net.plang.base.to.CodeTO;
import net.plang.base.to.MenuTO;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceFacadeImpl implements BaseServiceFacade {

    private BaseApplicationService baseApplicationService;

    public void setBaseApplicationService(BaseApplicationService baseApplicationService) {
        this.baseApplicationService = baseApplicationService;
    }

    @Override
    public List<CodeTO> getCodeList() {
        return baseApplicationService.getCodeList();
    }

    @Override
    public List<CodeDetailTO> getCodeDetailList() {
        return baseApplicationService.getCodeDetailList();
    }

    @Override
    public void batchDetailCode(List<CodeDetailTO> codeDetailList) {
        baseApplicationService.batchDetailCode(codeDetailList);
    }

    @Override
    public List<MenuTO> getMenuList() {
        return baseApplicationService.getMenuList();
    }

    @Override
    public String getSerialCode(String findSeq) {
        return baseApplicationService.getSerialCode(findSeq);
    }

    @Override
    public HashMap<String, Object> accessToAuthority(String empCode, String empPassword, String deptCode)
            throws IdNotFoundException, PwMissmatchException, DeptCodeNotFoundException {
        return baseApplicationService.accessToAuthority(empCode, empPassword, deptCode);
    }

}
