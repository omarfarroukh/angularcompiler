package AST;

import java.util.List;

public class ObjectInArray extends ASTNode {
    private List<Property> properties;

    public ObjectInArray(String type, List<Property> properties) {
        super(type);
        this.properties = properties;
    }

    // Getters and Setters
    public List<Property> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return properties.toString();
    }
}