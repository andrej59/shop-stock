package ru.ajana.stock.core.mapper;

import ru.ajana.stock.jpa.entities.nsi.SpTogKindEntity;
import ru.ajana.stok.model.TogKing;

/**
 * Маппер вида одежды магазина.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
public class TogKingMapper implements ToMapper<SpTogKindEntity, TogKing> {

  @Override
  public TogKing mapTo(SpTogKindEntity entity) {
    if (entity == null) {
      return null;
    }
    TogKing togKing = new TogKing();
    togKing.setId(entity.getId());
    togKing.setName(entity.getName());
    return togKing;
  }
}
