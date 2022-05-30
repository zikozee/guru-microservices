package com.zikozee.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zikozee.msscbeerservice.services.BeerService;
import com.zikozee.msscbeerservice.web.model.BeerDto;
import com.zikozee.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static com.zikozee.msscbeerservice.bootstrap.BeerLoader.BEER_1_UPC;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class) // this does not bring up the entire context hence a mockbean
class BeerControllerTest {

    public static final String FORWARD_SLASH = "/";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    BeerService beerService;

    @Test
    void getBeerById() throws Exception {
        given(beerService.getById(any())).willReturn(getValidBeerDto());

        mockMvc.perform(get(FORWARD_SLASH + BeerController.BASE_URL + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception{
        BeerDto beerDto = getValidBeerDto();
        String beerDtoJson = mapper.writeValueAsString(beerDto);

        mockMvc.perform(post(FORWARD_SLASH + BeerController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());

    }

    @Test
    void updateBeerId() throws Exception {

        given(beerService.getById(any())).willReturn(getValidBeerDto());

        BeerDto beerDto = getValidBeerDto();
        String beerDtoJson = mapper.writeValueAsString(beerDto);

        mockMvc.perform(put(FORWARD_SLASH + BeerController.BASE_URL + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    BeerDto getValidBeerDto(){
        return BeerDto.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(BigDecimal.valueOf(2.99))
                .upc(BEER_1_UPC)
                .build();
    }
}