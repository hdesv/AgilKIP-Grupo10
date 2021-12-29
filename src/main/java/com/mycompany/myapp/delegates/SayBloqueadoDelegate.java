package com.mycompany.myapp.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.service.dto.BikePlanProcessDTO;

@Component
public class SayBloqueadoDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
       
        BikePlanProcessDTO pi = (BikePlanProcessDTO) delegateExecution.getVariable("pi");
        Integer bikeNumber = pi.getBikePlan().getBikeNumber();

        System.out.println("============================================");
        System.out.println("================" + bikeNumber);
        System.out.println("============Bike Reservada==================");
        System.out.println("============================================");
    }
}