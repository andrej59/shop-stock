package ru.ajana.stok.model;

/**
 * Перечисление вида одежды.
 *
 * @author Andrey Kharintsev on 17.04.2018
 */
public enum TogKingEnums {
  DRESS(1, "Платье"), TROUSERS(2, "Брюки"), SKIRT(3, "Юбка"), VEST(4, "Жилетка"), SHIRT(5,
      "Рубашка");
  private Integer id;
  private String value;

  TogKingEnums(Integer id, String value) {
    this.id = id;
    this.value = value;
  }

  public Integer getId() {
    return id;
  }

  public String getValue() {
    return value;
  }

  public static TogKingEnums fromValue(String value) {
    for (TogKingEnums king : values()) {
      if (king.value.equals(value)) {
        return king;
      }
    }
    throw new IllegalArgumentException();
  }
}
