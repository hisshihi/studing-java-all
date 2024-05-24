package org.example.setExample;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetExample {

    public Set<String> getSetExample() {
        Set<String> set = new LinkedHashSet<>();
//        Метод add возвращает boolean, чтобы проверить смогли ли мы добавить значение в Set.
        set.add("Hiss");
        set.add("Dev");
        set.add("outrun");
        set.add("Arina");
        set.add("outrun");

        return set;
    }

}
