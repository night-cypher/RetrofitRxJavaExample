package com.questdot.retrofitrxjavaexample;

import retrofit2.Response;
import retrofit2.http.POST;
import rx.Observable;

public interface DoorServices {



    @POST("v2/57e55317110000e02481b1bf")
    Observable<Response<DoorResponse>> postRawJson();

}
