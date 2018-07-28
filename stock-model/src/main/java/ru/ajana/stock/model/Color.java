package ru.ajana.stock.model;

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
  @NotNull
  private Long id;
  @NotNull
  private String name;
  @NotNull
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
