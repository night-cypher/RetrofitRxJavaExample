package com.questdot.retrofitrxjavaexample;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 3/12/2016.
 */

public class RetrofitManager {

    private DoorServices doorServices;

    public DoorServices getDoorService() {
        if (doorServices == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.mocky.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            doorServices = retrofit.create(DoorServices.class);
        }
        return doorServices;
    }
}
