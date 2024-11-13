package br.com.treinotrack.models;

import br.com.treinotrack.models.exercises.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public class Workout implements Serializable {
    private String name;
    private int duration; // minutos
    private int caloriesBurned;
    private String type;
    private LocalDate data;
    private List<Exercise>  workout;

    //Builder
    public Workout(LocalDate data, List<Exercise> workout, String name,int duration,int caloriesBurned, String type){
        this.data = data;
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.type = type;
        this.workout = workout;
    }

    public LocalDate getData() {return data;}
    public void setData(LocalDate data) {this.data = data;}

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getDuration(){
        return duration;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
    public int getCaloriesBurned(){
        return caloriesBurned;
    }
    public void setCaloriesBurned(int caloriesBurned){
        this.caloriesBurned = caloriesBurned;
    }
    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public List<Exercise> getWorkout() {return workout;}
    public void setWorkout(List<Exercise> workout) {this.workout = workout;}

}

