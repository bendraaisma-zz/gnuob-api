
package com.netbrasoft.gnuob.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for operation.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="operation"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CREATE"/&gt;
 *     &lt;enumeration value="READ"/&gt;
 *     &lt;enumeration value="UPDATE"/&gt;
 *     &lt;enumeration value="DELETE"/&gt;
 *     &lt;enumeration value="NONE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 *
 */
@XmlType(name = "operation")
@XmlEnum
public enum Operation {

  CREATE, READ, UPDATE, DELETE, NONE;

  public static Operation fromValue(final String v) {
    return valueOf(v);
  }

  public String value() {
    return name();
  }

}
