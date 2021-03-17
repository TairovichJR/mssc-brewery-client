package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerId() {
        BeerDto dto = client.getBeerId(UUID.randomUUID());
        assertEquals("Pale Ale", dto.getBeerStyle());
        assertEquals("Galaxy Cat", dto.getBeerName());
        assertEquals(1234L, dto.getUpc());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {

        BeerDto beerDto = BeerDto.builder().beerName("New Beer").upc(11111L).build();
        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(beerDto);
        System.out.println(uri.toString());
    }

    @Test
    void updateBeer() {

        BeerDto beerDto = BeerDto.builder().beerName("New Beer").upc(11111L).build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }
}