package com.example.myapplication.Models.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Detail {

@SerializedName("cat_id")
@Expose
private String catId;
@SerializedName("cat_name")
@Expose
private String catName;
@SerializedName("sub_cat")
@Expose
private List<SubCat> subCat = null;

public String getCatId() {
return catId;
}

public void setCatId(String catId) {
this.catId = catId;
}

public String getCatName() {
return catName;
}

public void setCatName(String catName) {
this.catName = catName;
}

public List<SubCat> getSubCat() {
return subCat;
}

public void setSubCat(List<SubCat> subCat) {
this.subCat = subCat;
}

}
