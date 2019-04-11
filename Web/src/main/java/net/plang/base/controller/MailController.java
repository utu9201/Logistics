package net.plang.base.controller;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.base.sf.MailServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController {
    @Autowired
    private MailServiceFacade mailServiceFacade;

    @RequestMapping("/base/sendContractReport.do")
    protected ModelAndView sendContractReport(@RequestAttribute("inData") PlatformData inData) throws Exception {

        String contractNo = inData.getVariable("contractNo").getString();
        mailServiceFacade.sendContractReport(contractNo);

        return null;
    }
}
