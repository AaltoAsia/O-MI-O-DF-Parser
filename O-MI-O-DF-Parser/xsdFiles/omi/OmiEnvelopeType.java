//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.22 at 05:25:13 PM EEST 
//


package xsd.omi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OmiEnvelopeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OmiEnvelopeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="read" type="{http://www.opengroup.org/xsd/omi/1.0/}ReadRequestType"/>
 *           &lt;element name="write" type="{http://www.opengroup.org/xsd/omi/1.0/}WriteRequestType"/>
 *           &lt;element name="response" type="{http://www.opengroup.org/xsd/omi/1.0/}ResponseListType"/>
 *           &lt;element name="cancel" type="{http://www.opengroup.org/xsd/omi/1.0/}CancelRequestType"/>
 *           &lt;element name="call" type="{http://www.opengroup.org/xsd/omi/1.0/}CallRequestType"/>
 *           &lt;element name="delete" type="{http://www.opengroup.org/xsd/omi/1.0/}DeleteRequestType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ttl" use="required">
 *         &lt;simpleType>
 *           &lt;union memberTypes=" {http://www.opengroup.org/xsd/omi/1.0/}PositiveDouble {http://www.opengroup.org/xsd/omi/1.0/}DoubleMinusOne">
 *           &lt;/union>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OmiEnvelopeType", propOrder = {
    "read",
    "write",
    "response",
    "cancel",
    "call",
    "delete"
})
public class OmiEnvelopeType {

    protected ReadRequestType read;
    protected WriteRequestType write;
    protected ResponseListType response;
    protected CancelRequestType cancel;
    protected CallRequestType call;
    protected DeleteRequestType delete;
    @XmlAttribute(name = "version", required = true)
    protected String version;
    @XmlAttribute(name = "ttl", required = true)
    protected String ttl;

    /**
     * Gets the value of the read property.
     * 
     * @return
     *     possible object is
     *     {@link ReadRequestType }
     *     
     */
    public ReadRequestType getRead() {
        return read;
    }

    /**
     * Sets the value of the read property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadRequestType }
     *     
     */
    public void setRead(ReadRequestType value) {
        this.read = value;
    }

    /**
     * Gets the value of the write property.
     * 
     * @return
     *     possible object is
     *     {@link WriteRequestType }
     *     
     */
    public WriteRequestType getWrite() {
        return write;
    }

    /**
     * Sets the value of the write property.
     * 
     * @param value
     *     allowed object is
     *     {@link WriteRequestType }
     *     
     */
    public void setWrite(WriteRequestType value) {
        this.write = value;
    }

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseListType }
     *     
     */
    public ResponseListType getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseListType }
     *     
     */
    public void setResponse(ResponseListType value) {
        this.response = value;
    }

    /**
     * Gets the value of the cancel property.
     * 
     * @return
     *     possible object is
     *     {@link CancelRequestType }
     *     
     */
    public CancelRequestType getCancel() {
        return cancel;
    }

    /**
     * Sets the value of the cancel property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelRequestType }
     *     
     */
    public void setCancel(CancelRequestType value) {
        this.cancel = value;
    }

    /**
     * Gets the value of the call property.
     * 
     * @return
     *     possible object is
     *     {@link CallRequestType }
     *     
     */
    public CallRequestType getCall() {
        return call;
    }

    /**
     * Sets the value of the call property.
     * 
     * @param value
     *     allowed object is
     *     {@link CallRequestType }
     *     
     */
    public void setCall(CallRequestType value) {
        this.call = value;
    }

    /**
     * Gets the value of the delete property.
     * 
     * @return
     *     possible object is
     *     {@link DeleteRequestType }
     *     
     */
    public DeleteRequestType getDelete() {
        return delete;
    }

    /**
     * Sets the value of the delete property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteRequestType }
     *     
     */
    public void setDelete(DeleteRequestType value) {
        this.delete = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the ttl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTtl() {
        return ttl;
    }

    /**
     * Sets the value of the ttl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTtl(String value) {
        this.ttl = value;
    }

}
