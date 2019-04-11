package net.plang.base.controller;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.base.sf.BaseServiceFacade;
import net.plang.base.to.CodeDetailTO;
import net.plang.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/base/codeDetail.do")
public class CodeDetailController {
    @Autowired
    private BaseServiceFacade baseServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    public void getCodeDetailList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<CodeDetailTO> codeDetailList = baseServiceFacade.getCodeDetailList();

        datasetBeanMapper.beansToDataset(outData, codeDetailList, CodeDetailTO.class);
    }

    public void batchDetailCode(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<CodeDetailTO> codeDetailList = datasetBeanMapper.datasetToBeans(inData, CodeDetailTO.class);

        baseServiceFacade.batchDetailCode(codeDetailList);
        getCodeDetailList(inData, outData);
    }
}
