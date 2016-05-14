
package com.jehandadk.home24.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Links {

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("articles")
    @Expose
    private List<Article_> articles = new ArrayList<Article_>();
    @SerializedName("next")
    @Expose
    private Next next;

    /**
     * @return The self
     */
    public Self getSelf() {
        return self;
    }

    /**
     * @param self The self
     */
    public void setSelf(Self self) {
        this.self = self;
    }

    /**
     * @return The articles
     */
    public List<Article_> getArticles() {
        return articles;
    }

    /**
     * @param articles The articles
     */
    public void setArticles(List<Article_> articles) {
        this.articles = articles;
    }

    /**
     * @return The next
     */
    public Next getNext() {
        return next;
    }

    /**
     * @param next The next
     */
    public void setNext(Next next) {
        this.next = next;
    }

}
