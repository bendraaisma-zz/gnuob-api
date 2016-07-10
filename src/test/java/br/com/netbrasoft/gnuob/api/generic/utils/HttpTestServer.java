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

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.DELAY_TIME_IN_SEC;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.PORT;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SOCKET_ADDRESS;

import java.net.InetSocketAddress;

import org.junit.rules.ExternalResource;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class HttpTestServer extends ExternalResource {

  private static final String HOST_NAME = "0.0.0.0";
  private final InetSocketAddress address;
  private HttpServer httpServer;

  public static HttpTestServer server() {
    return new HttpTestServer(PORT);
  }

  public HttpTestServer(final int port) {
    address = new InetSocketAddress(HOST_NAME, port);
  }

  @Override
  protected final void before() throws Throwable {
    super.before();
    httpServer = HttpServer.create(address, SOCKET_ADDRESS);
    httpServer.start();
  }

  @Override
  protected final void after() {
    httpServer.stop(DELAY_TIME_IN_SEC);
    super.after();
  }

  public void addHandler(final String path, final HttpHandler handler) {
    httpServer.createContext(path, handler);
  }
}
