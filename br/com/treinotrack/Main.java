package br.com.treinotrack;
import br.com.treinotrack.service.Util;
import br.com.treinotrack.models.Admin;

public class Main {
    public static void main(String[] args){
        Admin admin = new Admin();
        admin.CreateNewBob();
        admin.CreateNewUser();
        admin.ReadUserList();
        admin.UpdateUser();
        admin.ReadUserList();
        admin.DeleteUser();
        admin.ReadUserList();
    }
}
