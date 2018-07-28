package ru.ajana.stock.model;

import java.io.Serializable;

/**
 * Статус продукта.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
public class ProductStatus implements Serializable {

  /**
   * Статус продукта - В магазине.
   */
  public static final String SHOP_STATUS = "SHOP";
  /**
   * Статус продукта - На складе.
   */
  public static final String STOCK_STATUS = "STOCK";

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
