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
    private TextView txtID;
    private TextView txtName;
    private TextView txtPrice;
    private TextView txtTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtID = (TextView) findViewById(R.id.txtID);
        txtName = (TextView) findViewById(R.id.txtName);
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        txtTag = (TextView) findViewById(R.id.txtTag);

        retrofitManager = new RetrofitManager();


        getDoor();
    }

    private void getDoor(){

        Subscription subscription = retrofitManager.getDoorService().postRawJson()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<DoorResponse>>() {


                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable t) {

                        }

                    @Override
                    public void onNext(Response<DoorResponse> doorResponseResponse) {


                        txtID.setText(doorResponseResponse.body().getId().toString());
                        txtName.setText(doorResponseResponse.body().getName().toString());
                        txtPrice.setText(doorResponseResponse.body().getPrice().toString());

                        txtTag.setText(doorResponseResponse.body().getTags().get(0).toString()+ doorResponseResponse.body().getTags().get(1).toString());

                    }



                });
    }
}
