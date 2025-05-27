package AST;

public class Property extends ASTNode{
    public String key;
    public Object value;

    public Property(String type, String key, Object value) {
        super(type);
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
