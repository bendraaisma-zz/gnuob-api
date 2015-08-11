
package com.netbrasoft.gnuob.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for orderBy.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="orderBy"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="RECOMMENDED"/&gt;
 *     &lt;enumeration value="HIGHEST_DISCOUNT"/&gt;
 *     &lt;enumeration value="LOWEST_DISCOUNT"/&gt;
 *     &lt;enumeration value="HIGHEST_PRICE"/&gt;
 *     &lt;enumeration value="LOWEST_PRICE"/&gt;
 *     &lt;enumeration value="HIGHEST_RATING"/&gt;
 *     &lt;enumeration value="LOWEST_RATING"/&gt;
 *     &lt;enumeration value="BESTSELLERS"/&gt;
 *     &lt;enumeration value="LATEST_COLLECTION"/&gt;
 *     &lt;enumeration value="TITLE_A_Z"/&gt;
 *     &lt;enumeration value="TITLE_Z_A"/&gt;
 *     &lt;enumeration value="POSITION_A_Z"/&gt;
 *     &lt;enumeration value="NONE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "orderBy")
@XmlEnum
public enum OrderBy {

   RECOMMENDED, HIGHEST_DISCOUNT, LOWEST_DISCOUNT, HIGHEST_PRICE, LOWEST_PRICE, HIGHEST_RATING, LOWEST_RATING, BESTSELLERS, LATEST_COLLECTION, TITLE_A_Z, TITLE_Z_A, POSITION_A_Z, NONE;

   public String value() {
      return name();
   }

   public static OrderBy fromValue(String v) {
      return valueOf(v);
   }

}
