package kbank.api

import com.fasterxml.jackson.databind.*

data class Command(val id: String, val type: CommandType, val command: JsonNode)

enum class CommandType {
    TRANSFER, READ, CREDIT, DEBIT
}