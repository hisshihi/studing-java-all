package org.example.reflectionApiExample;

public class ReflectionApiExample {

    ReflectionUser user = new ReflectionUser(21L, "Hiss");

    public void reflectionTest() {
        Class<? extends ReflectionUser> aClass = user.getClass();
        Class<ReflectionUser> userClass = ReflectionUser.class;
        System.out.println(aClass == userClass);
    }

    private class Test1 {

    }

    private static class Test3 {

    }

    private enum Test2 {

    }

}
