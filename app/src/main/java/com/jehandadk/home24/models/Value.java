
package com.jehandadk.home24.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Value {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("priority")
    @Expose
    private int priority;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("_metadata")
    @Expose
    private Metadata Metadata;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority The priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The Metadata
     */
    public Metadata getMetadata() {
        return Metadata;
    }

    /**
     * @param Metadata The _metadata
     */
    public void setMetadata(Metadata Metadata) {
        this.Metadata = Metadata;
    }

}
