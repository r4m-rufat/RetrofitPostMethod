package com.codingwithrufat.retrofitpostmethod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.codingwithrufat.retrofitpostmethod.api.ApiClient;
import com.codingwithrufat.retrofitpostmethod.api.IApi;
import com.codingwithrufat.retrofitpostmethod.models.ResponseItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txt_reponse);

        IApi iApi = ApiClient.getClient().create(IApi.class);
        Call<ResponseItem> responseItem = iApi.createPost(123456, "Android Studio", "Android Studio is the best tool.");

        responseItem.enqueue(new Callback<ResponseItem>() {
            @Override
            public void onResponse(Call<ResponseItem> call, Response<ResponseItem> response) {
                if (response.isSuccessful()){
                    ResponseItem apiResponse = response.body();
                    String api_text = "";
                    api_text += "Code: " + response.code() + "\n";
                    api_text += "ID: " + apiResponse.getId() + "\n";
                    api_text += "User Id: " + apiResponse.getUserId() + "\n";
                    api_text += "Title: " + apiResponse.getTitle() + "\n";
                    api_text += "Body: " + apiResponse.getBody() + "\n";

                    textView.setText(api_text);
                }
            }

            @Override
            public void onFailure(Call<ResponseItem> call, Throwable t) {

            }
        });
    }
}