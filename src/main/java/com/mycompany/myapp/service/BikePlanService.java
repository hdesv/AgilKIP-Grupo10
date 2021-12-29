package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.BikePlan;
import com.mycompany.myapp.repository.BikePlanRepository;
import com.mycompany.myapp.service.dto.BikePlanDTO;
import com.mycompany.myapp.service.mapper.BikePlanMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link BikePlan}.
 */
@Service
@Transactional
public class BikePlanService {

    private final Logger log = LoggerFactory.getLogger(BikePlanService.class);

    private final BikePlanRepository bikePlanRepository;

    private final BikePlanMapper bikePlanMapper;

    public BikePlanService(BikePlanRepository bikePlanRepository, BikePlanMapper bikePlanMapper) {
        this.bikePlanRepository = bikePlanRepository;
        this.bikePlanMapper = bikePlanMapper;
    }

    /**
     * Save a bikePlan.
     *
     * @param bikePlanDTO the entity to save.
     * @return the persisted entity.
     */
    public BikePlanDTO save(BikePlanDTO bikePlanDTO) {
        log.debug("Request to save BikePlan : {}", bikePlanDTO);
        BikePlan bikePlan = bikePlanMapper.toEntity(bikePlanDTO);
        bikePlan = bikePlanRepository.save(bikePlan);
        return bikePlanMapper.toDto(bikePlan);
    }

    /**
     * Partially update a bikePlan.
     *
     * @param bikePlanDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<BikePlanDTO> partialUpdate(BikePlanDTO bikePlanDTO) {
        log.debug("Request to partially update BikePlan : {}", bikePlanDTO);

        return bikePlanRepository
            .findById(bikePlanDTO.getId())
            .map(
                existingBikePlan -> {
                    bikePlanMapper.partialUpdate(existingBikePlan, bikePlanDTO);
                    return existingBikePlan;
                }
            )
            .map(bikePlanRepository::save)
            .map(bikePlanMapper::toDto);
    }

    /**
     * Get all the bikePlans.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<BikePlanDTO> findAll() {
        log.debug("Request to get all BikePlans");
        return bikePlanRepository.findAll().stream().map(bikePlanMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one bikePlan by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<BikePlanDTO> findOne(Long id) {
        log.debug("Request to get BikePlan : {}", id);
        return bikePlanRepository.findById(id).map(bikePlanMapper::toDto);
    }

    /**
     * Delete the bikePlan by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete BikePlan : {}", id);
        bikePlanRepository.deleteById(id);
    }
}
