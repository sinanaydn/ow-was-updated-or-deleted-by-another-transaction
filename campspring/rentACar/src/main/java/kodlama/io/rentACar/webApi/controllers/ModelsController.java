package kodlama.io.rentACar.webApi.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;
    
    @GetMapping()
    public List<GetAllModelsResponse> getAll() {
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateModelRequest createModelRequest) {
        modelService.add(createModelRequest);
    }
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable int id) {
        modelService.delete(id);
    }
} 