package com.netbrasoft.gnuob.api.generic.converter;

import java.util.Locale;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

public class ByteArrayConverter implements IConverter<byte[]> {

   private static final long serialVersionUID = 6630478538421382400L;

   @Override
   public byte[] convertToObject(String value, Locale locale) throws ConversionException {
      return value != null ? value.getBytes() : null;
   }

   @Override
   public String convertToString(byte[] value, Locale locale) {
      return value != null ? new String(value) : null;
   }
}
