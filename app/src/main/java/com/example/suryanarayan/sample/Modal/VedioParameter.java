package com.example.suryanarayan.sample.Modal;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by surya.narayan on 12/19/2017.
 */

public class VedioParameter implements Parcelable{

    private String strSolid;
    private String strDate;
    private String strInterval;
    private String strDatetime;
    private String strRetentionperiod;
    private String strAudiotype;
    private String strLocation;


    public VedioParameter(String strSolid, String strDate, String strInterval, String strDatetime, String strRetentionperiod, String strAudiotype, String strLocation) {
        this.strSolid = strSolid;
        this.strDate = strDate;
        this.strInterval = strInterval;
        this.strDatetime = strDatetime;
        this.strRetentionperiod = strRetentionperiod;
        this.strAudiotype = strAudiotype;
        this.strLocation = strLocation;
    }


    protected VedioParameter(Parcel in) {
        strSolid = in.readString();
        strDate = in.readString();
        strInterval = in.readString();
        strDatetime = in.readString();
        strRetentionperiod = in.readString();
        strAudiotype = in.readString();
        strLocation = in.readString();
    }

    public static final Creator<VedioParameter> CREATOR = new Creator<VedioParameter>() {
        @Override
        public VedioParameter createFromParcel(Parcel in) {
            return new VedioParameter(in);
        }

        @Override
        public VedioParameter[] newArray(int size) {
            return new VedioParameter[size];
        }
    };

    public String getStrSolid() {
        return strSolid;
    }

    public void setStrSolid(String strSolid) {
        this.strSolid = strSolid;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public String getStrInterval() {
        return strInterval;
    }

    public void setStrInterval(String strInterval) {
        this.strInterval = strInterval;
    }

    public String getStrDatetime() {
        return strDatetime;
    }

    public void setStrDatetime(String strDatetime) {
        this.strDatetime = strDatetime;
    }

    public String getStrRetentionperiod() {
        return strRetentionperiod;
    }

    public void setStrRetentionperiod(String strRetentionperiod) {
        this.strRetentionperiod = strRetentionperiod;
    }

    public String getStrAudiotype() {
        return strAudiotype;
    }

    public void setStrAudiotype(String strAudiotype) {
        this.strAudiotype = strAudiotype;
    }

    public String getStrLocation() {
        return strLocation;
    }

    public void setStrLocation(String strLocation) {
        this.strLocation = strLocation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(strSolid);
        dest.writeString(strDate);
        dest.writeString(strInterval);
        dest.writeString(strDatetime);
        dest.writeString(strRetentionperiod);
        dest.writeString(strAudiotype);
        dest.writeString(strLocation);
    }
}
