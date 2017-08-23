//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.22 at 05:25:38 PM EEST 
//


package xsd.odf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xsd.odf package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Objects_QNAME = new QName("http://www.opengroup.org/xsd/odf/1.0/", "Objects");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xsd.odf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObjectsType }
     * 
     */
    public ObjectsType createObjectsType() {
        return new ObjectsType();
    }

    /**
     * Create an instance of {@link ObjectType }
     * 
     */
    public ObjectType createObjectType() {
        return new ObjectType();
    }

    /**
     * Create an instance of {@link QlmIDType }
     * 
     */
    public QlmIDType createQlmIDType() {
        return new QlmIDType();
    }

    /**
     * Create an instance of {@link DescriptionType }
     * 
     */
    public DescriptionType createDescriptionType() {
        return new DescriptionType();
    }

    /**
     * Create an instance of {@link MetaDataType }
     * 
     */
    public MetaDataType createMetaDataType() {
        return new MetaDataType();
    }

    /**
     * Create an instance of {@link ValueType }
     * 
     */
    public ValueType createValueType() {
        return new ValueType();
    }

    /**
     * Create an instance of {@link InfoItemType }
     * 
     */
    public InfoItemType createInfoItemType() {
        return new InfoItemType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObjectsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengroup.org/xsd/odf/1.0/", name = "Objects")
    public JAXBElement<ObjectsType> createObjects(ObjectsType value) {
        return new JAXBElement<ObjectsType>(_Objects_QNAME, ObjectsType.class, null, value);
    }

}
