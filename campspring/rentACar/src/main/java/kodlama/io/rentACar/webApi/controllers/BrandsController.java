package kodlama.io.rentACar.webApi.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;
    
    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }
    
    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
        brandService.add(createBrandRequest);
    }
    
    @PutMapping(path = "/update")
    public void update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest) {
        brandService.update(updateBrandRequest);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }
}
