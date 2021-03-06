package io.dkozak.eobaly.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Lob

@Entity
class ErrorLog {

    @Id
    @GeneratedValue
    var id = 0

    var type = ""

    var url = ""

    var message = ""

    @Lob
    var stackTrace = ""

}