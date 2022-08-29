package com.mustafa.account.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class CustomerAccountDto( // customeraccount dto doesnt have information of customer
        val id: String?,
        val balance: BigDecimal? = BigDecimal.ZERO,
        val transactions: Set<TransactionDto>?,
        val creationDate: LocalDateTime

)
