package br.com.treinotrack.models;
import br.com.treinotrack.service.Util;
import java.util.ArrayList;

public class Admin {
    ArrayList<User> users = new ArrayList<User>();
    
    public Admin() {
    }

    public void CreateNewUser(){
        System.out.println("Digite o nome:");
        String name = Util.getString();
        System.out.println("Digte a idade:");
        byte age =  Util.getByte();
        System.out.println("Digite a altura:");
        float height = Util.getFloat();
        System.out.println("Digite o peso:");
        float weight = Util.getFloat();
        System.out.println("Digite o sexo:");
        String sex = Util.getSex();
        User newUser = new User(name, age, height, weight, sex);
        users.add(newUser);
    }
    
    //For Debugging
    public void CreateNewBob() {
    	User bob = new User();
    	users.add(bob);
    }
    
    public void ReadUserList(){
        if (users == null){
            System.out.println("Não há usuarios");
            return;
        }
        System.out.println("Lista de Usuarios: ");
        for (User user: users){
        	/* User user =  users.get(i);*/
            System.out.println("Nome:"+ user.getName()
            		+ "\n Idade:"+user.getAge()
            		+"\n Altura:" +user.getHeight()
            		+"\n Peso:"+ user.getWeight()
            		+"\nIMC:"+user.getImc());
        }
    }

    public void UpdateUser(){
        System.out.println("Digite o índice do usuario:");
        int i = Util.getInt();
        if ( i >= 0 && i < users.size()){
            User user = users.get(i);
            System.out.println("Atualizando informações para: " + user.getName());
            System.out.println("Digite o novo nome (pressione Enter para manter o atual):");
            String newName = Util.getString(); 
            if (!newName.isEmpty()) 
                user.setName(newName); // Atualiza o nome se não estiver vazio
            System.out.println("Digite a nova idade (pressione Enter para manter o atual):");
            String ageInput = Util.getString();
            if (!ageInput.isEmpty()) {
                byte newAge = Byte.parseByte(ageInput); // Converte para byte
                user.setAge(newAge); // Atualiza a idade
            }
            System.out.println("Digite a nova altura(pressione Enter para manter o atual):");
            float heigthInpult = Util.getFloat();
            user.setHeight(heigthInpult);
            System.out.println("Digite  novo peso(pressione Enter para manter o atual):");
            float weigthInput = Util.getFloat();
            user.setWeight(weigthInput);
            System.out.println("Usuário atualizado com sucesso!");
            System.out.println("Digite o novo sexo(pressione Enter para manter o atual):");
            String sexInput = Util.getSex();
            user.setSex(sexInput);
            System.out.println("Usuário atualizado com sucesso!");
        } 
        else 
            System.out.println("Índice inválido!"); // Mensagem de erro
    }

    public void DeleteUser(){
        if(users.isEmpty()){
            System.out.println("Não há usuarios a serem deletados");
            return;
        }
        System.out.println("Dgite o indice do usuario a ser deletado:");
        int index = Util.getInt();
        Util.getString();
        if(index >= 0 && index< users.size()){
            users.remove(index);
            System.out.println("Usuario removido.");
        }
        else
            System.out.println("Indice invalido!");
    }
}





