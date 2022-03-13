package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Day {
    @SerializedName("Timestamp")
    @Expose
    String timestamp;

    @SerializedName("Valute")
    @Expose
    Holder holder;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public class Holder {
        @SerializedName("USD")
                @Expose
        Currency usdCurrency;

        @SerializedName("EUR")
        @Expose
        Currency eurCurrency;

        public Currency getUsdCurrency() {
            return usdCurrency;
        }

        public void setUsdCurrency(Currency usdCurrency) {
            this.usdCurrency = usdCurrency;
        }

        public Currency getEurCurrency() {
            return eurCurrency;
        }

        public void setEurCurrency(Currency eurCurrency) {
            this.eurCurrency = eurCurrency;
        }
    }
}
