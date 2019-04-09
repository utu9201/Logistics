package net.plang.logistics.production.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;

import net.plang.logistics.production.sf.ProductionServiceFacade;
import net.plang.logistics.production.to.MpsTO;
import net.plang.logistics.production.to.MrpGatheringTO;
import net.plang.logistics.production.to.MrpOpenTempTO;
import net.plang.logistics.production.to.MrpTO;

public class MrpController extends MiplatformController {

    private ProductionServiceFacade productionServiceFacade;

    public void setProductionServiceFacade(ProductionServiceFacade productionServiceFacade) {
        this.productionServiceFacade = productionServiceFacade;
    }

    public void findMrpList(PlatformData inData, PlatformData outData) throws Exception {

        List<MrpTO> mrpList = productionServiceFacade.findMrpList();

        datasetBeanMapper.beansToDataset(outData, mrpList, MrpTO.class);
    }

    public void findMrpGatheringList(PlatformData inData, PlatformData outData) throws Exception {

        List<MrpGatheringTO> mrpGatheringList = productionServiceFacade.findMrpGatheringList();

        datasetBeanMapper.beansToDataset(outData, mrpGatheringList, MrpGatheringTO.class);
    }

    public void findMrpOpenTempProcess(PlatformData inData, PlatformData outData) throws Exception {
        HashMap<String, Object> paramMap = new HashMap<>();
        String mps = inData.getVariable("mpsNo").getValue().asString();
        String[] mpsNo = new String[1];
        mpsNo[0] = mps;
        paramMap.put("mpsNo", mpsNo);
        List<MrpOpenTempTO> mrpOpenTempList = productionServiceFacade.findMrpOpenTempProcessList(paramMap);

        datasetBeanMapper.beansToDataset(outData, mrpOpenTempList, MrpOpenTempTO.class);

    }

    public void batchMrpGathering(PlatformData inData, PlatformData outData) throws Exception {

        List<MrpGatheringTO> mrpGatheringList = datasetBeanMapper.datasetToBeans(inData, MrpGatheringTO.class);

        productionServiceFacade.batchMrpGathering(mrpGatheringList);

        findMrpList(inData, outData);
        findMrpGatheringList(inData, outData);

    }
/*	public void findMrpGatheringList2(PlatformData inData, PlatformData outData) throws Exception {

	      List<MrpTO> mrpList = datasetBeanMapper.datasetToBeans(inData, MrpTO.class);

	      List<MrpGatheringTO2> mrpGatheringList = productionServiceFacade.findMrpGatheringList2(mrpList);

	      datasetBeanMapper.beansToDataset(outData, mrpGatheringList, MrpGatheringTO2.class);

	}*/
    // 소요량 전개 MRP_OPEN_TEMP 프로시져 패키지메서드

    public void findMrpOpenTempList(PlatformData inData, PlatformData outData) throws Exception {
        // result Object 생성

        HashMap<String, Object> paramMap = new HashMap<>();

        List<MpsTO> mpsList = datasetBeanMapper.datasetToBeans(inData, MpsTO.class);
        int flag = 0;
        for (MpsTO mp : mpsList) {
            flag++;
        }
        String[] mpsNo = new String[flag];
        int index = 0;
        for (MpsTO mpt : mpsList) {
            System.out.println(mpt.getMpsNo());
            mpsNo[index] = mpt.getMpsNo();
            index++;
            //System.out.println(index+"uuu"+mpsNo[index-1]);
        }

        paramMap.put("mpsNo", mpsNo);

        List<MrpOpenTempTO> mrpOpenTempList = productionServiceFacade.findMrpOpenTempProcessList(paramMap);
        datasetBeanMapper.beansToDataset(outData, mrpOpenTempList, MrpOpenTempTO.class);

    }

    // 소요량 전개 MRP INSERT 프로시져
    //@RequestMapping("logistics/production/registMrp.do")
    public void registMrp(PlatformData inData, PlatformData outData) throws Exception {

        Map<String, Object> paramMap = new HashMap<>();

        productionServiceFacade.registMrp(paramMap);

        findMrpList(inData, outData);
    }
    // 소요량 취합 프로시져

    public void registMrpGathering(PlatformData inData, PlatformData outData) throws Exception {

        HashMap<String, Object> paramMap = new HashMap<>();
//타입핸들러는 string[] 형식으로만 사용이 가능
        List<MrpTO> mrpList = datasetBeanMapper.datasetToBeans(inData, MrpTO.class);
        int flag = 0;
        String mpsn = "확인용";
        for (MrpTO mp : mrpList) {
            if (!(mpsn).equals(mp.getMpsNo())) {
                mpsn = mp.getMpsNo();
                flag++;
            }
        }//mps넘버가 중복으로 넘어가는것을 방지
        String[] mpsNo = new String[flag];
        int index = 0;
        for (MrpTO mpt : mrpList) {
            System.out.println(mpt.getMpsNo());

            if (index == 0) {
                mpsNo[index] = (String) mpt.getMpsNo();
                index++;
            }
            if (index != 0) {
                if (!(mpsNo[index - 1]).equals(mpt.getMpsNo())) {
                    System.out.println(index + "들어갈소요량취합" + mpt.getMpsNo());
                    System.out.println(index + "들어있는소요량취합" + mpsNo[index - 1]);
                    mpsNo[index] = (String) mpt.getMpsNo();
                    index++;
                } else {
                    System.out.println("진입실패");
                }
            }

        }

        paramMap.put("mpsNo", mpsNo);
        productionServiceFacade.registMrpGathering(paramMap);

        //findMrpList(inData, outData);
        //findMrpGatheringList(inData, outData);

    }

}
