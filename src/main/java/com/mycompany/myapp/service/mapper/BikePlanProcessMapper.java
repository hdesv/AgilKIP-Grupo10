package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.BikePlanProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link BikePlanProcess} and its DTO {@link BikePlanProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, BikePlanMapper.class })
public interface BikePlanProcessMapper extends EntityMapper<BikePlanProcessDTO, BikePlanProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "bikePlan", source = "bikePlan")
    BikePlanProcessDTO toDto(BikePlanProcess s);
}
