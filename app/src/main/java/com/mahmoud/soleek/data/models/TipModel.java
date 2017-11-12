package com.mahmoud.soleek.data.models;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TipModel implements Parcelable {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Tip> data = null;
    public final static Parcelable.Creator<TipModel> CREATOR = new Creator<TipModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TipModel createFromParcel(Parcel in) {
            return new TipModel(in);
        }

        public TipModel[] newArray(int size) {
            return (new TipModel[size]);
        }

    };

    protected TipModel(Parcel in) {
        this.code = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.data, (com.mahmoud.soleek.data.models.Tip.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     */
    public TipModel() {
    }

    /**
     * @param message
     * @param data
     * @param code
     */
    public TipModel(Integer code, String message, List<Tip> data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Tip> getData() {
        return data;
    }

    public void setData(List<Tip> data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(code);
        dest.writeValue(message);
        dest.writeList(data);
    }

    public int describeContents() {
        return 0;
    }

}