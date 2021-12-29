package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.BikePlanDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link BikePlan} and its DTO {@link BikePlanDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BikePlanMapper extends EntityMapper<BikePlanDTO, BikePlan> {}
