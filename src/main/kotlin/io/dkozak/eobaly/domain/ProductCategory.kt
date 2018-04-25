package io.dkozak.eobaly.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class ProductCategory(name: String) {

    @Id
    @GeneratedValue
    var id = 0

    var name = ""

    @OneToMany(mappedBy = "category")
    var products: List<Product> = emptyList()

    init {
        this.name = name
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductCategory

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }

    override fun toString(): String {
        return "ProductCategory(id=$id, name='$name')"
    }
}