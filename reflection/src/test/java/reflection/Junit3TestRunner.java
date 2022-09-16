package reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Junit3TestRunner {

    @Test
    void run() throws Exception {
        Class<Junit3Test> clazz = Junit3Test.class;

        // TODO Junit3Test에서 test로 시작하는 메소드 실행
        Junit3Test junit3Test = new Junit3Test();

        String targetMethodPrefix = "test";
        List<Method> methods = Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> isNameStartWith(method.getName(), targetMethodPrefix))
                .collect(Collectors.toUnmodifiableList());

        for (Method method : methods) {
                method.invoke(junit3Test);
        }
    }

    private boolean isNameStartWith(String methodName, String prefix) {
        return methodName.startsWith(prefix);
    }
}
