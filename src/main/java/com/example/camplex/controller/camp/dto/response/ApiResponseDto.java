package com.example.camplex.controller.camp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ApiResponseDto {

	private Response response;

	@Getter
	public static class Response {
		private Header header;
		private Body body;
	}

	@Getter
	public static class Header {
		private String resultCode;
		private String resultMsg;
	}

	@Getter
	public static class Body {
		private Items items;
	}

	@Getter
	public static class Items {
		private List<Item> item;

	}

	@Getter
	@Builder
	public static class Item {
		private String facltNm;
		private String lineIntro;
		private String firstImageUrl;
		private String addr1;
		private String direction;
		private String doNm;
		private String sigunguNm;
		private String mapX;
		private String mapY;
		private String tel;
		private String homepage;
		private String resveUrl;
		private String operDeCl;
		private String animalCmgCl;
		private String intro;
	}
}