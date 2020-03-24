package jump;

import static jump.fixture.PlanetFixture.*;
import static org.junit.jupiter.api.Assertions.*;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class JumpControllerSpec {

  @Inject
  EmbeddedServer server;

  @Inject
  @Client("/")
  HttpClient client;

  @BeforeEach
  void addSinglePlanet() {
    client.toBlocking()
      .retrieve(HttpRequest.PUT("planet", PUT_PLANET));
  }

  @Test
  void shouldReturnPlanet() {
    String response = client.toBlocking()
      .retrieve(HttpRequest.GET("jump/Pluto"));

    assertTrue(response.contains("meters"));
  }


}
