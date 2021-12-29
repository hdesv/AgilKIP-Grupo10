package com.mycompany.myapp.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.service.dto.BikePlanProcessDTO;

@Component
public class SayReservadoDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
       
        BikePlanProcessDTO pi = (BikePlanProcessDTO) delegateExecution.getVariable("pi");
        String nameClient = pi.getBikePlan().getNameClient();

        System.out.println("============================================");
        System.out.println("================" + nameClient);
        System.out.println("============Experiencia Reservada===========");
        System.out.println("============================================");
    }
}