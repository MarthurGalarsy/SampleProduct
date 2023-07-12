package com.example.sampleproduct

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SampleProductApplication

fun main(args: Array<String>) {
	runApplication<SampleProductApplication>(*args)
}
