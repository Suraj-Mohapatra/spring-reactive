package com.uglyeagle;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveController {

	@GetMapping("/rctv")
	public Mono<String> foo() {
		return Mono.just("hello from reactive foo");
	}
	
	@GetMapping("/rctv2")
	public Mono<Map<String,String>> foo2(){
		return Mono.just(Map.of("key1","value1"));
	}
	
	@GetMapping("/users")
	public Mono<List<String>> getUsers() {
	    return Mono.just(List.of("rock", "austin", "cena"));
	}
	
	@GetMapping("/names")
	public Flux<String> streamNames() {
	    return Flux.just("rock", "austin", "cena");
	}
	
	@GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> streamEvents() {
	    return Flux.interval(Duration.ofSeconds(1))
	               .map(seq -> "tick " + seq);
	}

}
