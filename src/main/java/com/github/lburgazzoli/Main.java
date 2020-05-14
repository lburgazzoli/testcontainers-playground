package com.github.lburgazzoli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info(System.getenv("DOCKER_HOST"));
        LOGGER.info(System.getenv("TESTCONTAINERS_RYUK_DISABLED"));

        GenericContainer<?> gc = new GenericContainer("mongo:4.0")
            .withExposedPorts(27017)
            .withLogConsumer(new Slf4jLogConsumer(LOGGER))
            .waitingFor(Wait.forListeningPort());

        gc.start();
    }
}
