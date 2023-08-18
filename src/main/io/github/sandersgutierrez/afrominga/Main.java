package io.github.sandersgutierrez.afrominga;

import io.github.sandersgutierrez.afrominga.infrastructure.JettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        JettyServer.start();
        logger.info("Started application...");
    }
}
