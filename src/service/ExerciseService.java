// ExerciseService.java
package treinotrack.service;

import treinotrack.data.models.exercises.*;
import treinotrack.data.ExerciseRepository;

import java.util.List;

public class ExerciseService {
    private ExerciseRepository exerciseRepository;

    public ExerciseService() {
        this.exerciseRepository = new ExerciseRepository();
    }

    public void addExercise(ExerciseAbstract exercise) {
        exerciseRepository.addExercise(exercise);
    }

    public void removeExercise(ExerciseAbstract exercise) {
        exerciseRepository.removeExercise(exercise);
    }

    public List<ExerciseAbstract> getExercises() {
        return exerciseRepository.getExercises();
    }

    public ExerciseAbstract getExerciseByIndex(int index) {
        List<ExerciseAbstract> exercises = exerciseRepository.getExercises();
        if (index >= 0 && index < exercises.size()) {
            return exercises.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid exercise index");
        }
    }
    public void newTreadmil(String name, String description, double duration, double speed) {
        Treadmil treadmill = new Treadmil(duration, speed, name, description);
        addExercise(treadmill);
    }

    public void newStrength(String name, String description, int sets, int reps, float weight) {
        Strength weightLifting = new Strength(sets, reps, weight, name, description);
        addExercise(weightLifting);
    }

    public void newHike(String name, String description, double duration) {
        Hike hike = new Hike(duration, name, description);
        addExercise(hike);
    }

    public void newRace(String name, String description, double duration) {
        Race race = new Race(duration, name, description);
        addExercise(race);
    }
}