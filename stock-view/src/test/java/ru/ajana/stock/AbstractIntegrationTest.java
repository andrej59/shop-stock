package ru.ajana.stock;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.io.IOException;
import java.net.URL;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.formatter.Formatters;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Абстрактный интеграционный тест.
 *
 * @author Andrey Kharintsev on 28.07.2018
 */
public abstract class AbstractIntegrationTest {

  protected final Logger LOG = LoggerFactory.getLogger(getClass());
  protected static Client client = ClientBuilder.newBuilder()
      .register(JacksonJsonProvider.class)
      .build();
  private String baseURI;
  @ArquillianResource
  private URL baseURL;

  @Before
  public void setUp() {
    this.baseURI = baseURL + "api/v1";
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  protected String getBaseURI() {
    return baseURI;
  }

  @Deployment
  public static WebArchive createDeployment() throws IOException {
    final WebArchive war = ShrinkWrap.create(WebArchive.class, "stock-view.war")
        .addPackages(true, "ru.ajana.stock")
        .addAsResource("META-INF/persistence.xml")
        .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
    System.out.println(war.toString(Formatters.VERBOSE));
    return war;
  }
}
