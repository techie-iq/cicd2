package com.techieiq.learn.cicd

import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class PaymentService {
    companion object {
        init {
            println("this is the payment service")

        }
    }
}

@Service
class PaymentLwin() {

    companion object {
        init {
            println("Hello from lwin")
        }
    }
}

@Service
class SepaCreditService {
    companion object {
        init {
            println("Here is sepa")
        }
    }
}

@Service
class SepaDebitService {
     companion object {
        init {
            println("Sepa debit here")
        }
    }
}

@Repository
class SepaRepository {
    companion object {
        init {
            println("get repo")
        }
    }
}
