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

import java.net.InetSocketAddress;

import org.junit.rules.ExternalResource;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

@SuppressWarnings("restriction")
public class HttpTestServer extends ExternalResource {

  private final InetSocketAddress address;
  private HttpServer httpServer;

  public static HttpTestServer server() {
    return new HttpTestServer(8000);
  }

  public HttpTestServer(final int port) {
    address = new InetSocketAddress(port);
  }

  @Override
  protected final void before() throws Throwable {
    super.before();
    httpServer = HttpServer.create(address, 0);
    httpServer.start();
  }

  @Override
  protected final void after() {
    httpServer.stop(0);
    super.after();
  }

  public void addHandler(final String path, final HttpHandler handler) {
    httpServer.createContext(path, handler);
  }
}
