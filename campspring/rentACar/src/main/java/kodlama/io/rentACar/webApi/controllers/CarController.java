package kodlama.io.rentACar.webApi.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {
    private CarService carService;

    @GetMapping()
    public List<GetAllCarsResponse> getAll() {
        return carService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateCarRequest createCarRequest) {
        carService.add(createCarRequest);
    }

    @PutMapping(path = "/{id}")
    public void update( @RequestBody @Valid UpdateCarRequest updateCarRequest) {
        carService.update( updateCarRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        carService.delete(id);
    }
}