package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.BikePlan;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the BikePlan entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BikePlanRepository extends JpaRepository<BikePlan, Long> {}
