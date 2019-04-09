package net.plang.base.controller;

import net.plang.base.sf.BaseServiceFacade;
import net.plang.base.to.CodeTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import java.util.List;

@Controller
@RequestMapping("")
public class CodeController extends MultiActionController {

    private BaseServiceFacade baseServiceFacade;

    public void setBaseServiceFacade(BaseServiceFacade baseServiceFacade) {
        this.baseServiceFacade = baseServiceFacade;
    }




    public void findCodeList(PlatformData inData, PlatformData outData) throws Exception {
        List<CodeTO> codeList = baseServiceFacade.findCodeList();

        datasetBeanMapper.beansToDataset(outData, codeList, CodeTO.class);
    }

    public void takeSerialCode(PlatformData inData, PlatformData outData) throws Exception {
        String findSeq = inData.getVariable("findSeq").getValue().asString();
        System.out.println(findSeq);
        String serialNo = baseServiceFacade.takeSerialCode(findSeq);
        outData.getVariableList().addStr("serialCode", serialNo);
    }

}
