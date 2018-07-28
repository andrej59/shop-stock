package ru.ajana.stock.core.service;

import java.util.List;
import javax.ejb.Local;
import ru.ajana.stock.model.Color;
import ru.ajana.stock.model.ProductStatus;
import ru.ajana.stock.model.ProductType;
import ru.ajana.stock.model.TogKing;

/**
 * Интерфейс сервиса для работы со справочниками.
 *
 * @author Andrey Kharintsev on 15.04.2018
 */
@Local
public interface NsiService {

  TogKing getTogKing(Long id);

  List<TogKing> getAllTogKings();

  ProductStatus getProductStatus(Long id);

  List<ProductStatus> getProductStatues();

  ProductType getProductType(Long id);

  List<ProductType> getAllProducts();

  Color getColor(Long id);

  List<Color> getAllColors();
}
