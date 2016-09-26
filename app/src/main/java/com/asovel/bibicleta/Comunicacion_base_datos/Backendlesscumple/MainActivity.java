package com.asovel.bibicleta.Comunicacion_base_datos.Backendlesscumple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.asovel.bibicleta.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BicisAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        recyclerView = (RecyclerView) findViewById(R.id.amigos_recycler_view);

        adapter = new BicisAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.backendless.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final BicisService service = retrofit.create(BicisService.class);
















        Call<BackendlessResponse> call = service.getBicis("v1", "Bicis");
        Callback callbackRetrofit = new Callback<BackendlessResponse>() {
            @Override
            public void onResponse(Call<BackendlessResponse> call, Response<BackendlessResponse> response) {
                Log.d("eee","response");
                for(Bicis a : response.body().getData()) Log.d("ee",a.getNombre());
                adapter.addAll(response.body().getData());
            }

            @Override
            public void onFailure(Call<BackendlessResponse> call, Throwable t) {
                Log.d("eee","failue"+t.getMessage());
            }
        };
        call.enqueue(callbackRetrofit);
    }
}
