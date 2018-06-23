package ru.ajana.stock.view;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import ru.ajana.stock.view.controller.rest.TogController;
import ru.ajana.stock.view.exception.mapper.DebugValidationExceptionMapper;
import ru.ajana.stock.view.locale.AcceptLanguageRequestFilter;

/**
 * Конфигурация REST-сервисов.
 *
 * @author Andrey Kharintsev on 13.04.2018
 */
@ApplicationPath("service/rest")
public class ApplicationConfig extends Application {

  private final Set<Class<?>> classes;

  public ApplicationConfig() {
    HashSet<Class<?>> c = new HashSet<>();
    c.add(TogController.class);
    c.add(AcceptLanguageRequestFilter.class);
    c.add(ValidationConfigurationContextResolver.class);
    c.add(DebugValidationExceptionMapper.class);
    //c.add(GeneralValidatorCDI.class);
    //c.add(ValidationExceptionMapper.class);
    //c.add(WebApplicationExceptionMapper.class);
    //c.add(ValidationExceptionMapper.class);
    //c.add(MOXyJsonProvider.class);
    classes = Collections.unmodifiableSet(c);
  }

  @Override
  public Set<Object> getSingletons() {
    HashSet<Object> c = new HashSet<>();
    JacksonJsonProvider provider = new JacksonJsonProvider();
    provider.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    c.add(provider);
    return Collections.unmodifiableSet(c);
  }

  @Override
  public Set<Class<?>> getClasses() {
    return classes;
  }
}
