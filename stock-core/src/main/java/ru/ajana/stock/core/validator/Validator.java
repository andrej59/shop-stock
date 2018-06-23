package ru.ajana.stock.core.validator;

/**
 * Интерфейс валидатора.
 *
 * @author Andrey Kharintsev on 25.05.2018
 */
public interface Validator<T> {
  boolean validate(T model);
}
