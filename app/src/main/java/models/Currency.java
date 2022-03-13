package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency {
    @SerializedName("ID")
    @Expose
    String id;

    @SerializedName("NumCode")
    @Expose
    String numCode;

    @SerializedName("CharCode")
    @Expose
    String charCode;

    @SerializedName("Nominal")
    @Expose
    int nominal;


    String name;@SerializedName("Value")
    @Expose
    float value;

    @SerializedName("Previous")
    @Expose
    float previous;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPrevious() {
        return previous;
    }

    public void setPrevious(float previous) {
        this.previous = previous;
    }
}
