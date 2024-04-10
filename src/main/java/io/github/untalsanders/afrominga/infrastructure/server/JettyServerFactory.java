package io.github.untalsanders.afrominga.infrastructure.server;

import io.github.untalsanders.afrominga.application.rest.controller.AfroController;
import io.github.untalsanders.afrominga.application.rest.controller.TaskController;
import io.github.untalsanders.afrominga.application.web.IndexServlet;
import io.github.untalsanders.afrominga.infrastructure.config.Configuration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServerFactory {
    public static void start(String[] args) throws Exception {
        QueuedThreadPool threadPool = new QueuedThreadPool();
        threadPool.setName("server");
        Server server = new Server(threadPool);

        try (ServerConnector connector = new ServerConnector(server)) {
            connector.setPort(Integer.parseInt(Configuration.get("server.port")));
            connector.setHost(Configuration.get("server.host"));
            connector.setAcceptQueueSize(128);
            server.addConnector(connector);
        }

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setWar("src/main/webapp");
        webAppContext.addServlet(IndexServlet.class, "/");
        server.setHandler(webAppContext);

        ServletContextHandler apiContext = new ServletContextHandler();
        apiContext.addServlet(TaskController.class, "/tasks/*");
        apiContext.addServlet(AfroController.class, "/afros/*");
        server.setHandler(apiContext);

        server.start();
        server.join();
    }
}
