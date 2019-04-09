package net.plang.base.controller;

import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.base.sf.BaseServiceFacade;

import net.plang.base.to.MenuTO;
import net.plang.common.controller.MiplatformController;

public class MenuController extends MiplatformController {

    private BaseServiceFacade baseServiceFacade;

    public void setBaseServiceFacade(BaseServiceFacade baseServiceFacade) {
        this.baseServiceFacade = baseServiceFacade;
    }

    public void findMenuList(PlatformData inData, PlatformData outData) throws Exception {
        List<MenuTO> menuList = baseServiceFacade.findMenuList();

        datasetBeanMapper.beansToDataset(outData, menuList, MenuTO.class);

    }

}
