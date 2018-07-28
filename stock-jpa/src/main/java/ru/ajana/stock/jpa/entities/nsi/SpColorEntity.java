package ru.ajana.stock.jpa.entities.nsi;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import ru.ajana.stock.jpa.entities.TogProductEntity;


/**
 * The persistent class for the sp_color database table.
 */
@Entity
@Table(name = "sp_color")
@NamedQuery(name = SpColorEntity.FIND_ALL, query = "SELECT s FROM SpColorEntity s")
public class SpColorEntity implements Serializable {

  private static final long serialVersionUID = 1L;
  public static final String FIND_ALL = "SpColor.findAll";
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String code;

  private String name;

  //bi-directional many-to-one association to TogProductDao
  @OneToMany(mappedBy = "color")
  private List<TogProductEntity> togProducts;

  public SpColorEntity() {
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

  public List<TogProductEntity> getTogProducts() {
    return this.togProducts;
  }

  public void setTogProducts(List<TogProductEntity> togProducts) {
    this.togProducts = togProducts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    SpColorEntity spColor = (SpColorEntity) o;

    if (id != spColor.id) {
      return false;
    }
    if (code != null ? !code.equals(spColor.code) : spColor.code != null) {
      return false;
    }
    if (name != null ? !name.equals(spColor.name) : spColor.name != null) {
      return false;
    }
    return togProducts != null ? togProducts.equals(spColor.togProducts)
        : spColor.togProducts == null;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (code != null ? code.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (togProducts != null ? togProducts.hashCode() : 0);
    return result;
  }
}