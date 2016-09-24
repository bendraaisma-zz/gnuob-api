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

package br.com.netbrasoft.gnuob.api.generic.converter;

import static java.util.Base64.getDecoder;
import static java.util.Base64.getEncoder;

import java.util.Locale;

import org.apache.wicket.util.convert.IConverter;

public class ByteArrayConverter implements IConverter<byte[]> {

  private static final long serialVersionUID = 6630478538421382400L;

  @Override
  public byte[] convertToObject(final String value, final Locale locale) {
    return value != null ? getEncoder().encode(value.getBytes()) : null;
  }

  @Override
  public String convertToString(final byte[] value, final Locale locale) {
    return value != null ? new String(getDecoder().decode(value)) : null;
  }
}
