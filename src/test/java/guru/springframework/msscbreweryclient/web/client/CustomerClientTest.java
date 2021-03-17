package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void getCustomerById() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
        System.out.println(customerDto.getName());
        System.out.println(customerDto.getCustomerId());
    }

    @Test
    void saveNewCustomer() {
        CustomerDto dto = CustomerDto.builder().customerId(UUID.randomUUID()).name("Jack Reacher").build();
        URI uri = client.saveNewCustomer(dto);
        assertNotNull(dto);
        System.out.println(uri.toString());
    }

    @Test
    void updateCustomer() {
        CustomerDto dto = CustomerDto.builder().customerId(UUID.randomUUID()).name("Jack Reacher").build();
        client.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}