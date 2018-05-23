package ru.ajana.stock.dao;

import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Абстрактный DAO-класс.
 *
 * @author Andrey Kharintsev on 13.04.2018
 */
@Local
public abstract class AbstractDao {

  @PersistenceContext(unitName = "stockPU")
  protected EntityManager em;

  public void flush() {
    em.flush();
  }
}
