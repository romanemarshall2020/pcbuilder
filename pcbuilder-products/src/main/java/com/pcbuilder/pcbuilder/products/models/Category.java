package com.pcbuilder.pcbuilder.products.models;

import lombok.Data;

@Data
public class Category {
   private String id;
   private String name;

   @Override
   public String toString() {
    return "Category{id='" + id + "', name='" + name + "'}";
}
}
