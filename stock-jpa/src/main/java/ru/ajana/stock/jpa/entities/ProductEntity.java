package ru.ajana.stock.jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import ru.ajana.stock.jpa.entities.nsi.SpProductStatusEntity;
import ru.ajana.stock.jpa.entities.nsi.SpProductTypeEntity;


/**
 * The persistent class for the product database table.
 */
@Entity
@Table(name = "product")
@NamedQuery(name = ProductEntity.FIND_ALL, query = "SELECT p FROM ProductEntity p")
public class ProductEntity implements Serializable {

  private static final long serialVersionUID = 1L;
  public static final String FIND_ALL = "Product.findAll";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;

  private String name;

  private BigDecimal price;

  @Column(name = "status_id", insertable = false, updatable = false)
  private Long statusId;

  @JoinColumn(name = "status_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private SpProductStatusEntity status;

  @Column(name = "type_id", insertable = false, updatable = false)
  private Long typeId;


  @JoinColumn(name = "type_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private SpProductTypeEntity type;

  //bi-directional one-to-one association to TogProductDao
  //@OneToOne(mappedBy = "product")
  //private TogProductEntity togProduct;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return this.price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Long getStatusId() {
    return this.statusId;
  }

  public void setStatusId(Long statusId) {
    this.statusId = statusId;
  }

  public SpProductStatusEntity getStatus() {
    return status;
  }

  public void setStatus(SpProductStatusEntity status) {
    setStatusId(status.getId());
    this.status = status;
  }

  public Long getTypeId() {
    return this.typeId;
  }

  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  public SpProductTypeEntity getType() {
    return type;
  }

  public void setType(SpProductTypeEntity type) {
    setTypeId(type.getId());
    this.type = type;
  }

//  public TogProductEntity getTogProduct() {
//    return this.togProduct;
//  }
//
//  public void setTogProduct(TogProductEntity togProduct) {
//    this.togProduct = togProduct;
//  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ProductEntity product = (ProductEntity) o;

    if (id != product.id) {
      return false;
    }
    if (description != null ? !description.equals(product.description)
        : product.description != null) {
      return false;
    }
    if (name != null ? !name.equals(product.name) : product.name != null) {
      return false;
    }
    if (price != null ? !price.equals(product.price) : product.price != null) {
      return false;
    }
    if (statusId != null ? !statusId.equals(product.statusId) : product.statusId != null) {
      return false;
    }
    if (typeId != null ? !typeId.equals(product.typeId) : product.typeId != null) {
      return false;
    }
    return true;
    //return togProduct != null ? togProduct.equals(product.togProduct) : product.togProduct == null;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
    result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
    //result = 31 * result + (togProduct != null ? togProduct.hashCode() : 0);
    return result;
  }
}