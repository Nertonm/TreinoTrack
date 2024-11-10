package treinotrack.dados.exercises;


public abstract class Strength extends Exercise{
    private final int series;
    private final int repetiçoes;

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
