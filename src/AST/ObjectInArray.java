package AST;

import java.util.List;

public class ObjectInArray extends ASTNode {
    public List<Property> properties;

    public ObjectInArray(String type, List<Property> properties) {
        super(type);
        this.properties = properties;
    }

    public void addProperty(String key , Object value){
        this.properties.add(new Property( "Property", key , value));
    }
    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Object: {");

        for (int i = 0; i < properties.size(); i++) {
            Property prop = properties.get(i);
            sb.append(prop.getKey()).append(": ");

            if (prop.getValue() instanceof String) {
                sb.append("\"").append(prop.getValue()).append("\"");
            } else {
                sb.append(prop.getValue());
            }

            if (i < properties.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("}");
        return sb.toString();
    }
}
