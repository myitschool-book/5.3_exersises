package ru.samsung.itschool.retrofitsample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    // !!!! Установите свой адрес сервера !!!!
    public static String URL="http://set.you.ip.addr:8080";
    EditText name,age;
    Button get,send;
    TextView list;
    Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        get=findViewById(R.id.get);
        send=findViewById(R.id.send);
        list=findViewById(R.id.list);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=name.getText().toString();
                int a=Integer.valueOf(age.getText().toString());
                student=new Student(n,a);
                new SendAsyncTask().execute();

            }
        });
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetAsyncTask().execute();
            }
        });
    }

    class SendAsyncTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
              Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        StudentsService service = retrofit.create(StudentsService.class);
        Call<Student> call = service.putStudent(student);
        try {
            Response<Student> userResponse = call.execute();
            Student s = userResponse.body();
            Log.d("SEND_AND_RETURN","Student: "+s);
        } catch (IOException e) {
            e.printStackTrace();
        }
            return null;
        }
    }


    class GetAsyncTask extends AsyncTask{
        List<Student> listStudent;

        @Override
        protected Object doInBackground(Object[] objects) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            StudentsService service = retrofit.create(StudentsService.class);
            Call<ArrayList<Student>> call = service.getStudents();
            try {
                Response<ArrayList<Student>> userResponse = call.execute();
                listStudent = userResponse.body();
                Log.d("SEND_AND_RETURN","get list  with lenght "+listStudent.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            String str="";
            if(listStudent==null) return;
            for(Student s:listStudent){
                str+="Студент: "+s+"\n";
            }
            list.setText(str);
        }
    }

}
