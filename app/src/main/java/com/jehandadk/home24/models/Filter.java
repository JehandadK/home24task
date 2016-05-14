
package com.jehandadk.home24.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Filter {

    @SerializedName("values")
    @Expose
    private List<Value> values = new ArrayList<Value>();
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
    private Metadata_ Metadata;
    @SerializedName("min")
    @Expose
    private int min;
    @SerializedName("max")
    @Expose
    private int max;
    @SerializedName("currentMin")
    @Expose
    private int currentMin;
    @SerializedName("currentMax")
    @Expose
    private int currentMax;
    @SerializedName("unit")
    @Expose
    private String unit;

    /**
     * @return The values
     */
    public List<Value> getValues() {
        return values;
    }

    /**
     * @param values The values
     */
    public void setValues(List<Value> values) {
        this.values = values;
    }

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
    public Metadata_ getMetadata() {
        return Metadata;
    }

    /**
     * @param Metadata The _metadata
     */
    public void setMetadata(Metadata_ Metadata) {
        this.Metadata = Metadata;
    }

    /**
     * @return The min
     */
    public int getMin() {
        return min;
    }

    /**
     * @param min The min
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * @return The max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max The max
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return The currentMin
     */
    public int getCurrentMin() {
        return currentMin;
    }

    /**
     * @param currentMin The currentMin
     */
    public void setCurrentMin(int currentMin) {
        this.currentMin = currentMin;
    }

    /**
     * @return The currentMax
     */
    public int getCurrentMax() {
        return currentMax;
    }

    /**
     * @param currentMax The currentMax
     */
    public void setCurrentMax(int currentMax) {
        this.currentMax = currentMax;
    }

    /**
     * @return The unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit The unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

}
