
package com.jehandadk.home24.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Article {

    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("prevPrice")
    @Expose
    private PrevPrice prevPrice;
    @SerializedName("manufacturePrice")
    @Expose
    private Object manufacturePrice;
    @SerializedName("delivery")
    @Expose
    private Delivery delivery;
    @SerializedName("brand")
    @Expose
    private Brand brand;
    @SerializedName("media")
    @Expose
    private List<Medium> media = new ArrayList<Medium>();
    @SerializedName("assemblyService")
    @Expose
    private Object assemblyService;
    @SerializedName("availability")
    @Expose
    private Object availability;
    @SerializedName("url")
    @Expose
    private Object url;
    @SerializedName("energyClass")
    @Expose
    private Object energyClass;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("price")
    @Expose
    private Price price;
    @SerializedName("_metadata")
    @Expose
    private Metadata__ Metadata;
    @SerializedName("_links")
    @Expose
    private Links_ Links;

    private boolean isLiked = false;
    private boolean isDisliked = false;

    public boolean isDisliked() {
        return isDisliked;
    }

    public void setDisliked(boolean disliked) {
        isDisliked = disliked;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }


    /**
     * @return The description
     */
    public Object getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(Object description) {
        this.description = description;
    }

    /**
     * @return The prevPrice
     */
    public PrevPrice getPrevPrice() {
        return prevPrice;
    }

    /**
     * @param prevPrice The prevPrice
     */
    public void setPrevPrice(PrevPrice prevPrice) {
        this.prevPrice = prevPrice;
    }

    /**
     * @return The manufacturePrice
     */
    public Object getManufacturePrice() {
        return manufacturePrice;
    }

    /**
     * @param manufacturePrice The manufacturePrice
     */
    public void setManufacturePrice(Object manufacturePrice) {
        this.manufacturePrice = manufacturePrice;
    }

    /**
     * @return The delivery
     */
    public Delivery getDelivery() {
        return delivery;
    }

    /**
     * @param delivery The delivery
     */
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    /**
     * @return The brand
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * @param brand The brand
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * @return The media
     */
    public List<Medium> getMedia() {
        return media;
    }

    /**
     * @param media The media
     */
    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    /**
     * @return The assemblyService
     */
    public Object getAssemblyService() {
        return assemblyService;
    }

    /**
     * @param assemblyService The assemblyService
     */
    public void setAssemblyService(Object assemblyService) {
        this.assemblyService = assemblyService;
    }

    /**
     * @return The availability
     */
    public Object getAvailability() {
        return availability;
    }

    /**
     * @param availability The availability
     */
    public void setAvailability(Object availability) {
        this.availability = availability;
    }

    /**
     * @return The url
     */
    public Object getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(Object url) {
        this.url = url;
    }

    /**
     * @return The energyClass
     */
    public Object getEnergyClass() {
        return energyClass;
    }

    /**
     * @param energyClass The energyClass
     */
    public void setEnergyClass(Object energyClass) {
        this.energyClass = energyClass;
    }

    /**
     * @return The sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * @param sku The sku
     */
    public void setSku(String sku) {
        this.sku = sku;
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
     * @return The price
     */
    public Price getPrice() {
        return price;
    }

    /**
     * @param price The price
     */
    public void setPrice(Price price) {
        this.price = price;
    }

    /**
     * @return The Metadata
     */
    public Metadata__ getMetadata() {
        return Metadata;
    }

    /**
     * @param Metadata The _metadata
     */
    public void setMetadata(Metadata__ Metadata) {
        this.Metadata = Metadata;
    }

    /**
     * @return The Links
     */
    public Links_ getLinks() {
        return Links;
    }

    /**
     * @param Links The _links
     */
    public void setLinks(Links_ Links) {
        this.Links = Links;
    }

}
