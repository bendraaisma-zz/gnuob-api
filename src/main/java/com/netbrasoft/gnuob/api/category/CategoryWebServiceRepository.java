package com.netbrasoft.gnuob.api.category;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.Category;
import com.netbrasoft.gnuob.api.CategoryWebServiceImpl;
import com.netbrasoft.gnuob.api.CategoryWebServiceImplService;
import com.netbrasoft.gnuob.api.CountCategory;
import com.netbrasoft.gnuob.api.CountCategoryResponse;
import com.netbrasoft.gnuob.api.FindCategory;
import com.netbrasoft.gnuob.api.FindCategoryById;
import com.netbrasoft.gnuob.api.FindCategoryByIdResponse;
import com.netbrasoft.gnuob.api.FindCategoryResponse;
import com.netbrasoft.gnuob.api.MergeCategory;
import com.netbrasoft.gnuob.api.MergeCategoryResponse;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistCategory;
import com.netbrasoft.gnuob.api.PersistCategoryResponse;
import com.netbrasoft.gnuob.api.RefreshCategory;
import com.netbrasoft.gnuob.api.RefreshCategoryResponse;
import com.netbrasoft.gnuob.api.RemoveCategory;

@Repository("CategoryWebServiceRepository")
public class CategoryWebServiceRepository {

    private CategoryWebServiceImpl categoryWebServiceImpl = null;

    public CategoryWebServiceRepository() {

    }

    public long count(MetaData paramMetaData, Category paramCategory) {
        CountCategory paramCountCategory = new CountCategory();
        paramCountCategory.setCategory(paramCategory);
        CountCategoryResponse countCategoryResponse = getCategoryWebServiceImpl().countCategory(paramCountCategory, paramMetaData);
        return countCategoryResponse.getReturn();
    }

    public Category find(MetaData paramMetaData, Category paramCategory) {
        FindCategoryById paramFindCategoryById = new FindCategoryById();
        paramFindCategoryById.setCategory(paramCategory);
        FindCategoryByIdResponse findCategoryByIdResponse = getCategoryWebServiceImpl().findCategoryById(paramFindCategoryById, paramMetaData);
        return findCategoryByIdResponse.getReturn();

    }

    public List<Category> find(MetaData paramMetaData, Category paramCategory, Paging paramPaging, OrderBy paramOrderBy) {
        FindCategory paramFindCategory = new FindCategory();
        paramFindCategory.setCategory(paramCategory);
        paramFindCategory.setPaging(paramPaging);
        paramFindCategory.setOrderBy(paramOrderBy);
        FindCategoryResponse findCategoryResponse = getCategoryWebServiceImpl().findCategory(paramFindCategory, paramMetaData);
        return findCategoryResponse.getReturn();
    }

    private CategoryWebServiceImpl getCategoryWebServiceImpl() {

        if (categoryWebServiceImpl == null) {
            CategoryWebServiceImplService categoryWebServiceImplService = new CategoryWebServiceImplService(CategoryWebServiceImplService.WSDL_LOCATION);
            categoryWebServiceImpl = categoryWebServiceImplService.getCategoryWebServiceImplPort();
        }

        return categoryWebServiceImpl;
    }

    public Category merge(MetaData paramMetaData, Category paramCategory) {
        MergeCategory paramMergeCategory = new MergeCategory();
        paramMergeCategory.setCategory(paramCategory);
        MergeCategoryResponse mergeCategoryResponse = getCategoryWebServiceImpl().mergeCategory(paramMergeCategory, paramMetaData);
        return mergeCategoryResponse.getReturn();
    }

    public Category persist(MetaData paramMetaData, Category paramCategory) {
        PersistCategory paramPersistCategory = new PersistCategory();
        paramPersistCategory.setCategory(paramCategory);
        PersistCategoryResponse persistCategoryResponse = getCategoryWebServiceImpl().persistCategory(paramPersistCategory, paramMetaData);
        return persistCategoryResponse.getReturn();
    }

    public Category refresh(MetaData paramMetaData, Category paramCategory) {
        RefreshCategory paramRefresCategory = new RefreshCategory();
        paramRefresCategory.setCategory(paramCategory);
        RefreshCategoryResponse refreshCategoryResponse = getCategoryWebServiceImpl().refreshCategory(paramRefresCategory, paramMetaData);
        return refreshCategoryResponse.getReturn();
    }

    public void remove(MetaData paramMetaData, Category paramCategory) {
        RemoveCategory paramRemoveCategory = new RemoveCategory();
        paramRemoveCategory.setCategory(paramCategory);
        getCategoryWebServiceImpl().removeCategory(paramRemoveCategory, paramMetaData);
    }
}
