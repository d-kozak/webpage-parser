package io.dkozak.eobaly.domain


import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.NotNull

@Volatile
var UNKNOWN_CATEGORY = ProductCategory().let {
    it.name = "UNKNOWN"
    it.url = "NONE"
    it
}

@Entity
class ProductCategory {

    @Id
    @GeneratedValue
    var id = 0

    @Column(unique = true)
    @NotNull
    var name = ""
    var url = ""

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    var products: List<Product> = emptyList()


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