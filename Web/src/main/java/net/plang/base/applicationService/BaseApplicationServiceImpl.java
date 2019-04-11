
package net.plang.base.applicationService;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import net.plang.base.dao.CodeDAO;
import net.plang.base.dao.CodeDetailDAO;
import net.plang.base.dao.MenuDAO;
import net.plang.base.exception.DeptCodeNotFoundException;
import net.plang.base.exception.IdNotFoundException;
import net.plang.base.exception.PwMissmatchException;
import net.plang.base.to.CodeDetailTO;
import net.plang.base.to.CodeTO;
import net.plang.base.to.MenuTO;
import net.plang.hr.emp.dao.EmployeeDAO;
import net.plang.hr.emp.to.EmployeeTO;
import org.springframework.stereotype.Component;

@Component
public class BaseApplicationServiceImpl implements BaseApplicationService {
    @Autowired
    private CodeDAO codeDAO;
    @Autowired
    private CodeDetailDAO codeDetailDAO;
    @Autowired
    private MenuDAO menuDAO;
    @Autowired
    private EmployeeDAO employeeDAO;

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void setMenuDAO(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    public void setCodeDAO(CodeDAO codeDAO) {
        this.codeDAO = codeDAO;
    }

    public void setCodeDetailDAO(CodeDetailDAO codeDetailDAO) {
        this.codeDetailDAO = codeDetailDAO;
    }

    @Override
    public List<CodeTO> getCodeList() {
        return codeDAO.selectCodeList();
    }

    @Override
    public List<CodeDetailTO> getCodeDetailList() {
        return codeDetailDAO.selectCodeDetailList();
    }

    @Override
    public void batchDetailCode(List<CodeDetailTO> codeDetailList) {

        for (CodeDetailTO codeDetailTO : codeDetailList) {

            switch (codeDetailTO.getStatus()) {
                case "insert":
                    codeDetailDAO.insertDetailCode(codeDetailTO);
                    break;
                case "update":
                    codeDetailDAO.updateDetailCode(codeDetailTO);
                    break;
                case "delete":
                    codeDetailDAO.deleteDetailCode(codeDetailTO);
                    break;

            }

        }
    }

    @Override
    public List<MenuTO> getMenuList() {
        return menuDAO.selectMenuList();
    }

    @Override
    public String getSerialCode(String findSeq) {
        return codeDAO.getSerialCode(findSeq);
    }

    @Override
    public HashMap<String, Object> accessToAuthority(String empCode, String empPassword, String deptCode)
            throws IdNotFoundException, DeptCodeNotFoundException, PwMissmatchException, DataAccessException {
        EmployeeTO empTo = null;
        List<MenuTO> menuList = null;
        List<MenuTO> masterMenuList = null;
        HashMap<String, Object> result = new HashMap<String, Object>();
        System.out.println("empCode : " + empCode);
        empTo = employeeDAO.selectEmployee(empCode);

        if (empTo == null) {

            throw new IdNotFoundException(" 존재 하지 않는 계정입니다. ");
        } else {

            if (!(empTo.getDeptCode().equals(deptCode))) {
                throw new DeptCodeNotFoundException("존재하지않는 부서입니다");
            } else {
                if (empTo.getUserPw().equals(empPassword)) {

                    masterMenuList = menuDAO.selectMenuList();
                    result.put("employeeTO", empTo);
                    result.put("masterMenuList", masterMenuList);
                } else {

                    throw new PwMissmatchException(" 비밀번호가 틀립니다. ");
                }

            }

        }
        return result;
    }

}
