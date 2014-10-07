package com.netbrasoft.gnuob.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for operation.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="operation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREATE"/>
 *     &lt;enumeration value="READ"/>
 *     &lt;enumeration value="UPDATE"/>
 *     &lt;enumeration value="DELETE"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "operation")
@XmlEnum
public enum Operation {

    CREATE, READ, UPDATE, DELETE, NONE;

    public String value() {
        return name();
    }

    public static Operation fromValue(String v) {
        return valueOf(v);
    }

}
