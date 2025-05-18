package AST;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class SymbolTable {
    private final Deque<Map<String, Row>> scopeStack = new ArrayDeque<>();

    public SymbolTable() {
        // Start with global scope
        enterScope();
    }

    // Enters a new scope
    public void enterScope() {
        scopeStack.push(new HashMap<>());
    }

    // Exits the current scope
    public void exitScope() {
        if (scopeStack.size() <= 1) {
            throw new IllegalStateException("Cannot exit the global scope");
        }
        scopeStack.pop();
    }

    // Adds a symbol to the current scope
    public void add(String name, String type, String value) {
        if (type == null || value == null || name == null ||
                type.isEmpty() || value.isEmpty() || name.isEmpty()) {
            throw new IllegalArgumentException("Name, type and value cannot be null or empty.");
        }

        Map<String, Row> currentScope = scopeStack.peek();

        // Check for duplicate in current scope only
        if (currentScope.containsKey(name)) {
            System.out.println("Duplicate entry in current scope: name = " + name);
            return;
        }

        Row row = new Row();
        row.setName(name);
        row.setType(type);
        row.setValue(value);
        currentScope.put(name, row);
    }

    // Looks up a symbol in all scopes (from innermost to outermost)
    public Row lookup(String name) {
        for (Map<String, Row> scope : scopeStack) {
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        return null;
    }

    // Looks up a symbol only in the current scope
    public Row lookupCurrentScope(String name) {
        return scopeStack.peek().get(name);
    }

    // Gets all rows from all scopes (for debugging/display purposes)
    public List<Row> getAllRows() {
        List<Row> allRows = new ArrayList<>();
        for (Map<String, Row> scope : scopeStack) {
            allRows.addAll(scope.values());
        }
        return allRows;
    }

    // Prints the symbol table with scope information
    public void print() {
        if (scopeStack.isEmpty()) {
            System.out.println("Symbol table is empty.");
            return;
        }

        // Formatting strings
        String format = "| %-20s | %-30s | %-20s | %-10s |\n";
        String separator = "+----------------------+--------------------------------+----------------------+------------+\n";
        String headerFormat = "| %-20s | %-30s | %-20s | %-10s |\n";

        System.out.print(separator);
        System.out.printf(headerFormat, "Symbol Name", "Symbol Value", "Symbol Type", "Scope Level");
        System.out.print(separator);

        // Print from innermost to outermost scope (scope level decreases as we go down the stack)
        int currentScopeLevel = scopeStack.size() - 1;
        for (Map<String, Row> scope : scopeStack) {
            for (Row row : scope.values()) {
                System.out.printf(format,
                        row.getName() != null ? row.getName() : "null",
                        row.getValue() != null ? row.getValue() : "null",
                        row.getType() != null ? row.getType() : "null",
                        currentScopeLevel);
            }
            currentScopeLevel--;
        }
        System.out.print(separator);
    }
}