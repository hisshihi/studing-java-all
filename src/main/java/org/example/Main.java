package org.example;

import org.example.setExample.SetExample;
import org.example.treeMap.TreeMapExample;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        SetExample setExample = new SetExample();
        Set<String> result = setExample.getSetExample();
        System.out.println(result);

    }
}