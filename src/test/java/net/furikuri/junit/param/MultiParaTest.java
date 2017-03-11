package net.furikuri.junit.param;


import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiParaTest {
    @TestFactory
    Stream<DynamicTest> multi() {
        Iterator<Map<String, String>> generator = new Input()
                .add("lang", "de", "en", "fr")
                .add("dev", "m", "t")
                .add("ent", "1", "2", "3").generate();

        return DynamicTest.stream(generator, new NameGenerator("My multi test"), (parameters) -> {
            System.out.print(parameters.get("lang"));
            System.out.print(parameters.get("dev"));
            System.out.print(parameters.get("ent"));
            System.out.println();
            assertEquals(2, parameters.get("lang").length());
            assertEquals(1, parameters.get("dev").length());
            assertEquals(1, parameters.get("ent").length());
        });
    }
}
