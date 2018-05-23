package ru.ajana.stok.model;

/**
 * Перечисление цвета одежды.
 *
 * @author Andrey Kharintsev on 17.04.2018
 */

public enum ColorEnums {
  WHITE(1, "Белый"), BLUE(2, "Синий"), RED(3, "Красный"), GREEN(4, "Зелёный"), BLACK(5, "Чёрный");
  private Integer id;
  private String value;

  ColorEnums(Integer id, String value) {
    this.id = id;
    this.value = value;
  }

  public Integer getId() {
    return id;
  }

  public String getValue() {
    return value;
  }


  public static ColorEnums fromValue(String value) {
    for (ColorEnums color : values()) {
      if (color.value.equals(value)) {
        return color;
      }
    }
    throw new IllegalArgumentException();
  }
}
