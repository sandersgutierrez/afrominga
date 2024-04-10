package io.github.untalsanders.afrominga.application.rest.controller;

import com.google.gson.Gson;
import io.github.untalsanders.afrominga.domain.Afro;
import io.github.untalsanders.afrominga.infrastructure.persistence.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AfrosController", urlPatterns = "/afros/*")
public class AfroController extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(AfroController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        LOGGER.info("URL: " + req.getPathInfo());
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

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.setStatus(HttpServletResponse.SC_OK);
        res.getWriter().write(new Gson().toJson(afroList));
    }
}
