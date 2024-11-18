package treinotrack.UIconsole;

import treinotrack.facades.ExerciseFacade;
import treinotrack.facades.UserFacade;
import treinotrack.facades.WorkoutFacade;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UIadmin {
    private final UserFacade userFacade;
    private final WorkoutFacade workoutFacade;
    private final ExerciseFacade exerciseFacade;
    private final Scanner scanner;

    public UIadmin(UserFacade userFacade, WorkoutFacade workoutFacade, ExerciseFacade exerciseFacade){
        this.userFacade = userFacade;
        this.workoutFacade = workoutFacade;
        this.exerciseFacade = exerciseFacade;
        this.scanner = new Scanner(System.in);
    }

    private void displayMainMenu() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Gerenciar Usuários");
        System.out.println("2. Gerenciar Treinos");
        System.out.println("3. Gerenciar Exercícios");
        System.out.println("4. Sair");
    }

    private void displayWorkoutMenu() {
        System.out.println("\n--- Menu de Gerenciamento de Treinos ---");
        System.out.println("1. Criar Novo Treino");
        System.out.println("2. Ler Lista de Treinos");
        System.out.println("3. Atualizar Treino");
        System.out.println("4. Deletar Treino");
        System.out.println("5. Atribuir Treino a Usuário");
        System.out.println("6. Desatribuir Treino de Usuário");
        System.out.println("7. Sair");
    }

    private void displayExerciseMenu() {
        System.out.println("\n--- Menu de Gerenciamento de Exercícios ---");
        System.out.println("1. Adicionar Novo Exercício");
        System.out.println("2. Ler Lista de Exercícios");
        System.out.println("3. Remover Exercício");
        System.out.println("4. Associar a um Workout");
        System.out.println("5. Sair");
    }

    private void displayMenu(){
        System.out.println("\n--- Menu de Gerenciamento de Usuários ---");
        System.out.println("1. Criar Novo Usuário");
        System.out.println("2. Ler Lista de Usuários");
        System.out.println("3. Atualizar Usuário");
        System.out.println("4. Deletar Usuário");
        System.out.println("5. Sair");
    }

    public void start() {
        int option;
        do {
            displayMainMenu();
            option = getValidInt("Escolha uma opção:(1-4)");
            switch (option) {
                case 1 -> startUserManager();
                case 2 -> startWorkoutManager();
                case 3 -> startExerciseManager();
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
        } while (option != 4);
    }

    public void startUserManager(){
        int option;
        do{
            displayMenu();
            option = getValidInt("Escolha uma opção:(1-5)");
            switch (option){
                case 1 -> {
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
                case 2 -> {
                    userFacade.readUsers();
                    System.out.println("Lista de Usuários:");
                    for (int i = 0; i < userFacade.getUsers().size(); i++) {
                        System.out.println(userFacade.returnUser(i));
                    }
                }
                case 3 -> {
                    int i = getValidInt("Digite o índice do usuário:");
                    if (i >= 0 && i < userFacade.getUsers().size()) {
                        System.out.println("Digite o novo nome:");
                        scanner.nextLine();
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

                        userFacade.updateUser(i, name, age, height, weight, sex);
                        System.out.println("Usuário atualizado com sucesso!");
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


    private int getValidInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException error) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next();
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
    private double getValidDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return scanner.nextDouble();
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
    public void startWorkoutManager() {
        int option;
        do {
            displayWorkoutMenu();
            option = getValidInt("Escolha uma opção:(1-7)");
            switch (option) {
                case 1 -> createWorkout();
                case 2 -> readWorkouts();
                case 3 -> updateWorkout();
                case 4 -> deleteWorkout();
                case 5 -> {
                    if (userFacade.readUsers().isEmpty()) {
                        System.out.println("Nenhum usuário disponível.");
                    } else {
                        System.out.println("Digite o índice do usuário:");
                        int userIndex = scanner.nextInt();
                        while (userIndex > userFacade.getUsers().size() - 1) {
                            System.out.println("Índice inválido.");
                            userIndex = scanner.nextInt();
                        }
                        assignWorkout(userIndex);
                    }
                }
                case 6 -> {
                    if (userFacade.readUsers().isEmpty()) {
                        System.out.println("Nenhum usuário disponível.");
                    } else {
                        System.out.println("Digite o índice do usuário:");
                        int userIndex = scanner.nextInt();
                        while (userIndex > userFacade.getUsers().size() - 1) {
                            System.out.println("Índice inválido.");
                            userIndex = scanner.nextInt();
                        }
                        unassignWorkout(userIndex);
                    }
                }
                case 7 -> System.out.println("Saindo do Gerenciamento de Treinos...");
                default -> System.out.println("Opção inválida");
            }
        } while (option != 7);
    }


    private void assignWorkout(int userIndex) {
        scanner.nextLine(); // Consume newline
        System.out.println("Enter workout name:");
        String workoutName = scanner.nextLine();
        userFacade.assignWorkoutToUser(userIndex, workoutName);
        System.out.println("Workout assigned successfully.");
    }

    private void unassignWorkout(int userIndex) {
        scanner.nextLine();
        System.out.println("Enter workout name:");
        String workoutName = scanner.nextLine();
        userFacade.unassignWorkoutFromUser(userIndex, workoutName);
        System.out.println("Workout unassigned successfully.");
    }


    public void addExerciseToWorkout() {
        while (true) {
            try {
                for(int i = 0; i < workoutFacade.loadWorkouts().size(); i++){
                    System.out.println("Indice: "+ i + " " + workoutFacade.readWorkoutByIndex(i));
                }
                System.out.println("Enter the workout index:");
                int workoutIndex = scanner.nextInt();
                System.out.println("Enter the exercise index:");
                int exerciseIndex = scanner.nextInt();
                workoutFacade.addExerciseToWorkout(workoutIndex, exerciseFacade.getExerciseByIndex(exerciseIndex));
                System.out.println("Exercise assigned to workout successfully.");
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid index. Please try again.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    public void startExerciseManager() {
        int option;
        do {
            displayExerciseMenu();
            option = getValidInt("Escolha uma opção:(1-5)");
            switch (option) {
                case 1 -> addNewExercise();
                case 2 -> readExercises();
                case 3 -> removeExercise();
                case 4 -> addExerciseToWorkout();
                case 5 -> System.out.println("Saindo do Gerenciamento de Exercícios...");
                default -> System.out.println("Opção inválida");
            }
        } while (option != 5);
    }
    private void createWorkout() {
        String name;
        do {
            System.out.println("Digite o nome do treino:");
            name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Nome do treino não pode ser vazio. Por favor, insira um nome válido.");
            }
        } while (name.isEmpty());

        String description;
        do {
            System.out.println("Digite a descrição do treino:");
            description = scanner.nextLine();
            if (description.isEmpty()) {
                System.out.println("Descrição do treino não pode ser vazia. Por favor, insira uma descrição válida.");
            }
        } while (description.isEmpty());
        workoutFacade.createWorkout(name, description);
        System.out.println("Treino criado com sucesso!");
    }

    private void readWorkouts() {
        System.out.println("Lista de Treinos:");
        for (int i = 0; i < workoutFacade.loadWorkouts().size(); i++) {
            System.out.println("\nÍndice: " + i + "\n"
                    + workoutFacade.readWorkoutByIndex(i));
        }
    }

    private void updateWorkout() {
        readWorkouts();
        int index = getValidInt("Digite o índice do treino a ser atualizado:");
        if (index >= 0 && index <  workoutFacade.loadWorkouts().size()) {
            System.out.println("Digite o novo nome do treino (ou pressione Enter para manter o atual):");
            scanner.nextLine();
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                workoutFacade.updateWorkout(index, newName);
            }
            System.out.println("Digite a nova descrição do treino (ou pressione Enter para manter a atual):");
            String newDescription = scanner.nextLine();
            if (!newDescription.isEmpty()) {
                workoutFacade.updateWorkout(index, index, newDescription);
            }
            System.out.println("Treino atualizado com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private void deleteWorkout() {
        System.out.println(workoutFacade.loadWorkouts());
        int index = getValidInt("Digite o índice do treino a ser deletado:");
        if (index >= 0 && index <  workoutFacade.loadWorkouts().size()) {
            workoutFacade.deleteWorkout(index);
            System.out.println("Treino deletado com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private void addNewExercise() {
        System.out.println("Digite o tipo de exercício (Treadmil, Hike, Race, Strength):");
        String type = scanner.next();
        scanner.nextLine(); // Clear the buffer

        System.out.println("Digite o nome do exercício:");
        String name = scanner.nextLine();

        System.out.println("Digite a descrição do exercício:");
        String description = scanner.nextLine();

        switch (type) {
            case "Treadmil" -> {
                double speed = getValidDouble(scanner, "Digite a velocidade:");
                double duration = getValidDouble(scanner, "Digite a duração:");
                exerciseFacade.newTreadmil(name, description, duration, speed);
            }
            case "Hike" -> {
                double duration = getValidDouble(scanner, "Digite a duração:");
                exerciseFacade.newHike(name, description, duration);
            }
            case "Race" -> {
                double duration = getValidDouble(scanner, "Digite a duração:");
                exerciseFacade.newRace(name, description,duration);
            }
            case "Strength" -> {
                int sets = getValidInt("Digite o número de séries:");
                int reps = getValidInt("Digite o número de repetições:");
                float weight = getValidFloat(scanner, "Digite o peso:");
                exerciseFacade.newStrength(name, description, sets, reps, weight);
            }
            default -> {
                System.out.println("Tipo de exercício inválido.");
                return;
            }
        }
        System.out.println("Exercício adicionado com sucesso!");
    }

    private void readExercises() {
        System.out.println("Lista de Exercícios:");
        for (int i = 0; i < exerciseFacade.getExercises().size(); i++) {
            System.out.println("\nÍndice: " + i + "\n" + exerciseFacade.getExerciseByIndex(i));
        }
    }

    private void removeExercise() {
        readExercises();
        int index = getValidInt("Digite o índice do exercício a ser removido:");
        if (index >= 0 && index < exerciseFacade.getExercises().size()) {
            exerciseFacade.removeExercise(exerciseFacade.getExerciseByIndex(index));
            System.out.println("Exercício removido com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }
}