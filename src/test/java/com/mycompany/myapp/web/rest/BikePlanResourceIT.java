package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.BikePlan;
import com.mycompany.myapp.domain.enumeration.tourCity;
import com.mycompany.myapp.repository.BikePlanRepository;
import com.mycompany.myapp.service.dto.BikePlanDTO;
import com.mycompany.myapp.service.mapper.BikePlanMapper;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link BikePlanResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class BikePlanResourceIT {

    private static final String DEFAULT_EXPERIENCE = "AAAAAAAAAA";
    private static final String UPDATED_EXPERIENCE = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_CLIENT = "AAAAAAAAAA";
    private static final String UPDATED_NAME_CLIENT = "BBBBBBBBBB";

    private static final Integer DEFAULT_PHONE_NUMBER = 1;
    private static final Integer UPDATED_PHONE_NUMBER = 2;

    private static final String DEFAULT_USER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_USER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_USER_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_USER_EMAIL = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_START_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_START_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_BIKE_NUMBER = 1;
    private static final Integer UPDATED_BIKE_NUMBER = 2;

    private static final Integer DEFAULT_TOUR_NUMBER = 1;
    private static final Integer UPDATED_TOUR_NUMBER = 2;

    private static final tourCity DEFAULT_TOUR_CITY = tourCity.Lisboa;
    private static final tourCity UPDATED_TOUR_CITY = tourCity.Porto;

    private static final Integer DEFAULT_CLIENTE_NUMBER = 1;
    private static final Integer UPDATED_CLIENTE_NUMBER = 2;

    private static final String DEFAULT_WANT_TOUR = "AAAAAAAAAA";
    private static final String UPDATED_WANT_TOUR = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/bike-plans";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private BikePlanRepository bikePlanRepository;

    @Autowired
    private BikePlanMapper bikePlanMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restBikePlanMockMvc;

    private BikePlan bikePlan;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BikePlan createEntity(EntityManager em) {
        BikePlan bikePlan = new BikePlan()
            .experience(DEFAULT_EXPERIENCE)
            .nameClient(DEFAULT_NAME_CLIENT)
            .phoneNumber(DEFAULT_PHONE_NUMBER)
            .userName(DEFAULT_USER_NAME)
            .userEmail(DEFAULT_USER_EMAIL)
            .startDate(DEFAULT_START_DATE)
            .endDate(DEFAULT_END_DATE)
            .bikeNumber(DEFAULT_BIKE_NUMBER)
            .tourNumber(DEFAULT_TOUR_NUMBER)
            .tourCity(DEFAULT_TOUR_CITY)
            .clienteNumber(DEFAULT_CLIENTE_NUMBER)
            .wantTour(DEFAULT_WANT_TOUR);
        return bikePlan;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BikePlan createUpdatedEntity(EntityManager em) {
        BikePlan bikePlan = new BikePlan()
            .experience(UPDATED_EXPERIENCE)
            .nameClient(UPDATED_NAME_CLIENT)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .userName(UPDATED_USER_NAME)
            .userEmail(UPDATED_USER_EMAIL)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .bikeNumber(UPDATED_BIKE_NUMBER)
            .tourNumber(UPDATED_TOUR_NUMBER)
            .tourCity(UPDATED_TOUR_CITY)
            .clienteNumber(UPDATED_CLIENTE_NUMBER)
            .wantTour(UPDATED_WANT_TOUR);
        return bikePlan;
    }

    @BeforeEach
    public void initTest() {
        bikePlan = createEntity(em);
    }

    @Test
    @Transactional
    void getAllBikePlans() throws Exception {
        // Initialize the database
        bikePlanRepository.saveAndFlush(bikePlan);

        // Get all the bikePlanList
        restBikePlanMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bikePlan.getId().intValue())))
            .andExpect(jsonPath("$.[*].experience").value(hasItem(DEFAULT_EXPERIENCE)))
            .andExpect(jsonPath("$.[*].nameClient").value(hasItem(DEFAULT_NAME_CLIENT)))
            .andExpect(jsonPath("$.[*].phoneNumber").value(hasItem(DEFAULT_PHONE_NUMBER)))
            .andExpect(jsonPath("$.[*].userName").value(hasItem(DEFAULT_USER_NAME)))
            .andExpect(jsonPath("$.[*].userEmail").value(hasItem(DEFAULT_USER_EMAIL)))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].bikeNumber").value(hasItem(DEFAULT_BIKE_NUMBER)))
            .andExpect(jsonPath("$.[*].tourNumber").value(hasItem(DEFAULT_TOUR_NUMBER)))
            .andExpect(jsonPath("$.[*].tourCity").value(hasItem(DEFAULT_TOUR_CITY.toString())))
            .andExpect(jsonPath("$.[*].clienteNumber").value(hasItem(DEFAULT_CLIENTE_NUMBER)))
            .andExpect(jsonPath("$.[*].wantTour").value(hasItem(DEFAULT_WANT_TOUR)));
    }

    @Test
    @Transactional
    void getBikePlan() throws Exception {
        // Initialize the database
        bikePlanRepository.saveAndFlush(bikePlan);

        // Get the bikePlan
        restBikePlanMockMvc
            .perform(get(ENTITY_API_URL_ID, bikePlan.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(bikePlan.getId().intValue()))
            .andExpect(jsonPath("$.experience").value(DEFAULT_EXPERIENCE))
            .andExpect(jsonPath("$.nameClient").value(DEFAULT_NAME_CLIENT))
            .andExpect(jsonPath("$.phoneNumber").value(DEFAULT_PHONE_NUMBER))
            .andExpect(jsonPath("$.userName").value(DEFAULT_USER_NAME))
            .andExpect(jsonPath("$.userEmail").value(DEFAULT_USER_EMAIL))
            .andExpect(jsonPath("$.startDate").value(DEFAULT_START_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.bikeNumber").value(DEFAULT_BIKE_NUMBER))
            .andExpect(jsonPath("$.tourNumber").value(DEFAULT_TOUR_NUMBER))
            .andExpect(jsonPath("$.tourCity").value(DEFAULT_TOUR_CITY.toString()))
            .andExpect(jsonPath("$.clienteNumber").value(DEFAULT_CLIENTE_NUMBER))
            .andExpect(jsonPath("$.wantTour").value(DEFAULT_WANT_TOUR));
    }

    @Test
    @Transactional
    void getNonExistingBikePlan() throws Exception {
        // Get the bikePlan
        restBikePlanMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
