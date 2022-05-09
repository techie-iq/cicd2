package com.techieiq.learn.endpoint

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@SpringBootApplication
class EndpointApplication
//http://cicd-one.staging-system.svc.cluster.local:8080
var client = WebClient.create("http://color.staging-system.svc.cluster.local:8080")
fun main(args: Array<String>) {
    runApplication<EndpointApplication>(*args)
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
    print("Calling the color service")
    return client.get().uri("/api/color").retrieve().bodyToMono(String::class.java)
}