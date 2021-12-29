package com.mycompany.myapp.delegates;

import com.mycompany.myapp.service.MailService;
import com.mycompany.myapp.service.dto.BikePlanDTO;
import com.mycompany.myapp.service.dto.BikePlanProcessDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Locale;

@Component
public class EmailBikePlanSummaryDelegate implements JavaDelegate {

    @Autowired
    MailService mailService;

    @Autowired
    SpringTemplateEngine templateEngine;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        BikePlanProcessDTO bikePlanProcess = (BikePlanProcessDTO) delegateExecution.getVariable("processInstance");
        BikePlanDTO bikePlan = bikePlanProcess.getBikePlan();
        String to = bikePlan.getUserEmail();
        String subject = "[AgileKip] Summary of your experience " + bikePlan.getExperience();
        Context context = new Context(Locale.getDefault());
        context.setVariable("bikePlan", bikePlan);
        String content = templateEngine.process("bikePlanProcess/bikePlanSummaryUserEmail", context);
        mailService.sendEmail(to, subject, content, false, true);
    }
}