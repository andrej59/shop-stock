package ru.ajana.stock.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Продукт магазина.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
public class Product implements Serializable {

  private Long id;
  @NotNull
  private String name;
  @NotNull
  private BigDecimal price;
  private String description;
  @NotNull
  @Valid
  private ProductStatus status;
  @NotNull
  @Valid
  private ProductType productType;

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

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductStatus getStatus() {
    return status;
  }

  public void setStatus(ProductStatus status) {
    this.status = status;
  }

  public ProductType getProductType() {
    return productType;
  }

  public void setProductType(ProductType productType) {
    this.productType = productType;
  }
}
