package ru.ajana.stok.model;

import java.io.Serializable;

/**
 * Вид одежды магазина.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
public class TogKing implements Serializable {

  private Long id;
  private String name;

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
}
