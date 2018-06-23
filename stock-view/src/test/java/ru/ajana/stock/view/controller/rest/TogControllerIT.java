package ru.ajana.stock.view.controller.rest;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ajana.stok.model.Tog;

/**
 * Интеграционный тест контроллера одежды магазина.
 *
 * @author Andrey Kharintsev on 16.04.2018
 */
public class TogControllerIT {

  private static final Logger LOG = LoggerFactory.getLogger(TogControllerIT.class);
  private static URI uri = UriBuilder.
      fromUri("http://localhost/stock-view/service/rest/togs").port(8080).build();
  private static Client client = ClientBuilder.newBuilder()
      .register(JacksonJsonProvider.class)
      .build();

  @Before
  public void setUp() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  @Test
  public void testInvalidTog() {
    Tog expectedTog = ProductGenerator.createProduct();
    expectedTog.setName(null);
    expectedTog.setSize(null);
    // Посылаем продукт методом POST
    Response response = client.target(uri)
        .path("/validate")
        .request(MediaType.APPLICATION_JSON)
        .header("Accept-Language", "ru")
        .post(Entity.entity(expectedTog, MediaType.APPLICATION_JSON));
    response.bufferEntity();
    logResponse("testInvalidTog", response);
    assertEquals(Status.BAD_REQUEST, response.getStatusInfo());
  }

  @Test
  public void shouldNotCreateANullTog() {
    // Отправка нулевого продукта методом POST
    Response response = client.target(uri).request().post(Entity.entity(null,
        MediaType.APPLICATION_JSON));
    assertEquals(Response.Status.BAD_REQUEST, response.getStatusInfo());
  }

  @Test
  public void shouldNotFindTheBookID() {
    // Получение продукта с неизвестным ID методом GET
    Response response1 = client.target(uri).path("unknownId").request().get();
    assertEquals(Response.Status.NOT_FOUND, response1.getStatusInfo());

    // Получение продукта с неизвестным ID методом GET
    Response response2 = client.target(uri).path("-1").request().get();
    assertEquals(Response.Status.NOT_FOUND, response2.getStatusInfo());
  }

  @Test
  public void shouldCreateAndDeleteTog() {
    Tog expectedTog = ProductGenerator.createProduct();
    // Посылаем продукт методом POST
    Response response = client.target(uri)
        .request()
        .post(Entity.entity(expectedTog,
            MediaType.APPLICATION_JSON));

    assertEquals(Response.Status.CREATED, response.getStatusInfo());
    URI togURI = response.getLocation();

    // Имея местоположнение, получаем одежду методом GET
    response = client.target(togURI).request().get();

    Tog actualTog = response.readEntity(Tog.class);
    assertEquals(Response.Status.OK, response.getStatusInfo());
    assertEquals(expectedTog.getName(), actualTog.getName());
    // Получаем id одежды и удаляем ее методом DELETE
    String bookId = togURI.toString().split("/")[6];
    response = client.target(uri).path(bookId).request().delete();
    assertEquals(Response.Status.NO_CONTENT, response.getStatusInfo());
    // Методом GET получаем одежду Tog и проверяем, была ли она удалена
    response = client.target(togURI).request().get();
    assertEquals(Response.Status.NOT_FOUND, response.getStatusInfo());
  }

  private void logResponse(String method, Response response) {
    final StringBuilder builder = new StringBuilder(method).append("\n");
    builder.append("Response: ").append(response).append("\n");
    builder.append("Entity: ").append(response.readEntity(String.class)).append("\n");
    LOG.info(builder.toString());
  }
}