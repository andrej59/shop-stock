package ru.ajana.stock.core.mapper;

import ru.ajana.stock.jpa.entities.nsi.SpColorEntity;
import ru.ajana.stock.model.Color;

/**
 * Маппнг для справочника цвета.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
public class ColorMapper implements ToMapper<SpColorEntity, Color> {

  @Override
  public Color mapTo(SpColorEntity entity) {
    if (entity == null) {
      return null;
    }
    Color color = new Color();
    color.setId(entity.getId());
    color.setName(entity.getName());
    color.setCode(entity.getCode());
    return color;
  }
}
