package net.plang.base.sf;

import net.plang.base.applicationService.MailApplicationServce;
import org.springframework.stereotype.Service;

@Service
public class MailServiceFacadeImpl implements MailServiceFacade {
    private MailApplicationServce mailApplicationServce;

    @Override
    public void sendContractReport(String contractNo) {
        mailApplicationServce.sendContractReport(contractNo);
    }

    public void setMailApplicationService(MailApplicationServce mailApplicationService) {
        this.mailApplicationServce = mailApplicationService;
    }
}
