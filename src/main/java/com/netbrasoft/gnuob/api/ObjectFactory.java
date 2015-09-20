
package com.netbrasoft.gnuob.api;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.netbrasoft.gnuob.api package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

   private final static QName _Content_QNAME = new QName("http://gnuob.netbrasoft.com/", "Content");
   private final static QName _OrderBy_QNAME = new QName("http://gnuob.netbrasoft.com/", "OrderBy");
   private final static QName _Paging_QNAME = new QName("http://gnuob.netbrasoft.com/", "Paging");
   private final static QName _Permission_QNAME = new QName("http://gnuob.netbrasoft.com/", "Permission");
   private final static QName _Rule_QNAME = new QName("http://gnuob.netbrasoft.com/", "Rule");
   private final static QName _CountContent_QNAME = new QName("http://gnuob.netbrasoft.com/", "countContent");
   private final static QName _CountContentResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "countContentResponse");
   private final static QName _FindContent_QNAME = new QName("http://gnuob.netbrasoft.com/", "findContent");
   private final static QName _FindContentById_QNAME = new QName("http://gnuob.netbrasoft.com/", "findContentById");
   private final static QName _FindContentByIdResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "findContentByIdResponse");
   private final static QName _FindContentResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "findContentResponse");
   private final static QName _MergeContent_QNAME = new QName("http://gnuob.netbrasoft.com/", "mergeContent");
   private final static QName _MergeContentResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "mergeContentResponse");
   private final static QName _MetaData_QNAME = new QName("http://gnuob.netbrasoft.com/", "metaData");
   private final static QName _PersistContent_QNAME = new QName("http://gnuob.netbrasoft.com/", "persistContent");
   private final static QName _PersistContentResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "persistContentResponse");
   private final static QName _RefreshContent_QNAME = new QName("http://gnuob.netbrasoft.com/", "refreshContent");
   private final static QName _RefreshContentResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "refreshContentResponse");
   private final static QName _RemoveContent_QNAME = new QName("http://gnuob.netbrasoft.com/", "removeContent");
   private final static QName _RemoveContentResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "removeContentResponse");

   /**
    * Create a new ObjectFactory that can be used to create new instances of
    * schema derived classes for package: com.netbrasoft.gnuob.api
    * 
    */
   public ObjectFactory() {
   }

   /**
    * Create an instance of {@link Content }
    * 
    */
   public Content createContent() {
      return new Content();
   }

   /**
    * Create an instance of {@link Paging }
    * 
    */
   public Paging createPaging() {
      return new Paging();
   }

   /**
    * Create an instance of {@link Permission }
    * 
    */
   public Permission createPermission() {
      return new Permission();
   }

   /**
    * Create an instance of {@link CountContent }
    * 
    */
   public CountContent createCountContent() {
      return new CountContent();
   }

   /**
    * Create an instance of {@link CountContentResponse }
    * 
    */
   public CountContentResponse createCountContentResponse() {
      return new CountContentResponse();
   }

   /**
    * Create an instance of {@link FindContent }
    * 
    */
   public FindContent createFindContent() {
      return new FindContent();
   }

   /**
    * Create an instance of {@link FindContentById }
    * 
    */
   public FindContentById createFindContentById() {
      return new FindContentById();
   }

   /**
    * Create an instance of {@link FindContentByIdResponse }
    * 
    */
   public FindContentByIdResponse createFindContentByIdResponse() {
      return new FindContentByIdResponse();
   }

   /**
    * Create an instance of {@link FindContentResponse }
    * 
    */
   public FindContentResponse createFindContentResponse() {
      return new FindContentResponse();
   }

   /**
    * Create an instance of {@link MergeContent }
    * 
    */
   public MergeContent createMergeContent() {
      return new MergeContent();
   }

   /**
    * Create an instance of {@link MergeContentResponse }
    * 
    */
   public MergeContentResponse createMergeContentResponse() {
      return new MergeContentResponse();
   }

   /**
    * Create an instance of {@link MetaData }
    * 
    */
   public MetaData createMetaData() {
      return new MetaData();
   }

   /**
    * Create an instance of {@link PersistContent }
    * 
    */
   public PersistContent createPersistContent() {
      return new PersistContent();
   }

   /**
    * Create an instance of {@link PersistContentResponse }
    * 
    */
   public PersistContentResponse createPersistContentResponse() {
      return new PersistContentResponse();
   }

   /**
    * Create an instance of {@link RefreshContent }
    * 
    */
   public RefreshContent createRefreshContent() {
      return new RefreshContent();
   }

   /**
    * Create an instance of {@link RefreshContentResponse }
    * 
    */
   public RefreshContentResponse createRefreshContentResponse() {
      return new RefreshContentResponse();
   }

   /**
    * Create an instance of {@link RemoveContent }
    * 
    */
   public RemoveContent createRemoveContent() {
      return new RemoveContent();
   }

   /**
    * Create an instance of {@link RemoveContentResponse }
    * 
    */
   public RemoveContentResponse createRemoveContentResponse() {
      return new RemoveContentResponse();
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link Content }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "Content")
   public JAXBElement<Content> createContent(Content value) {
      return new JAXBElement<Content>(_Content_QNAME, Content.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link OrderBy }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "OrderBy")
   public JAXBElement<OrderBy> createOrderBy(OrderBy value) {
      return new JAXBElement<OrderBy>(_OrderBy_QNAME, OrderBy.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link Paging }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "Paging")
   public JAXBElement<Paging> createPaging(Paging value) {
      return new JAXBElement<Paging>(_Paging_QNAME, Paging.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link Permission }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "Permission")
   public JAXBElement<Permission> createPermission(Permission value) {
      return new JAXBElement<Permission>(_Permission_QNAME, Permission.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link Rule }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "Rule")
   public JAXBElement<Rule> createRule(Rule value) {
      return new JAXBElement<Rule>(_Rule_QNAME, Rule.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link CountContent }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "countContent")
   public JAXBElement<CountContent> createCountContent(CountContent value) {
      return new JAXBElement<CountContent>(_CountContent_QNAME, CountContent.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}
    * {@link CountContentResponse }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "countContentResponse")
   public JAXBElement<CountContentResponse> createCountContentResponse(CountContentResponse value) {
      return new JAXBElement<CountContentResponse>(_CountContentResponse_QNAME, CountContentResponse.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link FindContent }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findContent")
   public JAXBElement<FindContent> createFindContent(FindContent value) {
      return new JAXBElement<FindContent>(_FindContent_QNAME, FindContent.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link FindContentById
    * }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findContentById")
   public JAXBElement<FindContentById> createFindContentById(FindContentById value) {
      return new JAXBElement<FindContentById>(_FindContentById_QNAME, FindContentById.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}
    * {@link FindContentByIdResponse }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findContentByIdResponse")
   public JAXBElement<FindContentByIdResponse> createFindContentByIdResponse(FindContentByIdResponse value) {
      return new JAXBElement<FindContentByIdResponse>(_FindContentByIdResponse_QNAME, FindContentByIdResponse.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}
    * {@link FindContentResponse }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findContentResponse")
   public JAXBElement<FindContentResponse> createFindContentResponse(FindContentResponse value) {
      return new JAXBElement<FindContentResponse>(_FindContentResponse_QNAME, FindContentResponse.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link MergeContent }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "mergeContent")
   public JAXBElement<MergeContent> createMergeContent(MergeContent value) {
      return new JAXBElement<MergeContent>(_MergeContent_QNAME, MergeContent.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}
    * {@link MergeContentResponse }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "mergeContentResponse")
   public JAXBElement<MergeContentResponse> createMergeContentResponse(MergeContentResponse value) {
      return new JAXBElement<MergeContentResponse>(_MergeContentResponse_QNAME, MergeContentResponse.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link MetaData }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "metaData")
   public JAXBElement<MetaData> createMetaData(MetaData value) {
      return new JAXBElement<MetaData>(_MetaData_QNAME, MetaData.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link PersistContent }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "persistContent")
   public JAXBElement<PersistContent> createPersistContent(PersistContent value) {
      return new JAXBElement<PersistContent>(_PersistContent_QNAME, PersistContent.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}
    * {@link PersistContentResponse }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "persistContentResponse")
   public JAXBElement<PersistContentResponse> createPersistContentResponse(PersistContentResponse value) {
      return new JAXBElement<PersistContentResponse>(_PersistContentResponse_QNAME, PersistContentResponse.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link RefreshContent }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "refreshContent")
   public JAXBElement<RefreshContent> createRefreshContent(RefreshContent value) {
      return new JAXBElement<RefreshContent>(_RefreshContent_QNAME, RefreshContent.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}
    * {@link RefreshContentResponse }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "refreshContentResponse")
   public JAXBElement<RefreshContentResponse> createRefreshContentResponse(RefreshContentResponse value) {
      return new JAXBElement<RefreshContentResponse>(_RefreshContentResponse_QNAME, RefreshContentResponse.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link RemoveContent }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "removeContent")
   public JAXBElement<RemoveContent> createRemoveContent(RemoveContent value) {
      return new JAXBElement<RemoveContent>(_RemoveContent_QNAME, RemoveContent.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}
    * {@link RemoveContentResponse }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "removeContentResponse")
   public JAXBElement<RemoveContentResponse> createRemoveContentResponse(RemoveContentResponse value) {
      return new JAXBElement<RemoveContentResponse>(_RemoveContentResponse_QNAME, RemoveContentResponse.class, null, value);
   }

}
