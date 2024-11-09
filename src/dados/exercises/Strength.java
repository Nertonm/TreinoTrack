package br.com.treinotrack.models.exercises;


public abstract class Strength extends Exercise{
    private int series;
    private int repetiçoes;

    public Strength(String name, int series, int repeticoes){
        this.setName(name);
        this.series = series;
        this.repetiçoes = repeticoes;
    }

    public int getSeries(){
        return series;
    }
    public int getRepetiçoes(){
        return repetiçoes;
    }
    public void performExercise() {
        System.out.println("Performing " + getName() + ": " + series + " sets of " + repetiçoes + " repetitions.");
    }

}
