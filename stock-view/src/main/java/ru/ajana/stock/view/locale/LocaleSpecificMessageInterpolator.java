package ru.ajana.stock.view.locale;

import java.util.Locale;
import javax.validation.MessageInterpolator;

/**
 * Делигирует реализацию {@link MessageInterpolator}, но применяет данную локаль.
 *
 * @author Andrey Kharintsev on 23.06.2018
 */
public class LocaleSpecificMessageInterpolator implements MessageInterpolator {

  private final MessageInterpolator defaultInterpolator;

  public LocaleSpecificMessageInterpolator(MessageInterpolator interpolator) {
    this.defaultInterpolator = interpolator;
  }

  @Override
  public String interpolate(String message, Context context) {
    return defaultInterpolator.interpolate(message, context, LocaleThreadLocal.get());
  }

  @Override
  public String interpolate(String message, Context context, Locale locale) {
    return defaultInterpolator.interpolate(message, context, locale);
  }
}
