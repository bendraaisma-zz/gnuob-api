
package com.netbrasoft.gnuob.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rule.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="rule">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREATE_ACCESS"/>
 *     &lt;enumeration value="READ_ACCESS"/>
 *     &lt;enumeration value="UPDATE_ACCESS"/>
 *     &lt;enumeration value="DELETE_ACCESS"/>
 *     &lt;enumeration value="NONE_ACCESS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "rule")
@XmlEnum
public enum Rule {

    CREATE_ACCESS,
    READ_ACCESS,
    UPDATE_ACCESS,
    DELETE_ACCESS,
    NONE_ACCESS;

    public String value() {
        return name();
    }

    public static Rule fromValue(String v) {
        return valueOf(v);
    }

}
