package net.plang.base.controller;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.base.sf.BaseServiceFacade;
import net.plang.base.to.MenuTO;
import net.plang.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private BaseServiceFacade baseServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/base/getMenuList.do")
    public void getMenuList(@RequestAttribute("outData") PlatformData outData) throws Exception {
        List<MenuTO> menuList = baseServiceFacade.getMenuList();

        datasetBeanMapper.beansToDataset(outData, menuList, MenuTO.class);
    }

}
