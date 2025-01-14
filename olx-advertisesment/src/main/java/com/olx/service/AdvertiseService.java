package com.olx.service;

import java.util.List;

import com.olx.dto.AdvertiseDto;
import com.olx.entity.AdvertiseEntity;

public interface AdvertiseService {

	AdvertiseDto createAdvertise(AdvertiseDto advertiseDto);

	AdvertiseDto updateAdvertise(int id, AdvertiseDto advertiseDto);

	List<AdvertiseDto> getAllAdvertise();

	AdvertiseDto getAdvertiseById(int id);

	boolean deleteById(int id);

	List<AdvertiseDto> searchAddByFilter(String searchText, String title, String description, String postedBy,
			String sortBy, Integer startIndex, Integer records);


}
