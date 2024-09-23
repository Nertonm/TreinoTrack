package br.com.treinotrack;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    ArrayList<User> users = new ArrayList<User>();
    Scanner scan = new Scanner(System.in);
    public Admin(ArrayList<User>users){
        this.users = users;
    }
    public void CreatNewUser(){
        System.out.println("Digite o nome do novo user:");
        String userName = scan.nextLine();
        User c1 = new User();
        c1.setName(userName);

        System.out.println("Digte a idade do novo user:");
        byte id = scan.nextByte();
        scan.nextLine();
        c1.setAge(id);

        System.out.println("Digite a altura do novo user:");
        float altura = scan.nextFloat();
        scan.nextLine();
        c1.setHeight(altura);

        System.out.println("Digite o peso do novo user:");
        float peso = scan.nextFloat();
        scan.nextLine();
        c1.setWeight(peso);
        c1.getIMC();
        users.add(c1);

    }

    public void ReadUserList(){
        if(users==null){
            System.out.println("Não há usuarios cadastrados");
            return;
        }
        System.out.println("Lista de Usuarios:");
        for(int i = 0; i< users.size();i++){
            User user = users.get(i);
            System.out.println("Indice:"+ i + "\n Nome:"+ user.getName()+ "\n Idade:"+user.getAge()+"\n Altura:" +user.getHeight()+"\n Peso:"+ user.getWeight()+"\nIMC:"+user.getImc());
        }
    }

    public void UpdateUser{
    }




}
