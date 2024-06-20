package org.example.reflectionApiExample;

import java.lang.reflect.*;

public class ReflectionApiExample {

    ReflectionUser user = new ReflectionUser(21L, "Hiss", 24);

    public void reflectionTest() {
        Class<? extends ReflectionUser> aClass = user.getClass();
        Class<ReflectionUser> userClass = ReflectionUser.class;
        System.out.println(aClass == userClass);
    }

    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<ReflectionUser> constructor = ReflectionUser.class.getConstructor(Long.class, String.class);
        ReflectionUser hiss = constructor.newInstance(5L, "Hiss");
        System.out.println(hiss);
    }

//    Получение id пользователя
    public void getUserId(Object object) throws IllegalAccessException {
        Field[] declaredFields = ReflectionUser.class.getSuperclass().getDeclaredFields();
        for (Field declaredField :
             declaredFields) {
            declaredField.setAccessible(true);
            Object value = declaredField.get(object);
            System.out.println(value);
        }
    }

    public void getUserName(Object object) throws IllegalAccessException {
        Field[] declaredFields = ReflectionUser.class.getDeclaredFields();
        for (Field decalredFiled : declaredFields) {
            decalredFiled.setAccessible(true);
            Object value = decalredFiled.get(object);
            System.out.println(value);
        }
    }

    public void getAnAccessModifier(Object object) {
        Field[] declaredFields = ReflectionUser.class.getDeclaredFields();
        for (Field decalredFiled : declaredFields) {
            System.out.println("Модификатор доступа: " + Modifier.isPrivate(decalredFiled.getModifiers()));
        }
    }

    public void getUserMethods(ReflectionUser user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method declaredMethods = user.getClass().getDeclaredMethod("getName");
        System.out.println(declaredMethods.invoke(user));
    }

    private class Test1 {

    }

    private static class Test3 {

    }

    private enum Test2 {

    }

}
