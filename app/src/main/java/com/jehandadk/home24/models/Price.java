
package com.jehandadk.home24.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Price {

    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("isRecommendedRetailPrice")
    @Expose
    private boolean isRecommendedRetailPrice;

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
     * @return The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return The isRecommendedRetailPrice
     */
    public boolean isIsRecommendedRetailPrice() {
        return isRecommendedRetailPrice;
    }

    /**
     * @param isRecommendedRetailPrice The isRecommendedRetailPrice
     */
    public void setIsRecommendedRetailPrice(boolean isRecommendedRetailPrice) {
        this.isRecommendedRetailPrice = isRecommendedRetailPrice;
    }

}
