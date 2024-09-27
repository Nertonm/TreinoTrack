package br.com.treinotrack;
import br.com.treinotrack.service.Util;
import br.com.treinotrack.models.Admin;

public class Main {
    public static void main(String[] args){
        Admin ADM = new Admin();
        ADM.CreateNewUser();
        ADM.ReadUserList();
        ADM.UpdateUser();
        ADM.ReadUserList();
        ADM.DeleteUser();
        ADM.ReadUserList();
    }
}
