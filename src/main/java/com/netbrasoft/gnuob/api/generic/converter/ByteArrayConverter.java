package com.netbrasoft.gnuob.api.generic.converter;

import java.util.Locale;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

public class ByteArrayConverter implements IConverter<byte[]> {

  private static final long serialVersionUID = 6630478538421382400L;

  @Override
  public byte[] convertToObject(final String value, final Locale locale) throws ConversionException {
    return value != null ? value.getBytes() : null;
  }

  @Override
  public String convertToString(final byte[] value, final Locale locale) {
    return value != null ? new String(value) : null;
  }
}
