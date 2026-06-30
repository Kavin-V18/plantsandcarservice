package com.example.PlantsCarModule.service;

import com.example.PlantsCarModule.dto.ManufacturingPlantDto;
import com.example.PlantsCarModule.entity.ManufacturingPlant;
import com.example.PlantsCarModule.repository.ManufacturingPlantRepository;
import com.example.PlantsCarModule.util.ManufacturingPlantMapper;
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
         existing.setCapacity_per_day(manufacturingPlantDto.getCapacity_per_day());
         existing.set_active(manufacturingPlantDto.is_active());
        ManufacturingPlant updatedEntity=manufacturingPlantRepository.save(existing);
        return  manufacturingPlantMapper.toDto(updatedEntity);
    }
    @Override
    public void deleteManufacturingPlant(int id) {
        ManufacturingPlant existing=manufacturingPlantRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        manufacturingPlantRepository.deleteById(id);
    }
}

