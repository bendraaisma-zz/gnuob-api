
package com.netbrasoft.gnuob.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for rule.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="rule"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CREATE_ACCESS"/&gt;
 *     &lt;enumeration value="READ_ACCESS"/&gt;
 *     &lt;enumeration value="UPDATE_ACCESS"/&gt;
 *     &lt;enumeration value="DELETE_ACCESS"/&gt;
 *     &lt;enumeration value="NONE_ACCESS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "rule")
@XmlEnum
public enum Rule {

  CREATE_ACCESS, READ_ACCESS, UPDATE_ACCESS, DELETE_ACCESS, NONE_ACCESS;

  public String value() {
    return name();
  }

  public static Rule fromValue(String v) {
    return valueOf(v);
  }

}
