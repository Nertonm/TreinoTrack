package treinotrack;
import treinotrack.facades.AdminFacade;

public class Main {
    public static void main(String[] args){
        AdminFacade facade = new AdminFacade();
        facade.start(); // Inicia o menu de gerenciamento
        facade.close(); // Fecha o scanner ao final da execução
    }
}
