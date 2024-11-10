package treinotrack.data.exercises;

public abstract class Exercise {
    //Attributes
    private int id;
    private String name;
    
    //Getters and Setters
    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Exercise{id=" + id + ", name='" + name + "'}";
    }
}




