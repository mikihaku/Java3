import Annotations.AfterSuite;
import Annotations.BeforeSuite;
import Annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class RunTest<T> {

    Class theClass = null;

    Method[] methods;
    Method   before;
    Method   after;
    ArrayList<Method> tests;
    HashMap<Integer, Method[]> prioritizedTests;

    RunTest(T classRef) {

        if(classRef instanceof String) {

            try {

                this.theClass = Class.forName((String) classRef);

            } catch (ClassNotFoundException e) {
                System.out.println("Не удалось найти указанный пакет тестов");
                return;
            }

        }
        else if(classRef instanceof Class) {

            this.theClass = (Class) classRef;

        } else {

            System.out.println("Параметр должен быть строковым именем класса или объектом Class");
            return;

        }

        methods = theClass.getDeclaredMethods();

        if (methods == null) {

            System.out.println("Не удалось получить тестовые методы из указанного класса");
        } else {

            for (Method m: methods) {

                if(m.isAnnotationPresent(BeforeSuite.class)) {

                    if(before == null)
                        before = m;
                    else
                        throw new RuntimeException();

                }

                if(m.isAnnotationPresent(AfterSuite.class)) {

                    if(after == null)
                        after = m;
                    else
                        throw new RuntimeException();

                }

                if(m.isAnnotationPresent(Test.class)) {

                    if(o.getAnnotation(Test.class).priotity()) {


                    }

                    tests.add(m);

                }

            }

        }

    }

    public void start(T theClass) {



    }

}
