package treinotrack;
import treinotrack.facades.UserFacade;

public class Main {
    public static void main(String[] args){
        UserFacade facade = new UserFacade();
        facade.start(); // Inicia o menu de gerenciamento
        facade.close(); // Fecha o scanner ao final da execução
    }
}
