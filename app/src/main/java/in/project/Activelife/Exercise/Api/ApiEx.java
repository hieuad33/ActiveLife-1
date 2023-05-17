package in.project.Activelife.Exercise.Api;

import com.example.testapidemo.model.Exercise;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiEx {
    String BASE_URL = "https://musclewiki.p.rapidapi.com/";
    @Headers({"X-RapidAPI-Host: musclewiki.p.rapidapi.com",
            "X-RapidAPI-Key: 65f611b658msh772ba27afe3e92dp1b7647jsn4ba3e89240df",
            "content-type: application/octet-stream"})
    @GET("exercises")
    Call<List<Exercise>> getsuperHeroes();




}
