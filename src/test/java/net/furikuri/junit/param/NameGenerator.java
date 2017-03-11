package net.furikuri.junit.param;


import java.util.Map;
import java.util.function.Function;

public class NameGenerator implements Function<Map<String ,String>, String> {

    private final String prefix;

    public NameGenerator(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String apply(Map<String, String> parameters) {
        return prefix + flatMap(parameters);
    }

    private String flatMap(Map<String, String> parameters) {
        StringBuilder sb = new StringBuilder();
        sb.append(" with parameters ");
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            sb.append("{");
            sb.append(entry.getKey());
            sb.append(":");
            sb.append(entry.getValue());
            sb.append("}");
        }
        return sb.toString();
    }
}
