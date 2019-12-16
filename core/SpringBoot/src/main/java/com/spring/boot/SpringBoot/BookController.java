package com.spring.boot.SpringBoot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@GetMapping("/books")
	public List<Book> getBooks() {
		return Arrays.asList(new Book[] {new Book(1, "The Universe in a Nutshell ", "Stephen Hawking (:")});
	}
}
