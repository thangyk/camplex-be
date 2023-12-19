package com.example.camplex.controller.camp;

import com.example.camplex.domain.camp.service.CampService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
public class CampController {

	private final CampService campService;

	@GetMapping("/get-api")
	public Mono<Void> getApi() {
		return campService.saveCampFromApiResponse();
	}
}
