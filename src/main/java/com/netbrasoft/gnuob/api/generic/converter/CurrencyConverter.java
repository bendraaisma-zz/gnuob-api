package com.netbrasoft.gnuob.api.generic.converter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.converter.AbstractNumberConverter;

public class CurrencyConverter extends AbstractNumberConverter<BigDecimal> {

  private static final long serialVersionUID = 5677756371671782444L;

  @Override
  public BigDecimal convertToObject(final String value, final Locale locale) throws ConversionException {
    try {
      return (BigDecimal) NumberFormat.getNumberInstance(locale).parse(value.replaceAll("[^\\d.,]", ""));
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
    return NumberFormat.getCurrencyInstance();
  }

}
