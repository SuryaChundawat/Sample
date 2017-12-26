package com.example.suryanarayan.sample.Modal;

import java.io.Serializable;

/**
 * Created by surya.narayan on 12/20/2017.
 */

public class VedioDetailsParameter implements Serializable
{
    private String strSolid;
    private String strDuration;
    private String strDate;

    public String getStrSolid() {
        return strSolid;
    }

    public void setStrSolid(String strSolid) {
        this.strSolid = strSolid;
    }

    public String getStrDuration() {
        return strDuration;
    }

    public void setStrDuration(String strDuration) {
        this.strDuration = strDuration;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public VedioDetailsParameter(String strSolid, String strDuration, String strDate) {
        this.strSolid = strSolid;
        this.strDuration = strDuration;
        this.strDate = strDate;
    }

    @Override
    public String toString() {
        return "VedioDetailsParameter{" +
                "strSolid='" + strSolid + '\'' +
                ", strDuration='" + strDuration + '\'' +
                ", strDate='" + strDate + '\'' +
                '}';
    }
}
