package ru.ajana.stok.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 * Вид одежды магазина.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
public class TogKing implements Serializable {

  @NotNull(message = "{ru.ajana.stok.model.togking.id.notnull}")
  private Long id;
  @NotNull(message = "{ru.ajana.stok.model.togking.name.notnull}")
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
