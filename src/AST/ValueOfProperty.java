package AST;

public class ValueOfProperty extends ASTNode {
    private String stringValue;
    private Integer integerValue;

    public ValueOfProperty() {
        super("ValueOfProp");
    }

    // إنشاء كائن للقيم النصية
    public static ValueOfProperty ofString(String value) {
        ValueOfProperty vop = new ValueOfProperty();
        vop.stringValue = value;
        return vop;
    }

    // إنشاء كائن للقيم الرقمية
    public static ValueOfProperty ofInteger(Integer value) {
        ValueOfProperty vop = new ValueOfProperty();
        vop.integerValue = value;
        return vop;
    }

    // Getters and Setters
    public String getStringValue() {
        return stringValue;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    @Override
    public String toString() {
        return stringValue != null ? stringValue :
                integerValue != null ? integerValue.toString() : "null";
    }
}