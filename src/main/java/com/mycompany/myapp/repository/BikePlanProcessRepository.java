package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.BikePlanProcess;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the BikePlanProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BikePlanProcessRepository extends JpaRepository<BikePlanProcess, Long> {
    Optional<BikePlanProcess> findByProcessInstanceId(Long processInstanceId);
}
