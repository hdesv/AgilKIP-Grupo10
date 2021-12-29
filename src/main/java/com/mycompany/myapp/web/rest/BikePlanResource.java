package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.BikePlanRepository;
import com.mycompany.myapp.service.BikePlanService;
import com.mycompany.myapp.service.dto.BikePlanDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.BikePlan}.
 */
@RestController
@RequestMapping("/api")
public class BikePlanResource {

    private final Logger log = LoggerFactory.getLogger(BikePlanResource.class);

    private final BikePlanService bikePlanService;

    private final BikePlanRepository bikePlanRepository;

    public BikePlanResource(BikePlanService bikePlanService, BikePlanRepository bikePlanRepository) {
        this.bikePlanService = bikePlanService;
        this.bikePlanRepository = bikePlanRepository;
    }

    /**
     * {@code GET  /bike-plans} : get all the bikePlans.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bikePlans in body.
     */
    @GetMapping("/bike-plans")
    public List<BikePlanDTO> getAllBikePlans() {
        log.debug("REST request to get all BikePlans");
        return bikePlanService.findAll();
    }

    /**
     * {@code GET  /bike-plans/:id} : get the "id" bikePlan.
     *
     * @param id the id of the bikePlanDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bikePlanDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/bike-plans/{id}")
    public ResponseEntity<BikePlanDTO> getBikePlan(@PathVariable Long id) {
        log.debug("REST request to get BikePlan : {}", id);
        Optional<BikePlanDTO> bikePlanDTO = bikePlanService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bikePlanDTO);
    }
}
