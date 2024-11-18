package treinotrack.data.models.exercises;

public abstract class Cardio extends ExerciseAbstract {
    double duration;
	public abstract double getMET();
	public double getDuration() {return this.duration;}
	public void setDuration(double duration) {this.duration = duration;}
   	public float getCaloriesBurned(float weight) {return (float) (getMET() * weight * (float) (getDuration() / 60));}
}


	

