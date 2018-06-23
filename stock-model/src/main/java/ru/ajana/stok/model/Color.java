package ru.ajana.stok.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 * Цвет одежды.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
public class Color implements Serializable {

  /**
   * Белый цвет
   */
  private static final String WHITE = "WHITE";
  @NotNull(message = "ru.ajana.stock.model.color.id.notnull")
  private Long id;
  @NotNull(message = "ru.ajana.stock.model.color.name.notnull")
  private String name;
  @NotNull(message = "ru.ajana.stock.model.color.code.notnull")
  private String code;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
