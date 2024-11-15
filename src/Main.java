package treinotrack;
import treinotrack.IUconsole.*;

public class Main {
    public static void main(String[] args){
        IU console = new IU();
        console.start(); // Inicia o menu de gerenciamento
        console.close(); // Fecha o scanner ao final da execução
    }
}
