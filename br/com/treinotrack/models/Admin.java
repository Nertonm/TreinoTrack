package br.com.treinotrack.models;
import br.com.treinotrack.service.Util;
import java.util.ArrayList;

public class Admin {
    ArrayList<User> user = new ArrayList<User>();
    public Admin(ArrayList<User>user) {this.user = user;}

    public void CreateNewUser(){
        System.out.println("Digite o nome do Usuario:");
        String name = Util.getString();
        System.out.println("Digte a idade do Usuario:");
        byte age =  Util.getByte();
        System.out.println("Digite a altura do Usuario:");
        float height = Util.getFloat();
        System.out.println("Digite o peso do Usuario:");
        float weight = Util.getFloat();

        User newUser = new User(name, age, height, weight);
        user.add(newUser);
    }

    public void ReadUserList(){
        /*
        if(user==null){
            System.out.println("Não há usuarios cadastrados");
            return;
        }
        System.out.println("Lista de Usuarios:");
        for(int i = 0; i< user.size();i++){
            User user = User.get(i);
            System.out.println("Indice:"+ i + "\n Nome:"+ user.getName()+ "\n Idade:"+user.getAge()+"\n Altura:" +user.getHeight()+"\n Peso:"+ user.getWeight()+"\nIMC:"+user.getImc());
        }
        */
    }

    public void UpdateUser(){
        System.out.println("Digite o índice do usuario:");
        int i = Util.getInt();
        Util.getString();

        if(i>=0 && i< user.size()){
            User user = user.get(i);
            System.out.println("Atualizando informações para: " + user.getName());
            System.out.println("Digite o novo nome (pressione Enter para manter o atual):");
            String newName = Util.getString(); // Lê o novo nome

            if (!newName.isEmpty()) {
                user.setName(newName); // Atualiza o nome se não estiver vazio
            }

            System.out.println("Digite a nova idade (pressione Enter para manter o atual):");
            String ageInput = Util.getString();
            if (!ageInput.isEmpty()) {
                byte newAge = Byte.parseByte(ageInput); // Converte para byte
                user.setAge(newAge); // Atualiza a idade
            }

            System.out.println("Digite a nova altura(pressione Enter para manter o atual):");
            float HeigthInpult = Util.getFloat();
            user.setHeight(HeigthInpult);


            System.out.println("Digite  novo peso(pressione Enter para manter o atual):");
            float WeigthInput = Util.getFloat();
            user.setWeight(WeigthInput);

            System.out.println("Usuário atualizado com sucesso!");
        } else {
            System.out.println("Índice inválido!"); // Mensagem de erro
        }
    }

    public void DeleteUser(){
        if(user.isEmpty()){
            System.out.println("Não há usuarios a serem deletados");
            return;
        }
        System.out.println("Dgite o indice do usuario a ser deletado:");
        int i = Util.getInt();
        Util.getString();

        if(i>=0 && i< user.size()){
            user.remove(i);
            System.out.println("Usuario removido.");
        }
        else{
            System.out.println("Indice invalido!");
        }
    }
}





