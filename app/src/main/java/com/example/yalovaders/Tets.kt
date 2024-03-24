import java.util.Scanner

// Item class
open class Item(val name: String, val price: Double)

// Food class, subclass of Item
class Food(name: String, price: Double, val weight: String) : Item(name, price)

// Cloth class, subclass of Item
class Cloth(name: String, price: Double, val type: String) : Item(name, price)

// ShoppingList class
class ShoppingList {
    private val items = mutableListOf<Item>()

    // Function to add an item
    fun addItem(item: Item) {
        items.add(item)
        println("${item.name} added to the shopping list.")
    }

    // Function to display items
    fun displayItems() {
        if (items.isEmpty()) {
            println("Your shopping list is empty.")
        } else {
            println("Shopping List:")
            for ((index, item) in items.withIndex()) {
                println("${index + 1}. Name: ${item.name}, Price: ${item.price}")
                when (item) {
                    is Food -> println("   Weight: ${item.weight}")
                    is Cloth -> println("   Type: ${item.type}")
                }
            }
        }
    }

    // Function to delete an item
    fun deleteItem(index: Int) {
        if (index >= 0 && index < items.size) {
            val deletedItem = items.removeAt(index)
            println("${deletedItem.name} removed from the shopping list.")
        } else {
            println("Invalid item index.")
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val shoppingList = ShoppingList()

    while (true) {
        println("\nShopping List Application")
        println("1) Add Item")
        println("2) Display Items")
        println("3) Delete Item")
        println("4) Exit")
        print("Please select an option: ")

        when (scanner.nextInt()) {
            1 -> {
                println("Select item type:")
                println("1) Food")
                println("2) Cloth")
                print("Enter your choice: ")
                val itemType = scanner.nextInt()

                when (itemType) {
                    1 -> {
                        print("Enter food name: ")
                        val name = scanner.next()
                        print("Enter price: ")
                        val price = scanner.nextDouble()
                        print("Enter weight: ")
                        val weight = scanner.next()
                        shoppingList.addItem(Food(name, price, weight))
                    }
                    2 -> {
                        print("Enter cloth name: ")
                        val name = scanner.next()
                        print("Enter price: ")
                        val price = scanner.nextDouble()
                        print("Enter type: ")
                        val type = scanner.next()
                        shoppingList.addItem(Cloth(name, price, type))
                    }
                    else -> println("Invalid choice.")
                }
            }
            2 -> shoppingList.displayItems()
            3 -> {
                print("Enter item number to delete: ")
                val index = scanner.nextInt() - 1
                shoppingList.deleteItem(index)
            }
            4 -> {
                println("Exiting the application.")
                return
            }
            else -> println("Invalid choice. Please enter a number between 1 and 4.")
        }
    }
}
