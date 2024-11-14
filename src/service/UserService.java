package treinotrack.service;

import treinotrack.data.UserRepository;
import treinotrack.models.User;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserService {
    private UserRepository userRepository;
    private Scanner scanner;
    
    public UserService() {
        this.userRepository = new UserRepository();
        this.scanner = new Scanner(System.in);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public void CreateNewUser() {
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

        User newUser = new User(name, age, height, weight, sex);
        userRepository.addUser(newUser);
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

    public void ReadUserList() {
        if (userRepository.getUsers().isEmpty()) {
            System.out.println("Não há usuários.");
            return;
        }
        System.out.println("Lista de Usuários:");
        for (int i = 0; i < userRepository.getUsers().size(); i++) {
            User user = userRepository.getUsers().get(i);
            System.out.println("\nÍndice: " + i
                + "\nNome: " + user.getName()
                + "\nIdade: " + user.getAge()
                + "\nAltura: " + user.getHeight()
                + "\nPeso: " + user.getWeight()
                + "\nIMC: " + user.getImc()
                );
        }
    }

    public void UpdateUser() {
        int i = getValidInt(scanner, "Digite o índice do usuário:");
        if (i >= 0 && i < userRepository.getUsers().size()) {
            User user = userRepository.getUsers().get(i);
            System.out.println("Atualizando informações para: " + user.getName());

            while (true) {
                System.out.println("Selecione o campo que deseja alterar:");
                System.out.println("1. Nome");
                System.out.println("2. Idade");
                System.out.println("3. Altura");
                System.out.println("4. Peso");
                System.out.println("5. Sexo");
                System.out.println("6. Sair");

                int choice = getValidInt(scanner, "Digite sua escolha:");

                switch (choice) {
                    case 1:
                        System.out.println("Digite o novo nome:");
                        scanner.nextLine();
                        String newName = scanner.nextLine();
                        if (!newName.isEmpty()) {
                            user.setName(newName);
                        }
                        break;
                    case 2:
                        System.out.println("Digite a nova idade:");
                        scanner.nextLine();
                        String ageInput = scanner.nextLine();
                        if (!ageInput.isEmpty()) {
                            try {
                                byte newAge = Byte.parseByte(ageInput);
                                if (newAge >= 0 && newAge <= 120) {
                                    user.setAge(newAge);
                                } else {
                                    System.out.println("Idade inválida. Por favor, insira uma idade entre 0 e 120.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida. Mantendo idade atual.");
                            }
                        }
                        break;
                    case 3:
                        float newHeight = getValidFloat(scanner, "Digite a nova altura:");
                        if (newHeight >= 0.5 && newHeight <= 2.5) {
                            user.setHeight(newHeight);
                        } else {
                            System.out.println("Altura inválida. Por favor, insira uma altura entre 0.5 e 2.5 metros.");
                        }
                        break;
                    case 4:
                        float newWeight = getValidFloat(scanner, "Digite o novo peso:");
                        if (newWeight >= 2 && newWeight <= 300) {
                            user.setWeight(newWeight);
                        } else {
                            System.out.println("Peso inválido. Por favor, insira um peso entre 2 e 300 quilos.");
                        }
                        break;
                    case 5:
                        System.out.println("Digite o novo sexo:");
                        scanner.nextLine();
                        user.setSex(getSex(scanner));
                        break;
                    case 6:
                        userRepository.updateUser(i, user);
                        System.out.println("Usuário atualizado com sucesso!");
                        return;
                    default:
                        System.out.println("Escolha inválida. Tente novamente.");
                }
            }
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void DeleteUser() {
        if (userRepository.getUsers().isEmpty()) {
            System.out.println("Não há usuários a serem deletados.");
            return;
        }
        int index = getValidInt(scanner, "Digite o índice do usuário a ser deletado:");
        if (index >= 0 && index < userRepository.getUsers().size()) {
            userRepository.getUsers().remove(index);
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void saveUsers() {
        userRepository.saveUsers();
    }

    private int getValidInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException error) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next();
            }
        }
    }

}
