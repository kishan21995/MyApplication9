package com.example.myapplication.Models.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubCat {

@SerializedName("sub_cat_id")
@Expose
private String subCatId;
@SerializedName("sub_cat_name")
@Expose
private String subCatName;
@SerializedName("sub_sub_child")
@Expose
private List<SubSubChild> subSubChild = null;

public String getSubCatId() {
return subCatId;
}

public void setSubCatId(String subCatId) {
this.subCatId = subCatId;
}

public String getSubCatName() {
return subCatName;
}

public void setSubCatName(String subCatName) {
this.subCatName = subCatName;
}

public List<SubSubChild> getSubSubChild() {
return subSubChild;
}

public void setSubSubChild(List<SubSubChild> subSubChild) {
this.subSubChild = subSubChild;
}

}