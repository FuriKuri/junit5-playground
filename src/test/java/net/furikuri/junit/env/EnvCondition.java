package net.furikuri.junit.env;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.util.StringUtils;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;

public class EnvCondition implements ContainerExecutionCondition, TestExecutionCondition {
    private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled("Env is correct");

    @Override
    public ConditionEvaluationResult evaluate(ContainerExtensionContext context) {
        return evaluate(context.getElement());
    }

    @Override
    public ConditionEvaluationResult evaluate(TestExtensionContext context) {
        return evaluate(context.getElement());
    }

    private ConditionEvaluationResult evaluate(Optional<AnnotatedElement> element) {
        Optional<DisableEnv> disabled = findAnnotation(element, DisableEnv.class);
        String currentEnv = "dev";
        if (disabled.isPresent()) {
            boolean disableTest = disabled
                    .map(DisableEnv::value)
                    .map(Arrays::asList)
                    .filter(list -> list.contains(currentEnv))
                    .isPresent();
            if (disableTest) {
                return ConditionEvaluationResult.disabled("Current env");
            }
        }

        return ENABLED;
    }
}
