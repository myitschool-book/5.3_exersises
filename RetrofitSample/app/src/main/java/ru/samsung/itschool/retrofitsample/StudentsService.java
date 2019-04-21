package ru.samsung.itschool.retrofitsample;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by teacher-samsung on 20.04.2019.
 */
public interface StudentsService {
    @GET("/names/players/list")
    public Call<ArrayList<Student>> getStudents();
    @POST("/names/players/add")
    public Call<Student> putStudent(@Body Student student);
}
