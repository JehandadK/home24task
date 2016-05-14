
package com.jehandadk.home24.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Medium {

    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("mimeType")
    @Expose
    private String mimeType;
    @SerializedName("type")
    @Expose
    private Object type;
    @SerializedName("priority")
    @Expose
    private int priority;
    @SerializedName("size")
    @Expose
    private Object size;

    /**
     * @return The uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @param uri The uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * @return The mimeType
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * @param mimeType The mimeType
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * @return The type
     */
    public Object getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(Object type) {
        this.type = type;
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
     * @return The size
     */
    public Object getSize() {
        return size;
    }

    /**
     * @param size The size
     */
    public void setSize(Object size) {
        this.size = size;
    }

}
