package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.BikePlanProcessService;
import com.mycompany.myapp.service.dto.BikePlanProcessDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.BikePlanProcess}.
 */
@RestController
@RequestMapping("/api")
public class BikePlanProcessResource {

    private final Logger log = LoggerFactory.getLogger(BikePlanProcessResource.class);

    private static final String ENTITY_NAME = "bikePlanProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BikePlanProcessService bikePlanProcessService;

    public BikePlanProcessResource(BikePlanProcessService bikePlanProcessService) {
        this.bikePlanProcessService = bikePlanProcessService;
    }

    /**
     * {@code POST  /bike-plan-processes} : Create a new bikePlanProcess.
     *
     * @param bikePlanProcessDTO the bikePlanProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new bikePlanProcessDTO, or with status {@code 400 (Bad Request)} if the bikePlanProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/bike-plan-processes")
    public ResponseEntity<BikePlanProcessDTO> create(@RequestBody BikePlanProcessDTO bikePlanProcessDTO) throws URISyntaxException {
        log.debug("REST request to save BikePlanProcess : {}", bikePlanProcessDTO);
        if (bikePlanProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new bikePlanProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BikePlanProcessDTO result = bikePlanProcessService.create(bikePlanProcessDTO);
        return ResponseEntity
            .created(new URI("/api/bike-plan-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /bike-plan-processes} : get all the bikePlanProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bikePlanProcesss in body.
     */
    @GetMapping("/bike-plan-processes")
    public List<BikePlanProcessDTO> getAllBikePlanProcesss() {
        log.debug("REST request to get all BikePlanProcesss");
        return bikePlanProcessService.findAll();
    }

    /**
     * {@code GET  /bike-plan-processes/:id} : get the "id" bikePlanProcess.
     *
     * @param processInstanceId the id of the bikePlanProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bikePlanProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/bike-plan-processes/{processInstanceId}")
    public ResponseEntity<BikePlanProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get BikePlanProcess by processInstanceId : {}", processInstanceId);
        Optional<BikePlanProcessDTO> bikePlanProcessDTO = bikePlanProcessService.findByProcessInstanceId(processInstanceId);
        return ResponseUtil.wrapOrNotFound(bikePlanProcessDTO);
    }
}
