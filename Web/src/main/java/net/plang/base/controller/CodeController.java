package net.plang.base.controller;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.base.sf.BaseServiceFacade;
import net.plang.base.to.CodeTO;
import net.plang.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CodeController {
    @Autowired
    private BaseServiceFacade baseServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/base/getCodeList.do")
    public void getCodeList(@RequestAttribute("outData") PlatformData outData) throws Exception {
        List<CodeTO> codeList = baseServiceFacade.getCodeList();

        datasetBeanMapper.beansToDataset(outData, codeList, CodeTO.class);
    }

    @RequestMapping("/base/getSerialCode.do")
    public void getSerialCode(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        String findSeq = inData.getVariable("findSeq").getString();

        String serialNo = baseServiceFacade.getSerialCode(findSeq);
        outData.getVariableList().add("serialCode", serialNo);
    }

}
