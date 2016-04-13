package com.netbrasoft.gnuob.api.setting;

import static com.netbrasoft.gnuob.api.Rule.DELETE_ACCESS;
import static com.netbrasoft.gnuob.api.Rule.READ_ACCESS;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.SETTING_DATA_PROVIDER_NAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ApplyScriptBefore;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.spring.integration.test.annotation.SpringWebConfiguration;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.netbrasoft.gnuob.api.Permission;
import com.netbrasoft.gnuob.api.Setting;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.generic.utils.Utils;

@RunWith(Arquillian.class)
@SpringWebConfiguration()
public class SettingDataProviderTest {

  @Deployment
  public static Archive<?> createDeployment() {
    return Utils.createDeployment();
  }

  @Autowired
  @Qualifier(SETTING_DATA_PROVIDER_NAME)
  private AbstractGenericTypeDataProvider<Setting> settingDataProvider;

  private Setting setting;

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    setting = new Setting();
    setting.setActive(true);
    setting.setId(400L);
    setting.setVersion(0);
    setting.setProperty("Folly words widow one downs few age every seven.");
    setting.setValue("Folly words widow one downs few age every seven.");
    setting.setDescription("Folly words widow one downs few age every seven.");
    setting.setPermission(new Permission());
    setting.getPermission().setId(400L);
    setting.getPermission().setVersion(0);
    setting.getPermission().setOwner(DELETE_ACCESS);
    setting.getPermission().setGroup(READ_ACCESS);
    setting.getPermission().setOthers(READ_ACCESS);
    settingDataProvider.setUser("administrator");
    settingDataProvider.setPassword("administrator");
    settingDataProvider.setSite("localhost");
    settingDataProvider.getType().setActive(true);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testSize() {
    assertEquals("Size", 1L, settingDataProvider.size());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testIterator() {
    fail("Not yet implemented");
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testFindById() {
    fail("Not yet implemented");
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testPersist() {
    fail("Not yet implemented");
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testMerge() {
    fail("Not yet implemented");
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRefresh() {
    fail("Not yet implemented");
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemove() {
    fail("Not yet implemented");
  }
}
