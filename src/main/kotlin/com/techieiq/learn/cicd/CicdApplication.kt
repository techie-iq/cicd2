package com.techieiq.learn.cicd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@SpringBootApplication
class CicdApplication
//http://cicd-one.staging-system.svc.cluster.local:8080
var client = WebClient.create("http://cicd-one.staging-system.svc.cluster.local:8080")
fun main(args: Array<String>) {
    runApplication<CicdApplication>(*args)
}

@RestController
@EnableScheduling
class Controller {

    @Scheduled(fixedDelay = 2000)
   fun getColor() {
        println(callColor().block().toString())
    }
}

fun callColor(): Mono<String> {
    return client.get().uri("/api/color").retrieve().bodyToMono(String::class.java)
}