package ru.ajana.stok.model;

/**
 * Перечисление статуса продукта.
 *
 * @author Andrey Kharintsev on 17.04.2018
 */
public enum ProductStatusEnums {
  SHOP(1, "Магазин"), STOCK(2, "Склад");
  private Integer id;
  private String value;

  ProductStatusEnums(Integer id, String value) {
    this.id = id;
    this.value = value;
  }

  public Integer getId() {
    return id;
  }

  public String getValue() {
    return value;
  }

  public static ProductStatusEnums fromValue(String value) {
    for (ProductStatusEnums status : values()) {
      if (status.value.equals(value)) {
        return status;
      }
    }
    throw new IllegalArgumentException();
  }
}
