/**
 * WebBaseException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gouv.education.apogee.commun.transverse.exception;

public class WebBaseException  extends org.apache.axis.AxisFault  implements java.io.Serializable {
    private java.lang.String domaine;

    private java.lang.String element;

    private java.lang.String[] messages;

    private java.lang.String nature;

    private java.lang.String type;

    private java.lang.String lastErrorMsg;

    public WebBaseException() {
    }

    public WebBaseException(
           java.lang.String domaine,
           java.lang.String element,
           java.lang.String[] messages,
           java.lang.String nature,
           java.lang.String type,
           java.lang.String lastErrorMsg) {
        this.domaine = domaine;
        this.element = element;
        this.messages = messages;
        this.nature = nature;
        this.type = type;
        this.lastErrorMsg = lastErrorMsg;
    }


    /**
     * Gets the domaine value for this WebBaseException.
     * 
     * @return domaine
     */
    public java.lang.String getDomaine() {
        return domaine;
    }


    /**
     * Sets the domaine value for this WebBaseException.
     * 
     * @param domaine
     */
    public void setDomaine(java.lang.String domaine) {
        this.domaine = domaine;
    }


    /**
     * Gets the element value for this WebBaseException.
     * 
     * @return element
     */
    public java.lang.String getElement() {
        return element;
    }


    /**
     * Sets the element value for this WebBaseException.
     * 
     * @param element
     */
    public void setElement(java.lang.String element) {
        this.element = element;
    }


    /**
     * Gets the messages value for this WebBaseException.
     * 
     * @return messages
     */
    public java.lang.String[] getMessages() {
        return messages;
    }


    /**
     * Sets the messages value for this WebBaseException.
     * 
     * @param messages
     */
    public void setMessages(java.lang.String[] messages) {
        this.messages = messages;
    }


    /**
     * Gets the nature value for this WebBaseException.
     * 
     * @return nature
     */
    public java.lang.String getNature() {
        return nature;
    }


    /**
     * Sets the nature value for this WebBaseException.
     * 
     * @param nature
     */
    public void setNature(java.lang.String nature) {
        this.nature = nature;
    }


    /**
     * Gets the type value for this WebBaseException.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this WebBaseException.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the lastErrorMsg value for this WebBaseException.
     * 
     * @return lastErrorMsg
     */
    public java.lang.String getLastErrorMsg() {
        return lastErrorMsg;
    }


    /**
     * Sets the lastErrorMsg value for this WebBaseException.
     * 
     * @param lastErrorMsg
     */
    public void setLastErrorMsg(java.lang.String lastErrorMsg) {
        this.lastErrorMsg = lastErrorMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WebBaseException)) return false;
        WebBaseException other = (WebBaseException) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.domaine==null && other.getDomaine()==null) || 
             (this.domaine!=null &&
              this.domaine.equals(other.getDomaine()))) &&
            ((this.element==null && other.getElement()==null) || 
             (this.element!=null &&
              this.element.equals(other.getElement()))) &&
            ((this.messages==null && other.getMessages()==null) || 
             (this.messages!=null &&
              java.util.Arrays.equals(this.messages, other.getMessages()))) &&
            ((this.nature==null && other.getNature()==null) || 
             (this.nature!=null &&
              this.nature.equals(other.getNature()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.lastErrorMsg==null && other.getLastErrorMsg()==null) || 
             (this.lastErrorMsg!=null &&
              this.lastErrorMsg.equals(other.getLastErrorMsg())));
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
        if (getDomaine() != null) {
            _hashCode += getDomaine().hashCode();
        }
        if (getElement() != null) {
            _hashCode += getElement().hashCode();
        }
        if (getMessages() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMessages());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMessages(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNature() != null) {
            _hashCode += getNature().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getLastErrorMsg() != null) {
            _hashCode += getLastErrorMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WebBaseException.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("exception.transverse.commun.apogee.education.gouv", "WebBaseException"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domaine");
        elemField.setXmlName(new javax.xml.namespace.QName("", "domaine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("element");
        elemField.setXmlName(new javax.xml.namespace.QName("", "element"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messages");
        elemField.setXmlName(new javax.xml.namespace.QName("", "messages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nature");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nature"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastErrorMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastErrorMsg"));
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


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
