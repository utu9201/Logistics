package net.plang.base.controller;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.base.sf.BaseServiceFacade;
import net.plang.base.to.MenuTO;
import net.plang.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class MemberLoginController {

    @Autowired
    private BaseServiceFacade baseServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;
//    @Autowired
//    private MessageSource messageSource;

//    private ModelMap modelMap = new ModelMap();

    @RequestMapping("/base/accessToAuthority.do")
    public void accessToAuthority(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        System.out.println(inData);
        String empCode = inData.getVariable("empCode").getString().toUpperCase();
        String empPassword = inData.getVariable("empPassword").getString();
        String deptCode = inData.getVariable("deptCode").getString().toUpperCase();

        HashMap<String, Object> result = baseServiceFacade.accessToAuthority(empCode, empPassword, deptCode);
        List<MenuTO> menuList = (List<MenuTO>) result.get("masterMenuList");
        outData.getVariableList().add("empCode", empCode);
        outData.getVariableList().add("deptCode", deptCode);
        datasetBeanMapper.beansToDataset(outData, menuList, MenuTO.class);

    }

}
