package com.netbrasoft.gnuob.api.content;

import java.io.ByteArrayOutputStream;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class JaxbDataHandlerAdapter extends XmlAdapter<DataHandler, byte[]> {

   @Override
   public DataHandler marshal(byte[] v) throws Exception {
      if (v != null) {
         return new DataHandler(v, "application/octet-stream");
      }
      return null;
   }

   @Override
   public byte[] unmarshal(DataHandler v) throws Exception {
      if (v != null) {
         ByteArrayOutputStream output = new ByteArrayOutputStream();
         v.writeTo(output);
         return output.toByteArray();
      }
      return null;
   }
}
