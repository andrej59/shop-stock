package ru.ajana.stock.jpa.entities.nsi;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the sp_product_type database table.
 */
@Entity
@Table(name = "sp_product_type")
@NamedQuery(name = SpProductTypeEntity.FIND_ALL, query = "SELECT s FROM SpProductTypeEntity s")
public class SpProductTypeEntity implements Serializable {

  private static final long serialVersionUID = 1L;
  public static final String FIND_ALL = "SpProductType.findAll";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  //bi-directional many-to-one association to ProductEntity
  //@OneToMany(mappedBy = "productType")
  //private List<ProductEntity> products;

  public SpProductTypeEntity() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

//  public List<ProductEntity> getProducts() {
//    return this.products;
//  }

//  public void setProducts(List<ProductEntity> products) {
//    this.products = products;
//  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    SpProductTypeEntity that = (SpProductTypeEntity) o;

    if (id != that.id) {
      return false;
    }
    if (name != null ? !name.equals(that.name) : that.name != null) {
      return false;
    }
    return true;
    //return products != null ? products.equals(that.products) : that.products == null;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    return result;
  }
}