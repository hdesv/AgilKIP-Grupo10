package com.mycompany.myapp.process.bikePlanProcess;

import com.mycompany.myapp.domain.BikePlan;
import com.mycompany.myapp.domain.BikePlanProcess;
import com.mycompany.myapp.service.dto.BikePlanDTO;
import com.mycompany.myapp.service.dto.BikePlanProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface TaskTourMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    BikePlanProcessDTO toBikePlanProcessDTO(BikePlanProcess bikePlanProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "experience", source = "experience")
    @Mapping(target = "nameClient", source = "nameClient")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "tourNumber", source = "tourNumber")
    @Mapping(target = "tourCity", source = "tourCity")
    BikePlanDTO toBikePlanDTO(BikePlan bikePlan);
}
