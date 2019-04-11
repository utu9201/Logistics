package net.plang.hr.emp.controller;

import com.tobesoft.xplatform.data.DataSet;
import com.tobesoft.xplatform.data.PlatformData;
import lombok.Cleanup;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.hr.emp.sf.EmpServiceFacade;
import net.plang.hr.emp.to.EmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmpServiceFacade empServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/hr/getEmployeeList.do")
    public void getEmployeeList(@RequestAttribute("outData") PlatformData outData) throws Exception {
        List<EmployeeTO> employeeList = empServiceFacade.getEmployeeList();

        datasetBeanMapper.beansToDataset(outData, employeeList, EmployeeTO.class);
    }

    @RequestMapping("/hr/batchEmploayeeList.do")
    public void batchEmployeeList(@RequestAttribute("inData") PlatformData inData) throws Exception {
        List<EmployeeTO> employeeList = datasetBeanMapper.datasetToBeans(inData, EmployeeTO.class);

        empServiceFacade.batchEmployeeList(employeeList);
    }

    @RequestMapping("/hr/saveEmpImg.do")
    public void saveEmpImg(@RequestAttribute("inData") PlatformData inData) throws Exception {
        DataSet dataset = inData.getDataSet("dsImg");
        String fileName = dataset.getColumn("EMP_FILE_NAME").toString();

        //사진저장 경로
        @Cleanup FileOutputStream out = new FileOutputStream("D:\\PROJECTMUL\\HZLogi\\src\\main\\webapp\\Photos\\empPhoto\\" + fileName);
        @Cleanup BufferedOutputStream bufferedOut = new BufferedOutputStream(out);

        if (fileName != null) {
            byte[] file = dataset.getBlob(0, "IMG_FILE_DATA");
            bufferedOut.write(file);
            bufferedOut.flush();
        }
    }
}
