
package com.jehandadk.home24.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Links_ {

    @SerializedName("self")
    @Expose
    private Self_ self;
    @SerializedName("webShopUrl")
    @Expose
    private WebShopUrl webShopUrl;

    /**
     * @return The self
     */
    public Self_ getSelf() {
        return self;
    }

    /**
     * @param self The self
     */
    public void setSelf(Self_ self) {
        this.self = self;
    }

    /**
     * @return The webShopUrl
     */
    public WebShopUrl getWebShopUrl() {
        return webShopUrl;
    }

    /**
     * @param webShopUrl The webShopUrl
     */
    public void setWebShopUrl(WebShopUrl webShopUrl) {
        this.webShopUrl = webShopUrl;
    }

}
