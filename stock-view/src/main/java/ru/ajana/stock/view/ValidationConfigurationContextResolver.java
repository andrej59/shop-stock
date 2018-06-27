package ru.ajana.stock.view;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import javax.validation.BootstrapConfiguration;
import javax.validation.Configuration;
import javax.validation.ParameterNameProvider;
import javax.validation.Validation;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.jboss.resteasy.plugins.validation.GeneralValidatorImpl;
import org.jboss.resteasy.spi.validation.GeneralValidator;
import ru.ajana.stock.view.locale.LocaleSpecificMessageInterpolator;

/**
 * Конфигурация валидатора учитывающего локаль клиента.
 *
 * @author Andrey Kharintsev on 14.06.2018
 */
@Provider
public class ValidationConfigurationContextResolver implements ContextResolver<GeneralValidator> {

  /**
   * Возвращает контекст типа {@code GeneralValidator}, который пименяется к предоставленному типу.
   *
   * @param type класс объекта для которого требуется контекст
   * @return контекст для предоставленного типа или {@code null} если контекст для  типа не доступен
   * от этого провайдера
   */
  @Override
  public GeneralValidator getContext(Class<?> type) {
    Configuration<?> config = Validation.byDefaultProvider().configure();
    BootstrapConfiguration bootstrapConfiguration = config.getBootstrapConfiguration();
    config.messageInterpolator(
        new LocaleSpecificMessageInterpolator(Validation.byDefaultProvider().configure()
            .getDefaultMessageInterpolator()));
    config.parameterNameProvider(new CustomParameterNameProvider());
    return new GeneralValidatorImpl(config.buildValidatorFactory(),
        bootstrapConfiguration.isExecutableValidationEnabled(),
        bootstrapConfiguration.getDefaultValidatedExecutableTypes());
  }

  /**
   * If method input parameters are invalid, this class returns actual parameter names instead of
   * the default ones ( {@code arg0, arg1, ...})
   */
  private class CustomParameterNameProvider implements ParameterNameProvider {

    private final ParameterNameProvider nameProvider;

    public CustomParameterNameProvider() {
      nameProvider = Validation.byDefaultProvider().configure().getDefaultParameterNameProvider();
    }

    @Override
    public List<String> getParameterNames(final Constructor<?> constructor) {
      return nameProvider.getParameterNames(constructor);
    }

    @Override
    public List<String> getParameterNames(final Method method) {
      if ("getPerson".equals(method.getName())) {
        return Arrays.asList("id");
      }
      if ("createPerson".equals(method.getName())) {
        return Arrays.asList("id", "name");
      }
      return nameProvider.getParameterNames(method);
    }
  }
}


