package ru.ajana.stock.dao;

import java.util.List;
import javax.ejb.Stateless;

/**
 * DAO-компонент справочников магазина.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
@Stateless
public class NsiDao extends AbstractDao {

  public <T> List<T> findAll(Class<T> clazz) {
    try {
      String fieldValue = (String) clazz.getField("FIND_ALL").get(clazz);
      return em.createNamedQuery(fieldValue)
          .getResultList();
    } catch (IllegalAccessException | NoSuchFieldException e) {
      return null;
    }
  }

  public <T> T findById(Class<T> clazz, Long id) {
    return em.find(clazz, id);
  }
}
