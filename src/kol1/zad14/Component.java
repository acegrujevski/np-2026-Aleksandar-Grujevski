package kol1.zad14;

import java.util.ArrayList;
import java.util.List;

public class Component implements Comparable<Component> {
    private String color;
    private int weight;
    private List<Component> components;

    public Component(String color, int weight) {
        this.color = color;
        this.weight = weight;
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component){
        int i;
        for (i = 0; i < components.size(); i++) {
            if (component.compareTo(components.get(i)) < 0)
                break;
        }

        components.add(i,component);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void changeColor(int weight, String color){
        if (getWeight()<weight)
            setColor(color);
        for (Component component : components)
            component.changeColor(weight, color);
    }

    @Override
    public int compareTo(Component o) {

        int out = Integer.compare(this.getWeight(),o.getWeight());

        if (this.getWeight() != o.getWeight())
            return out;

        return this.getColor().compareTo(o.getColor());
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s%d:%s\n",indent,getWeight(),getColor()));

        for (Component component : components){
            sb.append(component.toString(indent+"---"));
        }

        return sb.toString();
    }
}
