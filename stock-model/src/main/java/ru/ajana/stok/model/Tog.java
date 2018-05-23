package ru.ajana.stok.model;

/**
 * Одежда магазина.
 *
 * @author Andrey Kharintsev on 11.04.2018
 */
public class Tog extends Product {

  private Color color;
  private Integer size;
  private TogKing kind;

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public TogKing getKind() {
    return kind;
  }

  public void setKind(TogKing kind) {
    this.kind = kind;
  }
}
