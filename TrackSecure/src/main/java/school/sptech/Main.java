package school.sptech;

import school.sptech.Dao.RegistroDAO;
import school.sptech.Entity.Registro;

public class Main {
    public static void main(String[] args) {
        RegistroDAO query = new RegistroDAO();
        System.out.println("\nUltímos 30 Registros");
        for (Registro selecionarUltimosRegistro : query.selecionarRegistroMaquina(2)) {
            System.out.println(selecionarUltimosRegistro.toString());
        }
    }
}