package io.github.untalsanders.afrominga;

import io.github.untalsanders.afrominga.infrastructure.server.JettyServerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("Profile active: {}", System.getenv("profile"));
        JettyServerFactory.start(args);
        LOGGER.info("Started application...!!!");
    }
}
