package io.github.sandersgutierrez.afrominga;

import io.github.sandersgutierrez.afrominga.infrastructure.JettyServerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        JettyServerFactory.start(args);
        logger.info("Profile active: {}", System.getenv("PROFILE"));
        logger.info("Started application...!!!");
    }
}
