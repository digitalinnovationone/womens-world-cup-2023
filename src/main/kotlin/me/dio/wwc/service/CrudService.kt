package me.dio.wwc.service

interface CrudService<T, ID> {
    fun findAll(): List<T>
    fun findById(id: ID): T
    fun create(model: T): T
    fun update(id: ID, model: T): T
    fun delete(id: ID)
}