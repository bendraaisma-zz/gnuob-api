
package com.netbrasoft.gnuob.api;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the com.netbrasoft.gnuob.api package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation
 * for XML content. The Java representation of XML content can consist of schema derived interfaces
 * and classes representing the binding of schema type definitions, element declarations and model
 * groups. Factory methods for each of these are provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

  private final static QName _OrderBy_QNAME = new QName("http://gnuob.netbrasoft.com/", "OrderBy");
  private final static QName _Paging_QNAME = new QName("http://gnuob.netbrasoft.com/", "Paging");
  private final static QName _PostalCode_QNAME = new QName("http://gnuob.netbrasoft.com/", "PostalCode");
  private final static QName _CountPostalCode_QNAME = new QName("http://gnuob.netbrasoft.com/", "countPostalCode");
  private final static QName _CountPostalCodeResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "countPostalCodeResponse");
  private final static QName _FindPostalCode_QNAME = new QName("http://gnuob.netbrasoft.com/", "findPostalCode");
  private final static QName _FindPostalCodeById_QNAME = new QName("http://gnuob.netbrasoft.com/", "findPostalCodeById");
  private final static QName _FindPostalCodeByIdResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "findPostalCodeByIdResponse");
  private final static QName _FindPostalCodeResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "findPostalCodeResponse");
  private final static QName _MergePostalCode_QNAME = new QName("http://gnuob.netbrasoft.com/", "mergePostalCode");
  private final static QName _MergePostalCodeResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "mergePostalCodeResponse");
  private final static QName _MetaData_QNAME = new QName("http://gnuob.netbrasoft.com/", "metaData");
  private final static QName _PersistPostalCode_QNAME = new QName("http://gnuob.netbrasoft.com/", "persistPostalCode");
  private final static QName _PersistPostalCodeResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "persistPostalCodeResponse");
  private final static QName _RefreshPostalCode_QNAME = new QName("http://gnuob.netbrasoft.com/", "refreshPostalCode");
  private final static QName _RefreshPostalCodeResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "refreshPostalCodeResponse");
  private final static QName _RemovePostalCode_QNAME = new QName("http://gnuob.netbrasoft.com/", "removePostalCode");
  private final static QName _RemovePostalCodeResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "removePostalCodeResponse");

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes
   * for package: com.netbrasoft.gnuob.api
   * 
   */
  public ObjectFactory() {}

  /**
   * Create an instance of {@link CountPostalCode }
   * 
   */
  public CountPostalCode createCountPostalCode() {
    return new CountPostalCode();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CountPostalCode }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "countPostalCode")
  public JAXBElement<CountPostalCode> createCountPostalCode(final CountPostalCode value) {
    return new JAXBElement<CountPostalCode>(_CountPostalCode_QNAME, CountPostalCode.class, null, value);
  }

  /**
   * Create an instance of {@link CountPostalCodeResponse }
   * 
   */
  public CountPostalCodeResponse createCountPostalCodeResponse() {
    return new CountPostalCodeResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CountPostalCodeResponse }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "countPostalCodeResponse")
  public JAXBElement<CountPostalCodeResponse> createCountPostalCodeResponse(final CountPostalCodeResponse value) {
    return new JAXBElement<CountPostalCodeResponse>(_CountPostalCodeResponse_QNAME, CountPostalCodeResponse.class, null, value);
  }

  /**
   * Create an instance of {@link FindPostalCode }
   * 
   */
  public FindPostalCode createFindPostalCode() {
    return new FindPostalCode();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link FindPostalCode }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findPostalCode")
  public JAXBElement<FindPostalCode> createFindPostalCode(final FindPostalCode value) {
    return new JAXBElement<FindPostalCode>(_FindPostalCode_QNAME, FindPostalCode.class, null, value);
  }

  /**
   * Create an instance of {@link FindPostalCodeById }
   * 
   */
  public FindPostalCodeById createFindPostalCodeById() {
    return new FindPostalCodeById();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link FindPostalCodeById }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findPostalCodeById")
  public JAXBElement<FindPostalCodeById> createFindPostalCodeById(final FindPostalCodeById value) {
    return new JAXBElement<FindPostalCodeById>(_FindPostalCodeById_QNAME, FindPostalCodeById.class, null, value);
  }

  /**
   * Create an instance of {@link FindPostalCodeByIdResponse }
   * 
   */
  public FindPostalCodeByIdResponse createFindPostalCodeByIdResponse() {
    return new FindPostalCodeByIdResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link FindPostalCodeByIdResponse }{@code >}
   * }
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findPostalCodeByIdResponse")
  public JAXBElement<FindPostalCodeByIdResponse> createFindPostalCodeByIdResponse(final FindPostalCodeByIdResponse value) {
    return new JAXBElement<FindPostalCodeByIdResponse>(_FindPostalCodeByIdResponse_QNAME, FindPostalCodeByIdResponse.class, null, value);
  }

  /**
   * Create an instance of {@link FindPostalCodeResponse }
   * 
   */
  public FindPostalCodeResponse createFindPostalCodeResponse() {
    return new FindPostalCodeResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link FindPostalCodeResponse }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findPostalCodeResponse")
  public JAXBElement<FindPostalCodeResponse> createFindPostalCodeResponse(final FindPostalCodeResponse value) {
    return new JAXBElement<FindPostalCodeResponse>(_FindPostalCodeResponse_QNAME, FindPostalCodeResponse.class, null, value);
  }

  /**
   * Create an instance of {@link MergePostalCode }
   * 
   */
  public MergePostalCode createMergePostalCode() {
    return new MergePostalCode();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link MergePostalCode }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "mergePostalCode")
  public JAXBElement<MergePostalCode> createMergePostalCode(final MergePostalCode value) {
    return new JAXBElement<MergePostalCode>(_MergePostalCode_QNAME, MergePostalCode.class, null, value);
  }

  /**
   * Create an instance of {@link MergePostalCodeResponse }
   * 
   */
  public MergePostalCodeResponse createMergePostalCodeResponse() {
    return new MergePostalCodeResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link MergePostalCodeResponse }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "mergePostalCodeResponse")
  public JAXBElement<MergePostalCodeResponse> createMergePostalCodeResponse(final MergePostalCodeResponse value) {
    return new JAXBElement<MergePostalCodeResponse>(_MergePostalCodeResponse_QNAME, MergePostalCodeResponse.class, null, value);
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
  public JAXBElement<MetaData> createMetaData(final MetaData value) {
    return new JAXBElement<MetaData>(_MetaData_QNAME, MetaData.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OrderBy }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "OrderBy")
  public JAXBElement<OrderBy> createOrderBy(final OrderBy value) {
    return new JAXBElement<OrderBy>(_OrderBy_QNAME, OrderBy.class, null, value);
  }

  /**
   * Create an instance of {@link Paging }
   * 
   */
  public Paging createPaging() {
    return new Paging();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Paging }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "Paging")
  public JAXBElement<Paging> createPaging(final Paging value) {
    return new JAXBElement<Paging>(_Paging_QNAME, Paging.class, null, value);
  }

  /**
   * Create an instance of {@link PersistPostalCode }
   * 
   */
  public PersistPostalCode createPersistPostalCode() {
    return new PersistPostalCode();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PersistPostalCode }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "persistPostalCode")
  public JAXBElement<PersistPostalCode> createPersistPostalCode(final PersistPostalCode value) {
    return new JAXBElement<PersistPostalCode>(_PersistPostalCode_QNAME, PersistPostalCode.class, null, value);
  }

  /**
   * Create an instance of {@link PersistPostalCodeResponse }
   * 
   */
  public PersistPostalCodeResponse createPersistPostalCodeResponse() {
    return new PersistPostalCodeResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PersistPostalCodeResponse }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "persistPostalCodeResponse")
  public JAXBElement<PersistPostalCodeResponse> createPersistPostalCodeResponse(final PersistPostalCodeResponse value) {
    return new JAXBElement<PersistPostalCodeResponse>(_PersistPostalCodeResponse_QNAME, PersistPostalCodeResponse.class, null, value);
  }

  /**
   * Create an instance of {@link PostalCode }
   * 
   */
  public PostalCode createPostalCode() {
    return new PostalCode();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PostalCode }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "PostalCode")
  public JAXBElement<PostalCode> createPostalCode(final PostalCode value) {
    return new JAXBElement<PostalCode>(_PostalCode_QNAME, PostalCode.class, null, value);
  }

  /**
   * Create an instance of {@link RefreshPostalCode }
   * 
   */
  public RefreshPostalCode createRefreshPostalCode() {
    return new RefreshPostalCode();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link RefreshPostalCode }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "refreshPostalCode")
  public JAXBElement<RefreshPostalCode> createRefreshPostalCode(final RefreshPostalCode value) {
    return new JAXBElement<RefreshPostalCode>(_RefreshPostalCode_QNAME, RefreshPostalCode.class, null, value);
  }

  /**
   * Create an instance of {@link RefreshPostalCodeResponse }
   * 
   */
  public RefreshPostalCodeResponse createRefreshPostalCodeResponse() {
    return new RefreshPostalCodeResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link RefreshPostalCodeResponse }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "refreshPostalCodeResponse")
  public JAXBElement<RefreshPostalCodeResponse> createRefreshPostalCodeResponse(final RefreshPostalCodeResponse value) {
    return new JAXBElement<RefreshPostalCodeResponse>(_RefreshPostalCodeResponse_QNAME, RefreshPostalCodeResponse.class, null, value);
  }

  /**
   * Create an instance of {@link RemovePostalCode }
   * 
   */
  public RemovePostalCode createRemovePostalCode() {
    return new RemovePostalCode();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link RemovePostalCode }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "removePostalCode")
  public JAXBElement<RemovePostalCode> createRemovePostalCode(final RemovePostalCode value) {
    return new JAXBElement<RemovePostalCode>(_RemovePostalCode_QNAME, RemovePostalCode.class, null, value);
  }

  /**
   * Create an instance of {@link RemovePostalCodeResponse }
   * 
   */
  public RemovePostalCodeResponse createRemovePostalCodeResponse() {
    return new RemovePostalCodeResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link RemovePostalCodeResponse }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "removePostalCodeResponse")
  public JAXBElement<RemovePostalCodeResponse> createRemovePostalCodeResponse(final RemovePostalCodeResponse value) {
    return new JAXBElement<RemovePostalCodeResponse>(_RemovePostalCodeResponse_QNAME, RemovePostalCodeResponse.class, null, value);
  }

}
