package io.github.sandersgutierrez.afrominga.infrastructure;

import io.github.sandersgutierrez.afrominga.application.web.controller.AfroController;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class JettyServer {
    private static Server server;

    public static void start() throws Exception {
        QueuedThreadPool threadPool = new QueuedThreadPool();
        threadPool.setName("server");
        server = new Server(threadPool);

        try (ServerConnector connector = new ServerConnector(server)) {
            connector.setPort(Integer.parseInt(Configuration.get("server.port")));
            connector.setHost(Configuration.get("server.host"));
            connector.setAcceptQueueSize(128);
            server.addConnector(connector);
        }

        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(AfroController.class, "/afros");

        server.setHandler(servletHandler);
        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }

    public static void waitForInterrupt() throws InterruptedException {
        server.join();
    }
}