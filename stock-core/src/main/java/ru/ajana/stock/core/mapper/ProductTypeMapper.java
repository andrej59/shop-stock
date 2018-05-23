package ru.ajana.stock.core.mapper;

import ru.ajana.stock.jpa.entities.nsi.SpProductTypeEntity;
import ru.ajana.stok.model.ProductType;

/**
 * Маппер типа продукта.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
public class ProductTypeMapper implements ToMapper<SpProductTypeEntity, ProductType> {

  @Override
  public ProductType mapTo(SpProductTypeEntity entity) {
    if (entity == null) {
      return null;
    }
    ProductType productType = new ProductType();
    productType.setId(entity.getId());
    productType.setName(entity.getName());
    return productType;
  }
}
