package ru.ajana.stock.core.mapper;

import ru.ajana.stock.jpa.entities.ProductEntity;
import ru.ajana.stock.jpa.entities.TogProductEntity;
import ru.ajana.stock.model.Color;
import ru.ajana.stock.model.ProductStatus;
import ru.ajana.stock.model.ProductType;
import ru.ajana.stock.model.Tog;
import ru.ajana.stock.model.TogKing;

/**
 * Маппер для одежды магазина.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
public class TogMapper implements ToMapper<TogProductEntity, Tog>,
    FromMapper<Tog, TogProductEntity> {

  private static final ColorMapper COLOR_MAPPER = new ColorMapper();
  private static final TogKingMapper TOG_KING_MAPPER = new TogKingMapper();
  private static final ProductTypeMapper PRODUCT_TYPE_MAPPER = new ProductTypeMapper();
  private static final ProductStatusMapper PRODUCT_STATUS_MAPPER = new ProductStatusMapper();


  @Override
  public Tog mapTo(TogProductEntity entity) {
    if (entity == null) {
      return null;
    }
    ProductEntity productEntity = entity.getProduct();
    Tog tog = new Tog();
    tog.setId(productEntity.getId());
    tog.setName(productEntity.getName());
    tog.setPrice(productEntity.getPrice());
    tog.setDescription(productEntity.getDescription());
    // Тип продукта
    ProductType type = PRODUCT_TYPE_MAPPER.mapTo(productEntity.getType());
    tog.setProductType(type);
    // Статус продукта
    ProductStatus status = PRODUCT_STATUS_MAPPER.mapTo(productEntity.getStatus());
    tog.setStatus(status);
    // Вид одежды
    TogKing togKing = TOG_KING_MAPPER.mapTo(entity.getTogKing());
    tog.setKind(togKing);
    // Цвет одежды
    Color color = COLOR_MAPPER.mapTo(entity.getColor());
    tog.setColor(color);
    tog.setSize(entity.getSize());
    return tog;
  }

  @Override
  public TogProductEntity mapFrom(Tog object) {
    if (object == null) {
      return null;
    }
    TogProductEntity entity = new TogProductEntity();
    entity.setId(object.getId());
    entity.setSize(object.getSize());
    entity.setColorId(object.getColor().getId());
    entity.setKindId(object.getKind().getId());
    return entity;
  }
}
