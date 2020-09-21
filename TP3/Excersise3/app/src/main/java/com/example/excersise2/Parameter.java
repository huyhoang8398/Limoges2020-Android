package com.example.excersise2;

import android.os.Parcel;
import android.os.Parcelable;

public class Parameter implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Parameter createFromParcel(Parcel in) {
            return new Parameter(in);
        }
        public Parameter[] newArray(int size) {
            return new Parameter[size];
        }
    };

    private String plainText;
    private String key;
    private String method;
    private String algo;

    public Parameter(Parcel in) {
        this.plainText = in.readString();
        this.key = in.readString();
        this.method = in.readString();
        this.algo = in.readString();
    }

    public Parameter(String text, String encryptKey, String method, String algo) {
        this.plainText =text;
        this.key = encryptKey;
        this.method = method;
        this.algo = algo;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.plainText);
        dest.writeString(this.key);
        dest.writeString(this.method);
        dest.writeString(this.algo);
    }

    public String getAlgo() {
        return algo;
    }

    public void setAlgo(String algo) {
        this.algo = algo;
    }
}
