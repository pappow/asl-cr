package com.asl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asl.entity.Zbusiness;

/**
 * @author Zubayer Ahamed
 * @since Dec 30, 2020
 */
@Repository
public interface BusinessRepository extends JpaRepository<Zbusiness, Integer> {

}
