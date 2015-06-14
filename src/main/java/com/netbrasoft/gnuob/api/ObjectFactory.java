
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

   private final static QName _OrderBy_QNAME = new QName("http://gnuob.netbrasoft.com/", "OrderBy");
   private final static QName _Paging_QNAME = new QName("http://gnuob.netbrasoft.com/", "Paging");
   private final static QName _Permission_QNAME = new QName("http://gnuob.netbrasoft.com/", "Permission");
   private final static QName _Rule_QNAME = new QName("http://gnuob.netbrasoft.com/", "Rule");
   private final static QName _CountSetting_QNAME = new QName("http://gnuob.netbrasoft.com/", "countSetting");
   private final static QName _CountSettingResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "countSettingResponse");
   private final static QName _FindSetting_QNAME = new QName("http://gnuob.netbrasoft.com/", "findSetting");
   private final static QName _FindSettingById_QNAME = new QName("http://gnuob.netbrasoft.com/", "findSettingById");
   private final static QName _FindSettingByIdResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "findSettingByIdResponse");
   private final static QName _FindSettingResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "findSettingResponse");
   private final static QName _MergeSetting_QNAME = new QName("http://gnuob.netbrasoft.com/", "mergeSetting");
   private final static QName _MergeSettingResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "mergeSettingResponse");
   private final static QName _MetaData_QNAME = new QName("http://gnuob.netbrasoft.com/", "metaData");
   private final static QName _PersistSetting_QNAME = new QName("http://gnuob.netbrasoft.com/", "persistSetting");
   private final static QName _PersistSettingResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "persistSettingResponse");
   private final static QName _RefreshSetting_QNAME = new QName("http://gnuob.netbrasoft.com/", "refreshSetting");
   private final static QName _RefreshSettingResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "refreshSettingResponse");
   private final static QName _RemoveSetting_QNAME = new QName("http://gnuob.netbrasoft.com/", "removeSetting");
   private final static QName _RemoveSettingResponse_QNAME = new QName("http://gnuob.netbrasoft.com/", "removeSettingResponse");

   /**
    * Create a new ObjectFactory that can be used to create new instances of
    * schema derived classes for package: com.netbrasoft.gnuob.api
    * 
    */
   public ObjectFactory() {
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
    * Create an instance of {@link CountSetting }
    * 
    */
   public CountSetting createCountSetting() {
      return new CountSetting();
   }

   /**
    * Create an instance of {@link CountSettingResponse }
    * 
    */
   public CountSettingResponse createCountSettingResponse() {
      return new CountSettingResponse();
   }

   /**
    * Create an instance of {@link FindSetting }
    * 
    */
   public FindSetting createFindSetting() {
      return new FindSetting();
   }

   /**
    * Create an instance of {@link FindSettingById }
    * 
    */
   public FindSettingById createFindSettingById() {
      return new FindSettingById();
   }

   /**
    * Create an instance of {@link FindSettingByIdResponse }
    * 
    */
   public FindSettingByIdResponse createFindSettingByIdResponse() {
      return new FindSettingByIdResponse();
   }

   /**
    * Create an instance of {@link FindSettingResponse }
    * 
    */
   public FindSettingResponse createFindSettingResponse() {
      return new FindSettingResponse();
   }

   /**
    * Create an instance of {@link MergeSetting }
    * 
    */
   public MergeSetting createMergeSetting() {
      return new MergeSetting();
   }

   /**
    * Create an instance of {@link MergeSettingResponse }
    * 
    */
   public MergeSettingResponse createMergeSettingResponse() {
      return new MergeSettingResponse();
   }

   /**
    * Create an instance of {@link MetaData }
    * 
    */
   public MetaData createMetaData() {
      return new MetaData();
   }

   /**
    * Create an instance of {@link PersistSetting }
    * 
    */
   public PersistSetting createPersistSetting() {
      return new PersistSetting();
   }

   /**
    * Create an instance of {@link PersistSettingResponse }
    * 
    */
   public PersistSettingResponse createPersistSettingResponse() {
      return new PersistSettingResponse();
   }

   /**
    * Create an instance of {@link RefreshSetting }
    * 
    */
   public RefreshSetting createRefreshSetting() {
      return new RefreshSetting();
   }

   /**
    * Create an instance of {@link RefreshSettingResponse }
    * 
    */
   public RefreshSettingResponse createRefreshSettingResponse() {
      return new RefreshSettingResponse();
   }

   /**
    * Create an instance of {@link RemoveSetting }
    * 
    */
   public RemoveSetting createRemoveSetting() {
      return new RemoveSetting();
   }

   /**
    * Create an instance of {@link RemoveSettingResponse }
    * 
    */
   public RemoveSettingResponse createRemoveSettingResponse() {
      return new RemoveSettingResponse();
   }

   /**
    * Create an instance of {@link Setting }
    * 
    */
   public Setting createSetting() {
      return new Setting();
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
    * Create an instance of {@link JAXBElement }{@code <}{@link CountSetting }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "countSetting")
   public JAXBElement<CountSetting> createCountSetting(CountSetting value) {
      return new JAXBElement<CountSetting>(_CountSetting_QNAME, CountSetting.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}
    * {@link CountSettingResponse }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "countSettingResponse")
   public JAXBElement<CountSettingResponse> createCountSettingResponse(CountSettingResponse value) {
      return new JAXBElement<CountSettingResponse>(_CountSettingResponse_QNAME, CountSettingResponse.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link FindSetting }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findSetting")
   public JAXBElement<FindSetting> createFindSetting(FindSetting value) {
      return new JAXBElement<FindSetting>(_FindSetting_QNAME, FindSetting.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link FindSettingById
    * }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findSettingById")
   public JAXBElement<FindSettingById> createFindSettingById(FindSettingById value) {
      return new JAXBElement<FindSettingById>(_FindSettingById_QNAME, FindSettingById.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}
    * {@link FindSettingByIdResponse }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findSettingByIdResponse")
   public JAXBElement<FindSettingByIdResponse> createFindSettingByIdResponse(FindSettingByIdResponse value) {
      return new JAXBElement<FindSettingByIdResponse>(_FindSettingByIdResponse_QNAME, FindSettingByIdResponse.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}
    * {@link FindSettingResponse }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "findSettingResponse")
   public JAXBElement<FindSettingResponse> createFindSettingResponse(FindSettingResponse value) {
      return new JAXBElement<FindSettingResponse>(_FindSettingResponse_QNAME, FindSettingResponse.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link MergeSetting }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "mergeSetting")
   public JAXBElement<MergeSetting> createMergeSetting(MergeSetting value) {
      return new JAXBElement<MergeSetting>(_MergeSetting_QNAME, MergeSetting.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}
    * {@link MergeSettingResponse }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "mergeSettingResponse")
   public JAXBElement<MergeSettingResponse> createMergeSettingResponse(MergeSettingResponse value) {
      return new JAXBElement<MergeSettingResponse>(_MergeSettingResponse_QNAME, MergeSettingResponse.class, null, value);
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
    * Create an instance of {@link JAXBElement }{@code <}{@link PersistSetting }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "persistSetting")
   public JAXBElement<PersistSetting> createPersistSetting(PersistSetting value) {
      return new JAXBElement<PersistSetting>(_PersistSetting_QNAME, PersistSetting.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}
    * {@link PersistSettingResponse }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "persistSettingResponse")
   public JAXBElement<PersistSettingResponse> createPersistSettingResponse(PersistSettingResponse value) {
      return new JAXBElement<PersistSettingResponse>(_PersistSettingResponse_QNAME, PersistSettingResponse.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link RefreshSetting }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "refreshSetting")
   public JAXBElement<RefreshSetting> createRefreshSetting(RefreshSetting value) {
      return new JAXBElement<RefreshSetting>(_RefreshSetting_QNAME, RefreshSetting.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}
    * {@link RefreshSettingResponse }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "refreshSettingResponse")
   public JAXBElement<RefreshSettingResponse> createRefreshSettingResponse(RefreshSettingResponse value) {
      return new JAXBElement<RefreshSettingResponse>(_RefreshSettingResponse_QNAME, RefreshSettingResponse.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSetting }
    * {@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "removeSetting")
   public JAXBElement<RemoveSetting> createRemoveSetting(RemoveSetting value) {
      return new JAXBElement<RemoveSetting>(_RemoveSetting_QNAME, RemoveSetting.class, null, value);
   }

   /**
    * Create an instance of {@link JAXBElement }{@code <}
    * {@link RemoveSettingResponse }{@code >}}
    * 
    */
   @XmlElementDecl(namespace = "http://gnuob.netbrasoft.com/", name = "removeSettingResponse")
   public JAXBElement<RemoveSettingResponse> createRemoveSettingResponse(RemoveSettingResponse value) {
      return new JAXBElement<RemoveSettingResponse>(_RemoveSettingResponse_QNAME, RemoveSettingResponse.class, null, value);
   }

}
