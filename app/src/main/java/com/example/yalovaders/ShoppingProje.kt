package com.example.yalovaders


open class Item (name : String , price : Double){

    val name : String
    val price : Double
    init {
        this.name = name
        this.price = price
    }
}
class Food (name : String, price: Double, val weight : String) : Item(name,price){}
class Cloth(name: String,price: Double, val type : String) : Item(name,price){}
class ShoppingList{
    fun addItem(){}
    fun displayItem(){}
    fun deleteItem(){}
}
fun main() {

}