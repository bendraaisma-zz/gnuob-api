package com.netbrasoft.gnuob.api.category;

import org.apache.wicket.model.LoadableDetachableModel;

import com.netbrasoft.gnuob.api.Category;

class CategoryLoadableDetachableModel<C extends Category> extends LoadableDetachableModel<C> {

   private static final long serialVersionUID = 2803887803933459687L;

   private final C category;

   public CategoryLoadableDetachableModel(C category) {
      this.category = category;
   }

   @Override
   public boolean equals(final Object obj) {
      if (obj == this) {
         return true;
      } else if (obj == null) {
         return false;
      } else if (obj instanceof CategoryLoadableDetachableModel) {
         CategoryLoadableDetachableModel<?> other = (CategoryLoadableDetachableModel<?>) obj;
         return other.category.getId() == category.getId();
      }
      return false;
   }

   @Override
   public int hashCode() {
      return Long.valueOf(category.getId()).hashCode();
   }

   @Override
   protected C load() {
      return category;
   }

}
