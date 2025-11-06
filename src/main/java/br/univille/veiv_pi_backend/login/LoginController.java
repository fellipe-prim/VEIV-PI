package br.univille.veiv_pi_backend.login;

import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String senha = body.get("senha");

        String sql = "SELECT COUNT(*) FROM usuario WHERE email = ? AND senha = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email, senha);

        boolean sucesso = count != null && count > 0;

        return Map.of("success", sucesso);
    }
}
