package ru.ajana.stock.view.controller.rest;

import java.math.BigDecimal;
import ru.ajana.stock.model.Color;
import ru.ajana.stock.model.ColorEnums;
import ru.ajana.stock.model.ProductStatus;
import ru.ajana.stock.model.ProductStatusEnums;
import ru.ajana.stock.model.ProductType;
import ru.ajana.stock.model.ProductTypeEnums;
import ru.ajana.stock.model.Tog;
import ru.ajana.stock.model.TogKing;
import ru.ajana.stock.model.TogKingEnums;

/**
 * Генератор объектов продукта для тестирования.
 *
 * @author Andrey Kharintsev on 26.04.2018
 */
public class ProductGenerator {

  public static Tog createProduct() {
    Tog tog = new Tog();
    tog.setName("Летнее платье");
    tog.setPrice(BigDecimal.valueOf(3500.15));
    tog.setSize(42);
    tog.setDescription("Описание одежды");
    // Тип продукта
    ProductType productType = new ProductType();
    productType.setId(ProductTypeEnums.TOG.getId().longValue());
    productType.setName(ProductTypeEnums.TOG.getValue());
    tog.setProductType(productType);
    // Цвет
    Color color = new Color();
    color.setId(ColorEnums.WHITE.getId().longValue());
    color.setName(ColorEnums.WHITE.getValue());
    color.setCode(ColorEnums.WHITE.name());
    tog.setColor(color);
    // Вид одежды
    TogKing togKing = new TogKing();
    togKing.setId(TogKingEnums.DRESS.getId().longValue());
    togKing.setName(TogKingEnums.DRESS.getValue());
    tog.setKind(togKing);
    // Статус продукта
    ProductStatus status = new ProductStatus();
    status.setId(ProductStatusEnums.SHOP.getId().longValue());
    status.setName(ProductStatusEnums.SHOP.getValue());
    status.setIdent(ProductStatusEnums.SHOP.name());
    tog.setStatus(status);
    return tog;
  }
}
