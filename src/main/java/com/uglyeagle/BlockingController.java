package com.uglyeagle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlockingController {

	@GetMapping({ "/", "/home" })
	@ResponseBody()
	public String home() {
		return "finally The Rock has come back.................home"; // here the MIME type is plain/text
	}
	
	@GetMapping(value = { "/foo", "/fooo" }, produces = "application/json") // it is better to return a java object like																		// a Map<K,V>
	@ResponseBody()
	public String foo() {
		return "{\"message\":\"hello\"}"; // explicitly returning a JSON string
	}
	
	@GetMapping(value = "/foo1", produces = "application/xml") // it is better to return a java object like																		// a Map<K,V>
	@ResponseBody()
	public String foo1() {
		return "<message>Finally The Rock has come back... home</message>"; // explicitly returning a JSON string
	}

}

// this class is annotated with @Controller which requires the methods to be annotated with @ResponseBody
