package com.questdot.retrofitrxjavaexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import retrofit2.Response;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    RetrofitManager retrofitManager;
    private TextView txtName;
    private TextView txtStatus;
    private TextView txtTalent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (TextView) findViewById(R.id.txtName);
        txtStatus = (TextView) findViewById(R.id.txtStatus);
        txtTalent = (TextView) findViewById(R.id.txtTalent);

        retrofitManager = new RetrofitManager();


        getProfile();
    }

    private void getProfile(){

        Subscription subscription = retrofitManager.getDoorService().postRawJson()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ProfileResponse>>() {


                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable t) {

                        }

                    @Override
                    public void onNext(Response<ProfileResponse> profileResponseResponse) {


                        txtName.setText(profileResponseResponse.body().getName().toString());

                        txtStatus.setText(profileResponseResponse.body().getStatus().toString());
                        txtTalent.setText(profileResponseResponse.body().getTalent().toString());



                    }



                });
    }
}
