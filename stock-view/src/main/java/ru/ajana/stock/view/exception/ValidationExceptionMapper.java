package ru.ajana.stock.view.exception;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Поставщик для перехвата исключений валидации клиентских запросов.
 *
 * @author Andrey Kharintsev on 20.05.2018
 */
@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

  @Override
  public Response toResponse(ValidationException exception) {
    return null;
  }
}
