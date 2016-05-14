
package com.jehandadk.home24.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ArticleListResponse {

    @SerializedName("resourceType")
    @Expose
    private String resourceType;
    @SerializedName("articlesCount")
    @Expose
    private int articlesCount;
    @SerializedName("_links")
    @Expose
    private Links Links;
    @SerializedName("_embedded")
    @Expose
    private Embedded Embedded;

    /**
     * @return The resourceType
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * @param resourceType The resourceType
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * @return The articlesCount
     */
    public int getArticlesCount() {
        return articlesCount;
    }

    /**
     * @param articlesCount The articlesCount
     */
    public void setArticlesCount(int articlesCount) {
        this.articlesCount = articlesCount;
    }

    /**
     * @return The Links
     */
    public Links getLinks() {
        return Links;
    }

    /**
     * @param Links The _links
     */
    public void setLinks(Links Links) {
        this.Links = Links;
    }

    /**
     * @return The Embedded
     */
    public Embedded getEmbedded() {
        return Embedded;
    }

    /**
     * @param Embedded The _embedded
     */
    public void setEmbedded(Embedded Embedded) {
        this.Embedded = Embedded;
    }

}
