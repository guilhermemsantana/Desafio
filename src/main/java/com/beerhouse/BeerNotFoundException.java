package com.beerhouse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "beer not found")
public class BeerNotFoundException extends RuntimeException {
}