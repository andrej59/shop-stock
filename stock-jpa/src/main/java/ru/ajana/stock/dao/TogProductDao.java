package ru.ajana.stock.dao;

import java.util.List;
import javax.ejb.Stateless;
import ru.ajana.stock.jpa.entities.ProductEntity;
import ru.ajana.stock.jpa.entities.TogProductEntity;

/**
 * DAO-компонент одежды магазина.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
@Stateless
public class TogProductDao extends AbstractDao {

  public TogProductEntity createTogProduct(TogProductEntity togProductEntity) {
    ProductEntity productEntity = togProductEntity.getProduct();
    em.persist(productEntity);
    togProductEntity.setId(productEntity.getId());
    em.persist(togProductEntity);
    return togProductEntity;
  }

  public TogProductEntity updateProduct(TogProductEntity togProductEntity) {
    em.merge(togProductEntity);
    return togProductEntity;
  }

  public List<TogProductEntity> findAllTogProducts() {
    return em.createNamedQuery(TogProductEntity.FIND_ALL, TogProductEntity.class).getResultList();
  }

  public TogProductEntity findById(Long id) {
    return em.find(TogProductEntity.class, id);
  }

  public void removeById(Long id) {
    TogProductEntity togProductEntity = em.find(TogProductEntity.class, id);
    em.remove(togProductEntity);
    em.remove(togProductEntity.getProduct());
  }
}
