package ru.ajana.stock.core.mapper;

import ru.ajana.stock.jpa.entities.nsi.SpProductStatusEntity;
import ru.ajana.stock.model.ProductStatus;

/**
 * Маппер статуса продукта.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
public class ProductStatusMapper implements ToMapper<SpProductStatusEntity, ProductStatus> {

  @Override
  public ProductStatus mapTo(SpProductStatusEntity entity) {
    if (entity == null) {
      return null;
    }
    ProductStatus productStatus = new ProductStatus();
    productStatus.setId(entity.getId());
    productStatus.setName(entity.getName());
    productStatus.setIdent(entity.getCode());
    return productStatus;
  }
}
