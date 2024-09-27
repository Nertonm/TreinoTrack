package br.com.treinotrack;
import br.com.treinotrack.models.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<User>();
        Admin ADM = new Admin(users);
        ADM.CreateNewUser();
        ADM.CreateNewUser();
        ADM.ReadUserList();
        ADM.UpdateUser();
        ADM.ReadUserList();
        ADM.DeleteUser();
        ADM.ReadUserList();




    }
}
