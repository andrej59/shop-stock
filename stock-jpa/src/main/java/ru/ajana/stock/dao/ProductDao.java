package ru.ajana.stock.dao;

import java.util.List;
import javax.ejb.Stateless;
import ru.ajana.stock.jpa.entities.ProductEntity;

/**
 * DAO-компонент продукта магазина.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
@Stateless
public class ProductDao extends AbstractDao {

  public ProductEntity createProduct(ProductEntity productEntity) {
    em.persist(productEntity);
    return productEntity;
  }

  public ProductEntity updateProduct(ProductEntity productEntity) {
    em.merge(productEntity);
    return productEntity;
  }

  public List<ProductEntity> findAllProducts() {
    return em.createNamedQuery(ProductEntity.FIND_ALL, ProductEntity.class).getResultList();
  }

  public ProductEntity findById(Long id) {
    return em.find(ProductEntity.class, id);
  }
}
