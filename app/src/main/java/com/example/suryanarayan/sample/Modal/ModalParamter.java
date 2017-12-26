package com.example.suryanarayan.sample.Modal;

import java.io.Serializable;

/**
 * Created by surya.narayan on 12/13/2017.
 */

public class ModalParamter implements Serializable
{
    private String AlertPercentage ;
    private String HeaderName;
    private String StoreOne;
    private String StoreTwo;
    private String Storethree;
    private String StoreFour;
    private String StoreFive;
    private String StoreOnevalue;
    private String StoreTwovalue;
    private String StoreThreevalue;
    private String StoreFourvalue;
    private String StoreFivevalue;

    public ModalParamter(String HeaderName,String AlertPercentage, String StoreOne, String StoreTwo, String StoreThree, String StoreFour, String StoreFive,
                         String StoreValueOne, String StoreValueTwo, String StoreValueThree, String StoreValueFour, String StoreValueFive)
    {
        this.HeaderName = HeaderName;
        this.AlertPercentage = AlertPercentage;
        this.StoreOne  =StoreOne;
        this.StoreTwo  =StoreTwo;
        this.Storethree  =StoreThree;
        this.StoreFour  =StoreFour;
        this.StoreFive  =StoreFive;
        this.StoreOnevalue  =StoreValueOne;
        this.StoreTwovalue  =StoreValueTwo;
        this.StoreThreevalue  =StoreValueThree;
        this.StoreFourvalue  =StoreValueFour;
        this.StoreFivevalue  =StoreValueFive;
    }

    public String getHeaderName() {
        return HeaderName;
    }

    public void setHeaderName(String headerName) {
        HeaderName = headerName;
    }


    public String getAlertPercentage() {
        return AlertPercentage;
    }

    public void setAlertPercentage(String alertPercentage) {
        AlertPercentage = alertPercentage;
    }

    public String getStoreOne() {
        return StoreOne;
    }

    public void setStoreOne(String storeOne) {
        StoreOne = storeOne;
    }

    public String getStoreTwo() {
        return StoreTwo;
    }

    public void setStoreTwo(String storeTwo) {
        StoreTwo = storeTwo;
    }

    public String getStorethree() {
        return Storethree;
    }

    public void setStorethree(String storethree) {
        Storethree = storethree;
    }

    public String getStoreFour() {
        return StoreFour;
    }

    public void setStoreFour(String storeFour) {
        StoreFour = storeFour;
    }

    public String getStoreFive() {
        return StoreFive;
    }

    public void setStoreFive(String storeFive) {
        StoreFive = storeFive;
    }

    public String getStoreOnevalue() {
        return StoreOnevalue;
    }

    public void setStoreOnevalue(String storeOnevalue) {
        StoreOnevalue = storeOnevalue;
    }

    public String getStoreTwovalue() {
        return StoreTwovalue;
    }

    public void setStoreTwovalue(String storeTwovalue) {
        StoreTwovalue = storeTwovalue;
    }

    public String getStoreThreevalue() {
        return StoreThreevalue;
    }

    public void setStoreThreevalue(String storeThreevalue) {
        StoreThreevalue = storeThreevalue;
    }

    public String getStoreFourvalue() {
        return StoreFourvalue;
    }

    public void setStoreFourvalue(String storeFourvalue) {
        StoreFourvalue = storeFourvalue;
    }

    public String getStoreFivevalue() {
        return StoreFivevalue;
    }

    public void setStoreFivevalue(String storeFivevalue) {
        StoreFivevalue = storeFivevalue;
    }







}
