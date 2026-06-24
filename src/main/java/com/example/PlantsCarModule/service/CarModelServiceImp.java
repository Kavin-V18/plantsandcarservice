package com.example.PlantsCarModule.service;

import com.example.PlantsCarModule.dto.CarModelDto;
import com.example.PlantsCarModule.entity.CarModel;
import com.example.PlantsCarModule.repository.CarModelRepository;
import com.example.PlantsCarModule.util.CarModelMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarModelServiceImp implements CarModelService{
    private  final CarModelRepository carModelRepository;
    private final CarModelMapper carModelMapper;

    public CarModelServiceImp(CarModelRepository carModelRepository, CarModelMapper carModelMapper) {
        this.carModelRepository = carModelRepository;
        this.carModelMapper = carModelMapper;
    }

    @Override
    public CarModelDto createCarModel(CarModelDto carModelDto) {
        CarModel entity = carModelMapper.toEntity(carModelDto); // DTO -> Entity
        CarModel savedEntity = carModelRepository.save(entity);
        return carModelMapper.toDto(savedEntity);
    }

    @Override
    public CarModelDto getCarModelById(int id) {
        CarModel existing=carModelRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        CarModelDto carModelDtos= carModelMapper.toDto(existing);
        return  carModelDtos;
    }

    @Override
    public List<CarModelDto> getAllCarModel() {
        return carModelRepository.findAll().stream().map(carModelMapper::toDto).toList();
    }

    @Override
    public CarModelDto updateCarModel(int id, CarModelDto carModelDto) {
        CarModel existing=carModelRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
         existing.setModel_name(carModelDto.getModel_name());
         existing.setFuelType(carModelDto.getFuelType());
         existing.setTransmission(carModelDto.getTransmission());
         existing.setBase_price(carModelDto.getBase_price());
         existing.setColor_options(carModelDto.getColor_options());
         existing.setLaunch_date(carModelDto.getLaunch_date());
         existing.set_active(carModelDto.is_active());
        CarModel updatedEntity=carModelRepository.save(existing);
        return  carModelMapper.toDto(updatedEntity);
    }

    @Override
    public void deleteCarModel(int id) {
        CarModel existing=carModelRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        carModelRepository.deleteById(id);
    }
}
