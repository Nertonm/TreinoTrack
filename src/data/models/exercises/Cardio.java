package treinotrack.data.models.exercises;

public abstract class Cardio extends ExerciseAbstract {
    double duration;
	//protected double getWeight() {return this.getUser().getWeight();}
	public abstract double getMET();
	public double getDuration() {return this.duration;}
	public void setDuration(double duration) {this.duration = duration;}
   // public double getCaloriesBurned() {return getMET() * getWeight() * getDuration() / 60;}

}


	
