
package com.jehandadk.home24.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Time {

    @SerializedName("renderAs")
    @Expose
    private String renderAs;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("units")
    @Expose
    private String units;

    /**
     * @return The renderAs
     */
    public String getRenderAs() {
        return renderAs;
    }

    /**
     * @param renderAs The renderAs
     */
    public void setRenderAs(String renderAs) {
        this.renderAs = renderAs;
    }

    /**
     * @return The amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount The amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return The units
     */
    public String getUnits() {
        return units;
    }

    /**
     * @param units The units
     */
    public void setUnits(String units) {
        this.units = units;
    }

}
