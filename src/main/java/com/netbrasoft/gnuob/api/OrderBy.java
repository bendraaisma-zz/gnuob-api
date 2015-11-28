
package com.netbrasoft.gnuob.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for orderBy.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
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
 *     &lt;enumeration value="NAME_A_Z"/&gt;
 *     &lt;enumeration value="NAME_Z_A"/&gt;
 *     &lt;enumeration value="DESCRIPTION_A_Z"/&gt;
 *     &lt;enumeration value="DESCRIPTION_Z_A"/&gt;
 *     &lt;enumeration value="PROPERTY_A_Z"/&gt;
 *     &lt;enumeration value="PROPERTY_Z_A"/&gt;
 *     &lt;enumeration value="PLACE_NAME_A_Z"/&gt;
 *     &lt;enumeration value="PLACE_NAME_Z_A"/&gt;
 *     &lt;enumeration value="COUNTRY_CODE_A_Z"/&gt;
 *     &lt;enumeration value="COUNTRY_CODE_Z_A"/&gt;
 *     &lt;enumeration value="POSTAL_CODE_A_Z"/&gt;
 *     &lt;enumeration value="POSTAL_CODE_Z_A"/&gt;
 *     &lt;enumeration value="STATE_NAME_A_Z"/&gt;
 *     &lt;enumeration value="STATE_NAME_Z_A"/&gt;
 *     &lt;enumeration value="VALUE_A_Z"/&gt;
 *     &lt;enumeration value="VALUE_Z_A"/&gt;
 *     &lt;enumeration value="POSITION_A_Z"/&gt;
 *     &lt;enumeration value="POSITION_Z_A"/&gt;
 *     &lt;enumeration value="NONE"/&gt;
 *     &lt;enumeration value="FIRST_NAME_A_Z"/&gt;
 *     &lt;enumeration value="FIRST_NAME_Z_A"/&gt;
 *     &lt;enumeration value="LAST_NAME_A_Z"/&gt;
 *     &lt;enumeration value="LAST_NAME_Z_A"/&gt;
 *     &lt;enumeration value="CONTRACT_ID_A_Z"/&gt;
 *     &lt;enumeration value="CONTRACT_ID_Z_A"/&gt;
 *     &lt;enumeration value="ORDER_ID_A_Z"/&gt;
 *     &lt;enumeration value="ORDER_ID_Z_A"/&gt;
 *     &lt;enumeration value="OFFER_ID_A_Z"/&gt;
 *     &lt;enumeration value="OFFER_ID_Z_A"/&gt;
 *     &lt;enumeration value="NUMBER_A_Z"/&gt;
 *     &lt;enumeration value="NUMBER_Z_A"/&gt;
 *     &lt;enumeration value="CREATION_A_Z"/&gt;
 *     &lt;enumeration value="CREATION_Z_A"/&gt;
 *     &lt;enumeration value="MODIFICATION_A_Z"/&gt;
 *     &lt;enumeration value="MODIFICATION_Z_A"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 *
 */
@XmlType(name = "orderBy")
@XmlEnum
public enum OrderBy {

  RECOMMENDED, HIGHEST_DISCOUNT, LOWEST_DISCOUNT, HIGHEST_PRICE, LOWEST_PRICE, HIGHEST_RATING, LOWEST_RATING, BESTSELLERS, LATEST_COLLECTION, NAME_A_Z, NAME_Z_A, DESCRIPTION_A_Z, DESCRIPTION_Z_A, PROPERTY_A_Z, PROPERTY_Z_A, PLACE_NAME_A_Z, PLACE_NAME_Z_A, COUNTRY_CODE_A_Z, COUNTRY_CODE_Z_A, POSTAL_CODE_A_Z, POSTAL_CODE_Z_A, STATE_NAME_A_Z, STATE_NAME_Z_A, VALUE_A_Z, VALUE_Z_A, POSITION_A_Z, POSITION_Z_A, NONE, FIRST_NAME_A_Z, FIRST_NAME_Z_A, LAST_NAME_A_Z, LAST_NAME_Z_A, CONTRACT_ID_A_Z, CONTRACT_ID_Z_A, ORDER_ID_A_Z, ORDER_ID_Z_A, OFFER_ID_A_Z, OFFER_ID_Z_A, NUMBER_A_Z, NUMBER_Z_A, CREATION_A_Z, CREATION_Z_A, MODIFICATION_A_Z, MODIFICATION_Z_A;

  public static OrderBy fromValue(final String v) {
    return valueOf(v);
  }

  public String value() {
    return name();
  }

}
