package kol1.zad14;

import java.util.*;
import java.util.stream.Collectors;

public class Window {
    private String name;
    private Map<Integer,Component> components;

    public Window(String name) {
        this.name = name;
        this.components = new TreeMap<>();
    }

    public void addComponent(int position, Component component) throws InvalidPositionException {


        if (components.containsKey(position))
            throw new InvalidPositionException(String.format("Invalid position %d, alredy taken!", position));

        components.put(position, component);
    }

    public void changeColor(int weight, String color){
        for (Component component : components.values())
            component.changeColor(weight,color);
    }

    public void swichComponents(int pos1, int pos2){

        if (components.containsKey(pos1) && components.containsKey(pos2)){
            Component tmp = components.get(pos1);
            components.put(pos1,components.get(pos2));
            components.put(pos2,tmp);
        }

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("WINDOW %s\n",getName()));

        int i = 1;
        for (Component component : components.values()){
            sb.append(String.format("%d:%s",i++,component.toString("")));
        }

        return sb.toString();
    }
}
