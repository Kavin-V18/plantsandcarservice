package com.example.plant_car.service;

import com.example.plant_car.dto.CarModelDto;
import com.example.plant_car.entity.CarModel;
import com.example.plant_car.repository.CarModelRepository;
import com.example.plant_car.util.CarModelMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarModelServiceImp implements CarModelService{
    private  final CarModelRepository carModelRepository;
    private final CarModelMapper carModelMapper;

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
         existing.setModelName(carModelDto.getModelName());
         existing.setFuelType(carModelDto.getFuelType());
         existing.setTransmission(carModelDto.getTransmission());
         existing.setBasePrice(carModelDto.getBasePrice());
         existing.setColorOptions(carModelDto.getColorOptions());
         existing.setLaunchDate(carModelDto.getLaunchDate());
         existing.setActive(carModelDto.getActive());
        CarModel updatedEntity=carModelRepository.save(existing);
        return  carModelMapper.toDto(updatedEntity);
    }
    @Override
    public void deleteCarModel(int id) {
        CarModel existing=carModelRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        carModelRepository.deleteById(id);
    }
    @Override
    public Boolean existsById(int id) {
        return carModelRepository.existsById(id);
    }
}
