package com.rajendra.firebasemessgingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.iid.FirebaseInstanceId;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {
    EditText nameET;
    Button
    buttonSend;
    private String Tag="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET = (EditText)findViewById(R.id.nameET);
        buttonSend = (Button)findViewById(R.id.sendButton);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             sendToServer(nameET.getText().toString());
            }
        });
    }

    private void sendToServer(String name) {
       String userid = FirebaseInstanceId.getInstance().getToken();
        Ion.with(this).load("http://akshaymandloi.com/insert_db.php").setBodyParameter("userid",userid).setBodyParameter("name",name).asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
           if(e!=null)
           {
               Log.e(Tag,"Exception :"+e);
               return;
           }

             Log.d(Tag, "Result "+result);


            }
        });
    }
}
