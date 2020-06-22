package com.mikhailovskii.task1_5

import java.util.*

open class Animal(val id: Int)

class Dog(id: Int) : Animal(id)

class Cat(id: Int) : Animal(id)

fun main() {
    val animalList = LinkedList<Animal>()

    enqueue(animalList, Cat(1))
    enqueue(animalList, Cat(2))
    enqueue(animalList, Dog(3))
    enqueue(animalList, Dog(4))
    enqueue(animalList, Cat(5))
    enqueue(animalList, Cat(6))
    enqueue(animalList, Dog(7))

    val (animal, animals) = dequeueAny(animalList)

    if (animal is Dog) {
        println("DOG")
    } else {
        println("CAT")
    }

    println(animals.size)

    val (cat, animals1) = dequeueCat(animals)

    println(cat.id)
    println(animals1.size)

    val (dog, animals2) = dequeueCat(animals)

    println(dog.id)
    println(animals2.size)

}

data class DequeueResult(
        val animal: Animal,
        val animalList: LinkedList<Animal>
)

fun enqueue(animalList: LinkedList<Animal>, animal: Animal) = animalList.apply { add(animal) }

fun dequeueAny(animalList: LinkedList<Animal>): DequeueResult = DequeueResult(animalList.removeLast(), animalList)

fun dequeueCat(animalList: LinkedList<Animal>): DequeueResult {
    var iterator = animalList.iterator()
    var cat: Cat? = null

    while (iterator.hasNext()) {
        val animal = iterator.next()

        if (animal is Cat) {
            cat = animal
        }

    }

    iterator = animalList.iterator()

    while (iterator.hasNext()) {
        val animal = iterator.next()

        if (animal is Cat && animal === cat) {
            animalList.remove(animal)
            break
        }

    }

    return DequeueResult(cat!!, animalList)
}

fun dequeueDog(animalList: LinkedList<Animal>): DequeueResult {
    var iterator = animalList.iterator()
    var dog: Dog? = null

    while (iterator.hasNext()) {
        val animal = iterator.next()

        if (animal is Dog) {
            dog = animal
        }

    }

    iterator = animalList.iterator()

    while (iterator.hasNext()) {
        val animal = iterator.next()

        if (animal is Dog && animal === dog) {
            animalList.remove(dog)
            break
        }

    }

    return DequeueResult(dog!!, animalList)
}