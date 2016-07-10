package br.com.netbrasoft.gnuob.api.order;

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.ORDER_DATA_PROVIDER_NAME;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.APPLICATION_CONTEXT_XML;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.COUNTRY_BR;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.DATASETS_SETTINGS_XML;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.DOMAIN;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.LANGUAGE_PT;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.PATH_PAYPAL_NOTIFICATIONS;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.ROOT;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL;
import static br.com.netbrasoft.gnuob.api.generic.utils.PagseguroInstanceHelper.getOrderInstance;
import static org.junit.Assert.assertNotNull;

import java.net.HttpURLConnection;
import java.util.Locale;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.persistence.ApplyScriptBefore;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.spring.integration.test.annotation.SpringClientConfiguration;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.netbrasoft.gnuob.api.Order;

import br.com.netbrasoft.gnuob.api.generic.utils.HttpTestServer;
import br.com.netbrasoft.gnuob.api.generic.utils.Utils;
import br.com.netbrasoft.gnuob.api.order.IGenericOrderCheckoutDataProvider;
import br.com.netbrasoft.gnuob.api.order.OrderDataProvider.PaymentProviderEnum;

@RunWith(Arquillian.class)
@Cleanup(phase = TestExecutionPhase.NONE)
@SpringClientConfiguration(APPLICATION_CONTEXT_XML)
public class PayPalOrderDataProviderTest {

  @Drone
  private WebDriver driver;
  @Autowired
  @Qualifier(ORDER_DATA_PROVIDER_NAME)
  private IGenericOrderCheckoutDataProvider<Order> orderDataProvider;
  private Order order;

  @Deployment
  public static Archive<?> createDeployment() {
    return Utils.createDeployment();
  }

  @Rule
  public ExpectedException expectedException = ExpectedException.none();
  @Rule
  public HttpTestServer httpTestServer = HttpTestServer.server();

  @Test
  @InSequence(1)
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void populateDatabaseWorkaround() {
    // Populates database since unable to use @UsingDataSet with @RunAsClient
    // Check https://issues.jboss.org/browse/ARQ-1077
  }

  @Test
  @InSequence(2)
  @RunAsClient
  public void testPagseguro() throws InterruptedException {
    setUp();
    order = orderDataProvider.doCheckout(order);
    waitForCheckoutToFinish();
    assertNotNull(order.getNotificationId());
    order = orderDataProvider.doNotification(order);
    order = orderDataProvider.doCheckoutDetails(order);
    order = orderDataProvider.doCheckoutPayment(order);
    order = orderDataProvider.doTransactionDetails(order);
    order = orderDataProvider.doRefundTransaction(order);
    order = orderDataProvider.doTransactionDetails(order);
  }

  private void waitForCheckoutToFinish() {
    // TODO Auto-generated method stub
  }

  private void setUp() {
    Locale.setDefault(new Locale(LANGUAGE_PT, COUNTRY_BR));
    orderDataProvider.setPaymentProvider(PaymentProviderEnum.PAY_PAL);
    orderDataProvider.setUser(ROOT);
    orderDataProvider.setPassword(ROOT);
    orderDataProvider.setSite(DOMAIN);
    orderDataProvider.getType().setActive(true);
    order = orderDataProvider.persist(getOrderInstance());
    httpTestServer.addHandler(PATH_PAYPAL_NOTIFICATIONS, exhange -> {
      exhange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0L);
      exhange.getResponseBody().write(new byte[0]);
      // order.setNotificationId(getNotificationId(exhange.getRequestURI().getQuery()));
      exhange.close();
    });
  }

  @Test
  @InSequence(3)
  @Cleanup(phase = TestExecutionPhase.BEFORE)
  public void cleanupDatabaseWorkaround() {}
}
