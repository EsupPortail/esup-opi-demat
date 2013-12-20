/**
 * DepartementDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gouv.education.apogee.commun.transverse.dto.etablissement.DepartementDTO;

public class DepartementDTO  implements java.io.Serializable {
    private java.lang.String codeDept;

    private java.lang.String libDept;

    private java.lang.String temEnSveDept;

    public DepartementDTO() {
    }

    public DepartementDTO(
           java.lang.String codeDept,
           java.lang.String libDept,
           java.lang.String temEnSveDept) {
           this.codeDept = codeDept;
           this.libDept = libDept;
           this.temEnSveDept = temEnSveDept;
    }


    /**
     * Gets the codeDept value for this DepartementDTO.
     * 
     * @return codeDept
     */
    public java.lang.String getCodeDept() {
        return codeDept;
    }


    /**
     * Sets the codeDept value for this DepartementDTO.
     * 
     * @param codeDept
     */
    public void setCodeDept(java.lang.String codeDept) {
        this.codeDept = codeDept;
    }


    /**
     * Gets the libDept value for this DepartementDTO.
     * 
     * @return libDept
     */
    public java.lang.String getLibDept() {
        return libDept;
    }


    /**
     * Sets the libDept value for this DepartementDTO.
     * 
     * @param libDept
     */
    public void setLibDept(java.lang.String libDept) {
        this.libDept = libDept;
    }


    /**
     * Gets the temEnSveDept value for this DepartementDTO.
     * 
     * @return temEnSveDept
     */
    public java.lang.String getTemEnSveDept() {
        return temEnSveDept;
    }


    /**
     * Sets the temEnSveDept value for this DepartementDTO.
     * 
     * @param temEnSveDept
     */
    public void setTemEnSveDept(java.lang.String temEnSveDept) {
        this.temEnSveDept = temEnSveDept;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DepartementDTO)) return false;
        DepartementDTO other = (DepartementDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codeDept==null && other.getCodeDept()==null) || 
             (this.codeDept!=null &&
              this.codeDept.equals(other.getCodeDept()))) &&
            ((this.libDept==null && other.getLibDept()==null) || 
             (this.libDept!=null &&
              this.libDept.equals(other.getLibDept()))) &&
            ((this.temEnSveDept==null && other.getTemEnSveDept()==null) || 
             (this.temEnSveDept!=null &&
              this.temEnSveDept.equals(other.getTemEnSveDept())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCodeDept() != null) {
            _hashCode += getCodeDept().hashCode();
        }
        if (getLibDept() != null) {
            _hashCode += getLibDept().hashCode();
        }
        if (getTemEnSveDept() != null) {
            _hashCode += getTemEnSveDept().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DepartementDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("DepartementDTO.etablissement.dto.transverse.commun.apogee.education.gouv", "DepartementDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeDept");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codeDept"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("libDept");
        elemField.setXmlName(new javax.xml.namespace.QName("", "libDept"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temEnSveDept");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temEnSveDept"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
