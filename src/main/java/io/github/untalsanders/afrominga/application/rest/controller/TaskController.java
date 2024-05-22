package io.github.untalsanders.afrominga.application.rest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TaskController", urlPatterns = "/tasks/*")
public class TaskController extends HttpServlet {

    private final List<String> tasks = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            resp.getWriter().write(tasks.toString());
        } else {
            String taskId = pathInfo.substring(1); // Remove leading slash
            int id;
            try {
                id = Integer.parseInt(taskId);
            } catch (NumberFormatException e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Invalid task ID");
                return;
            }
            if (id < 0 || id >= tasks.size()) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("Task not found");
                return;
            }
            resp.getWriter().write(tasks.get(id));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String task = req.getParameter("task");
        if (task != null && !task.isEmpty()) {
            tasks.add(task);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.getWriter().write("Task added successfully");
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Task cannot be empty");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Task ID is required");
            return;
        }
        String taskId = pathInfo.substring(1); // Remove leading slash
        int id;
        try {
            id = Integer.parseInt(taskId);
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Invalid task ID");
            return;
        }
        if (id < 0 || id >= tasks.size()) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().write("Task not found");
            return;
        }
        String updatedTask = req.getParameter("task");
        if (updatedTask != null && !updatedTask.isEmpty()) {
            tasks.set(id, updatedTask);
            resp.getWriter().write("Task updated successfully");
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Task cannot be empty");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Task ID is required");
            return;
        }
        String taskId = pathInfo.substring(1); // Remove leading slash
        int id;
        try {
            id = Integer.parseInt(taskId);
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Invalid task ID");
            return;
        }
        if (id < 0 || id >= tasks.size()) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().write("Task not found");
            return;
        }
        tasks.remove(id);
        resp.getWriter().write("Task deleted successfully");
    }
}
