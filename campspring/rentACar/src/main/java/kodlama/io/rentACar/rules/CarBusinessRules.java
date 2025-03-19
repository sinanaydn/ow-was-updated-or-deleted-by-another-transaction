package kodlama.io.rentACar.rules;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    private CarRepository carRepository;

    public void checkIfCarPlateExists(String plate) {
        if(this.carRepository.existsByPlate(plate)) {
            throw new BusinessException("Car plate already exists");
        }
    }
}