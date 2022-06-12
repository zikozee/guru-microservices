package com.zikozee.msscbeerservice.web.controller;

import com.zikozee.msscbeerservice.services.BeerService;
import com.zikozee.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @author: Ezekiel Eromosei
 * @created: 03 May 2022
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(path = BeerController.BASE_URL)
public class BeerController {
    public static final String BASE_URL = "api/v1/beer/";

    private final BeerService beerService;

    @GetMapping(path = "{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){

        return  new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@RequestBody @Validated BeerDto beerDto){

        return  new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping(path = "{beerId}")
    public ResponseEntity<BeerDto> updateBeerId(@PathVariable("beerId") UUID beerId, @RequestBody  @Validated BeerDto beerDto){

        return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto),HttpStatus.NO_CONTENT);
    }
}
