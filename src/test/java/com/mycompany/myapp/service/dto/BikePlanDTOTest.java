package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class BikePlanDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BikePlanDTO.class);
        BikePlanDTO bikePlanDTO1 = new BikePlanDTO();
        bikePlanDTO1.setId(1L);
        BikePlanDTO bikePlanDTO2 = new BikePlanDTO();
        assertThat(bikePlanDTO1).isNotEqualTo(bikePlanDTO2);
        bikePlanDTO2.setId(bikePlanDTO1.getId());
        assertThat(bikePlanDTO1).isEqualTo(bikePlanDTO2);
        bikePlanDTO2.setId(2L);
        assertThat(bikePlanDTO1).isNotEqualTo(bikePlanDTO2);
        bikePlanDTO1.setId(null);
        assertThat(bikePlanDTO1).isNotEqualTo(bikePlanDTO2);
    }
}
