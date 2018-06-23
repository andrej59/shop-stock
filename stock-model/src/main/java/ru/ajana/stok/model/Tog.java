package ru.ajana.stok.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

/**
 * Одежда магазина.
 *
 * @author Andrey Kharintsev on 11.04.2018
 */
public class Tog extends Product {

  @Range(min = 42, max = 52, message = "{ru.ajana.stock.model.tog.range}")
  @NotNull(message = "{ru.ajana.stock.model.tog.size.notnull}")
  private Integer size;

  @NotNull(message = "ru.ajana.stock.model.tog.color.notnull")
  @Valid
  private Color color;

  @NotNull(message = "ru.ajana.stock.model.tog.kind.notnull")
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
