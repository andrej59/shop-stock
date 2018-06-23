package ru.ajana.stock.view.locale;

import java.util.Locale;

/**
 * ThreadLocal для обработки {@code Accept-Language} HTTP заголовка, используется для определения
 * локали клиента.
 *
 * @author Andrey Kharintsev on 23.06.2018
 */
public class LocaleThreadLocal {

  public static final ThreadLocal<Locale> THREAD_LOCAL = new ThreadLocal<>();

  public static Locale get() {
    return (THREAD_LOCAL.get() == null) ? Locale.getDefault() : THREAD_LOCAL.get();
  }

  public static void set(Locale locale) {
    THREAD_LOCAL.set(locale);
  }

  public static void unset() {
    THREAD_LOCAL.remove();
  }
}
