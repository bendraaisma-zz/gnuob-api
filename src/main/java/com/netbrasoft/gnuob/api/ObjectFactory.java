
package com.netbrasoft.gnuob.api;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.netbrasoft.gnuob.api package. 
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

    private final static QName _MetaData_QNAME = new QName("http://gnuob.netbrasoft.com/", "metaData");
    private final static QName _FindSiteByIdResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "findSiteByIdResponse");
    private final static QName _FindSite_QNAME = new QName("http://gnuob.netbrasoft.com/", "findSite");
    private final static QName _PersistSiteResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "persistSiteResponse");
    private final static QName _CountSite_QNAME = new QName("http://gnuob.netbrasoft.com/", "countSite");
    private final static QName _RefreshSiteResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "refreshSiteResponse");
    private final static QName _MergeSite_QNAME = new QName("http://gnuob.netbrasoft.com/", "mergeSite");
    private final static QName _RefreshSite_QNAME = new QName("http://gnuob.netbrasoft.com/", "refreshSite");
    private final static QName _Paging_QNAME = new QName("http://gnuob.netbrasoft.com/", "Paging");
    private final static QName _GNUOpenBusinessServiceException_QNAME = new QName("http://gnuob.netbrasoft.com/", "GNUOpenBusinessServiceException");
    private final static QName _MergeSiteResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "mergeSiteResponse");
    private final static QName _RemoveSiteResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "removeSiteResponse");
    private final static QName _CountSiteResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "countSiteResponse");
    private final static QName _RemoveSite_QNAME = new QName("http://gnuob.netbrasoft.com/", "removeSite");
    private final static QName _OrderBy_QNAME = new QName("http://gnuob.netbrasoft.com/", "OrderBy");
    private final static QName _FindSiteResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "findSiteResponse");
    private final static QName _Site_QNAME = new QName("http://gnuob.netbrasoft.com/", "Site");
    private final static QName _PersistSite_QNAME = new QName("http://gnuob.netbrasoft.com/", "persistSite");
    private final static QName _FindSiteById_QNAME = new QName("http://gnuob.netbrasoft.com/", "findSiteById");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.netbrasoft.gnuob.api
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindSiteById }
     * 
     */
    public FindSiteById createFindSiteById() {
        return new FindSiteById();
    }

    /**
     * Create an instance of {@link PersistSite }
     * 
     */
    public PersistSite createPersistSite() {
        return new PersistSite();
    }

    /**
     * Create an instance of {@link Site }
     * 
     */
    public Site createSite() {
        return new Site();
    }

    /**
     * Create an instance of {@link FindSiteResponse }
     * 
     */
    public FindSiteResponse createFindSiteResponse() {
        return new FindSiteResponse();
    }

    /**
     * Create an instance of {@link RemoveSite }
     * 
     */
    public RemoveSite createRemoveSite() {
        return new RemoveSite();
    }

    /**
     * Create an instance of {@link RemoveSiteResponse }
     * 
     */
    public RemoveSiteResponse createRemoveSiteResponse() {
        return new RemoveSiteResponse();
    }

    /**
     * Create an instance of {@link CountSiteResponse }
     * 
     */
    public CountSiteResponse createCountSiteResponse() {
        return new CountSiteResponse();
    }

    /**
     * Create an instance of {@link GNUOpenBusinessServiceException }
     * 
     */
    public GNUOpenBusinessServiceException createGNUOpenBusinessServiceException() {
        return new GNUOpenBusinessServiceException();
    }

    /**
     * Create an instance of {@link MergeSiteResponse }
     * 
     */
    public MergeSiteResponse createMergeSiteResponse() {
        return new MergeSiteResponse();
    }

    /**
     * Create an instance of {@link Paging }
     * 
     */
    public Paging createPaging() {
        return new Paging();
    }

    /**
     * Create an instance of {@link RefreshSite }
     * 
     */
    public RefreshSite createRefreshSite() {
        return new RefreshSite();
    }

    /**
     * Create an instance of {@link MergeSite }
     * 
     */
    public MergeSite createMergeSite() {
        return new MergeSite();
    }

    /**
     * Create an instance of {@link RefreshSiteResponse }
     * 
     */
    public RefreshSiteResponse createRefreshSiteResponse() {
        return new RefreshSiteResponse();
    }

    /**
     * Create an instance of {@link CountSite }
     * 
     */
    public CountSite createCountSite() {
        return new CountSite();
    }

    /**
     * Create an instance of {@link PersistSiteResponse }
     * 
     */
    public PersistSiteResponse createPersistSiteResponse() {
        return new PersistSiteResponse();
    }

    /**
     * Create an instance of {@link FindSite }
     * 
     */
    public FindSite createFindSite() {
        return new FindSite();
    }

    /**
     * Create an instance of {@link FindSiteByIdResponse }
     * 
     */
    public FindSiteByIdResponse createFindSiteByIdResponse() {
        return new FindSiteByIdResponse();
    }

    /**
     * Create an instance of {@link MetaData }
     * 
     */
    public MetaData createMetaData() {
        return new MetaData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MetaData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "metaData")
    public JAXBElement<MetaData> createMetaData(MetaData value) {
        return new JAXBElement<MetaData>(_MetaData_QNAME, MetaData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSiteByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findSiteByIdResponse")
    public JAXBElement<FindSiteByIdResponse> createFindSiteByIdResponse(FindSiteByIdResponse value) {
        return new JAXBElement<FindSiteByIdResponse>(_FindSiteByIdResponse_QNAME, FindSiteByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findSite")
    public JAXBElement<FindSite> createFindSite(FindSite value) {
        return new JAXBElement<FindSite>(_FindSite_QNAME, FindSite.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersistSiteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "persistSiteResponse")
    public JAXBElement<PersistSiteResponse> createPersistSiteResponse(PersistSiteResponse value) {
        return new JAXBElement<PersistSiteResponse>(_PersistSiteResponse_QNAME, PersistSiteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountSite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "countSite")
    public JAXBElement<CountSite> createCountSite(CountSite value) {
        return new JAXBElement<CountSite>(_CountSite_QNAME, CountSite.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefreshSiteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "refreshSiteResponse")
    public JAXBElement<RefreshSiteResponse> createRefreshSiteResponse(RefreshSiteResponse value) {
        return new JAXBElement<RefreshSiteResponse>(_RefreshSiteResponse_QNAME, RefreshSiteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MergeSite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "mergeSite")
    public JAXBElement<MergeSite> createMergeSite(MergeSite value) {
        return new JAXBElement<MergeSite>(_MergeSite_QNAME, MergeSite.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefreshSite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "refreshSite")
    public JAXBElement<RefreshSite> createRefreshSite(RefreshSite value) {
        return new JAXBElement<RefreshSite>(_RefreshSite_QNAME, RefreshSite.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Paging }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "Paging")
    public JAXBElement<Paging> createPaging(Paging value) {
        return new JAXBElement<Paging>(_Paging_QNAME, Paging.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GNUOpenBusinessServiceException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "GNUOpenBusinessServiceException")
    public JAXBElement<GNUOpenBusinessServiceException> createGNUOpenBusinessServiceException(GNUOpenBusinessServiceException value) {
        return new JAXBElement<GNUOpenBusinessServiceException>(_GNUOpenBusinessServiceException_QNAME, GNUOpenBusinessServiceException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MergeSiteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "mergeSiteResponse")
    public JAXBElement<MergeSiteResponse> createMergeSiteResponse(MergeSiteResponse value) {
        return new JAXBElement<MergeSiteResponse>(_MergeSiteResponse_QNAME, MergeSiteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSiteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "removeSiteResponse")
    public JAXBElement<RemoveSiteResponse> createRemoveSiteResponse(RemoveSiteResponse value) {
        return new JAXBElement<RemoveSiteResponse>(_RemoveSiteResponse_QNAME, RemoveSiteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountSiteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "countSiteResponse")
    public JAXBElement<CountSiteResponse> createCountSiteResponse(CountSiteResponse value) {
        return new JAXBElement<CountSiteResponse>(_CountSiteResponse_QNAME, CountSiteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "removeSite")
    public JAXBElement<RemoveSite> createRemoveSite(RemoveSite value) {
        return new JAXBElement<RemoveSite>(_RemoveSite_QNAME, RemoveSite.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderBy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "OrderBy")
    public JAXBElement<OrderBy> createOrderBy(OrderBy value) {
        return new JAXBElement<OrderBy>(_OrderBy_QNAME, OrderBy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSiteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findSiteResponse")
    public JAXBElement<FindSiteResponse> createFindSiteResponse(FindSiteResponse value) {
        return new JAXBElement<FindSiteResponse>(_FindSiteResponse_QNAME, FindSiteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Site }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "Site")
    public JAXBElement<Site> createSite(Site value) {
        return new JAXBElement<Site>(_Site_QNAME, Site.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersistSite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "persistSite")
    public JAXBElement<PersistSite> createPersistSite(PersistSite value) {
        return new JAXBElement<PersistSite>(_PersistSite_QNAME, PersistSite.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSiteById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findSiteById")
    public JAXBElement<FindSiteById> createFindSiteById(FindSiteById value) {
        return new JAXBElement<FindSiteById>(_FindSiteById_QNAME, FindSiteById.class, null, value);
    }

}
