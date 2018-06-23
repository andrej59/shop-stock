package ru.ajana.stock.view.exception.mapper;

import javax.validation.ValidationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import ru.ajana.stock.view.exception.ResponseError;

/**
 * Поставщик для перехвата исключений валидации клиентских запросов.
 *
 * @author Andrey Kharintsev on 20.05.2018
 */
@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

  @Override
  public Response toResponse(ValidationException exception) {
    ResponseError responseError = new ResponseError();
    responseError.setId(-1 + "");
    responseError.setMessage(exception.getMessage());
    return Response.status(Status.BAD_REQUEST).entity(responseError)
        .type(MediaType.APPLICATION_JSON).build();
  }
}
