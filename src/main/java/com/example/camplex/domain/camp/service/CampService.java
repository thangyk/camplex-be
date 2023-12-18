package com.example.camplex.domain.camp.service;

import com.example.camplex.domain.camp.repository.CampRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class CampService {

	private final CampRepository campRepository;
}
