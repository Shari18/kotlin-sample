package com.example

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.*
import org.jetbrains.exposed.sql.Database
import org.slf4j.LoggerFactory

const val HIKARI_CONFIG_KEY = "ktor.database.hikariconfig"

fun Application.initDB(){
    val configPath = environment.config.property(HIKARI_CONFIG_KEY).getString()
    //val dbConfig = HikariConfig(configPath)
    //val dataSource = HikariDataSource(dbConfig)
    val config = HikariConfig()
    config.jdbcUrl = "jdbc:mysql://localhost:3306/mydb?serverTimeZone=UTC"
    config.username = ""
    config.password = ""
    val dataSource = HikariDataSource(config)
    Database.connect(dataSource)
    LoggerFactory.getLogger(Application::class.simpleName).info("Initialized Database")
}