package net.plang.base.applicationService;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import net.plang.base.exception.DeptCodeNotFoundException;
import net.plang.base.exception.IdNotFoundException;
import net.plang.base.exception.PwMissmatchException;
import net.plang.base.to.CodeDetailTO;
import net.plang.base.to.CodeTO;
import net.plang.base.to.MenuTO;

public interface BaseApplicationService {

    List<CodeTO> findCodeList();
    // 코드리스트 조회

    List<CodeDetailTO> findCodeDetailList();
    // 상세코드리스트 조회

    void batchDetailCode(List<CodeDetailTO> codeDetailList);
    // DetailCode 변경저장

    List<MenuTO> findMenuList();

    String takeSerialCode(String findSeq);

    HashMap<String, Object> accessToAuthority(String empCode, String empPassword, String deptCode) throws IdNotFoundException, DeptCodeNotFoundException, PwMissmatchException, DataAccessException;
}
