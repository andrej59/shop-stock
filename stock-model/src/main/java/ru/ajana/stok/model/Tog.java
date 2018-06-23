package ru.ajana.stok.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Одежда магазина.
 *
 * @author Andrey Kharintsev on 11.04.2018
 */
public class Tog extends Product {

  @NotNull
  private Color color;
  @NotNull(message = "{tog.size.notnull}")
  private Integer size;
  @NotNull
  @Valid
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
