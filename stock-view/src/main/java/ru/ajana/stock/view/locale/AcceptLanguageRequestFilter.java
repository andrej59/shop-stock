package ru.ajana.stock.view.locale;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

/**
 * Проверяет существует ли {@code Accept-Language} HTTP заголовк и создаёт {@link ThreadLocal}
 * соответсвующую локаль.
 *
 * @author Andrey Kharintsev on 23.06.2018
 */
@Provider
public class AcceptLanguageRequestFilter implements ContainerRequestFilter {

  @Context
  private HttpHeaders headers;

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    if (!headers.getAcceptableLanguages().isEmpty()) {
      LocaleThreadLocal.set(headers.getAcceptableLanguages().get(0));
    }
  }
}
