/*
 * Copyright 2016 Netbrasoft
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.netbrasoft.gnuob.generic.utils;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public final class Utils {

  private static final String APPLICATION_CONTEXT_XML = "applicationContext.xml";
  private static final String COM_NETBRASOFT_GNUOB_API_PKG = "com.netbrasoft.gnuob.api";
  private static final String COM_NETBRASOFT_GNUOB_GENERIC_PKG = "com.netbrasoft.gnuob.generic";
  private static final String GNUOB_API_WAR = "gnuob-api.war";
  private static final String META_INF_MANIFEST_MF = "META-INF/MANIFEST.MF";
  private static final String PBKDF2 = "de.rtner:PBKDF2:1.1.1";
  private static final String PICKETBOX = "org.picketbox:picketbox:4.9.4.Final";
  private static final String POM_XML = "pom.xml";
  private static final String SPRING_CONTEXT = "org.springframework:spring-context:4.1.7.RELEASE";
  private static final String SPRING_WEB = "org.springframework:spring-web:4.1.7.RELEASE";
  private static final String WEB_XML = "web.xml";
  private static final String WICKET_CORE = "org.apache.wicket:wicket-core:7.2.0";
  private static final String WICKET_EXTENSIONS = "org.apache.wicket:wicket-extensions:7.2.0";
  private static final String WICKET_UTIL = "org.apache.wicket:wicket-util:7.2.0";

  public static Archive<?> createDeployment() {
    return ShrinkWrap.create(WebArchive.class, GNUOB_API_WAR)
        .addPackages(true, COM_NETBRASOFT_GNUOB_GENERIC_PKG).addPackages(true, COM_NETBRASOFT_GNUOB_API_PKG)
        .addAsResource(META_INF_MANIFEST_MF).addAsWebInfResource(APPLICATION_CONTEXT_XML).addAsWebInfResource(WEB_XML)
        .addAsLibraries(Maven.resolver().loadPomFromFile(POM_XML)
            .resolve(WICKET_UTIL, WICKET_EXTENSIONS, WICKET_CORE, PICKETBOX, PBKDF2, SPRING_CONTEXT, SPRING_WEB)
            .withTransitivity().asFile());
  }
}
