package ru.ajana.stock.jpa.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import ru.ajana.stock.jpa.entities.nsi.SpColorEntity;
import ru.ajana.stock.jpa.entities.nsi.SpTogKindEntity;


/**
 * The persistent class for the tog_product database table.
 */
@Entity
@Table(name = "tog_product")
@NamedQuery(name = TogProductEntity.FIND_ALL, query = "SELECT t FROM TogProductEntity t")
public class TogProductEntity implements Serializable {

  private static final long serialVersionUID = 1L;
  public static final String FIND_ALL = "TogProductEntity.findAll";
  @Id
  private Long id;

  @Column(name = "color_id", insertable = false, updatable = false)
  private Long colorId;

  @JoinColumn(name = "color_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private SpColorEntity color;


  @Column(name = "kind_id", insertable = false, updatable = false)
  private Long kindId;

  @JoinColumn(name = "kind_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private SpTogKindEntity togKing;

  private Integer size;

  //bi-directional one-to-one association to ProductEntity
  @OneToOne(cascade = {CascadeType.PERSIST})
  @JoinColumn(name = "id")
  private ProductEntity product;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getColorId() {
    return this.colorId;
  }

  public void setColorId(Long colorId) {
    this.colorId = colorId;
  }

  public SpColorEntity getColor() {
    return color;
  }

  public void setColor(SpColorEntity color) {
    setColorId(color.getId());
    this.color = color;
  }

  public Long getKindId() {
    return this.kindId;
  }

  public void setKindId(Long kindId) {
    this.kindId = kindId;
  }

  public SpTogKindEntity getTogKing() {
    return togKing;
  }

  public void setTogKing(SpTogKindEntity togKing) {
    setKindId(togKing.getId());
    this.togKing = togKing;
  }

  public Integer getSize() {
    return this.size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }


  public ProductEntity getProduct() {
    return this.product;
  }

  public void setProduct(ProductEntity product) {
    this.product = product;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TogProductEntity that = (TogProductEntity) o;

    if (id != that.id) {
      return false;
    }
    if (colorId != null ? !colorId.equals(that.colorId) : that.colorId != null) {
      return false;
    }
    if (kindId != null ? !kindId.equals(that.kindId) : that.kindId != null) {
      return false;
    }
    if (size != null ? !size.equals(that.size) : that.size != null) {
      return false;
    }
    return product != null ? product.equals(that.product) : that.product == null;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (colorId != null ? colorId.hashCode() : 0);
    result = 31 * result + (kindId != null ? kindId.hashCode() : 0);
    result = 31 * result + (size != null ? size.hashCode() : 0);
    result = 31 * result + (product != null ? product.hashCode() : 0);
    return result;
  }
}