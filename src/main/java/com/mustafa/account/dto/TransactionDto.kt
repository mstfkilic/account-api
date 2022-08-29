package com.mustafa.account.dto

import com.mustafa.account.model.Transaction.TransactionType
import com.mustafa.account.model.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDto(
        val id: String?,
        val transactionType: TransactionType? = Transaction.TransactionType.INITIAL,
        val amount: BigDecimal?,
        val transactionDate: LocalDateTime?

)