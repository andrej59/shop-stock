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
 * The persistent class for the sp_kind_tog database table.
 */
@Entity
@Table(name = "sp_tog_kind")
@NamedQuery(name = SpTogKindEntity.FIND_ALL, query = "SELECT s FROM SpTogKindEntity s")
public class SpTogKindEntity implements Serializable {

  private static final long serialVersionUID = 1L;
  public static final String FIND_ALL = "SpTogKindEntity.findAll";
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  //bi-directional many-to-one association to TogProductDao
  @OneToMany(mappedBy = "togKing")
  private List<TogProductEntity> togProducts;

  public SpTogKindEntity() {
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

  public List<TogProductEntity> getTogProducts() {
    return this.togProducts;
  }

  public void setTogProducts(List<TogProductEntity> togProducts) {
    this.togProducts = togProducts;
  }
}