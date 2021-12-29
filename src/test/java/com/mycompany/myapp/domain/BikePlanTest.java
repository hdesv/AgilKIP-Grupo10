package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class BikePlanTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BikePlan.class);
        BikePlan bikePlan1 = new BikePlan();
        bikePlan1.setId(1L);
        BikePlan bikePlan2 = new BikePlan();
        bikePlan2.setId(bikePlan1.getId());
        assertThat(bikePlan1).isEqualTo(bikePlan2);
        bikePlan2.setId(2L);
        assertThat(bikePlan1).isNotEqualTo(bikePlan2);
        bikePlan1.setId(null);
        assertThat(bikePlan1).isNotEqualTo(bikePlan2);
    }
}
