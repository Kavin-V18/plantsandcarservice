package com.example.PlantsCarModule.service;

import com.example.PlantsCarModule.entity.ManufacturingPlant;
import com.example.PlantsCarModule.repository.ManufacturingPlantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturingPlantServiceImp implements  ManufacturingPlantService {
    private final ManufacturingPlantRepository manufacturingPlantRepository;
    public ManufacturingPlantServiceImp(ManufacturingPlantRepository manufacturingPlantRepository) {
        this.manufacturingPlantRepository = manufacturingPlantRepository;
    }
    @Override
    public ManufacturingPlant createManufacturingPlant(ManufacturingPlant manufacturingPlant) {
        return manufacturingPlantRepository.save((manufacturingPlant));
    }
    @Override
    public ManufacturingPlant getManufacturingPlantById(int id) {
        return manufacturingPlantRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No Manufacturingplant found in this id"));
    }
    @Override
    public List<ManufacturingPlant> getAllManufacturingPlant() {
        return manufacturingPlantRepository.findAll();
    }
    @Override
    public ManufacturingPlant updateManufacturingPlant(int id, ManufacturingPlant manufacturingPlant) {
        ManufacturingPlant existing=manufacturingPlantRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No Manufacturing Plant Found in this id"));

        existing.setName(manufacturingPlant.getName());
        existing.setLocation(manufacturingPlant.getLocation());
        existing.setCapacity_per_day(manufacturingPlant.getCapacity_per_day());
        existing.set_active(manufacturingPlant.is_active());
        return null;
    }
    @Override
    public void deleteManufacturingPlant(int id) {
             manufacturingPlantRepository.deleteById(id);
    }
}
