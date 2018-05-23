package ru.ajana.stock.view.exception;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Поставщик для перехвата исключений WebApplicationException.
 *
 * @author Andrey Kharintsev on 16.04.2018
 */
@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

  public WebApplicationExceptionMapper() {
  }

  @Override
  public Response toResponse(WebApplicationException ex) {
    final int status = ex.getResponse().getStatus();
    final String message = ex.getMessage();
    ResponseError responseError = new ResponseError();
    responseError.setId(String.valueOf(status));
    responseError.setMessage(message);

    if (ex instanceof ClientErrorException) {
      // Обработка ошибок запроса клиента
      if (ex instanceof NotFoundException) {
        responseError.setId(String.valueOf(Status.NOT_FOUND.getStatusCode()));
        responseError.setMessage("Ошибка клиента: объекта не найден");
      }
    }
    if (ex instanceof ServerErrorException) {
      // Обработка ошибок сервера
      if (ex instanceof InternalServerErrorException) {
        responseError.setMessage("Ошибка сервера: " + ex.getMessage());
      }
      if (ex instanceof ServiceUnavailableException) {
        responseError.setMessage("Сервис не доступен: " + ex.getMessage());
      }
    }
    return Response.status(status).entity(responseError)
        .type(MediaType.APPLICATION_JSON).build();
  }
}
