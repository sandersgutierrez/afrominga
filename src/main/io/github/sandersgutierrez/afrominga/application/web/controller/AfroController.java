package io.github.sandersgutierrez.afrominga.application.web.controller;

import com.google.gson.Gson;
import io.github.sandersgutierrez.afrominga.domain.Afro;
import io.github.sandersgutierrez.afrominga.infrastructure.persistence.Database;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "afros", urlPatterns = "/afros")
public class AfroController extends HttpServlet {
    public static final Logger logger = LoggerFactory.getLogger(AfroController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        List<Afro> afroList = new ArrayList<>();
        try (
            var connection = Database.connect();
            var stmt = connection.createStatement();
            var rs = stmt.executeQuery("SELECT * FROM afro");
        ) {
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String fullName = rs.getString("nombres_apellidos");
                afroList.add(new Afro(id, fullName));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        res.setContentType("application/json");
        res.setStatus(HttpServletResponse.SC_OK);
        res.getWriter().println(new Gson().toJson(afroList));
    }
}
