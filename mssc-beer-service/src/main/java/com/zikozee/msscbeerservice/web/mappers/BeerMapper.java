package com.zikozee.msscbeerservice.web.mappers;

import com.zikozee.msscbeerservice.domain.Beer;
import com.zikozee.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

import java.util.Date;

/**
 * @author: Ezekiel Eromosei
 * @created: 16 May 2022
 */

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
