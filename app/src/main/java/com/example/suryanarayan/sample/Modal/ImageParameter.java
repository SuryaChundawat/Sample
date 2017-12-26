package com.example.suryanarayan.sample.Modal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by surya.narayan on 12/19/2017.
 */

@SuppressLint("ParcelCreator")
public class ImageParameter implements Parcelable
{
    private String strImagepath;
    private String strCameraPath;
    private String strTime;
    private String strSoiId;
    private String strDateTime;

    public ImageParameter(String strCameraPath, String strDateTime, String strImagepath) {
        this.strCameraPath = strCameraPath;
        this.strDateTime = strDateTime;
        this.strImagepath = strImagepath;
    }

    public String getStrImagepath() {
        return strImagepath;
    }

    public void setStrImagepath(String strImagepath) {
        this.strImagepath = strImagepath;
    }

    public String getStrCameraPath() {
        return strCameraPath;
    }

    public void setStrCameraPath(String strCameraPath) {
        this.strCameraPath = strCameraPath;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public String getStrSoiId() {
        return strSoiId;
    }

    public void setStrSoiId(String strSoiId) {
        this.strSoiId = strSoiId;
    }

    public String getStrDateTime() {
        return strDateTime;
    }

    public void setStrDateTime(String strDateTime) {
        this.strDateTime = strDateTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(strImagepath);
        dest.writeString(strCameraPath);
        dest.writeString(strTime);
        dest.writeString(strSoiId);
        dest.writeString(strDateTime);
    }
}
