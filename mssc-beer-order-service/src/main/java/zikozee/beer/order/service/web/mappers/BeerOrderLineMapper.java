package zikozee.beer.order.service.web.mappers;

import zikozee.beer.order.service.domain.BeerOrderLine;
import zikozee.beer.order.service.web.model.BeerOrderLineDto;
import org.mapstruct.Mapper;


/**
 * @author: Ezekiel Eromosei
 * @created: 12 June 2022
 */
@Mapper(uses = {DateMapper.class})
public interface BeerOrderLineMapper {
    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}
