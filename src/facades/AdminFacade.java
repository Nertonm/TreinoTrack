package treinotrack.facades;
import treinotrack.models.Admin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminFacade {
    private Admin admin;
    private Scanner scanner;

    public AdminFacade(){
        this.admin = new Admin();
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        int option;

        do{
            displayMenu();
            option = getValidInt("Escolha uma opção:(1-5)");
            switch (option){
                case 1 -> admin.CreateNewUser();
                case 2 -> admin.ReadUserList();
                case 3 -> admin.UpdateUser();
                case 4 -> admin.DeleteUser();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção invalida");
            }
        }
        while(option!=5);

        admin.saveUsers();
    }

    private void displayMenu(){
        System.out.println("\n--- Menu de Gerenciamento de Usuários ---");
        System.out.println("1. Criar Novo Usuário");
        System.out.println("2. Ler Lista de Usuários");
        System.out.println("3. Atualizar Usuário");
        System.out.println("4. Deletar Usuário");
        System.out.println("5. Sair");
    }

    private int getValidInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException error) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpa o scanner
            }
        }
    }

    public void close(){
        scanner.close();
    }
}
