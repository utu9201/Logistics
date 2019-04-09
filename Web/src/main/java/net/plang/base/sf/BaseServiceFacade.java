package net.plang.base.sf;

import java.util.HashMap;
import java.util.List;

import net.plang.base.exception.DeptCodeNotFoundException;
import net.plang.base.exception.IdNotFoundException;
import net.plang.base.exception.PwMissmatchException;
import net.plang.base.to.CodeDetailTO;
import net.plang.base.to.CodeTO;
import net.plang.base.to.MenuTO;

public interface BaseServiceFacade {
    List<CodeTO> findCodeList();
    // 코드리스트 조회

    List<CodeDetailTO> findCodeDetailList();
    // 상세코드리스트 조회

    void batchDetailCode(List<CodeDetailTO> codeDetailList);
    // DetailCode 변경저장

    List<MenuTO> findMenuList();

    String takeSerialCode(String findSeq);

    HashMap<String, Object> accessToAuthority(String empCode, String empPassword, String deptCode) throws IdNotFoundException, PwMissmatchException, DeptCodeNotFoundException;

}
