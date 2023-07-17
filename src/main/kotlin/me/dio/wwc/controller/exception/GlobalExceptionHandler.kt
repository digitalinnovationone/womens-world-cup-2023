package me.dio.wwc.controller.exception

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    private val logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBusinessException(ex: IllegalArgumentException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.UNPROCESSABLE_ENTITY)
    }

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoContentException(): ResponseEntity<String> {
        return ResponseEntity("Resource ID not found.", HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(Throwable::class)
    fun handleUnexpectedException(unexpectedException: Throwable): ResponseEntity<String> {
        val message = "Unexpected server error."
        logger.error(message, unexpectedException)
        return ResponseEntity(message, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}