package ru.ajana.stock.core.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import ru.ajana.stock.core.mapper.ColorMapper;
import ru.ajana.stock.core.mapper.ProductStatusMapper;
import ru.ajana.stock.core.mapper.ProductTypeMapper;
import ru.ajana.stock.core.mapper.TogKingMapper;
import ru.ajana.stock.core.service.NsiService;
import ru.ajana.stock.dao.NsiDao;
import ru.ajana.stock.jpa.entities.nsi.SpColorEntity;
import ru.ajana.stock.jpa.entities.nsi.SpProductStatusEntity;
import ru.ajana.stock.jpa.entities.nsi.SpProductTypeEntity;
import ru.ajana.stock.jpa.entities.nsi.SpTogKindEntity;
import ru.ajana.stok.model.Color;
import ru.ajana.stok.model.ProductStatus;
import ru.ajana.stok.model.ProductType;
import ru.ajana.stok.model.TogKing;


/**
 * Реализация сервиса для работы со справочниками.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
@Named("nsiService")
@Stateless
public class NsiServiceImpl implements NsiService {

  private final NsiDao nsiDao;
  private static final ColorMapper COLOR_MAPPER = new ColorMapper();
  private static final ProductTypeMapper PRODUCT_TYPE_MAPPER = new ProductTypeMapper();
  private static final ProductStatusMapper PRODUCT_STATUS_MAPPER = new ProductStatusMapper();
  private static final TogKingMapper TOG_KING_MAPPER = new TogKingMapper();

  @Inject
  public NsiServiceImpl(NsiDao nsiDao) {
    this.nsiDao = nsiDao;
  }

  public TogKing getTogKing(Long id) {
    SpTogKindEntity entity = nsiDao.findById(SpTogKindEntity.class, id);
    return TOG_KING_MAPPER.mapTo(entity);
  }

  public List<TogKing> getAllTogKings() {
    List<SpTogKindEntity> list = nsiDao.findAll(SpTogKindEntity.class);
    return list.stream().map(TOG_KING_MAPPER::mapTo).collect(Collectors.toList());
  }

  public ProductStatus getProductStatus(Long id) {
    SpProductStatusEntity entity = nsiDao.findById(SpProductStatusEntity.class, id);
    return PRODUCT_STATUS_MAPPER.mapTo(entity);
  }

  public List<ProductStatus> getProductStatues() {
    List<SpProductStatusEntity> list = nsiDao.findAll(SpProductStatusEntity.class);
    return list.stream().map(PRODUCT_STATUS_MAPPER::mapTo).collect(Collectors.toList());
  }

  public ProductType getProductType(Long id) {
    SpProductTypeEntity entity = nsiDao.findById(SpProductTypeEntity.class, id);
    return PRODUCT_TYPE_MAPPER.mapTo(entity);
  }

  public List<ProductType> getAllProducts() {
    List<SpProductTypeEntity> list = nsiDao.findAll(SpProductTypeEntity.class);
    return list.stream().map(PRODUCT_TYPE_MAPPER::mapTo).collect(Collectors.toList());
  }

  public Color getColor(Long id) {
    SpColorEntity colorEntity = nsiDao.findById(SpColorEntity.class, id);
    return COLOR_MAPPER.mapTo(colorEntity);
  }

  public List<Color> getAllColors() {
    List<SpColorEntity> list = nsiDao.findAll(SpColorEntity.class);
    return list.stream().map(COLOR_MAPPER::mapTo).collect(Collectors.toList());
  }
}
