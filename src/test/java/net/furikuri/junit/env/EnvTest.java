package net.furikuri.junit.env;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnvTest {
    @Test
    @DisableEnv("prod")
    public void runOk() {
        assertEquals(4, 2 * 2);
    }

    @Test
    @DisableEnv("dev")
    public void doNotRun() {
        assertEquals(4, 2 * 2);
    }
}
