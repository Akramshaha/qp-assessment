package com.akrams.qp_assessment.service.impl;

import com.akrams.qp_assessment.dto.GroceryDto;
import com.akrams.qp_assessment.model.Grocery;
import com.akrams.qp_assessment.repository.GroceryRepository;
import com.akrams.qp_assessment.service.GroceryService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class GroceryServiceImpl implements GroceryService {

    Logger logger = LoggerFactory.getLogger(GroceryServiceImpl.class);

    @Autowired
    private GroceryRepository groceryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GroceryDto addNewGrocery(GroceryDto groceryDto) {
        Grocery grocery = new Grocery();
        grocery = convertDTOtoModel(grocery, groceryDto);
        return convertModeltoDto(groceryDto,groceryRepository.save(grocery));
    }

    @Override
    public GroceryDto updateGrocery(GroceryDto groceryDto) {
        Grocery grocery = groceryRepository.findById(groceryDto.getGroceryId()).get();
        grocery = convertDTOtoModel(grocery, groceryDto);
        return convertModeltoDto(groceryDto,groceryRepository.save(grocery));
    }

    @Override
    public void removeGrocery(Integer id) {
        groceryRepository.deleteById(id);
    }

    @Override
    public List<Grocery> findAllGroceries() {
        return groceryRepository.findAll();
    }

    @Override
    public GroceryDto findById(Integer id) {
        return convertModeltoDto(new GroceryDto(),groceryRepository.findById(id).get());
    }

    public Grocery convertDTOtoModel(Grocery grocery, GroceryDto groceryDto){
       if(groceryDto.getGroceryId() != null) {
            grocery.setId(groceryDto.getGroceryId());
        }
        if(StringUtils.hasText(groceryDto.getName())) {
            grocery.setName(groceryDto.getName());
        }
        if(groceryDto.getPrice() != null) {
            grocery.setPrice(groceryDto.getPrice());
        }
        return grocery;
    }

    public GroceryDto convertModeltoDto(GroceryDto groceryDto,Grocery grocery){
        groceryDto.setGroceryId(grocery.getId());
        groceryDto.setName(grocery.getName());
        groceryDto.setPrice(grocery.getPrice());
        groceryDto.setUpdatedAt(grocery.getUpdatedAt());
        groceryDto.setAddedAt(grocery.getAddedAt());
        return groceryDto;
    }
}
