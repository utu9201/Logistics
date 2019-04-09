package net.plang.base.controller;

import net.plang.base.sf.MailServiceFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/mail.do")
public class MailController extends MultiActionController {
    private MailServiceFacade mailServiceFacade;

    @RequestMapping(method = RequestMethod.GET)
    protected ModelAndView sendContractReport(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        String contractNo = httpServletRequest.getParameter("contractNo");
        mailServiceFacade.sendContractReport(contractNo);

        return null;
    }

    public void setMailServiceFacade(MailServiceFacade mailServiceFacade) {
        this.mailServiceFacade = mailServiceFacade;
    }
}
