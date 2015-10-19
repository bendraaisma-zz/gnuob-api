package com.netbrasoft.gnuob.api.generic.converter;

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
  public XMLGregorianCalendar convertToObject(String value, Locale locale) {
    try {
      final GregorianCalendar gregorianCalendar = new GregorianCalendar();
      gregorianCalendar.setTime(DateFormat.getDateInstance(DateFormat.SHORT, locale).parse(value));

      return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
    } catch (final DatatypeConfigurationException | ParseException e) {
      throw new ConversionException(e.getMessage(), e);
    }
  }

  @Override
  public String convertToString(XMLGregorianCalendar value, Locale locale) {
    return new SimpleDateFormat("dd-MM-YYYY").format(value.toGregorianCalendar().getTime());
  }
}
