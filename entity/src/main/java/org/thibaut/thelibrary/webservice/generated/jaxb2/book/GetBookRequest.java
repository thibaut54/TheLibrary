
package org.thibaut.thelibrary.webservice.generated.jaxb2.book;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bookTitle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="authorName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bookCategory" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bookTitle",
    "authorName",
    "bookCategory"
})
@XmlRootElement(name = "getBookRequest", namespace = "http://spring.io/guides/gs-producing-web-service")
public class GetBookRequest {

    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected String bookTitle;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected String authorName;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected String bookCategory;

    /**
     * Obtient la valeur de la propriété bookTitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Définit la valeur de la propriété bookTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookTitle(String value) {
        this.bookTitle = value;
    }

    /**
     * Obtient la valeur de la propriété authorName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * Définit la valeur de la propriété authorName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorName(String value) {
        this.authorName = value;
    }

    /**
     * Obtient la valeur de la propriété bookCategory.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookCategory() {
        return bookCategory;
    }

    /**
     * Définit la valeur de la propriété bookCategory.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookCategory(String value) {
        this.bookCategory = value;
    }

}
