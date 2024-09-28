package br.com.treinotrack.models.exercises;
public class Cardio extends Exercise;

public class Cardio extends Exercise {
	public class Treadmill{ //Esteira
		public void performExercise() {
	        System.out.println("Running for " + getDuration() + " minutes, burning " + getCaloriesBurned() + " calories.");
	    }		
	}

	@Override
	public void performExercise() {
		// TODO Auto-generated method stub
		
	}
}
public class Hike extends Exercise { //Caminhada

}

public class Race extends Exercise { //Caminhada

}