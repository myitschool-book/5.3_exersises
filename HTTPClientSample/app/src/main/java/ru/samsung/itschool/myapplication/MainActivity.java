package ru.samsung.itschool.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText lastname,firstname,message;
    Button send;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lastname=findViewById(R.id.lastname);
        firstname=findViewById(R.id.firstname);
        message=findViewById(R.id.message);
        result=findViewById(R.id.result);
        send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAsyncTask task=new MyAsyncTask();
                task.execute();
            }
        });
    }

    class MyAsyncTask extends AsyncTask{
        String rez="";

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpGet httppost = new HttpGet("http://192.168.49.103:8080/test?firstname="+firstname.getText().toString()+
                        "&lastname="+ lastname.getText().toString()+
                        "&message="+ message.getText().toString());
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                rez += EntityUtils.toString(entity);
            }catch (Exception ex){
                Log.d("HTTP Client", "что то пошло не так");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {

            result.setText(rez);
        }
    }
}
