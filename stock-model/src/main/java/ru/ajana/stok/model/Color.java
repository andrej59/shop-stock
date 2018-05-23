package ru.ajana.stok.model;

import java.io.Serializable;

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

  private Long id;
  private String name;
  private String ident;

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

  public String getIdent() {
    return ident;
  }

  public void setIdent(String ident) {
    this.ident = ident;
  }
}
