package kodlama.io.rentACar.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.rules.CarBusinessRules;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private CarBusinessRules carBusinessRules;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
            .map(car -> modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
            .collect(Collectors.toList());
    }   

    @Override
    public void add(CreateCarRequest createCarRequest) {
        carBusinessRules.checkIfCarPlateExists(createCarRequest.getPlate());
        Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        carBusinessRules.checkIfCarPlateExists(updateCarRequest.getPlate());
        Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
        carRepository.save(car);
    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }
}





