package br.com.netbrasoft.gnuob.api.order;

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.ORDER_DATA_PROVIDER_NAME;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.APPLICATION_CONTEXT_XML;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.BACK_TO_SHOP;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.BUTTON;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.CHANGE_STATUS_LINK;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.CHANGE_STATUS_LIST;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.CONTINUE_TO_PAYMENT;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.COUNTRY_BR;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.CREDIT_CARD_CVV_WALLET;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.CREDIT_CARD_CVV_WALLET_VALUE;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.DATASETS_SETTINGS_XML;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.DOMAIN;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.EMAIL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.ENTRAR;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.LANGUAGE_PT;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.NOTIFICATION_CODE;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.OPTION;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.PAGSEGURO_BUTTON;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.PAGSEGURO_EMAIL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.PAGSEGURO_PASSWORD;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.PASSWORD;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.PATH_PAGSEGURO_NOTIFICATIONS;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.ROOT;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SANDBOX_PAGSEGURO_UOL_COM_BR;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SANDBOX_PAGSEGURO_UOL_COM_BR_TRANSACOES;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SENDER_AREA_CODE;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SENDER_AREA_CODE_VALUE;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SENDER_CPF;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SENDER_PASSWORD;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SENDER_PASSWORD_VALUE;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SENDER_PHONE;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SENDER_PHONE_VALUE;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.STATEMENT_LIST_TABLE;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.TBODY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.TR;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.WALLET_HOLDER_BORN_DATE;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.WALLET_HOLDER_BORN_DATE_VALUE;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.WALLET_HOLDER_CPF;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.WALLET_HOLDER_CPF_VALUE;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.WALLET_INSTALLMENT_QUANTITY;
import static br.com.netbrasoft.gnuob.api.generic.utils.PagseguroInstanceHelper.getOrderInstance;
import static org.junit.Assert.assertNotNull;

import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.apache.http.client.utils.URLEncodedUtils;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
public class PagseguroOrderDataProviderTest {

  @Drone
  private WebDriver driver;
  private WebDriverWait webDriverWait;
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

  private void waitForCheckoutToFinish() throws InterruptedException {
    webDriverWait = new WebDriverWait(driver, 30);
    driver.get(SANDBOX_PAGSEGURO_UOL_COM_BR + order.getToken());
    driver.findElement(By.id(SENDER_PASSWORD)).sendKeys(SENDER_PASSWORD_VALUE);
    driver.findElement(By.tagName(BUTTON)).click();
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CREDIT_CARD_CVV_WALLET)));
    driver.findElement(By.id(CREDIT_CARD_CVV_WALLET)).sendKeys(CREDIT_CARD_CVV_WALLET_VALUE);
    driver.findElement(By.id(WALLET_INSTALLMENT_QUANTITY)).findElements(By.tagName(OPTION)).get(1).click();
    driver.findElement(By.id(WALLET_HOLDER_CPF)).sendKeys(WALLET_HOLDER_CPF_VALUE);
    driver.findElement(By.id(WALLET_HOLDER_BORN_DATE)).sendKeys(WALLET_HOLDER_BORN_DATE_VALUE);
    driver.findElement(By.id(SENDER_CPF)).sendKeys(WALLET_HOLDER_CPF_VALUE);
    driver.findElement(By.id(SENDER_AREA_CODE)).sendKeys(SENDER_AREA_CODE_VALUE);
    driver.findElement(By.id(SENDER_PHONE)).sendKeys(SENDER_PHONE_VALUE);
    driver.findElement(By.id(CONTINUE_TO_PAYMENT)).click();
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BACK_TO_SHOP)));
    driver.get(SANDBOX_PAGSEGURO_UOL_COM_BR_TRANSACOES);
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(EMAIL)));
    driver.findElement(By.id(EMAIL)).sendKeys(System.getProperty(PAGSEGURO_EMAIL));
    driver.findElement(By.id(PASSWORD)).sendKeys(System.getProperty(PAGSEGURO_PASSWORD));
    driver.findElement(By.id(ENTRAR)).click();
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(STATEMENT_LIST_TABLE)));
    driver.findElement(By.id(STATEMENT_LIST_TABLE)).findElement(By.tagName(TBODY)).findElements(By.tagName(TR)).get(0)
        .click();
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CHANGE_STATUS_LINK)));
    driver.findElement(By.id(CHANGE_STATUS_LINK)).click();
    driver.findElement(By.cssSelector(CHANGE_STATUS_LIST)).findElements(By.tagName(OPTION)).get(1).click();
    driver.findElement(By.cssSelector(PAGSEGURO_BUTTON)).click();
    driver.close();
    driver.wait(5000L);
  }

  private void setUp() {
    Locale.setDefault(new Locale(LANGUAGE_PT, COUNTRY_BR));
    orderDataProvider.setPaymentProvider(PaymentProviderEnum.PAGSEGURO);
    orderDataProvider.setUser(ROOT);
    orderDataProvider.setPassword(ROOT);
    orderDataProvider.setSite(DOMAIN);
    orderDataProvider.getType().setActive(true);
    order = orderDataProvider.persist(getOrderInstance());
    httpTestServer.addHandler(PATH_PAGSEGURO_NOTIFICATIONS, exhange -> {
      exhange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0L);
      exhange.getResponseBody().write(new byte[0]);
      order.setNotificationId(getNotificationId(exhange.getRequestURI().getQuery()));
      exhange.close();
    });
  }

  private String getNotificationId(final String query) {
    return URLEncodedUtils.parse(query, StandardCharsets.UTF_8).stream()
        .filter(e -> NOTIFICATION_CODE.equals(e.getName())).findFirst().get().getValue();
  }

  @Test
  @InSequence(3)
  @Cleanup(phase = TestExecutionPhase.BEFORE)
  public void cleanupDatabaseWorkaround() {}
}
