package com.example.plant_car.service;

import com.example.plant_car.dto.ManufacturingPlantDto;
import com.example.plant_car.entity.ManufacturingPlant;
import com.example.plant_car.repository.ManufacturingPlantRepository;
import com.example.plant_car.util.ManufacturingPlantMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturingPlantServiceImp implements  ManufacturingPlantService {
    private final ManufacturingPlantRepository manufacturingPlantRepository;
    private  final ManufacturingPlantMapper manufacturingPlantMapper;

    @Override
    public ManufacturingPlantDto createManufacturingPlant(ManufacturingPlantDto manufacturingPlantDto) {
        ManufacturingPlant entity = manufacturingPlantMapper.toEntity(manufacturingPlantDto); // DTO -> Entity
        ManufacturingPlant savedEntity = manufacturingPlantRepository.save(entity);
        return manufacturingPlantMapper.toDto(savedEntity);
    }
    @Override
    public ManufacturingPlantDto getManufacturingPlantById(int id) {
        ManufacturingPlant existing=manufacturingPlantRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        ManufacturingPlantDto manufacturingPlantDto= manufacturingPlantMapper.toDto(existing);
        return  manufacturingPlantDto;
    }
    @Override
    public List<ManufacturingPlantDto> getAllManufacturingPlant() {
        return manufacturingPlantRepository.findAll().stream().map(manufacturingPlantMapper::toDto).toList();
    }
    @Override
    public ManufacturingPlantDto updateManufacturingPlant(int id, ManufacturingPlantDto manufacturingPlantDto) {
        ManufacturingPlant existing=manufacturingPlantRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
         existing.setName(manufacturingPlantDto.getName());
         existing.setCode(manufacturingPlantDto.getCode());
         existing.setLocation(existing.getLocation());
         existing.setCapacityPerDay(manufacturingPlantDto.getCapacityPerDay());
         existing.setActive(manufacturingPlantDto.getActive());
        ManufacturingPlant updatedEntity=manufacturingPlantRepository.save(existing);
        return  manufacturingPlantMapper.toDto(updatedEntity);
    }
    @Override
    public void deleteManufacturingPlant(int id) {
        ManufacturingPlant existing=manufacturingPlantRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        manufacturingPlantRepository.deleteById(id);
    }

    @Override
    public Boolean existsById(int id) {
        return manufacturingPlantRepository.existsById(id);
    }
}

