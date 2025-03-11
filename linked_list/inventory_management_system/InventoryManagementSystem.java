package data_structure.linked_list.inventory_management_system;

public class InventoryManagementSystem {
    private Item head;

    // Check if the inventory is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Add an item at the beginning of the list
    public void addItemAtBeginning(Item item) {
        if (isEmpty()) {
            head = item;
        } else {
            item.next = head;
            head = item;
        }
    }

    // Add an item at the end of the list
    public void addItemAtEnd(Item item) {
        if (isEmpty()) {
            head = item;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = item;
        }
    }

    // Add an item at a specific position
    public void addItemAtPosition(Item item, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position should be >= 1.");
            return;
        }
        if (position == 1) {
            addItemAtBeginning(item);
        } else {
            Item temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
                if (temp == null) {
                    System.out.println("Position out of range.");
                    return;
                }
            }
            item.next = temp.next;
            temp.next = item;
        }
    }

    // Remove an item by Item ID
    public void removeItemById(int itemId) {
        if (isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }
        Item temp = head;
        Item prev = null;
        while (temp != null && temp.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            prev.next = temp.next;
            System.out.println("Item with ID " + itemId + " removed.");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        if (isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemId + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID
    public void searchById(int itemId) {
        if (isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item found: " + temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item Name
    public void searchByName(String itemName) {
        if (isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item found: " + temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item with name " + itemName + " not found.");
        }
    }

    // Calculate and display the total value of inventory
    public void calculateTotalValue() {
        if (isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total value of inventory: $" + totalValue);
    }

    // Sort the inventory based on Item Name (ascending or descending)
    public void sortByName(boolean ascending) {
        if (isEmpty() || head.next == null) {
            System.out.println("Inventory is empty or has only one item.");
            return;
        }
        head = mergeSort(head, true, ascending);
        System.out.println("Inventory sorted by Item Name (" + (ascending ? "ascending" : "descending") + ").");
    }

    // Sort the inventory based on Price (ascending or descending)
    public void sortByPrice(boolean ascending) {
        if (isEmpty() || head.next == null) {
            System.out.println("Inventory is empty or has only one item.");
            return;
        }
        head = mergeSort(head, false, ascending);
        System.out.println("Inventory sorted by Price (" + (ascending ? "ascending" : "descending") + ").");
    }

    // Merge Sort implementation for sorting
    private Item mergeSort(Item head, boolean sortByName, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSort(head, sortByName, ascending);
        Item right = mergeSort(nextOfMiddle, sortByName, ascending);
        return merge(left, right, sortByName, ascending);
    }

    // Helper method to get the middle of the linked list
    private Item getMiddle(Item head) {
        if (head == null) {
            return head;
        }
        Item slow = head;
        Item fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper method to merge two sorted linked lists
    private Item merge(Item left, Item right, boolean sortByName, boolean ascending) {
        Item result = null;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (sortByName) {
            if ((ascending && left.itemName.compareTo(right.itemName) <= 0) || (!ascending && left.itemName.compareTo(right.itemName) >= 0)) {
                result = left;
                result.next = merge(left.next, right, sortByName, ascending);
            } else {
                result = right;
                result.next = merge(left, right.next, sortByName, ascending);
            }
        } else {
            if ((ascending && left.price <= right.price) || (!ascending && left.price >= right.price)) {
                result = left;
                result.next = merge(left.next, right, sortByName, ascending);
            } else {
                result = right;
                result.next = merge(left, right.next, sortByName, ascending);
            }
        }
        return result;
    }

    // Display all items in the inventory
    public void displayInventory() {
        if (isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
