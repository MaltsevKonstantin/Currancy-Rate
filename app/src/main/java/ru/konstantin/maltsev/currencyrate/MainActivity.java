package ru.konstantin.maltsev.currencyrate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import java.net.ContentHandler;
import java.util.List;
import java.util.Locale;

import models.Currency;
import models.Day;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.konstantin.maltsev.currencyrate.databinding.ActivityMainBinding;
import services.CbrService;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String title = getString(R.string.app_name) + " " + getString(R.string.app_version);
        if (getSupportActionBar() != null) getSupportActionBar().setTitle(title);

        CbrService.getInstance().getApi().getDay().enqueue(new Callback<Day>() {
            @Override
            public void onResponse(@NonNull Call<Day> call, @NonNull Response<Day> response) {
                if (response.isSuccessful()) {
                    showSuccessful();
                    assert response.body() != null;

                    binding.dateUpdate.setText(response.body().getTimestamp());

                    Currency usdCurrency = response.body().getHolder().getUsdCurrency();
                    String message = String.format(Locale.getDefault(), "%.2f", usdCurrency.getValue());

                    float deference = usdCurrency.getValue() - usdCurrency.getPrevious();
                    if (deference > 0) {
                        message += " (+";
                    } else {
                        message += " (";
                    }
                    message += String.format(Locale.getDefault(), "%.2f", deference) + ")";
                    binding.usd.setText(message);

                    Currency eusCurrency = response.body().getHolder().getEurCurrency();
                    message = String.format(Locale.getDefault(), "%.2f", eusCurrency.getValue());

                    deference = eusCurrency.getValue() - eusCurrency.getPrevious();
                    if (deference > 0) {
                        message += " (+";
                    } else {
                        message += " (";
                    }
                    message += String.format(Locale.getDefault(), "%.2f", deference) + ")";
                    binding.eu.setText(message);
                } else {
                    showError();
                    binding.usd.setText("");
                    binding.eu.setText("");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Day> call, @NonNull Throwable t) {
                showError();
                binding.usd.setText("");
                binding.eu.setText("");
            }
        });
    }

    private void showError() {
        Snackbar.make(binding.getRoot(), "Ошибка обновления данных", Snackbar.LENGTH_SHORT)
                .setBackgroundTint(getResources().getColor(android.R.color.holo_red_light)).show();
    }

    private void showSuccessful() {
        Snackbar.make(binding.getRoot(), "Данные обновлены", Snackbar.LENGTH_SHORT)
                .setBackgroundTint(getResources().getColor(android.R.color.holo_green_light
                )).show();
    }
}