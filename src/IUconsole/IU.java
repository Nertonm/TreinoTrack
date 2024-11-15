package treinotrack.IUconsole;

import treinotrack.facades.UserFacade;
import treinotrack.models.User;
import treinotrack.service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IU {
    private final UserFacade userFacade;
    private final Scanner scanner;

    public IU(){
        UserService userService = new UserService();
        this.userFacade = new UserFacade(userService);
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        int option;
        do{
            displayMenu();
            option = getValidInt("Escolha uma opção:(1-5)");
            switch (option){
                case 1 -> {
                    System.out.println("Digite o nome:");
                    String name = scanner.nextLine();
                    while (name.isEmpty()) {
                        System.out.println("Nome não pode ser vazio. Digite o nome:");
                        name = scanner.nextLine();
                    }

                    byte age = getValidByte(scanner, "Digite a idade(anos):");
                    while (age < 0 || age > 120) {
                        System.out.println("Idade inválida. Por favor, insira uma idade entre 0 e 120.");
                        age = getValidByte(scanner, "Digite a idade(anos):");
                    }

                    float height = getValidFloat(scanner, "Digite a altura(metros):");
                    while (height < 0.5 || height > 2.5) {
                        System.out.println("Altura inválida. Por favor, insira uma altura entre 0,5 e 2,5 metros.");
                        height = getValidFloat(scanner, "Digite a altura(metros):");
                    }

                    float weight = getValidFloat(scanner, "Digite o peso(kilos):");
                    while (weight < 2 || weight > 300) {
                        System.out.println("Peso inválido. Por favor, insira um peso entre 2 e 300 quilos.");
                        weight = getValidFloat(scanner, "Digite o peso(kilos):");
                    }

                    System.out.println("Digite o sexo:");
                    String sex = getSex(scanner);
                    userFacade.createUser(name, age, height, weight, sex);
                }
                case 2 -> userFacade.readUsers();
                case 3 -> {
                    int i = getValidInt("Digite o índice do usuário:");
                    if (i >= 0 && i < userFacade.getUsers().size()) {
                        while (true) {
                            System.out.println("Selecione o campo que deseja alterar:");
                            System.out.println("1. Nome");
                            System.out.println("2. Idade");
                            System.out.println("3. Altura");
                            System.out.println("4. Peso");
                            System.out.println("5. Sexo");
                            System.out.println("6. Sair");
                            int choice = getValidInt("Digite sua escolha:");
                            User user = userFacade.readUserByIndex(i);
                            String newName = user.getName();
                            byte newAge = user.getAge();
                            float newHeight = user.getHeight();
                            float newWeight = user.getWeight();
                            String newSex = user.getSex();
                            switch (choice) {
                                case 1 -> {
                                    System.out.println("Digite o novo nome:");
                                    scanner.nextLine();
                                    newName = scanner.nextLine();
                                }
                                case 2 -> {
                                    System.out.println("Digite a nova idade:");
                                    scanner.nextLine();
                                    String ageInput = scanner.nextLine();
                                    if (!ageInput.isEmpty()) {
                                        try {
                                            byte tempAge = Byte.parseByte(ageInput);
                                            if (tempAge >= 0 && tempAge <= 120) {
                                                newAge = tempAge;
                                            } else {
                                                System.out.println("Idade inválida. Por favor, insira uma idade entre 0 e 120.");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Entrada inválida. Mantendo idade atual.");
                                        }
                                    }
                                }
                                case 3 -> {
                                    float tempHeight = getValidFloat(scanner, "Digite a nova altura:");
                                    if (tempHeight >= 0.5 && tempHeight <= 2.5) {
                                        newHeight = tempHeight;
                                    } else {
                                        System.out.println("Altura inválida. Por favor, insira uma altura entre 0.5 e 2.5 metros.");
                                    }
                                }
                                case 4 -> {
                                    float tempWeight = getValidFloat(scanner, "Digite o novo peso:");
                                    if (tempWeight >= 2 && tempWeight <= 300) {
                                        newWeight = tempWeight;
                                    } else {
                                        System.out.println("Peso inválido. Por favor, insira um peso entre 2 e 300 quilos.");
                                    }
                                }
                                case 5 -> {
                                    System.out.println("Digite o novo sexo:");
                                    scanner.nextLine();
                                    newSex = getSex(scanner);
                                }
                                case 6 -> {
                                    userFacade.updateUser(i, newName, newAge, newHeight, newWeight, newSex);
                                    System.out.println("Usuário atualizado com sucesso!");
                                    return;
                                }
                                default -> System.out.println("Escolha inválida. Tente novamente.");
                            }
                        }
                    } else {
                        System.out.println("Índice inválido!");
                    }
                }
                case 4 -> {
                    int index = getValidInt("Digite o índice do usuário:");
                    userFacade.deleteUser(index);
                }
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
        }
        while(option != 5);

        userFacade.saveUsers();
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

    private byte getValidByte(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return scanner.nextByte();
            } catch (InputMismatchException error) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next();
            }
        }
    }

    private float getValidFloat(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return scanner.nextFloat();
            } catch (InputMismatchException error) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next();
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
}