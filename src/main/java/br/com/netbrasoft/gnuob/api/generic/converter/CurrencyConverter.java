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

import static java.text.NumberFormat.getCurrencyInstance;
import static java.text.NumberFormat.getNumberInstance;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.converter.AbstractNumberConverter;

public class CurrencyConverter extends AbstractNumberConverter<BigDecimal> {

  private static final long serialVersionUID = 5677756371671782444L;

  public static final CurrencyConverter getInstance() {
    return new CurrencyConverter();
  }

  @Override
  public BigDecimal convertToObject(final String value, final Locale locale) {
    try {
      return (BigDecimal) getNumberInstance(locale).parse(value.replaceAll("[^\\d.,]", ""));
    } catch (final ParseException e) {
      throw new ConversionException(e.getMessage(), e);
    }
  }

  @Override
  protected Class<BigDecimal> getTargetType() {
    return BigDecimal.class;
  }

  @Override
  protected NumberFormat newNumberFormat(final Locale locale) {
    return getCurrencyInstance();
  }
}
