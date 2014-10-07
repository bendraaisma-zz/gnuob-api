package com.netbrasoft.gnuob.generic.security;

import java.util.UUID;

import javax.xml.ws.soap.SOAPFaultException;

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
import com.netbrasoft.gnuob.api.Rule;
import com.netbrasoft.gnuob.api.Site;
import com.netbrasoft.gnuob.api.User;
import com.netbrasoft.gnuob.api.security.SiteWebServiceRepository;
import com.netbrasoft.gnuob.generic.utils.Utils;

@RunWith(Arquillian.class)
public class SiteWebServiceRepositoryTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return Utils.createDeployment();
    }

    private SiteWebServiceRepository siteWebServiceRepository = new SiteWebServiceRepository();
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
        user.setRole(UUID.randomUUID().toString());
        user.setAccess(Rule.NONE_ACCESS);

        group.setName(UUID.randomUUID().toString());
        group.setDescription(UUID.randomUUID().toString());

        site.setName(UUID.randomUUID().toString());
        site.setDescription(UUID.randomUUID().toString());

        user.getGroups().add(group);
        user.getSites().add(site);
    }

    @Test
    public void testFindSite() throws GNUOpenBusinessServiceException_Exception {
        String siteName = site.getName();
        String siteDescription = site.getDescription();

        Site persistSite = siteWebServiceRepository.persist(metaData, site);

        Site findSite = siteWebServiceRepository.find(metaData, persistSite);

        Assert.assertTrue("Site id has no value bigger than zero.", findSite.getId() > 0);
        Assert.assertEquals("Site name is not equal.", siteName, findSite.getName());
        Assert.assertEquals("Site description is not equal.", siteDescription, findSite.getDescription());
    }

    @Test
    public void testMergeSite() throws GNUOpenBusinessServiceException_Exception {
        String siteName = UUID.randomUUID().toString();
        String siteDescription = UUID.randomUUID().toString();

        Site persistSite = siteWebServiceRepository.persist(metaData, site);

        persistSite.setName(siteName);
        persistSite.setDescription(siteDescription);

        Site mergeSite = siteWebServiceRepository.merge(metaData, persistSite);

        Assert.assertTrue("Site id has no value bigger than zero.", mergeSite.getId() > 0);
        Assert.assertEquals("Site name is not equal.", siteName, mergeSite.getName());
        Assert.assertEquals("Site description is not equal.", siteDescription, mergeSite.getDescription());
    }

    @Test
    public void testPersistSite() throws GNUOpenBusinessServiceException_Exception {
        String siteName = site.getName();
        String siteDescription = site.getDescription();

        Site persistSite = siteWebServiceRepository.persist(metaData, site);

        Assert.assertTrue("Site id has no value bigger than zero.", persistSite.getId() > 0);
        Assert.assertEquals("Site name is not equal.", siteName, persistSite.getName());
        Assert.assertEquals("Site description is not equal.", siteDescription, persistSite.getDescription());
    }

    @Test
    public void testPersistSiteWithSiteThatDoesNotExist() throws GNUOpenBusinessServiceException_Exception {
        metaData.setSite("NO_ACCESS_SITE");

        try {
            siteWebServiceRepository.persist(metaData, site);
        } catch (Exception e) {
            Assert.assertEquals("Exception message is not equal.", "com.netbrasoft.gnuob.exception.GNUOpenBusinessServiceException: Given site [NO_ACCESS_SITE] doesn't have the right access, verify that the given site has access.", e.getMessage());
        }
    }

    @Test
    public void testPersistSiteWithUserThatHasNoCreateAccess() throws GNUOpenBusinessServiceException_Exception {
        metaData.setUser("guest");
        metaData.setPassword("guest");
        metaData.setSite("www.netbrasoft.com");

        try {
            siteWebServiceRepository.persist(metaData, site);
        } catch (SOAPFaultException e) {
            Assert.assertEquals("Exception message is not equal.", "com.netbrasoft.gnuob.exception.GNUOpenBusinessServiceException: Given user [guest] doesn't have the right access, verify that the given user has access.", e.getMessage());
        }
    }

    @Test
    public void testPersistSiteWithUserThatHaveNoAccessToTheSite() throws GNUOpenBusinessServiceException_Exception {
        metaData.setUser("manager");
        metaData.setPassword("manager");
        metaData.setSite("www.cheirodeflor.nl");

        try {
            siteWebServiceRepository.persist(metaData, site);
        } catch (SOAPFaultException e) {
            Assert.assertEquals("Exception message is not equal.",
                    "com.netbrasoft.gnuob.exception.GNUOpenBusinessServiceException: Given user [manager] doesn't have the right access for site [www.cheirodeflor.nl], verify that the given user have access to the site.", e.getMessage());
        }
    }

    @Test
    public void testPersistSiteWithUserThatThatDoesNotExist() throws GNUOpenBusinessServiceException_Exception {
        metaData.setUser("NO_ACCESS_USER");

        try {
            siteWebServiceRepository.persist(metaData, site);
        } catch (Exception e) {
            Assert.assertEquals("Exception message is not equal.", "com.netbrasoft.gnuob.exception.GNUOpenBusinessServiceException: Given user [NO_ACCESS_USER] doesn't have the right access, verify that the given user has access.", e.getMessage());
        }
    }

    @Test
    public void testRefreshSite() throws GNUOpenBusinessServiceException_Exception {
        Site persistSite = siteWebServiceRepository.persist(metaData, site);

        String siteName = site.getName();
        String siteDescription = site.getDescription();

        persistSite.setName(UUID.randomUUID().toString());
        persistSite.setDescription(UUID.randomUUID().toString());

        Site refreshSite = siteWebServiceRepository.refresh(metaData, persistSite);

        Assert.assertTrue("Site id has no value bigger than zero.", refreshSite.getId() > 0);
        Assert.assertEquals("Site name is not equal.", siteName, refreshSite.getName());
        Assert.assertEquals("Site description is not equal.", siteDescription, refreshSite.getDescription());
    }

    @Test
    public void testRemoveSite() throws GNUOpenBusinessServiceException_Exception {
        Site persistSite = siteWebServiceRepository.persist(metaData, site);
        siteWebServiceRepository.remove(metaData, persistSite);

        Site findSite = siteWebServiceRepository.find(metaData, persistSite);

        Assert.assertNull("Site is found.", findSite);
    }

    @Test
    public void testRemoveUserWithGroupAndSiteButOtherUserHasNoRightToDelete() throws GNUOpenBusinessServiceException_Exception {
        metaData.setUser("manager");
        metaData.setPassword("manager");

        Site persistSite = siteWebServiceRepository.persist(metaData, site);

        metaData.setUser("employee");
        metaData.setPassword("employee");

        try {
            siteWebServiceRepository.remove(metaData, persistSite);
        } catch (Exception e) {
            Assert.assertEquals("Exception message is not equal.", "com.netbrasoft.gnuob.exception.GNUOpenBusinessServiceException: Given user [employee] doesn't have the right access, verify that the given user has access.", e.getMessage());
        }

        metaData.setUser("manager");
        metaData.setPassword("manager");

        Site findSite = siteWebServiceRepository.find(metaData, persistSite);

        Assert.assertNotNull("Site is not found.", findSite);
    }
}
