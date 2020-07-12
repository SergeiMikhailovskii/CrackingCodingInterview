package com.mikhailovskii.task1_5

fun main() {
    val cardDeck = CardDeck()

    cardDeck.showCards()

    val card = cardDeck.getTopCard()

    cardDeck.showCards()
}

class CardDeck {

    private var cards = mutableListOf(
            Card(6, 0),
            Card(7, 0),
            Card(8, 0),
            Card(9, 0),
            Card(6, 1),
            Card(7, 1)
    )

    fun showCards() {
        this.cards.forEach {
            println(it)
        }
    }

    fun getTopCard(): Card {
        val card = cards[cards.size - 1]
        cards.removeAt(cards.size - 1)
        return card
    }


}

class Card(
        private var value: Int,
        private var suit: Int
) {

    override fun toString(): String {
        return "$value $suit"
    }
}
