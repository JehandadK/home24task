
package com.jehandadk.home24.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class WebShopUrl {

    @SerializedName("href")
    @Expose
    private Object href;

    /**
     * @return The href
     */
    public Object getHref() {
        return href;
    }

    /**
     * @param href The href
     */
    public void setHref(Object href) {
        this.href = href;
    }

}
