package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BikePlanMapperTest {

    private BikePlanMapper bikePlanMapper;

    @BeforeEach
    public void setUp() {
        bikePlanMapper = new BikePlanMapperImpl();
    }
}
