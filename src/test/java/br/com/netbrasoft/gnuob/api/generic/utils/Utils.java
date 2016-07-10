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

package br.com.netbrasoft.gnuob.api.generic.utils;

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.APPLICATION_CONTEXT_XML;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.BR_COM_NETBRASOFT_GNUOB_API_PKG;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.BR_COM_NETBRASOFT_GNUOB_GENERIC_PKG;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.GNUOB_API_WAR;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.GUAVA;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.HTTPCLIENT;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.HTTPSERVER;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.META_INF_MANIFEST_MF;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.PBKDF2;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.PICKETBOX;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.POM_XML;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SELENIUM_API;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SELENIUM_SUPPORT;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SPRING_CONTEXT;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SPRING_WEB;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.WEB_XML;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.WICKET_CORE;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.WICKET_EXTENSIONS;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.WICKET_UTIL;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public final class Utils {

  public static Archive<?> createDeployment() {
    return ShrinkWrap.create(WebArchive.class, GNUOB_API_WAR).addPackages(true, BR_COM_NETBRASOFT_GNUOB_GENERIC_PKG)
        .addPackages(true, BR_COM_NETBRASOFT_GNUOB_API_PKG).addAsResource(META_INF_MANIFEST_MF)
        .addAsWebInfResource(APPLICATION_CONTEXT_XML).addAsWebInfResource(WEB_XML)
        .addAsLibraries(Maven.resolver()
            .loadPomFromFile(POM_XML).resolve(HTTPCLIENT, HTTPSERVER, GUAVA, SELENIUM_API, SELENIUM_SUPPORT,
                WICKET_UTIL, WICKET_EXTENSIONS, WICKET_CORE, PICKETBOX, PBKDF2, SPRING_CONTEXT, SPRING_WEB)
            .withTransitivity().asFile());
  }
}
