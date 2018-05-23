package ru.ajana.stock.core.mapper;

import ru.ajana.stock.jpa.entities.ProductEntity;
import ru.ajana.stok.model.Product;

/**
 * Маппер продукта магазина.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
public class ProductMapper implements ToMapper<ProductEntity, Product>,
    FromMapper<Product, ProductEntity> {

  @Override
  public Product mapTo(ProductEntity entity) {
    if (entity == null) {
      return null;
    }
    Product product = new Product();
    product.setId(entity.getId());
    product.setName(entity.getName());
    product.setPrice(entity.getPrice());
    product.setDescription(entity.getDescription());
    return product;
  }

  @Override
  public ProductEntity mapFrom(Product object) {
    if (object == null) {
      return null;
    }
    ProductEntity entity = new ProductEntity();
    entity.setId(object.getId());
    entity.setName(object.getName());
    entity.setPrice(object.getPrice());
    entity.setDescription(object.getDescription());
    entity.setStatusId(object.getStatus().getId());
    entity.setTypeId(object.getProductType().getId());
    return entity;
  }
}
