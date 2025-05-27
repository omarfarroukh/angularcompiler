package AST;

public class Property extends ASTNode {
    private String key;
    private ValueOfProperty value;

    public Property(String type, String key, ValueOfProperty value) {
        super(type);
        this.key = key;
        this.value = value;
    }

    // Getters and Setters
    public String getKey() {
        return key;
    }

    public ValueOfProperty getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + ": " + value;
    }
}