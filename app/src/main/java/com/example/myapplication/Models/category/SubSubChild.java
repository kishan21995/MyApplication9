package com.example.myapplication.Models.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubSubChild {

@SerializedName("id")
@Expose
private String id;
@SerializedName("sub_child_name")
@Expose
private String subChildName;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getSubChildName() {
return subChildName;
}

public void setSubChildName(String subChildName) {
this.subChildName = subChildName;
}

}