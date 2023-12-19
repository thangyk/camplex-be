package com.example.camplex.domain.camp.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Camp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String facltNm;	// 캠핑장 이름
	private String lineIntro;	// 한줄소개
	private String firstImageUrl;	// 대표이미지
	private String addr1;	// 주소
	private String direction;	// 오시는길
	private String doNm;	// 도 이름
	private String sigunguNm;	// 시군구 이름
	private String mapX;	// x좌표
	private String mapY;	// y좌표
	private String tel;		// 전화번호
	private String homepage;	// 홈페이지
	private String resveUrl;	// 예약페이지
	private String operDeCl;	// 운영일
	private String animalCmgCl;	// 애완동물출입
	@Column(columnDefinition = "TEXT")
	private String intro;	// 소개


}
