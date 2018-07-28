package ru.ajana.stock.core.service;

import java.util.List;
import javax.ejb.Local;
import ru.ajana.stock.model.ProductStatus;
import ru.ajana.stock.model.Tog;

/**
 * Интерфейс EJB-сервиса для работы с одеждой.
 *
 * @author Andrey Kharintsev on 13.04.2018
 */
@Local
public interface TogService {

  /**
   * Изменяет статус продукта на новый.
   *
   * @param togProduct продукт одежда
   * @param newStatus новый статус продукта
   * @return продукт с изменённым статусом
   */
  Tog changeTogStatus(Tog togProduct, ProductStatus newStatus);

  Tog saveTog(Tog tog);

  List<Tog> getAllTogs();

  Tog getTog(Long id);

  void deleteTog(Long id);
}
