package data_structure.linked_list.inventory_management_system;

public class Main {
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        // Adding items
        inventory.addItemAtBeginning(new Item("Laptop", 101, 10, 1200.0));
        inventory.addItemAtEnd(new Item("Mouse", 102, 50, 25.0));
        inventory.addItemAtPosition(new Item("Keyboard", 103, 30, 50.0), 2);

        // Display all items
        System.out.println("All Items:");
        inventory.displayInventory();

        // Search for an item by ID
        System.out.println("\nSearching for Item ID 102:");
        inventory.searchById(102);

        // Search for an item by name
        System.out.println("\nSearching for Item Name 'Keyboard':");
        inventory.searchByName("Keyboard");

        // Update quantity of an item
        System.out.println("\nUpdating quantity of Item ID 101 to 15:");
        inventory.updateQuantity(101, 15);
        inventory.displayInventory();

        // Calculate total value of inventory
        System.out.println("\nCalculating total value of inventory:");
        inventory.calculateTotalValue();

        // Sort inventory by Item Name (ascending)
        System.out.println("\nSorting inventory by Item Name (ascending):");
        inventory.sortByName(true);
        inventory.displayInventory();

        // Sort inventory by Price (descending)
        System.out.println("\nSorting inventory by Price (descending):");
        inventory.sortByPrice(false);
        inventory.displayInventory();

        // Remove an item by ID
        System.out.println("\nRemoving Item ID 102:");
        inventory.removeItemById(102);
        inventory.displayInventory();
    }
}

