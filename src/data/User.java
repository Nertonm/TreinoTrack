package treinotrack.data;

public class User {
    private String name; //nome
    private byte age; // idade em anos
    private float height; // altura em metros
    private float weight; // peso em kg
    private String sex;
    private float imc; // imc

	// Builder
	public User(String name, byte age, float height, float weight, String sex){
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.sex = sex;
		calculateIMC();
	}
	// Dummy User
	public User(){
		this.name = "Bob";
		this.age = 18;
		this.height = 1.70f;
		this.weight = 65.00f;
		this.sex = "male";
		calculateIMC();
	}

	// Getters and Setters
	public float getImc() {return imc;} //
	public void calculateIMC() {this.imc = this.weight / (this.height * this.height);}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public byte getAge() {return age;}
	public void setAge(byte age) {this.age = age;}

	public float getHeight() {return height;}

	public void setHeight(float height) {
		this.height = height;
		calculateIMC(); 	// Calcula novamente o IMC após a mudança de altura
	}

	public float getWeight() {return weight;}
	public void setWeight(float weight) {
		this.weight = weight;
		calculateIMC();		// Calcula novamente o IMC após a mudança de peso
	}
	public void setSex(String sex) {this.sex = sex;}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				", height=" + height +
				", weight=" + weight +
				", sex='" + sex + '\'' +
				", imc=" + imc +
				'}';
	}
}

