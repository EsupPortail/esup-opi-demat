/**
 * AcademieDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gouv.education.apogee.commun.transverse.dto.etablissement.AcademieDTO;

public class AcademieDTO  implements java.io.Serializable {
    private java.lang.String codAcd;

    private java.lang.String libAcd;

    public AcademieDTO() {
    }

    public AcademieDTO(
           java.lang.String codAcd,
           java.lang.String libAcd) {
           this.codAcd = codAcd;
           this.libAcd = libAcd;
    }


    /**
     * Gets the codAcd value for this AcademieDTO.
     * 
     * @return codAcd
     */
    public java.lang.String getCodAcd() {
        return codAcd;
    }


    /**
     * Sets the codAcd value for this AcademieDTO.
     * 
     * @param codAcd
     */
    public void setCodAcd(java.lang.String codAcd) {
        this.codAcd = codAcd;
    }


    /**
     * Gets the libAcd value for this AcademieDTO.
     * 
     * @return libAcd
     */
    public java.lang.String getLibAcd() {
        return libAcd;
    }


    /**
     * Sets the libAcd value for this AcademieDTO.
     * 
     * @param libAcd
     */
    public void setLibAcd(java.lang.String libAcd) {
        this.libAcd = libAcd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AcademieDTO)) return false;
        AcademieDTO other = (AcademieDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codAcd==null && other.getCodAcd()==null) || 
             (this.codAcd!=null &&
              this.codAcd.equals(other.getCodAcd()))) &&
            ((this.libAcd==null && other.getLibAcd()==null) || 
             (this.libAcd!=null &&
              this.libAcd.equals(other.getLibAcd())));
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
        if (getCodAcd() != null) {
            _hashCode += getCodAcd().hashCode();
        }
        if (getLibAcd() != null) {
            _hashCode += getLibAcd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AcademieDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("AcademieDTO.etablissement.dto.transverse.commun.apogee.education.gouv", "AcademieDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codAcd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codAcd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("libAcd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "libAcd"));
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
