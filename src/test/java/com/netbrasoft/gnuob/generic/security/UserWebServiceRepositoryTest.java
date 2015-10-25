package com.netbrasoft.gnuob.generic.security;

import java.util.UUID;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
import com.netbrasoft.gnuob.api.Group;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.Permission;
import com.netbrasoft.gnuob.api.Role;
import com.netbrasoft.gnuob.api.Rule;
import com.netbrasoft.gnuob.api.Site;
import com.netbrasoft.gnuob.api.User;
import com.netbrasoft.gnuob.api.security.UserWebServiceRepository;
import com.netbrasoft.gnuob.generic.utils.Utils;

import de.rtner.security.auth.spi.SimplePBKDF2;

@RunWith(Arquillian.class)
public class UserWebServiceRepositoryTest {

  @Deployment
  public static Archive<?> createDeployment() {
    return Utils.createDeployment();
  }

  private final UserWebServiceRepository<User> userWebServiceRepository = new UserWebServiceRepository<User>();
  private MetaData metaData = null;
  private User user = null;
  private Group group = null;
  private Site site = null;

  @Before
  public void testBefore() {
    metaData = new MetaData();
    user = new User();
    group = new Group();
    site = new Site();

    metaData.setUser("administrator");
    metaData.setPassword("administrator");
    metaData.setSite("www.netbrasoft.com");

    user.setName(UUID.randomUUID().toString());
    user.setDescription(UUID.randomUUID().toString());
    user.setPassword(UUID.randomUUID().toString());
    user.getRoles().add(Role.ADMINISTRATOR);
    user.setAccess(Rule.NONE_ACCESS);

    group.setName(UUID.randomUUID().toString());
    group.setDescription(UUID.randomUUID().toString());

    site.setName(UUID.randomUUID().toString());
    site.setDescription(UUID.randomUUID().toString());

    user.getGroups().add(group);
    user.getSites().add(site);
  }

  @Test
  public void testFindUserWithGroupAndSite() throws GNUOpenBusinessServiceException_Exception {
    final String userName = user.getName();
    final String userDescription = user.getDescription();
    final String userPassword = user.getPassword();
    final String groupName = group.getName();
    final String groupDescription = group.getDescription();
    final String siteName = site.getName();
    final String siteDescription = site.getDescription();

    final Rule userAccess = user.getAccess();

    final User persistUser = userWebServiceRepository.persist(metaData, user);

    final User findUser = userWebServiceRepository.find(metaData, persistUser);

    Assert.assertNotNull("User is not found.", findUser);

    Assert.assertTrue("User id has no value bigger than zero.", findUser.getId() > 0);
    Assert.assertEquals("User name is not equal.", userName, findUser.getName());
    Assert.assertEquals("User description is not equal.", userDescription, findUser.getDescription());
    Assert.assertTrue("User password is not correct.", new SimplePBKDF2().verifyKeyFormatted(findUser.getPassword(), userPassword));
    Assert.assertEquals("User access is not equal.", userAccess, findUser.getAccess());

    Assert.assertTrue("User is not assigned to a group.", !findUser.getGroups().isEmpty());

    final Group newGroup = findUser.getGroups().iterator().next();

    Assert.assertTrue("Group id has no value bigger than zero.", newGroup.getId() > 0);
    Assert.assertEquals("Group name is not equal.", groupName, newGroup.getName());
    Assert.assertEquals("Group description is not equal.", groupDescription, newGroup.getDescription());

    Assert.assertTrue("User is not assigned to a site.", !findUser.getSites().isEmpty());

    final Site newSite = findUser.getSites().iterator().next();

    Assert.assertTrue("Site id has no value bigger than zero.", newSite.getId() > 0);
    Assert.assertEquals("Site name is not equal.", siteName, newSite.getName());
    Assert.assertEquals("Site description is not equal.", siteDescription, newSite.getDescription());
  }

  @Test
  public void testMergeUserWithGroupAndSite() throws GNUOpenBusinessServiceException_Exception {
    final String userName = UUID.randomUUID().toString();
    final String userDescription = UUID.randomUUID().toString();
    final String userPassword = UUID.randomUUID().toString();
    final String groupName = UUID.randomUUID().toString();
    final String groupDescription = UUID.randomUUID().toString();
    final String siteName = UUID.randomUUID().toString();
    final String siteDescription = UUID.randomUUID().toString();

    final User persistUser = userWebServiceRepository.persist(metaData, user);
    final Group persistGroup = persistUser.getGroups().iterator().next();
    final Site persistSite = persistUser.getSites().iterator().next();

    persistUser.setName(userName);
    persistUser.setDescription(userDescription);
    persistUser.setPassword(userPassword);

    persistGroup.setName(groupName);
    persistGroup.setDescription(groupDescription);

    persistSite.setName(siteName);
    persistSite.setDescription(siteDescription);

    final User mergeUser = userWebServiceRepository.merge(metaData, persistUser);

    Assert.assertTrue("User id has no value bigger than zero.", mergeUser.getId() > 0);
    Assert.assertEquals("User name is not equal.", userName, mergeUser.getName());
    Assert.assertEquals("User description is not equal.", userDescription, mergeUser.getDescription());
    Assert.assertTrue("User password is not correct.", new SimplePBKDF2().verifyKeyFormatted(mergeUser.getPassword(), userPassword));

    Assert.assertTrue("User is not assigned to a group.", !mergeUser.getGroups().isEmpty());

    final Group mergeGroup = mergeUser.getGroups().iterator().next();

    Assert.assertTrue("Group id has no value bigger than zero.", mergeGroup.getId() > 0);
    Assert.assertEquals("Group name is not equal.", groupName, mergeGroup.getName());
    Assert.assertEquals("Group description is not equal.", groupDescription, mergeGroup.getDescription());

    Assert.assertTrue("User is not assigned to a site.", !mergeUser.getSites().isEmpty());

    final Site mergeSite = mergeUser.getSites().iterator().next();

    Assert.assertTrue("Site id has no value bigger than zero.", mergeSite.getId() > 0);
    Assert.assertEquals("Site name is not equal.", siteName, mergeSite.getName());
    Assert.assertEquals("Site description is not equal.", siteDescription, mergeSite.getDescription());
  }

  @Test
  public void testMergeUserWithGroupAndSiteWhereOthersHasUpdateAccess() throws GNUOpenBusinessServiceException_Exception {
    final String userName = UUID.randomUUID().toString();
    final String userDescription = UUID.randomUUID().toString();
    final String userPassword = UUID.randomUUID().toString();
    final String groupName = UUID.randomUUID().toString();
    final String groupDescription = UUID.randomUUID().toString();
    final String siteName = UUID.randomUUID().toString();
    final String siteDescription = UUID.randomUUID().toString();

    user.setPermission(new Permission());
    user.getPermission().setOwner(Rule.NONE_ACCESS);
    user.getPermission().setGroup(Rule.NONE_ACCESS);
    user.getPermission().setOthers(Rule.UPDATE_ACCESS);

    final User persistUser = userWebServiceRepository.persist(metaData, user);
    final Group persistGroup = persistUser.getGroups().iterator().next();
    final Site persistSite = persistUser.getSites().iterator().next();

    persistUser.setName(userName);
    persistUser.setDescription(userDescription);
    persistUser.setPassword(userPassword);

    persistGroup.setName(groupName);
    persistGroup.setDescription(groupDescription);

    persistSite.setName(siteName);
    persistSite.setDescription(siteDescription);

    metaData.setUser("manager");
    metaData.setPassword("manager");

    final User mergeUser = userWebServiceRepository.merge(metaData, persistUser);

    Assert.assertTrue("User id has no value bigger than zero.", mergeUser.getId() > 0);
    Assert.assertEquals("User name is not equal.", userName, mergeUser.getName());
    Assert.assertEquals("User description is not equal.", userDescription, mergeUser.getDescription());
    Assert.assertTrue("User password is not correct.", new SimplePBKDF2().verifyKeyFormatted(mergeUser.getPassword(), userPassword));

    Assert.assertTrue("User is not assigned to a group.", !mergeUser.getGroups().isEmpty());

    final Group mergeGroup = mergeUser.getGroups().iterator().next();

    Assert.assertTrue("Group id has no value bigger than zero.", mergeGroup.getId() > 0);
    Assert.assertEquals("Group name is not equal.", groupName, mergeGroup.getName());
    Assert.assertEquals("Group description is not equal.", groupDescription, mergeGroup.getDescription());

    Assert.assertTrue("User is not assigned to a site.", !mergeUser.getSites().isEmpty());

    final Site mergeSite = mergeUser.getSites().iterator().next();

    Assert.assertTrue("Site id has no value bigger than zero.", mergeSite.getId() > 0);
    Assert.assertEquals("Site name is not equal.", siteName, mergeSite.getName());
    Assert.assertEquals("Site description is not equal.", siteDescription, mergeSite.getDescription());
  }

  @Test
  public void testPersistUserWithGroupAndSite() throws GNUOpenBusinessServiceException_Exception {
    final String userName = user.getName();
    final String userDescription = user.getDescription();
    final String userPassword = user.getPassword();
    final String groupName = group.getName();
    final String groupDescription = group.getDescription();
    final String siteName = site.getName();
    final String siteDescription = site.getDescription();

    final Rule userRule = user.getAccess();

    final User persistUser = userWebServiceRepository.persist(metaData, user);

    Assert.assertTrue("User id has no value bigger than zero.", persistUser.getId() > 0);
    Assert.assertEquals("User name is not equal.", userName, persistUser.getName());
    Assert.assertEquals("User description is not equal.", userDescription, persistUser.getDescription());
    Assert.assertTrue("User password is not correct.", new SimplePBKDF2().verifyKeyFormatted(persistUser.getPassword(), userPassword));
    Assert.assertEquals("User rule is not equal.", userRule, persistUser.getAccess());

    Assert.assertTrue("User is not assigned to a group.", !persistUser.getGroups().isEmpty());

    final Group newGroup = persistUser.getGroups().iterator().next();

    Assert.assertTrue("Group id has no value bigger than zero.", newGroup.getId() > 0);
    Assert.assertEquals("Group name is not equal.", groupName, newGroup.getName());
    Assert.assertEquals("Group description is not equal.", groupDescription, newGroup.getDescription());

    Assert.assertTrue("User is not assigned to a site.", !persistUser.getSites().isEmpty());

    final Site newSite = persistUser.getSites().iterator().next();

    Assert.assertTrue("Site id has no value bigger than zero.", newSite.getId() > 0);
    Assert.assertEquals("Site name is not equal.", siteName, newSite.getName());
    Assert.assertEquals("Site description is not equal.", siteDescription, newSite.getDescription());
  }

  @Test
  public void testRefreshUserWithGroupAndSite() throws GNUOpenBusinessServiceException_Exception {
    final User persistUser = userWebServiceRepository.persist(metaData, user);
    final Group persistGroup = persistUser.getGroups().iterator().next();
    final Site persistSite = persistUser.getSites().iterator().next();

    final String userName = user.getName();
    final String userDescription = user.getDescription();
    final String userPassword = user.getPassword();
    final String groupName = group.getName();
    final String groupDescription = group.getDescription();
    final String siteName = site.getName();
    final String siteDescription = site.getDescription();

    persistUser.setName(UUID.randomUUID().toString());
    persistUser.setDescription(UUID.randomUUID().toString());
    persistUser.setPassword(UUID.randomUUID().toString());

    persistGroup.setName(UUID.randomUUID().toString());
    persistGroup.setDescription(UUID.randomUUID().toString());

    persistSite.setName(UUID.randomUUID().toString());
    persistSite.setDescription(UUID.randomUUID().toString());

    final User refreshUser = userWebServiceRepository.refresh(metaData, persistUser);

    Assert.assertTrue("User id has no value bigger than zero.", refreshUser.getId() > 0);
    Assert.assertEquals("User name is not equal.", userName, refreshUser.getName());
    Assert.assertEquals("User description is not equal.", userDescription, refreshUser.getDescription());
    Assert.assertTrue("User password is not correct.", new SimplePBKDF2().verifyKeyFormatted(refreshUser.getPassword(), userPassword));

    Assert.assertTrue("User is not assigned to a group.", !refreshUser.getGroups().isEmpty());

    final Group refreshGroup = refreshUser.getGroups().iterator().next();

    Assert.assertTrue("Group id has no value bigger than zero.", refreshGroup.getId() > 0);
    Assert.assertEquals("Group name is not equal.", groupName, refreshGroup.getName());
    Assert.assertEquals("Group description is not equal.", groupDescription, refreshGroup.getDescription());

    Assert.assertTrue("User is not assigned to a site.", !refreshUser.getSites().isEmpty());

    final Site refreshSite = refreshUser.getSites().iterator().next();

    Assert.assertTrue("Site id has no value bigger than zero.", refreshSite.getId() > 0);
    Assert.assertEquals("Site name is not equal.", siteName, refreshSite.getName());
    Assert.assertEquals("Site description is not equal.", siteDescription, refreshSite.getDescription());
  }

  @Test
  public void testRemoveUserWithGroupAndSite() throws GNUOpenBusinessServiceException_Exception {
    final User persistUser = userWebServiceRepository.persist(metaData, user);
    userWebServiceRepository.remove(metaData, persistUser);

    final User findUser = userWebServiceRepository.find(metaData, persistUser);

    Assert.assertNull("User is found.", findUser);
  }

  @Test
  public void testRemoveUserWithGroupAndSiteButOtherHasRightToDelete() throws GNUOpenBusinessServiceException_Exception {
    Site userSite = user.getSites().iterator().next();
    Group userGroup = user.getGroups().iterator().next();

    user.setPermission(new Permission());
    user.getPermission().setOwner(Rule.DELETE_ACCESS);
    user.getPermission().setGroup(Rule.DELETE_ACCESS);
    user.getPermission().setOthers(Rule.DELETE_ACCESS);
    user.setAccess(Rule.DELETE_ACCESS);

    userSite.setPermission(new Permission());
    userSite.getPermission().setOwner(Rule.DELETE_ACCESS);
    userSite.getPermission().setGroup(Rule.DELETE_ACCESS);
    userSite.getPermission().setOthers(Rule.DELETE_ACCESS);

    userGroup.setPermission(new Permission());
    userGroup.getPermission().setOwner(Rule.DELETE_ACCESS);
    userGroup.getPermission().setGroup(Rule.DELETE_ACCESS);
    userGroup.getPermission().setOthers(Rule.DELETE_ACCESS);

    userWebServiceRepository.persist(metaData, user);

    testBefore();

    userSite = user.getSites().iterator().next();
    userGroup = user.getGroups().iterator().next();

    user.setPermission(new Permission());
    user.getPermission().setOwner(Rule.DELETE_ACCESS);
    user.getPermission().setGroup(Rule.DELETE_ACCESS);
    user.getPermission().setOthers(Rule.DELETE_ACCESS);
    user.setAccess(Rule.DELETE_ACCESS);

    userSite.setPermission(new Permission());
    userSite.getPermission().setOwner(Rule.DELETE_ACCESS);
    userSite.getPermission().setGroup(Rule.DELETE_ACCESS);
    userSite.getPermission().setOthers(Rule.DELETE_ACCESS);

    userGroup.setPermission(new Permission());
    userGroup.getPermission().setOwner(Rule.DELETE_ACCESS);
    userGroup.getPermission().setGroup(Rule.DELETE_ACCESS);
    userGroup.getPermission().setOthers(Rule.DELETE_ACCESS);

    User persistOtherUser = userWebServiceRepository.persist(metaData, user);

    testBefore();

    user.setPermission(new Permission());
    user.getPermission().setOwner(Rule.DELETE_ACCESS);
    user.getPermission().setGroup(Rule.DELETE_ACCESS);
    user.getPermission().setOthers(Rule.DELETE_ACCESS);
    user.setAccess(Rule.DELETE_ACCESS);

    User persistOtherNewUser = userWebServiceRepository.persist(metaData, user);

    persistOtherNewUser.getSites().add(persistOtherUser.getSites().iterator().next());
    persistOtherNewUser.getGroups().add(persistOtherUser.getGroups().iterator().next());

    persistOtherNewUser = userWebServiceRepository.merge(metaData, persistOtherNewUser);

    userWebServiceRepository.remove(metaData, persistOtherUser);

    persistOtherUser = userWebServiceRepository.find(metaData, persistOtherUser);

    Assert.assertNull("User is found.", persistOtherUser);
  }

  @Test
  public void testRemoveUserWithGroupAndSiteButOtherUserHasNoRightToDelete() throws GNUOpenBusinessServiceException_Exception {
    metaData.setUser("manager");
    metaData.setPassword("manager");

    final User persistUser = userWebServiceRepository.persist(metaData, user);

    metaData.setUser("employee");
    metaData.setPassword("employee");

    try {
      userWebServiceRepository.remove(metaData, persistUser);
    } catch (final Exception e) {
      Assert.assertEquals("Exception message is not equal.",
          "com.netbrasoft.gnuob.exception.GNUOpenBusinessServiceException: Given user [employee] doesn't have the right access to delete this entity object, verify that the given user has access",
          e.getMessage());
    }

    metaData.setUser("manager");
    metaData.setPassword("manager");

    final User findUser = userWebServiceRepository.find(metaData, persistUser);

    Assert.assertNotNull("User is not found.", findUser);
  }
}
