package br.com.treinotrack.models;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin {
    ArrayList<User> users = new ArrayList<User>();
    
    public Admin() {}

    public void CreateNewUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome:");
        String name = scanner.nextLine();
        byte age = getValidByte(scanner, "Digite a idade:");        
        float height = getValidFloat(scanner, "Digite a altura:");        
        float weight = getValidFloat(scanner, "Digite o peso:");
        System.out.println("Digite o sexo:");
        String sex = getSex(scanner);
        User newUser = new User(name, age, height, weight, sex);
        users.add(newUser);
    }
<<<<<<< HEAD

    private byte getValidByte(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return scanner.nextByte();
            } catch (InputMismatchException error) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpa o scanner
            }
=======
    
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
>>>>>>> 9714d5385af0ba60abdaf1db7481229149ab7585
        }
    }

    private float getValidFloat(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return scanner.nextFloat();
            } catch (InputMismatchException error) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpa o scanner
            }
        }
    }

    private String getSex(Scanner scanner) {
        while (true) {
            String sex = scanner.next();
            if (sex.equalsIgnoreCase("masculino") || sex.equalsIgnoreCase("feminino")) {
                return sex;
            } else {
                System.out.println("Entrada inválida. Digite 'masculino' ou 'feminino'.");
            }
        }
    }

    public void CreateNewBob() {
        User bob = new User();
        users.add(bob);
    }

    public void ReadUserList() {
        if (users.isEmpty()) {
            System.out.println("Não há usuários.");
            return;
        }
        System.out.println("Lista de Usuários:");
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println("Índice: " + i 
                + "\nNome: " + user.getName()
                + "\nIdade: " + user.getAge()
                + "\nAltura: " + user.getHeight()
                + "\nPeso: " + user.getWeight()
                + "\nIMC: " + user.getImc());
        }
    }

    public void UpdateUser() {
        Scanner scanner = new Scanner(System.in);
        int i = getValidInt(scanner, "Digite o índice do usuário:");
        if (i >= 0 && i < users.size()) {
            User user = users.get(i);
            System.out.println("Atualizando informações para: " + user.getName());
            System.out.println("Digite o novo nome (pressione Enter para manter o atual):");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) 
                user.setName(newName);
            System.out.println("Digite a nova idade (pressione Enter para manter o atual):");
            String ageInput = scanner.nextLine();
            if (!ageInput.isEmpty()) {
                try {
                    byte newAge = Byte.parseByte(ageInput);
                    user.setAge(newAge);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Mantendo idade atual.");
                }
            }
            user.setHeight(getValidFloat(scanner, "Digite a nova altura (pressione Enter para manter o atual):"));
            user.setWeight(getValidFloat(scanner, "Digite o novo peso (pressione Enter para manter o atual):"));
            System.out.println("Digite o novo sexo (pressione Enter para manter o atual):");
            user.setSex(getSex(scanner));
            System.out.println("Usuário atualizado com sucesso!");
        } else {
            System.out.println("Índice inválido!"); 
        }
    }

    public void DeleteUser() {
        Scanner scanner = new Scanner(System.in);
        if (users.isEmpty()) {
            System.out.println("Não há usuários a serem deletados.");
            return;
        }
        int index = getValidInt(scanner, "Digite o índice do usuário a ser deletado:");
        if (index >= 0 && index < users.size()) {
            users.remove(index);
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    private int getValidInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException error) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpa o scanner
            }
        }
    }
}
