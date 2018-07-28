package ru.ajana.stock.jpa.entities.nsi;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the sp_product_status database table.
 */
@Entity
@Table(name = "sp_product_status")
@NamedQuery(name = SpProductStatusEntity.FIND_ALL, query = "SELECT s FROM SpProductStatusEntity s")
public class SpProductStatusEntity implements Serializable {

  private static final long serialVersionUID = 1L;
  public static final String FIND_ALL = "SpProductStatus.findAll";
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String code;

  private String name;

  //bi-directional many-to-one association to ProductEntity
  //@OneToMany(mappedBy = "productStatus")
  //private List<ProductEntity> products;

  public SpProductStatusEntity() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String ident) {
    this.code = ident;
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

    SpProductStatusEntity that = (SpProductStatusEntity) o;

    if (id != that.id) {
      return false;
    }
    if (code != null ? !code.equals(that.code) : that.code != null) {
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
    result = 31 * result + (code != null ? code.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    //result = 31 * result + (products != null ? products.hashCode() : 0);
    return result;
  }
}