package com.example.batsumi

class ResDynamicModel {
    var name: String
    var rating: String? = null
    var reviews: String? = null
    var price: String
    var pos = 0

    constructor(name: String, price: String, rating: String?, reviews: String?) {
        this.name = name
        this.price = price
        this.rating = rating
        this.reviews = reviews
    }

    constructor(name: String, price: String) {
        this.name = name
        this.price = price
    }
}
