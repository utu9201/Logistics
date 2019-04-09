package net.plang.base.controller;
import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.base.sf.BaseServiceFacade;
import net.plang.base.to.CodeDetailTO;

import net.plang.common.controller.MiplatformController;

public class CodeDetailController extends MiplatformController {
	private BaseServiceFacade baseServiceFacade;

	public void setBaseServiceFacade(BaseServiceFacade baseServiceFacade) {
		this.baseServiceFacade = baseServiceFacade;
	}
	public void findCodeDetailList(PlatformData inData, PlatformData outData) throws Exception{
        List<CodeDetailTO> codeDetailList= baseServiceFacade.findCodeDetailList();

        datasetBeanMapper.beansToDataset(outData, codeDetailList, CodeDetailTO.class);

	}

	public void batchDetailCode(PlatformData inData, PlatformData outData) throws Exception{

		List<CodeDetailTO> codeDetailList = datasetBeanMapper.datasetToBeans(inData, CodeDetailTO.class);

		baseServiceFacade.batchDetailCode(codeDetailList);

		findCodeDetailList(inData, outData);
	}
}
