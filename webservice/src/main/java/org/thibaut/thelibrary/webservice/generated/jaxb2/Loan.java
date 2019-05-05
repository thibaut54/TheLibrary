
package org.thibaut.thelibrary.webservice.generated.jaxb2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour loan complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="loan"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="returned" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="initialEndDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="extendedEndDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="user" type="{http://spring.io/guides/gs-producing-web-service}user"/&gt;
 *         &lt;element name="book" type="{http://spring.io/guides/gs-producing-web-service}book"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loan", namespace = "http://spring.io/guides/gs-producing-web-service", propOrder = {
    "id",
    "startDate",
    "returned",
    "initialEndDate",
    "extendedEndDate",
    "user",
    "book"
})
public class Loan {

    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service")
    protected int id;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service")
    protected boolean returned;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar initialEndDate;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar extendedEndDate;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected User user;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected Book book;

    /**
     * Obtient la valeur de la propri�t� id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * D�finit la valeur de la propri�t� id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propri�t� startDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * D�finit la valeur de la propri�t� startDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� returned.
     * 
     */
    public boolean isReturned() {
        return returned;
    }

    /**
     * D�finit la valeur de la propri�t� returned.
     * 
     */
    public void setReturned(boolean value) {
        this.returned = value;
    }

    /**
     * Obtient la valeur de la propri�t� initialEndDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInitialEndDate() {
        return initialEndDate;
    }

    /**
     * D�finit la valeur de la propri�t� initialEndDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInitialEndDate(XMLGregorianCalendar value) {
        this.initialEndDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� extendedEndDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExtendedEndDate() {
        return extendedEndDate;
    }

    /**
     * D�finit la valeur de la propri�t� extendedEndDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExtendedEndDate(XMLGregorianCalendar value) {
        this.extendedEndDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� user.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * D�finit la valeur de la propri�t� user.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Obtient la valeur de la propri�t� book.
     * 
     * @return
     *     possible object is
     *     {@link Book }
     *     
     */
    public Book getBook() {
        return book;
    }

    /**
     * D�finit la valeur de la propri�t� book.
     * 
     * @param value
     *     allowed object is
     *     {@link Book }
     *     
     */
    public void setBook(Book value) {
        this.book = value;
    }

}
