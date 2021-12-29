package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.BikePlanProcess} entity.
 */
public class BikePlanProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private BikePlanDTO bikePlan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public BikePlanDTO getBikePlan() {
        return bikePlan;
    }

    public void setBikePlan(BikePlanDTO bikePlan) {
        this.bikePlan = bikePlan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BikePlanProcessDTO)) {
            return false;
        }

        BikePlanProcessDTO bikePlanProcessDTO = (BikePlanProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, bikePlanProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BikePlanProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", bikePlan=" + getBikePlan() +
            "}";
    }
}
