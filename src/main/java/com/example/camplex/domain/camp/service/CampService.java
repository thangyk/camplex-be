package com.example.camplex.domain.camp.service;

import com.example.camplex.controller.camp.dto.response.ApiResponseDto;
import com.example.camplex.domain.camp.entity.Camp;
import com.example.camplex.domain.camp.repository.CampRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CampService {

	@Value("${gocamping.key}")
	private String apiKey;
	private final WebClient.Builder webClientBuilder;
	private final CampRepository campRepository;

	public Mono<List<ApiResponseDto.Item>> getApi() {
		String BASE_URL = "https://apis.data.go.kr/B551011/GoCamping";

		WebClient webClient = webClientBuilder.baseUrl(BASE_URL)
			.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
			.build();

		return webClient.get()
			.uri(uriBuilder -> uriBuilder.path("/basedList")
				.queryParam("numOfRows", 5)
				.queryParam("pageNo", 1)
				.queryParam("MobileOS", "WIN")
				.queryParam("MobileApp", "camplex")
				.queryParam("serviceKey", apiKey)
				.queryParam("_type", "json")
				.build())
			.retrieve()
			.bodyToMono(ApiResponseDto.class)
			.map(ApiResponseDto::getResponse)
			.map(ApiResponseDto.Response::getBody)
			.map(ApiResponseDto.Body::getItems)
			.map(ApiResponseDto.Items::getItem);
	}

	public Camp mapToCampEntity(ApiResponseDto.Item item) {

		return Camp.builder()
			.facltNm(item.getFacltNm())
			.lineIntro(item.getLineIntro())
			.firstImageUrl(item.getFirstImageUrl())
			.addr1(item.getAddr1())
			.direction(item.getDirection())
			.doNm(item.getDoNm())
			.sigunguNm(item.getSigunguNm())
			.mapX(item.getMapX())
			.mapY(item.getMapY())
			.tel(item.getTel())
			.homepage(item.getHomepage())
			.resveUrl(item.getResveUrl())
			.operDeCl(item.getOperDeCl())
			.animalCmgCl(item.getAnimalCmgCl())
			.intro(item.getIntro())
			.build();
	}

	public Mono<Void> saveCampFromApiResponse() {
		return getApi()
			.flatMapMany(Flux::fromIterable)
			.flatMap(item -> {
				Camp camp = mapToCampEntity(item);
				return Mono.fromRunnable(() -> {
					campRepository.save(camp);
					log.info("Camp saved: {}", camp);
				});
			})
			.then();
	}

}