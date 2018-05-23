package ru.ajana.stock.core.mapper;

/**
 * Интерфейс маррера Entity-сущностей на POJO-объекты
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
@FunctionalInterface
public interface ToMapper<S, T> {

  T mapTo(S entity);
}
