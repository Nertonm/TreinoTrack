package br.com.treinotrack.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getString(){
        return scanner.nextLine();
    }
    public static byte getByte(){
        while (true) { // verificação de error
            try {
                return scanner.nextByte();
            }
            catch (InputMismatchException error){
                System.out.println("Entrada Inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpa o Scanner
            }
        }
    }

    public static float getFloat(){
        while (true) { // verificação de error
            try {
                return scanner.nextFloat();
            }
            catch (InputMismatchException error){
                System.out.println("Entrada Inválida. Por favor, insira um número válido.");

                scanner.next(); // Limpa o Scanner
            }
        }
    }

    public static int getInt(){
        while (true) { // verificação de error
            try {
                return scanner.nextInt();
            }
            catch (InputMismatchException error){
                System.out.print("Entrada Inválida\n");
                scanner.next(); // Limpa o Scanner
            }
        }
    }
}
