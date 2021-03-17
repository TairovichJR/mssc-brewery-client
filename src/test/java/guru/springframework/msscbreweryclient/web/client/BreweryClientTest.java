package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}