package tech.ineb.ats.alpha.reflection.proxy;

import io.github.classgraph.ClassInfo;
import io.github.classgraph.MethodInfo;
import io.github.classgraph.MethodInfoList;
import tech.ineb.ats.alpha.annotations.Pre;
import tech.ineb.ats.alpha.strategy.Strategy;
import tech.ineb.ats.alpha.utils.Pair;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

public class StrategyProxy implements InvocationHandler {
    private Pair<Object, ClassInfo> target;

    public StrategyProxy(Pair<Object, ClassInfo> target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if (methodName.equals("getName")) {
            Method m = target.getClass().getDeclaredMethod("when");
            Boolean data = (Boolean) m.invoke(target);

            //com.example.demo2.annotation.Rule rule =
            //        ReflectionsHelper.findAnnotationWithinClass(com.example.demo2.annotation.Rule.class, target.getClass());
            //String name = rule.name();


            //com.example.demo2.annotation.Rule rule =
            //        Utils.findAnnotation(com.example.demo2.annotation.Rule.class, getTargetClass());
            //rule.name().equals(Rule.DEFAULT_NAME) ? getTargetClass().getSimpleName() : rule.name();
            return null;
        } else if (method.getName().equals("getDescription")) {
            return null;
        } else if (method.getName().equals("pre")) {
            Object data = null;
            ClassInfo classInfo = target.getSecond();
            Object t = target.getFirst();

            MethodInfoList formMethods = classInfo.getMethodInfo()
                    .filter(m -> m.getAnnotationInfo()
                            .containsName(Pre.class.getName()));

            for (MethodInfo methodInfo : formMethods) {
                Method m = t.getClass().getDeclaredMethod(methodInfo.getName(), Pair.class);
                //Pair<Tick, Tick> pairs = (Pair<Tick, Tick>);
                data = m.invoke(t, args[0]);
            }

            return data;
        } else if (method.getName().equals("getPriority")) {
            return null;
        } else if (method.getName().equals("hashCode")) {
            Strategy strategy = (Strategy) proxy;
            return Objects.hash(strategy.getName(), strategy.getDescription());
        } else if (method.getName().equals("equals")) {
            Object o = args[0];
            if (proxy == o) return true;
            if (o == null || proxy.getClass() != o.getClass()) return false;
            Strategy proxyStrategy = (Strategy) proxy;
            Strategy oStrategy = (Strategy) o;
            return Objects.equals(proxyStrategy.getName(), oStrategy.getName()) &&
                    Objects.equals(proxyStrategy.getDescription(), oStrategy.getDescription());
        } else {
            throw new UnsupportedOperationException("Unsupported method: " + method.getName());
        }
    }
}
