# projects.java.generics

import java.util.List;

// Define the abstract product class
abstract class Product {
private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void use();

}

// Define concrete product classes
class ConcreteProductA extends Product {
public ConcreteProductA(String name) {
super(name);
}

    @Override
    public void use() {
        System.out.println("Using " + getName() + " of type A");
    }

}

class ConcreteProductB extends Product {
public ConcreteProductB(String name) {
super(name);
}

    @Override
    public void use() {
        System.out.println("Using " + getName() + " of type B");
    aki}

}

// Define the abstract factory class
abstract class ProductFactory {
public abstract List<Product> createProducts(int count, String type);
}

// Define concrete factory classes
class ConcreteFactoryA extends ProductFactory {
@Override
public List<Product> createProducts(int count, String type) {
List<Product> products = new java.util.ArrayList<>();
for (int i = 0; i < count; i++) {
products.add(new ConcreteProductA(type + "A" + (i + 1)));
}
return products;
}
}

class ConcreteFactoryB extends ProductFactory {
@Override
public List<Product> createProducts(int count, String type) {
List<Product> products = new java.util.ArrayList<>();
for (int i = 0; i < count; i++) {
products.add(new ConcreteProductB(type + "B" + (i + 1)));
}
return products;
}
}

// Client code
public class Main {
public static void main(String[] args) {
ProductFactory factoryA = new ConcreteFactoryA();
List<Product> productsA = factoryA.createProducts(3, "Product");
for (Product product : productsA) {
product.use();
}

        ProductFactory factoryB = new ConcreteFactoryB();
        List<Product> productsB = factoryB.createProducts(2, "Item");
        for (Product product : productsB) {
            product.use();
        }
    }

}