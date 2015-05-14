package com.netbrasoft.gnuob.generic.utils;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import com.netbrasoft.gnuob.api.MetaData;

public final class Utils {

   public static Archive<?> createDeployment() {

      JavaArchive[] wicketCore = Maven.resolver().resolve("org.apache.wicket:wicket-core:7.0.0-SNAPSHOT").withoutTransitivity().as(JavaArchive.class);
      JavaArchive[] wicketUtil = Maven.resolver().resolve("org.apache.wicket:wicket-util:7.0.0-SNAPSHOT").withoutTransitivity().as(JavaArchive.class);
      JavaArchive[] wicketExtentsion = Maven.resolver().resolve("org.apache.wicket:wicket-extensions:7.0.0-SNAPSHOT").withoutTransitivity().as(JavaArchive.class);
      JavaArchive[] pbkdf2 = Maven.resolver().resolve("de.rtner:PBKDF2:1.1.0").withoutTransitivity().as(JavaArchive.class);
      JavaArchive[] picketbox = Maven.resolver().resolve("org.picketbox:picketbox:4.0.21.Final").withoutTransitivity().as(JavaArchive.class);

      return ShrinkWrap.create(WebArchive.class, "gnuob-test-application.war").addPackages(true, "com.netbrasoft.gnuob.generic").addPackages(true, "com.netbrasoft.gnuob.api").addAsResource("META-INF/MANIFEST.MF", "META-INF/MANIFEST.MF")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml").addAsLibraries(wicketCore, wicketUtil, wicketExtentsion, picketbox, pbkdf2);
   }

   public static MetaData paramMetaData() {
      MetaData paramMetaData = new MetaData();
      paramMetaData.setUser("admin");
      paramMetaData.setPassword("admin");
      paramMetaData.setSite("www.netbrasoft.com");

      return paramMetaData;
   }
}
