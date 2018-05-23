package ru.ajana.stock.core.mapper;

/**
 * Интерфейс маррера POJO-объекта на Entity-сущность.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
@FunctionalInterface
public interface FromMapper<S, T> {

  T mapFrom(S object);
}
