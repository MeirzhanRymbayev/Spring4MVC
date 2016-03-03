package com.websystique.springmvc.model;

import com.sun.xml.internal.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Pizza {
    private String name;

    private String flavor;

    private List<String> toppings = new ArrayList<String>();

    public Pizza() {
    }

    public Pizza(String name, String flavor, List<String> toppings) {
        this.name = name;
        this.flavor = flavor;
        this.toppings.add("Cheese");
        this.toppings.add("bakon");
    }


    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    @XmlElement
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public List<String> getToppings() {
        return toppings;
    }

    @XmlElement
    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }
}