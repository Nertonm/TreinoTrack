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

    public void UpdateUser(){
        System.out.println("Digite o índice do usuario:");
        int i = scan.nextInt();
        scan.nextLine();

        if(i>=0 && i< users.size()){
            User user = users.get(i);
            System.out.println("Atualizando informações para: " + user.getName());
            System.out.println("Digite o novo nome (pressione Enter para manter o atual):");
            String newName = scan.nextLine(); // Lê o novo nome

            if (!newName.isEmpty()) {
                user.setName(newName); // Atualiza o nome se não estiver vazio
            }

            System.out.println("Digite a nova idade (pressione Enter para manter o atual):");
            String ageInput = scan.nextLine();
            if (!ageInput.isEmpty()) {
                byte newAge = Byte.parseByte(ageInput); // Converte para byte
                user.setAge(newAge); // Atualiza a idade
            }

            System.out.println("Digite a nova altura(pressione Enter para manter o atual):");
            float HeigthInpult = scan.nextFloat();
            user.setHeight(HeigthInpult);


            System.out.println("Digite  novo peso(pressione Enter para manter o atual):");
            float WeigthInput = scan.nextFloat();
            user.setWeight(WeigthInput);

            System.out.println("Usuário atualizado com sucesso!");
        } else {
            System.out.println("Índice inválido!"); // Mensagem de erro
        }
    }

}





