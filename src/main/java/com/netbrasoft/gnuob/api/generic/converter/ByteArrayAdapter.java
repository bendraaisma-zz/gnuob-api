
package com.netbrasoft.gnuob.api.generic.converter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ByteArrayAdapter extends XmlAdapter<String, byte[]> {

  @Override
  public byte[] unmarshal(final String value) {
    return value.getBytes();
  }

  @Override
  public String marshal(final byte[] value) {
    if (value == null) {
      return null;
    }
    return new String(value);
  }

}
