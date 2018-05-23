package ru.ajana.stok.model;

/**
 * Перечисление типа продукта.
 *
 * @author Andrey Kharintsev on 17.04.2018
 */
public enum ProductTypeEnums {
  TOG(1, "Одежда");
  private Integer id;
  private String value;

  ProductTypeEnums(Integer id, String value) {
    this.id = id;
    this.value = value;
  }

  public Integer getId() {
    return id;
  }

  public String getValue() {
    return value;
  }


  public static ProductTypeEnums fromValue(String value) {
    for (ProductTypeEnums type : values()) {
      if (type.value.equals(value)) {
        return type;
      }
    }
    throw new IllegalArgumentException();
  }
}
