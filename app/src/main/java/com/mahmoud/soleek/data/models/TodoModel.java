

package com.mahmoud.soleek.data.models;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TodoModel implements Parcelable {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Todo> data = null;
    public final static Parcelable.Creator<TodoModel> CREATOR = new Creator<TodoModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TodoModel createFromParcel(Parcel in) {
            return new TodoModel(in);
        }

        public TodoModel[] newArray(int size) {
            return (new TodoModel[size]);
        }

    };

    protected TodoModel(Parcel in) {
        this.code = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.data, (com.mahmoud.soleek.data.models.Todo.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     */
    public TodoModel() {
    }

    /**
     * @param message
     * @param data
     * @param code
     */
    public TodoModel(Integer code, String message, List<Todo> data) {
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

    public List<Todo> getData() {
        return data;
    }

    public void setData(List<Todo> data) {
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