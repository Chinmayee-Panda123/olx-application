package com.olx.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.AdvertiseDto;
import com.olx.entity.AdvertiseEntity;
import com.olx.exception.ResourceNotFoundException;
import com.olx.repository.AdvertiseRepository;

import jakarta.transaction.Transactional;


@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	@Autowired
	private AdvertiseRepository addRepo;
	@Autowired
	private ModelMapper modelMapper;
	
//	@Autowired
//	private CategoryRepository categoryRepo;
//	private StatusRepository statusRepo;

	@Override
	public AdvertiseDto createAdvertise(AdvertiseDto advertiseDto) {
		//code to fetch category and status by their ids and the values needed
		AdvertiseEntity advertiseEntity = modelMapper.map(advertiseDto, AdvertiseEntity.class);
		
		advertiseEntity.setCreatedDate(LocalDate.now());
		advertiseEntity.setModifiedDate(LocalDate.now());
		advertiseEntity.setActive("1");
		
		AdvertiseEntity savedAdd = addRepo.save(advertiseEntity);
		return modelMapper.map(savedAdd, AdvertiseDto.class);
		
	}

	@Override
	public AdvertiseDto updateAdvertise(int id, AdvertiseDto advertiseDto) {

	    Optional<AdvertiseEntity> add = addRepo.findById(id);

	    if(!add.isPresent()) {
	        throw new ResourceNotFoundException("Advertise with id " + id + " not found");
	    }
	    
	    AdvertiseEntity existingAdd = add.get();
	    existingAdd.setTitle(advertiseDto.getTitle());
	    existingAdd.setDescription(advertiseDto.getDescription());
	    existingAdd.setPrice(advertiseDto.getPrice());
	    existingAdd.setModifiedDate(LocalDate.now());
	    
	    AdvertiseEntity updatedAdd = addRepo.save(existingAdd);
	    return modelMapper.map(updatedAdd, AdvertiseDto.class);
	}

	@Override
	public List<AdvertiseDto> getAllAdvertise() {
	    List<AdvertiseEntity> adds = addRepo.findAll();
	    return adds.stream()                                                     
	               .map(ad -> modelMapper.map(ad, AdvertiseDto.class))
	               .collect(Collectors.toList());                           //streams to map each entity to a DTO, ensuring all entries are properly converted.
	}



	@Override
	public AdvertiseDto getAdvertiseById(int id) {
		Optional<AdvertiseEntity> add= addRepo.findById(id);
		if(!add.isPresent()) {
			throw new ResourceNotFoundException("Advertise with id " + id + " not found");
		}
		return modelMapper.map(add, AdvertiseDto.class);
	}

	@Override
	public boolean deleteById(int id) {
		Optional<AdvertiseEntity> add = addRepo.findById(id);
		if(!add.isPresent()) {
			throw new ResourceNotFoundException("Advertise with id " + id + " not found");
		}	
		addRepo.deleteById(id);
		return true;
	}

	
	
}

