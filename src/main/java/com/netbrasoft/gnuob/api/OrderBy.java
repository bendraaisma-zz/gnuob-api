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
 * &lt;simpleType name="orderBy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RECOMMENDED"/>
 *     &lt;enumeration value="HIGHEST_DISCOUNT"/>
 *     &lt;enumeration value="LOWEST_DISCOUNT"/>
 *     &lt;enumeration value="HIGHEST_PRICE"/>
 *     &lt;enumeration value="LOWEST_PRICE"/>
 *     &lt;enumeration value="HIGHEST_RATING"/>
 *     &lt;enumeration value="LOWEST_RATING"/>
 *     &lt;enumeration value="BESTSELLERS"/>
 *     &lt;enumeration value="LATEST_COLLECTION"/>
 *     &lt;enumeration value="TITLE_A_Z"/>
 *     &lt;enumeration value="TITLE_Z_A"/>
 *     &lt;enumeration value="POSITION_A_Z"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
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
