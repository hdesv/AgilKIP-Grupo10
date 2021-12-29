package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.BikePlanProcess;
import com.mycompany.myapp.repository.BikePlanProcessRepository;
import com.mycompany.myapp.repository.BikePlanRepository;
import com.mycompany.myapp.service.dto.BikePlanProcessDTO;
import com.mycompany.myapp.service.mapper.BikePlanProcessMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link BikePlanProcess}.
 */
@Service
@Transactional
public class BikePlanProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "BikePlanProcess";

    private final Logger log = LoggerFactory.getLogger(BikePlanProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final BikePlanRepository bikePlanRepository;

    private final BikePlanProcessRepository bikePlanProcessRepository;

    private final BikePlanProcessMapper bikePlanProcessMapper;

    public BikePlanProcessService(
        ProcessInstanceService processInstanceService,
        BikePlanRepository bikePlanRepository,
        BikePlanProcessRepository bikePlanProcessRepository,
        BikePlanProcessMapper bikePlanProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.bikePlanRepository = bikePlanRepository;
        this.bikePlanProcessRepository = bikePlanProcessRepository;
        this.bikePlanProcessMapper = bikePlanProcessMapper;
    }

    /**
     * Save a bikePlanProcess.
     *
     * @param bikePlanProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public BikePlanProcessDTO create(BikePlanProcessDTO bikePlanProcessDTO) {
        log.debug("Request to save BikePlanProcess : {}", bikePlanProcessDTO);

        BikePlanProcess bikePlanProcess = bikePlanProcessMapper.toEntity(bikePlanProcessDTO);

        //Saving the domainEntity
        bikePlanRepository.save(bikePlanProcess.getBikePlan());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "BikePlan#" + bikePlanProcess.getBikePlan().getId(),
            bikePlanProcess
        );
        bikePlanProcess.setProcessInstance(processInstance);

        //Saving the process entity
        bikePlanProcess = bikePlanProcessRepository.save(bikePlanProcess);
        return bikePlanProcessMapper.toDto(bikePlanProcess);
    }

    /**
     * Get all the bikePlanProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<BikePlanProcessDTO> findAll() {
        log.debug("Request to get all BikePlanProcesss");
        return bikePlanProcessRepository
            .findAll()
            .stream()
            .map(bikePlanProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one bikePlanProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<BikePlanProcessDTO> findOne(Long id) {
        log.debug("Request to get BikePlanProcess : {}", id);
        return bikePlanProcessRepository.findById(id).map(bikePlanProcessMapper::toDto);
    }

    /**
     * Get one bikePlanProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<BikePlanProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get BikePlanProcess by  processInstanceId: {}", processInstanceId);
        return bikePlanProcessRepository.findByProcessInstanceId(processInstanceId).map(bikePlanProcessMapper::toDto);
    }
}
