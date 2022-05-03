package com.zikozee.msscbeerservice.web.controller;

import com.zikozee.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author: Ezekiel Eromosei
 * @created: 03 May 2022
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/beer")
public class BeerController {

    @GetMapping(path = "{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){

        // TODO: 5/3/2022
        return  new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@RequestBody BeerDto beerDto){

        // TODO: 5/3/2022
        return  new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PutMapping(path = {"beerId"})
    public ResponseEntity updateBeerId(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto){

        // TODO: 5/3/2022  
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
