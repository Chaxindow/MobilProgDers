package com.example.yalovaders


open class Item(name: String, price: Double) {

    val name: String
    val price: Double

    init {
        this.name = name
        this.price = price
    }
}

class Food(name: String, price: Double, val weight: String) : Item(name, price)
class Cloth(name: String, price: Double, val type: String) : Item(name, price)
class ShoppingList {

    private var shoppingItemList: MutableList<Item> = mutableListOf()

    fun addItem(item: Item) {
        shoppingItemList.add(item)
        println("${item.name} is added successfully")
    }

    fun displayItem() {

        if (shoppingItemList.isEmpty()) {
            println("Your shopping list is empty.")
        } else {
            println("Shopping List:")
            // withIndex could be use
            for (item in shoppingItemList) {
                when (item) {
                    is Food -> {
                        println("${shoppingItemList.indexOf(item) + 1}. ${item.name} ${item.price}$ ${item.weight}")
                    }

                    is Cloth -> {
                        println("${shoppingItemList.indexOf(item) + 1}. ${item.name} ${item.price}$ ${item.type}")
                    }
                }
            }
        }
    }

    fun deleteItem(index: Int) {
        if (index in 0..shoppingItemList.size) {
            println("${shoppingItemList[index].name} is deleted successfully")
            shoppingItemList.removeAt(index)
        } else {
            println("Please enter valid index")
        }
    }
}

fun main() {


    println("***** Welcome to Shopping List *****")


    var value = 0
    val shoppingList = ShoppingList()

    while (value != 4) {
        println("Make your choice : (1-2-3-4)")
        println("1. Add item")
        println("2. Display item")
        println("3. Delete item")
        println("4. Exit")
        print("Your choice is : ")
        value = readln().toInt()

        if (value == 1) {
            print("Enter the item type you want to add (1 for Food , 2 for Cloth): ")
            val itemType = readln().toInt()

            when (itemType) {
                1 -> {
                    print("Enter the item name you want to add : ")
                    val foodName = readln()
                    print("Enter the item price you want to add : ")
                    val foodPrice = readln().toDouble()
                    print("Enter the food weight : ")
                    val foodWeight = readln()
                    shoppingList.addItem(Food(foodName, foodPrice, foodWeight))
                }

                2 -> {
                    print("Enter the item name you want to add : ")
                    val clothName = readln()
                    print("Enter the item price you want to add : ")
                    val clothPrice = readln().toDouble()
                    print("Enter the cloth type : ")
                    val clothType = readln()
                    shoppingList.addItem(Cloth(clothName, clothPrice, clothType))
                }

                else -> {
                    continue
                }
            }
        } else if (value == 2) {
            shoppingList.displayItem()
        } else if (value == 3) {
            print("Enter the item number you want to delete : ")
            val indexForDelete = readln().toInt() - 1
            shoppingList.deleteItem(indexForDelete)
        } else if (value == 4) {
            println("Exiting...")
        } else {
            println("Please enter valid number")
        }
    }
}