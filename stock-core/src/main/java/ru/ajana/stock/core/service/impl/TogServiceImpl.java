package ru.ajana.stock.core.service.impl;


import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import ru.ajana.stock.core.mapper.ProductMapper;
import ru.ajana.stock.core.mapper.TogMapper;
import ru.ajana.stock.core.service.NsiService;
import ru.ajana.stock.core.service.TogService;
import ru.ajana.stock.dao.NsiDao;
import ru.ajana.stock.dao.ProductDao;
import ru.ajana.stock.dao.TogProductDao;
import ru.ajana.stock.jpa.entities.ProductEntity;
import ru.ajana.stock.jpa.entities.TogProductEntity;
import ru.ajana.stock.jpa.entities.nsi.SpColorEntity;
import ru.ajana.stock.jpa.entities.nsi.SpProductStatusEntity;
import ru.ajana.stock.jpa.entities.nsi.SpProductTypeEntity;
import ru.ajana.stock.jpa.entities.nsi.SpTogKindEntity;
import ru.ajana.stock.model.ProductStatus;
import ru.ajana.stock.model.Tog;

/**
 * Реализация EJB-сервис одежды.
 *
 * @author Andrey Kharintsev on 11.04.2018
 */
@Named("togService")
@Stateless
public class TogServiceImpl implements TogService {

  private static final ProductMapper PRODUCT_MAPPER = new ProductMapper();
  private static final TogMapper TOG_MAPPER = new TogMapper();

  private final ProductDao productDao;
  private final TogProductDao togProductDao;
  private final NsiDao nsiDao;
  private final NsiService nsiService;


  @Inject
  public TogServiceImpl(ProductDao productDao, TogProductDao togProductDao, NsiDao nsiDao,
      NsiService nsiService) {
    this.productDao = productDao;
    this.togProductDao = togProductDao;
    this.nsiDao = nsiDao;
    this.nsiService = nsiService;
  }

  @Override
  public Tog changeTogStatus(Tog togProduct, ProductStatus newStatus) {
    return null;
  }

  @Override
  public Tog saveTog(Tog tog) {
    if (tog == null) {
      return null;
    }
    ProductEntity productEntity = PRODUCT_MAPPER.mapFrom(tog);
    // Тип продукта
    SpProductTypeEntity productTypeEntity = nsiDao
        .findById(SpProductTypeEntity.class, tog.getProductType().getId());
    productEntity.setType(productTypeEntity);
    // Статус продукта
    SpProductStatusEntity productStatusEntity = nsiDao
        .findById(SpProductStatusEntity.class, tog.getStatus().getId());
    productEntity.setStatus(productStatusEntity);
    // Цвет одежды
    TogProductEntity togProductEntity = TOG_MAPPER.mapFrom(tog);
    SpColorEntity colorEntity = nsiDao.findById(SpColorEntity.class, tog.getColor().getId());
    togProductEntity.setColor(colorEntity);
    // Вид одежды
    SpTogKindEntity togKingEntity = nsiDao.findById(SpTogKindEntity.class, tog.getKind().getId());
    togProductEntity.setTogKing(togKingEntity);

    togProductEntity.setProduct(productEntity);
    if (togProductEntity.getId() == null) {
      togProductDao.createTogProduct(togProductEntity);
    } else {
      togProductDao.updateProduct(togProductEntity);
    }
    productDao.flush();
    tog.setId(togProductEntity.getId());
    return tog;
  }

  @Override
  public List<Tog> getAllTogs() {
    List<TogProductEntity> togProductEntities = togProductDao.findAllTogProducts();
    return togProductEntities.stream().map(TOG_MAPPER::mapTo).collect(Collectors.toList());
  }

  @Override
  public Tog getTog(Long id) {
    if (id == null) {
      return null;
    }
    TogProductEntity togProductEntity = togProductDao.findById(id);
    return TOG_MAPPER.mapTo(togProductEntity);
  }

  @Override
  public void deleteTog(Long id) {
    if (id == null) {
      return;
    }
    togProductDao.removeById(id);
    togProductDao.flush();
  }
}
