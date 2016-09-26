package com.asovel.bibicleta.Comunicacion_base_datos.Backendlesscumple;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by emilio on 17/09/2016.
 */


public interface BicisService {

    @Headers({"application-id: APP_ID",
            "secret-key: REST_SECRET_KEY",
            "Content-Type: application/json"})
    @GET("/{version}/data/{table-name}")
    Call<BackendlessResponse> getBicis(@Path("version") String version, @Path("table-name") String table);
}
