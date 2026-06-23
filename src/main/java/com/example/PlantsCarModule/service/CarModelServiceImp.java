package com.example.PlantsCarModule.service;

import com.example.PlantsCarModule.entity.CarModel;
import com.example.PlantsCarModule.repository.CarModelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CarModelServiceImp implements CarModelService{
    private  final CarModelRepository carModelRepository;

    public CarModelServiceImp(CarModelRepository carModelRepository) {
        this.carModelRepository = carModelRepository;
    }
    @Override
    public CarModel createCarModel(CarModel carModel){
        return  carModelRepository.save(carModel);
    }
    @Override
    public CarModel getCarModelById(@PathVariable int id){
        return  carModelRepository.findById(id).orElseThrow(()->new EntityNotFoundException("CarModel Not Found With Id :"+id));
    }
    @Override
    public List<CarModel> getAllCarModel(){
        return carModelRepository.findAll();
    }
    @Override
    public CarModel updateCarModel(int id, CarModel carModel) {
         CarModel existing=carModelRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No CarModel Found In This Id:"+id));
          existing.setModel_name(carModel.getModel_name());
          existing.setBase_price(carModel.getBase_price());
          existing.setTransmission(carModel.getTransmission());
          existing.setFuelType(carModel.getFuelType());
          existing.setLaunch_date(carModel.getLaunch_date());
          existing.set_active(carModel.is_active());
        return carModelRepository.save(existing);
    }
    @Override
    public void deleteCarModel(int id) {
             carModelRepository.deleteById(id);
    }
}
