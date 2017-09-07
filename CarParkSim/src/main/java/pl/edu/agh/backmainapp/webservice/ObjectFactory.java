
package pl.edu.agh.backmainapp.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.agh.backmainapp.webservice package. 
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

    private final static QName _NotifyaddSpot_QNAME = new QName("http://webService.backMainApp.agh.edu.pl/", "notifyaddSpot");
    private final static QName _NotifyOccupySpotResponse_QNAME = new QName("http://webService.backMainApp.agh.edu.pl/", "notifyOccupySpotResponse");
    private final static QName _NotifyaddSpotResponse_QNAME = new QName("http://webService.backMainApp.agh.edu.pl/", "notifyaddSpotResponse");
    private final static QName _NotifyRemoveSpotResponse_QNAME = new QName("http://webService.backMainApp.agh.edu.pl/", "notifyRemoveSpotResponse");
    private final static QName _NotifyVacateSpotResponse_QNAME = new QName("http://webService.backMainApp.agh.edu.pl/", "notifyVacateSpotResponse");
    private final static QName _NotifyOccupySpot_QNAME = new QName("http://webService.backMainApp.agh.edu.pl/", "notifyOccupySpot");
    private final static QName _NotifyPrintSpotsResponse_QNAME = new QName("http://webService.backMainApp.agh.edu.pl/", "notifyPrintSpotsResponse");
    private final static QName _NotifyPrintSpots_QNAME = new QName("http://webService.backMainApp.agh.edu.pl/", "notifyPrintSpots");
    private final static QName _NotifyVacateSpot_QNAME = new QName("http://webService.backMainApp.agh.edu.pl/", "notifyVacateSpot");
    private final static QName _NotifyRemoveSpot_QNAME = new QName("http://webService.backMainApp.agh.edu.pl/", "notifyRemoveSpot");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.agh.backmainapp.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotifyOccupySpot }
     * 
     */
    public NotifyOccupySpot createNotifyOccupySpot() {
        return new NotifyOccupySpot();
    }

    /**
     * Create an instance of {@link NotifyPrintSpotsResponse }
     * 
     */
    public NotifyPrintSpotsResponse createNotifyPrintSpotsResponse() {
        return new NotifyPrintSpotsResponse();
    }

    /**
     * Create an instance of {@link NotifyRemoveSpotResponse }
     * 
     */
    public NotifyRemoveSpotResponse createNotifyRemoveSpotResponse() {
        return new NotifyRemoveSpotResponse();
    }

    /**
     * Create an instance of {@link NotifyVacateSpotResponse }
     * 
     */
    public NotifyVacateSpotResponse createNotifyVacateSpotResponse() {
        return new NotifyVacateSpotResponse();
    }

    /**
     * Create an instance of {@link NotifyVacateSpot }
     * 
     */
    public NotifyVacateSpot createNotifyVacateSpot() {
        return new NotifyVacateSpot();
    }

    /**
     * Create an instance of {@link NotifyRemoveSpot }
     * 
     */
    public NotifyRemoveSpot createNotifyRemoveSpot() {
        return new NotifyRemoveSpot();
    }

    /**
     * Create an instance of {@link NotifyPrintSpots }
     * 
     */
    public NotifyPrintSpots createNotifyPrintSpots() {
        return new NotifyPrintSpots();
    }

    /**
     * Create an instance of {@link NotifyaddSpot }
     * 
     */
    public NotifyaddSpot createNotifyaddSpot() {
        return new NotifyaddSpot();
    }

    /**
     * Create an instance of {@link NotifyaddSpotResponse }
     * 
     */
    public NotifyaddSpotResponse createNotifyaddSpotResponse() {
        return new NotifyaddSpotResponse();
    }

    /**
     * Create an instance of {@link NotifyOccupySpotResponse }
     * 
     */
    public NotifyOccupySpotResponse createNotifyOccupySpotResponse() {
        return new NotifyOccupySpotResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyaddSpot }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.backMainApp.agh.edu.pl/", name = "notifyaddSpot")
    public JAXBElement<NotifyaddSpot> createNotifyaddSpot(NotifyaddSpot value) {
        return new JAXBElement<NotifyaddSpot>(_NotifyaddSpot_QNAME, NotifyaddSpot.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyOccupySpotResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.backMainApp.agh.edu.pl/", name = "notifyOccupySpotResponse")
    public JAXBElement<NotifyOccupySpotResponse> createNotifyOccupySpotResponse(NotifyOccupySpotResponse value) {
        return new JAXBElement<NotifyOccupySpotResponse>(_NotifyOccupySpotResponse_QNAME, NotifyOccupySpotResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyaddSpotResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.backMainApp.agh.edu.pl/", name = "notifyaddSpotResponse")
    public JAXBElement<NotifyaddSpotResponse> createNotifyaddSpotResponse(NotifyaddSpotResponse value) {
        return new JAXBElement<NotifyaddSpotResponse>(_NotifyaddSpotResponse_QNAME, NotifyaddSpotResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyRemoveSpotResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.backMainApp.agh.edu.pl/", name = "notifyRemoveSpotResponse")
    public JAXBElement<NotifyRemoveSpotResponse> createNotifyRemoveSpotResponse(NotifyRemoveSpotResponse value) {
        return new JAXBElement<NotifyRemoveSpotResponse>(_NotifyRemoveSpotResponse_QNAME, NotifyRemoveSpotResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyVacateSpotResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.backMainApp.agh.edu.pl/", name = "notifyVacateSpotResponse")
    public JAXBElement<NotifyVacateSpotResponse> createNotifyVacateSpotResponse(NotifyVacateSpotResponse value) {
        return new JAXBElement<NotifyVacateSpotResponse>(_NotifyVacateSpotResponse_QNAME, NotifyVacateSpotResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyOccupySpot }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.backMainApp.agh.edu.pl/", name = "notifyOccupySpot")
    public JAXBElement<NotifyOccupySpot> createNotifyOccupySpot(NotifyOccupySpot value) {
        return new JAXBElement<NotifyOccupySpot>(_NotifyOccupySpot_QNAME, NotifyOccupySpot.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyPrintSpotsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.backMainApp.agh.edu.pl/", name = "notifyPrintSpotsResponse")
    public JAXBElement<NotifyPrintSpotsResponse> createNotifyPrintSpotsResponse(NotifyPrintSpotsResponse value) {
        return new JAXBElement<NotifyPrintSpotsResponse>(_NotifyPrintSpotsResponse_QNAME, NotifyPrintSpotsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyPrintSpots }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.backMainApp.agh.edu.pl/", name = "notifyPrintSpots")
    public JAXBElement<NotifyPrintSpots> createNotifyPrintSpots(NotifyPrintSpots value) {
        return new JAXBElement<NotifyPrintSpots>(_NotifyPrintSpots_QNAME, NotifyPrintSpots.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyVacateSpot }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.backMainApp.agh.edu.pl/", name = "notifyVacateSpot")
    public JAXBElement<NotifyVacateSpot> createNotifyVacateSpot(NotifyVacateSpot value) {
        return new JAXBElement<NotifyVacateSpot>(_NotifyVacateSpot_QNAME, NotifyVacateSpot.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyRemoveSpot }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.backMainApp.agh.edu.pl/", name = "notifyRemoveSpot")
    public JAXBElement<NotifyRemoveSpot> createNotifyRemoveSpot(NotifyRemoveSpot value) {
        return new JAXBElement<NotifyRemoveSpot>(_NotifyRemoveSpot_QNAME, NotifyRemoveSpot.class, null, value);
    }

}
