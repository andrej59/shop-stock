package ru.ajana.stock.view.exception.mapper;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import ru.ajana.stock.view.exception.ResponseError;

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
      ClientErrorException clientException = (ClientErrorException) ex;
      if (ex instanceof BadRequestException) {
        responseError.setMessage("Ошибка клиента: не верный запрос");
      }
      // Обработка ошибок запроса клиента
      if (ex instanceof NotFoundException) {
        responseError.setMessage(ex.getMessage());
      }
    }
    if (ex instanceof ServerErrorException) {
      ClientErrorException serverException = (ClientErrorException) ex;
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
