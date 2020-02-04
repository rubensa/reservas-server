package org.eu.rubensa.uniovi.reservas;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReservasServerApplicationTests {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void contextLoads() {
  }

  @Test
  public void getHome_ReturnsAppInfo() throws Exception {
    ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);

    Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    Assertions.assertThat(response.hasBody()).isTrue();
    Assertions.assertThat(response.getBody()).contains("reservas-server");
  }
}
