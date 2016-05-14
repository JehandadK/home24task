
package com.jehandadk.home24.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Delivery {

    @SerializedName("time")
    @Expose
    private Time time;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("terms")
    @Expose
    private Object terms;
    @SerializedName("deliveredBy")
    @Expose
    private Object deliveredBy;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("typeLabelLink")
    @Expose
    private String typeLabelLink;

    /**
     * @return The time
     */
    public Time getTime() {
        return time;
    }

    /**
     * @param time The time
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The terms
     */
    public Object getTerms() {
        return terms;
    }

    /**
     * @param terms The terms
     */
    public void setTerms(Object terms) {
        this.terms = terms;
    }

    /**
     * @return The deliveredBy
     */
    public Object getDeliveredBy() {
        return deliveredBy;
    }

    /**
     * @param deliveredBy The deliveredBy
     */
    public void setDeliveredBy(Object deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    /**
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return The typeLabelLink
     */
    public String getTypeLabelLink() {
        return typeLabelLink;
    }

    /**
     * @param typeLabelLink The typeLabelLink
     */
    public void setTypeLabelLink(String typeLabelLink) {
        this.typeLabelLink = typeLabelLink;
    }

}
