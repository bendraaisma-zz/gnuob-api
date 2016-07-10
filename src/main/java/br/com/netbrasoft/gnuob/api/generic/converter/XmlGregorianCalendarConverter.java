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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

public class XmlGregorianCalendarConverter implements IConverter<XMLGregorianCalendar> {

  private static final long serialVersionUID = -5566238811480030646L;

  @Override
  public XMLGregorianCalendar convertToObject(final String value, final Locale locale) {
    try {
      final GregorianCalendar gregorianCalendar = new GregorianCalendar();
      gregorianCalendar.setTime(DateFormat.getDateInstance(DateFormat.SHORT, locale).parse(value));
      return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
    } catch (final DatatypeConfigurationException | ParseException e) {
      throw new ConversionException(e.getMessage(), e);
    }
  }

  @Override
  public String convertToString(final XMLGregorianCalendar value, final Locale locale) {
    return new SimpleDateFormat("dd-MM-YYYY").format(value.toGregorianCalendar().getTime());
  }
}
