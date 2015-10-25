package com.netbrasoft.gnuob.generic.utils;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public final class Utils {

  public static Archive<?> createDeployment() {

    final JavaArchive[] wicketCore = Maven.resolver().resolve("org.apache.wicket:wicket-core:7.0.0").withoutTransitivity().as(JavaArchive.class);
    final JavaArchive[] wicketUtil = Maven.resolver().resolve("org.apache.wicket:wicket-util:7.0.0").withoutTransitivity().as(JavaArchive.class);
    final JavaArchive[] wicketExtentsion = Maven.resolver().resolve("org.apache.wicket:wicket-extensions:7.0.0").withoutTransitivity().as(JavaArchive.class);
    final JavaArchive[] pbkdf2 = Maven.resolver().resolve("de.rtner:PBKDF2:1.1.1").withoutTransitivity().as(JavaArchive.class);
    final JavaArchive[] picketbox = Maven.resolver().resolve("org.picketbox:picketbox:4.9.2.Final").withoutTransitivity().as(JavaArchive.class);

    return ShrinkWrap.create(WebArchive.class, "gnuob-test-application.war").addPackages(true, "com.netbrasoft.gnuob.generic").addPackages(true, "com.netbrasoft.gnuob.api")
        .addAsResource("META-INF/MANIFEST.MF", "META-INF/MANIFEST.MF").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
        .addAsLibraries(wicketCore, wicketUtil, wicketExtentsion, picketbox, pbkdf2);
  }
}
