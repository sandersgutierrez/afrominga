package io.github.untalsanders.afrominga.application.service;

import io.github.untalsanders.afrominga.application.rest.controller.AfroController;
import io.github.untalsanders.afrominga.domain.Afro;
import io.github.untalsanders.afrominga.domain.service.AfroService;
import io.github.untalsanders.afrominga.infrastructure.persistence.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AfroServiceImpl implements AfroService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AfroController.class);

    public List<Afro> getAll() {
        List<Afro> afroList = new ArrayList<>();

        try (
            var connection = Database.getConnection();
            var stmt = connection.createStatement();
            var rs = stmt.executeQuery("SELECT * FROM afros");
        ) {
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String fullName = rs.getString("nombresapellidos");
                afroList.add(new Afro(id, fullName));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }

        return afroList;
    }
}
