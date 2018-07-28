package ru.ajana.stock.view.controller.rest;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URL;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.ajana.stock.AbstractIntegrationTest;
import ru.ajana.stock.model.Tog;

/**
 * Интеграционный тест контроллера одежды магазина.
 *
 * @author Andrey Kharintsev on 16.04.2018
 */
@RunWith(Arquillian.class)
public class TogControllerIT extends AbstractIntegrationTest {

  @Override
  protected String getBaseURI() {
    return super.getBaseURI() + "/togs";
  }

  @Test
  @RunAsClient
  public void testInvalidTog() {
    LOG.info("BaseURI: " + getBaseURI());
    Tog expectedTog = ProductGenerator.createProduct();
    expectedTog.setName(null);
    //expectedTog.setSize(null);
    // Посылаем продукт методом POST
    Response response = client.target(getBaseURI())
        .path("/validate")
        .request(MediaType.APPLICATION_JSON)
        //.header("Accept-Language", "en")
        .post(Entity.entity(expectedTog, MediaType.APPLICATION_JSON));
    response.bufferEntity();
    logResponse("testInvalidTog", response);
    assertEquals(Status.BAD_REQUEST, response.getStatusInfo());
  }

  @Test
  @RunAsClient
  public void shouldNotCreateANullTog(@ArquillianResource URL baseURL) {
    // Отправка нулевого продукта методом POST
    Response response = client.target(getBaseURI()).request().post(Entity.entity(null,
        MediaType.APPLICATION_JSON));
    assertEquals(Response.Status.BAD_REQUEST, response.getStatusInfo());
  }

  @Test
  @RunAsClient
  public void shouldNotFindTheBookID(@ArquillianResource URL baseURL) {
    String uri = getBaseURI();
    // Получение продукта с неизвестным ID методом GET
    Response response1 = client.target(uri).path("unknownId").request().get();
    assertEquals(Response.Status.NOT_FOUND, response1.getStatusInfo());

    // Получение продукта с неизвестным ID методом GET
    Response response2 = client.target(uri).path("-1").request().get();
    assertEquals(Response.Status.NOT_FOUND, response2.getStatusInfo());
  }

  @Test
  @RunAsClient
  public void shouldCreateAndDeleteTog(@ArquillianResource URL baseURL) {
    String uri = getBaseURI();
    LOG.debug("BaseURI: {}", uri);
    Tog expectedTog = ProductGenerator.createProduct();
    // Посылаем продукт методом POST
    Response response = client.target(uri)
        .request()
        .post(Entity.entity(expectedTog,
            MediaType.APPLICATION_JSON));
    assertEquals(Response.Status.CREATED, response.getStatusInfo());
    URI togURI = response.getLocation();
    LOG.debug("togURI: {}", togURI);

    // Имея местоположнение, получаем одежду методом GET
    response = client.target(togURI).request().get();
    Tog actualTog = response.readEntity(Tog.class);
    assertEquals(Response.Status.OK, response.getStatusInfo());
    assertEquals(expectedTog.getName(), actualTog.getName());

    // Получаем id одежды и удаляем ее методом DELETE
    String bookId = String.valueOf(actualTog.getId());
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