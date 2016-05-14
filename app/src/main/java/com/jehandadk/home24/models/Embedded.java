
package com.jehandadk.home24.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Embedded {

    @SerializedName("filters")
    @Expose
    private List<Filter> filters = new ArrayList<Filter>();
    @SerializedName("articles")
    @Expose
    private List<Article> articles = new ArrayList<Article>();

    /**
     * @return The filters
     */
    public List<Filter> getFilters() {
        return filters;
    }

    /**
     * @param filters The filters
     */
    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    /**
     * @return The articles
     */
    public List<Article> getArticles() {
        return articles;
    }

    /**
     * @param articles The articles
     */
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}
