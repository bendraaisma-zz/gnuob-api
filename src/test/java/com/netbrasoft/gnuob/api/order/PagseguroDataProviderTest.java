package com.netbrasoft.gnuob.api.order;

import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.ORDER_DATA_PROVIDER_NAME;
import static com.netbrasoft.gnuob.generic.utils.PagseguroInstanceHelper.getOrderInstance;

import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.Locale;

import org.apache.http.NameValuePair;
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

import com.netbrasoft.gnuob.api.Order;
import com.netbrasoft.gnuob.api.order.OrderDataProvider.PaymentProviderEnum;
import com.netbrasoft.gnuob.generic.utils.HttpTestServer;
import com.netbrasoft.gnuob.generic.utils.Utils;

@RunWith(Arquillian.class)
@Cleanup(phase = TestExecutionPhase.NONE)
@SpringClientConfiguration("applicationContext.xml")
public class PagseguroDataProviderTest {

  private static final String BR = "BR";
  private static final String PT = "pt";
  private static final String ROOT = "root";
  private static final String DATASETS_SETTINGS_XML = "datasets/settings.xml";
  private static final String SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL = "scripts/scriptsToExecuteBeforeTest.sql";

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
  public void testDoCheckout() throws InterruptedException {
    httpTestServer.addHandler("/pagseguro_notifications", exhange -> {
      exhange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0L);
      exhange.getResponseBody().write(new byte[0]);
      final NameValuePair findFirst = URLEncodedUtils.parse(exhange.getRequestURI().getQuery(), Charset.forName("utf8"))
          .stream().filter(e -> "notificationCode".equals(e.getName())).findFirst().get();
      order.setNotificationId(findFirst.getValue());
      exhange.close();
    });
    Locale.setDefault(new Locale(PT, BR));
    webDriverWait = new WebDriverWait(driver, 60);
    orderDataProvider.setPaymentProvider(PaymentProviderEnum.PAGSEGURO);
    orderDataProvider.setUser(ROOT);
    orderDataProvider.setPassword(ROOT);
    orderDataProvider.setSite("domain");
    orderDataProvider.getType().setActive(true);
    order = orderDataProvider.persist(getOrderInstance());
    order = orderDataProvider.doCheckout(order);
    driver.get("https://sandbox.pagseguro.uol.com.br/v2/checkout/payment.html?code=" + order.getToken());
    driver.findElement(By.id("senderPassword")).sendKeys("pC4u57FT8060Cw7d");
    driver.findElement(By.tagName("button")).click();
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("creditCardCVV_wallet")));
    driver.findElement(By.id("creditCardCVV_wallet")).sendKeys("123");
    driver.findElement(By.id("walletInstallmentQuantity")).findElements(By.tagName("option")).get(1).click();
    driver.findElement(By.id("walletHolderCPF")).sendKeys("553.887.423-00");
    driver.findElement(By.id("walletHolderBornDate")).sendKeys("20/05/1980");
    driver.findElement(By.id("senderCPF")).sendKeys("553.887.423-00");
    driver.findElement(By.id("senderAreaCode")).sendKeys("27");
    driver.findElement(By.id("senderPhone")).sendKeys("999999999");
    driver.findElement(By.id("continueToPayment")).click();
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("backToShop")));
    driver.findElement(By.id("backToShop")).click();
    driver.close();
    while (order.getNotificationId() == null) {
      Thread.sleep(1000);
    }
  }

  @Test
  @InSequence(3)
  @Cleanup(phase = TestExecutionPhase.BEFORE)
  public void cleanupDatabaseWorkaround() {}
}
