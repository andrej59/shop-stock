package ru.ajana.stock.view.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.Test;
import ru.ajana.stok.model.Tog;

/**
 * @author Andrey Kharintsev on 27.04.2018
 */
public class TogMarshallTest {

  @Test
  public void testMarshalTog() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    //Tog tog =  RandomData.random(Tog.class);
    Tog togExpected = ProductGenerator.createProduct();
    String jsonString = mapper.writeValueAsString(togExpected);
    System.out.println(jsonString);

    Tog togActual = mapper.readValue(jsonString, Tog.class);
    System.out.println(togActual);
  }
}
