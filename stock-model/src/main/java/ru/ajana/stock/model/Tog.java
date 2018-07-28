package ru.ajana.stock.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

/**
 * Одежда магазина.
 *
 * @author Andrey Kharintsev on 11.04.2018
 */
public class Tog extends Product {

  @Range(min = 42, max = 52)
  @NotNull
  private Integer size;

  @NotNull
  @Valid
  private Color color;

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
