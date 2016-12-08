package com.questdot.retrofitrxjavaexample;

import retrofit2.Response;
import retrofit2.http.POST;
import rx.Observable;

public interface ProfileServices {



    @POST("v2/584900841100004312590b79")
    Observable<Response<ProfileResponse>> postRawJson();

}
