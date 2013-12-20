/**
 * TypeEtablissementDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gouv.education.apogee.commun.transverse.dto.etablissement.TypeEtablissementDTO;

public class TypeEtablissementDTO  implements java.io.Serializable {
    private java.lang.String codTypeEtb;

    private java.lang.String libLongTpe;

    private java.lang.String temEnSveTpe;

    public TypeEtablissementDTO() {
    }

    public TypeEtablissementDTO(
           java.lang.String codTypeEtb,
           java.lang.String libLongTpe,
           java.lang.String temEnSveTpe) {
           this.codTypeEtb = codTypeEtb;
           this.libLongTpe = libLongTpe;
           this.temEnSveTpe = temEnSveTpe;
    }


    /**
     * Gets the codTypeEtb value for this TypeEtablissementDTO.
     * 
     * @return codTypeEtb
     */
    public java.lang.String getCodTypeEtb() {
        return codTypeEtb;
    }


    /**
     * Sets the codTypeEtb value for this TypeEtablissementDTO.
     * 
     * @param codTypeEtb
     */
    public void setCodTypeEtb(java.lang.String codTypeEtb) {
        this.codTypeEtb = codTypeEtb;
    }


    /**
     * Gets the libLongTpe value for this TypeEtablissementDTO.
     * 
     * @return libLongTpe
     */
    public java.lang.String getLibLongTpe() {
        return libLongTpe;
    }


    /**
     * Sets the libLongTpe value for this TypeEtablissementDTO.
     * 
     * @param libLongTpe
     */
    public void setLibLongTpe(java.lang.String libLongTpe) {
        this.libLongTpe = libLongTpe;
    }


    /**
     * Gets the temEnSveTpe value for this TypeEtablissementDTO.
     * 
     * @return temEnSveTpe
     */
    public java.lang.String getTemEnSveTpe() {
        return temEnSveTpe;
    }


    /**
     * Sets the temEnSveTpe value for this TypeEtablissementDTO.
     * 
     * @param temEnSveTpe
     */
    public void setTemEnSveTpe(java.lang.String temEnSveTpe) {
        this.temEnSveTpe = temEnSveTpe;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TypeEtablissementDTO)) return false;
        TypeEtablissementDTO other = (TypeEtablissementDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codTypeEtb==null && other.getCodTypeEtb()==null) || 
             (this.codTypeEtb!=null &&
              this.codTypeEtb.equals(other.getCodTypeEtb()))) &&
            ((this.libLongTpe==null && other.getLibLongTpe()==null) || 
             (this.libLongTpe!=null &&
              this.libLongTpe.equals(other.getLibLongTpe()))) &&
            ((this.temEnSveTpe==null && other.getTemEnSveTpe()==null) || 
             (this.temEnSveTpe!=null &&
              this.temEnSveTpe.equals(other.getTemEnSveTpe())));
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
        if (getCodTypeEtb() != null) {
            _hashCode += getCodTypeEtb().hashCode();
        }
        if (getLibLongTpe() != null) {
            _hashCode += getLibLongTpe().hashCode();
        }
        if (getTemEnSveTpe() != null) {
            _hashCode += getTemEnSveTpe().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TypeEtablissementDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("TypeEtablissementDTO.etablissement.dto.transverse.commun.apogee.education.gouv", "TypeEtablissementDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codTypeEtb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codTypeEtb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("libLongTpe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "libLongTpe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temEnSveTpe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temEnSveTpe"));
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
