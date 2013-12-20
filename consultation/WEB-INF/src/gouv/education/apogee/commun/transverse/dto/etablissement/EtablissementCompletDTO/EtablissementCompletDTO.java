/**
 * EtablissementCompletDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gouv.education.apogee.commun.transverse.dto.etablissement.EtablissementCompletDTO;

public class EtablissementCompletDTO  implements java.io.Serializable {
    private gouv.education.apogee.commun.transverse.dto.etablissement.AcademieDTO.AcademieDTO academie;

    private java.lang.String codeEtb;

    private gouv.education.apogee.commun.transverse.dto.etablissement.DepartementDTO.DepartementDTO departement;

    private java.lang.String libEtb;

    private gouv.education.apogee.commun.transverse.dto.etablissement.PaysDTO.PaysDTO pays;

    private java.lang.String temEnSveEtb;

    private gouv.education.apogee.commun.transverse.dto.etablissement.TypeEtablissementDTO.TypeEtablissementDTO type;

    public EtablissementCompletDTO() {
    }

    public EtablissementCompletDTO(
           gouv.education.apogee.commun.transverse.dto.etablissement.AcademieDTO.AcademieDTO academie,
           java.lang.String codeEtb,
           gouv.education.apogee.commun.transverse.dto.etablissement.DepartementDTO.DepartementDTO departement,
           java.lang.String libEtb,
           gouv.education.apogee.commun.transverse.dto.etablissement.PaysDTO.PaysDTO pays,
           java.lang.String temEnSveEtb,
           gouv.education.apogee.commun.transverse.dto.etablissement.TypeEtablissementDTO.TypeEtablissementDTO type) {
           this.academie = academie;
           this.codeEtb = codeEtb;
           this.departement = departement;
           this.libEtb = libEtb;
           this.pays = pays;
           this.temEnSveEtb = temEnSveEtb;
           this.type = type;
    }


    /**
     * Gets the academie value for this EtablissementCompletDTO.
     * 
     * @return academie
     */
    public gouv.education.apogee.commun.transverse.dto.etablissement.AcademieDTO.AcademieDTO getAcademie() {
        return academie;
    }


    /**
     * Sets the academie value for this EtablissementCompletDTO.
     * 
     * @param academie
     */
    public void setAcademie(gouv.education.apogee.commun.transverse.dto.etablissement.AcademieDTO.AcademieDTO academie) {
        this.academie = academie;
    }


    /**
     * Gets the codeEtb value for this EtablissementCompletDTO.
     * 
     * @return codeEtb
     */
    public java.lang.String getCodeEtb() {
        return codeEtb;
    }


    /**
     * Sets the codeEtb value for this EtablissementCompletDTO.
     * 
     * @param codeEtb
     */
    public void setCodeEtb(java.lang.String codeEtb) {
        this.codeEtb = codeEtb;
    }


    /**
     * Gets the departement value for this EtablissementCompletDTO.
     * 
     * @return departement
     */
    public gouv.education.apogee.commun.transverse.dto.etablissement.DepartementDTO.DepartementDTO getDepartement() {
        return departement;
    }


    /**
     * Sets the departement value for this EtablissementCompletDTO.
     * 
     * @param departement
     */
    public void setDepartement(gouv.education.apogee.commun.transverse.dto.etablissement.DepartementDTO.DepartementDTO departement) {
        this.departement = departement;
    }


    /**
     * Gets the libEtb value for this EtablissementCompletDTO.
     * 
     * @return libEtb
     */
    public java.lang.String getLibEtb() {
        return libEtb;
    }


    /**
     * Sets the libEtb value for this EtablissementCompletDTO.
     * 
     * @param libEtb
     */
    public void setLibEtb(java.lang.String libEtb) {
        this.libEtb = libEtb;
    }


    /**
     * Gets the pays value for this EtablissementCompletDTO.
     * 
     * @return pays
     */
    public gouv.education.apogee.commun.transverse.dto.etablissement.PaysDTO.PaysDTO getPays() {
        return pays;
    }


    /**
     * Sets the pays value for this EtablissementCompletDTO.
     * 
     * @param pays
     */
    public void setPays(gouv.education.apogee.commun.transverse.dto.etablissement.PaysDTO.PaysDTO pays) {
        this.pays = pays;
    }


    /**
     * Gets the temEnSveEtb value for this EtablissementCompletDTO.
     * 
     * @return temEnSveEtb
     */
    public java.lang.String getTemEnSveEtb() {
        return temEnSveEtb;
    }


    /**
     * Sets the temEnSveEtb value for this EtablissementCompletDTO.
     * 
     * @param temEnSveEtb
     */
    public void setTemEnSveEtb(java.lang.String temEnSveEtb) {
        this.temEnSveEtb = temEnSveEtb;
    }


    /**
     * Gets the type value for this EtablissementCompletDTO.
     * 
     * @return type
     */
    public gouv.education.apogee.commun.transverse.dto.etablissement.TypeEtablissementDTO.TypeEtablissementDTO getType() {
        return type;
    }


    /**
     * Sets the type value for this EtablissementCompletDTO.
     * 
     * @param type
     */
    public void setType(gouv.education.apogee.commun.transverse.dto.etablissement.TypeEtablissementDTO.TypeEtablissementDTO type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EtablissementCompletDTO)) return false;
        EtablissementCompletDTO other = (EtablissementCompletDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.academie==null && other.getAcademie()==null) || 
             (this.academie!=null &&
              this.academie.equals(other.getAcademie()))) &&
            ((this.codeEtb==null && other.getCodeEtb()==null) || 
             (this.codeEtb!=null &&
              this.codeEtb.equals(other.getCodeEtb()))) &&
            ((this.departement==null && other.getDepartement()==null) || 
             (this.departement!=null &&
              this.departement.equals(other.getDepartement()))) &&
            ((this.libEtb==null && other.getLibEtb()==null) || 
             (this.libEtb!=null &&
              this.libEtb.equals(other.getLibEtb()))) &&
            ((this.pays==null && other.getPays()==null) || 
             (this.pays!=null &&
              this.pays.equals(other.getPays()))) &&
            ((this.temEnSveEtb==null && other.getTemEnSveEtb()==null) || 
             (this.temEnSveEtb!=null &&
              this.temEnSveEtb.equals(other.getTemEnSveEtb()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType())));
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
        if (getAcademie() != null) {
            _hashCode += getAcademie().hashCode();
        }
        if (getCodeEtb() != null) {
            _hashCode += getCodeEtb().hashCode();
        }
        if (getDepartement() != null) {
            _hashCode += getDepartement().hashCode();
        }
        if (getLibEtb() != null) {
            _hashCode += getLibEtb().hashCode();
        }
        if (getPays() != null) {
            _hashCode += getPays().hashCode();
        }
        if (getTemEnSveEtb() != null) {
            _hashCode += getTemEnSveEtb().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EtablissementCompletDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("EtablissementCompletDTO.etablissement.dto.transverse.commun.apogee.education.gouv", "EtablissementCompletDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("academie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "academie"));
        elemField.setXmlType(new javax.xml.namespace.QName("AcademieDTO.etablissement.dto.transverse.commun.apogee.education.gouv", "AcademieDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeEtb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codeEtb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departement");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departement"));
        elemField.setXmlType(new javax.xml.namespace.QName("DepartementDTO.etablissement.dto.transverse.commun.apogee.education.gouv", "DepartementDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("libEtb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "libEtb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pays"));
        elemField.setXmlType(new javax.xml.namespace.QName("PaysDTO.etablissement.dto.transverse.commun.apogee.education.gouv", "PaysDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temEnSveEtb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temEnSveEtb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("TypeEtablissementDTO.etablissement.dto.transverse.commun.apogee.education.gouv", "TypeEtablissementDTO"));
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
