/**
 * PaysDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gouv.education.apogee.commun.transverse.dto.etablissement.PaysDTO;

public class PaysDTO  implements java.io.Serializable {
    private java.lang.String codPay;

    private java.lang.String libPay;

    public PaysDTO() {
    }

    public PaysDTO(
           java.lang.String codPay,
           java.lang.String libPay) {
           this.codPay = codPay;
           this.libPay = libPay;
    }


    /**
     * Gets the codPay value for this PaysDTO.
     * 
     * @return codPay
     */
    public java.lang.String getCodPay() {
        return codPay;
    }


    /**
     * Sets the codPay value for this PaysDTO.
     * 
     * @param codPay
     */
    public void setCodPay(java.lang.String codPay) {
        this.codPay = codPay;
    }


    /**
     * Gets the libPay value for this PaysDTO.
     * 
     * @return libPay
     */
    public java.lang.String getLibPay() {
        return libPay;
    }


    /**
     * Sets the libPay value for this PaysDTO.
     * 
     * @param libPay
     */
    public void setLibPay(java.lang.String libPay) {
        this.libPay = libPay;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PaysDTO)) return false;
        PaysDTO other = (PaysDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codPay==null && other.getCodPay()==null) || 
             (this.codPay!=null &&
              this.codPay.equals(other.getCodPay()))) &&
            ((this.libPay==null && other.getLibPay()==null) || 
             (this.libPay!=null &&
              this.libPay.equals(other.getLibPay())));
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
        if (getCodPay() != null) {
            _hashCode += getCodPay().hashCode();
        }
        if (getLibPay() != null) {
            _hashCode += getLibPay().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PaysDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("PaysDTO.etablissement.dto.transverse.commun.apogee.education.gouv", "PaysDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codPay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codPay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("libPay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "libPay"));
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
