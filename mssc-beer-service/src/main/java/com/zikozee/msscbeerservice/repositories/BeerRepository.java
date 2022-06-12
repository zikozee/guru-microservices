package com.zikozee.msscbeerservice.repositories;

import com.zikozee.msscbeerservice.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author: Ezekiel Eromosei
 * @created: 14 May 2022
 */

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
