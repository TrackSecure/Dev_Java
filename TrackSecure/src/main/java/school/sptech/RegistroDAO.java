package school.sptech;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RegistroDAO {
    private JdbcTemplate assistente;

    public RegistroDAO() {
        DatabaseConfiguration conexao = new DatabaseConfiguration();
        assistente = conexao.getTemplate();
    }

    public List<Registro> selecionarUltimosRegistros() {
        return assistente.query("SELECT * FROM Registro ORDER BY idRegistro DESC LIMIT 30", new BeanPropertyRowMapper<>(Registro.class));
    }

    public List<Registro> selecionarRegistroMaquina(Integer idMaquina) {
        return assistente.query("SELECT * FROM Registro WHERE idRegistro = %d ORDER BY idRegistro DESC LIMIT 30".formatted(idMaquina), new BeanPropertyRowMapper<>(Registro.class));
    }

}
