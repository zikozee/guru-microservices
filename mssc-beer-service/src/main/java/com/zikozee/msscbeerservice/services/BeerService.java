package com.zikozee.msscbeerservice.services;

import com.zikozee.msscbeerservice.domain.Beer;
import com.zikozee.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

/**
 * @author: Ezekiel Eromosei
 * @created: 30 May 2022
 */

public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
