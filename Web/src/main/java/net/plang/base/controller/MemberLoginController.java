package net.plang.base.controller;

import java.util.HashMap;
import java.util.List;

import net.plang.common.controller.MiplatformController;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;

import net.plang.base.sf.BaseServiceFacade;
import net.plang.base.to.MenuTO;
import com.tobesoft.platform.data.PlatformData;

public class MemberLoginController extends MiplatformController {

    private BaseServiceFacade baseServiceFacade;
    private MessageSource messageSource;
    private ModelMap modelMap = new ModelMap();

    public void setBaseServiceFacade(BaseServiceFacade baseServiceFacade) {
        this.baseServiceFacade = baseServiceFacade;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void accessToAuthority(PlatformData inData, PlatformData outData) throws Exception {
        System.out.println(inData);
        String empCode = inData.getVariable("empCode").getValue().asString().toUpperCase();
        String empPassword = inData.getVariable("empPassword").getValue().asString();
        String deptCode = inData.getVariable("deptCode").getValue().asString().toUpperCase();
        HashMap<String, Object> result = baseServiceFacade.accessToAuthority(empCode, empPassword, deptCode);
        List<MenuTO> menuList = (List<MenuTO>) result.get("masterMenuList");
        outData.getVariableList().addStr("empCode", empCode);
        outData.getVariableList().addStr("deptCode", deptCode);
        datasetBeanMapper.beansToDataset(outData, menuList, MenuTO.class);

    }

}
