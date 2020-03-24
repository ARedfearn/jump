package jump;

import static jump.fixture.PlanetFixture.*;
import static org.junit.jupiter.api.Assertions.*;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class PlanetControllerSpec {
  @Inject
  EmbeddedServer server;

  @Inject
  @Client("/")
  HttpClient client;

  @Test
  void shouldAddSinglePlanet() {
    String response = client.toBlocking()
      .retrieve(HttpRequest.PUT("planet", PUT_PLANET));

    assertEquals(PUT_PLANET_RESPONSE, response);
  }

  @Test
  void shouldGetAllPlanets() {
    client.toBlocking()
      .retrieve(HttpRequest.PUT("planet", PUT_PLANET));

    String response = client.toBlocking()
      .retrieve(HttpRequest.GET("planet"));

    assertTrue(response.contains("Pluto"));
  }

}
