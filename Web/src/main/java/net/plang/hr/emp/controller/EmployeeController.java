package net.plang.hr.emp.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;
import net.plang.hr.emp.sf.EmpServiceFacade;
import net.plang.hr.emp.to.EmployeeTO;

public class EmployeeController extends MiplatformController {

    private EmpServiceFacade empServiceFacade;

    public void setEmpServiceFacade(EmpServiceFacade empServiceFacade) {
        this.empServiceFacade = empServiceFacade;
    }

    public void findEmployeeList(PlatformData inData, PlatformData outData) throws Exception {

        List<EmployeeTO> employeeList = empServiceFacade.findEmployeeList();

        datasetBeanMapper.beansToDataset(outData, employeeList, EmployeeTO.class);

    }

    public void batchEmployeeList(PlatformData inData, PlatformData outData) throws Exception {
        List<EmployeeTO> employeeList = datasetBeanMapper.datasetToBeans(inData, EmployeeTO.class);

        empServiceFacade.batchEmployeeList(employeeList);

    }

    public void saveEmpImg(PlatformData inData, PlatformData outData) throws Exception {
        Dataset dataset = inData.getDataset("dsImg");
        FileOutputStream out = null;
        BufferedOutputStream bufferedOut = null;
        String fileName = dataset.getColumn(0, "EMP_FILE_NAME").getString();
        try {
            if (fileName != null) {

                out = new FileOutputStream("D:\\PROJECTMUL\\HZLogi\\src\\main\\webapp\\Photos\\empPhoto\\" + fileName);//사진저장 경로
                byte[] file = dataset.getColumnAsByteArray(0, "IMG_FILE_DATA");
                bufferedOut = new BufferedOutputStream(out);
                bufferedOut.write(file);
                bufferedOut.flush();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bufferedOut.close();
                out.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
