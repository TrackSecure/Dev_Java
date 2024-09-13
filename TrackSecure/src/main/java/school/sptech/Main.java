package school.sptech;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistroDAO query = new RegistroDAO();
        System.out.println("\nUltímos 30 Registros");
        for (Registro selecionarUltimosRegistro : query.selecionarRegistroMaquina(2)) {
            System.out.println(selecionarUltimosRegistro.toString());
        }
    }
}