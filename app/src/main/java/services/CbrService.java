package services;

import java.util.List;

import models.Currency;
import models.Day;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class CbrService {
    private static final String BASE_URL = "https://www.cbr-xml-daily.ru/";
    static private CbrService service;
    Retrofit retrofit;

    private CbrService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static CbrService getInstance() {
        if (service == null) service = new CbrService();
        return service;
    }

    public interface CbrApi {
        @GET("daily_json.js")
        Call<List<Currency>> getCurrencyList();

        @GET("daily_json.js")
        Call<Day> getDay();
    }

    public CbrApi getApi() {
        return retrofit.create(CbrApi.class);
    }
}
