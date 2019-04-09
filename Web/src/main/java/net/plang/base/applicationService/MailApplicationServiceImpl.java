package net.plang.base.applicationService;

import net.plang.base.dao.ReportDAO;
import net.plang.base.to.ContractReportTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.InputStream;
import java.util.List;


public class MailApplicationServiceImpl implements MailApplicationServce {
    private JavaMailSender javaMailSender;
    private ReportDAO reportDAO;

    @Override
    public void sendContractReport(String contractNo) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            InputStream jrxmlStream = this.getClass().getResourceAsStream("/pdfTemplate/Contract.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(jrxmlStream);

            List<ContractReportTO> contractReport = reportDAO.getContractReport(contractNo);

            System.out.println(contractReport.size());
            JRDataSource jrDataSource = new JRBeanCollectionDataSource(contractReport);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "D:/projectmul/HZLogi/exportContract.pdf");


            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            mimeMessageHelper.setFrom("mailtester1029@gmail.com");
            mimeMessageHelper.setTo("utu9201@naver.com");
            mimeMessageHelper.setSubject("Spring + Javax.Mail Test");
            mimeMessageHelper.setText("Spring + Javax.Mail Test Text");

            FileSystemResource fileSystemResource = new FileSystemResource(new File("D:/projectmul/HZLogi/exportContract.pdf"));
            mimeMessageHelper.addAttachment("contract.pdf", fileSystemResource);
//            mimeMessage.setFileName();

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void setReportDAO(ReportDAO reportDAO) {
        this.reportDAO = reportDAO;
    }
}
