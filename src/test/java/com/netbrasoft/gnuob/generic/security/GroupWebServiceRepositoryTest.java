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
import com.netbrasoft.gnuob.api.Role;
import com.netbrasoft.gnuob.api.Rule;
import com.netbrasoft.gnuob.api.Site;
import com.netbrasoft.gnuob.api.User;
import com.netbrasoft.gnuob.api.security.GroupWebServiceRepository;
import com.netbrasoft.gnuob.generic.utils.Utils;

@RunWith(Arquillian.class)
public class GroupWebServiceRepositoryTest {

  @Deployment
  public static Archive<?> createDeployment() {
    return Utils.createDeployment();
  }

  private final GroupWebServiceRepository<Group> groupWebServiceRepository = new GroupWebServiceRepository<Group>();

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
    metaData.setSite("localhost");

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
  public void testFindGroup() throws GNUOpenBusinessServiceException_Exception {
    final String groupName = group.getName();
    final String groupDescription = group.getDescription();

    final Group persistGroup = groupWebServiceRepository.persist(metaData, group);

    final Group findGroup = groupWebServiceRepository.find(metaData, persistGroup);

    Assert.assertTrue("Group id has no value bigger than zero.", findGroup.getId() > 0);
    Assert.assertEquals("Group name is not equal.", groupName, findGroup.getName());
    Assert.assertEquals("Group description is not equal.", groupDescription, findGroup.getDescription());
  }

  @Test
  public void testMergeGroup() throws GNUOpenBusinessServiceException_Exception {
    final String groupName = UUID.randomUUID().toString();
    final String groupDescription = UUID.randomUUID().toString();

    final Group persistGroup = groupWebServiceRepository.persist(metaData, group);

    persistGroup.setName(groupName);
    persistGroup.setDescription(groupDescription);

    final Group mergeGroup = groupWebServiceRepository.merge(metaData, persistGroup);

    Assert.assertTrue("Group id has no value bigger than zero.", mergeGroup.getId() > 0);
    Assert.assertEquals("Group name is not equal.", groupName, mergeGroup.getName());
    Assert.assertEquals("Group description is not equal.", groupDescription, mergeGroup.getDescription());
  }

  @Test
  public void testPersistGroup() throws GNUOpenBusinessServiceException_Exception {
    final String groupName = group.getName();
    final String groupDescription = group.getDescription();

    final Group persistGroup = groupWebServiceRepository.persist(metaData, group);

    Assert.assertTrue("Group id has no value bigger than zero.", persistGroup.getId() > 0);
    Assert.assertEquals("Group name is not equal.", groupName, persistGroup.getName());
    Assert.assertEquals("Group description is not equal.", groupDescription, persistGroup.getDescription());
  }

  @Test
  public void testRefreshGroup() throws GNUOpenBusinessServiceException_Exception {
    final Group persistGroup = groupWebServiceRepository.persist(metaData, group);

    final String groupName = group.getName();
    final String groupDescription = group.getDescription();

    persistGroup.setName(UUID.randomUUID().toString());
    persistGroup.setDescription(UUID.randomUUID().toString());

    final Group refreshGroup = groupWebServiceRepository.refresh(metaData, persistGroup);

    Assert.assertTrue("Group id has no value bigger than zero.", refreshGroup.getId() > 0);
    Assert.assertEquals("Group name is not equal.", groupName, refreshGroup.getName());
    Assert.assertEquals("Group description is not equal.", groupDescription, refreshGroup.getDescription());
  }

  @Test
  public void testRemoveGroup() throws GNUOpenBusinessServiceException_Exception {
    final Group persistGroup = groupWebServiceRepository.persist(metaData, group);
    groupWebServiceRepository.remove(metaData, persistGroup);

    final Group findGroup = groupWebServiceRepository.find(metaData, persistGroup);

    Assert.assertNull("Group is found.", findGroup);
  }

  @Test
  public void testRemoveUserWithGroupAndGroupButOtherUserHasNoRightToDelete() throws GNUOpenBusinessServiceException_Exception {
    metaData.setUser("manager");
    metaData.setPassword("manager");

    final Group persistGroup = groupWebServiceRepository.persist(metaData, group);

    metaData.setUser("employee");
    metaData.setPassword("employee");

    try {
      groupWebServiceRepository.remove(metaData, persistGroup);
    } catch (final Exception e) {
      Assert.assertEquals("Exception message is not equal.",
          "com.netbrasoft.gnuob.exception.GNUOpenBusinessServiceException: Given user [employee] doesn't have the right access to delete this entity object, verify that the given user has access",
          e.getMessage());
    }

    metaData.setUser("manager");
    metaData.setPassword("manager");

    final Group findGroup = groupWebServiceRepository.find(metaData, persistGroup);

    Assert.assertNotNull("Group is not found.", findGroup);
  }

}
