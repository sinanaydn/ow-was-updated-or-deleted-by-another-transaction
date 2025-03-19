package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import kodlama.io.rentACar.rules.ModelBusinessRules;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    private ModelBusinessRules modelBusinessRules;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
                .collect(Collectors.toList());
        return modelsResponse;
    }

    @Override
    public GetByIdModelResponse getById(int id) {
        Model model = modelRepository.findById(id).orElseThrow();
        return modelMapperService.forResponse().map(model, GetByIdModelResponse.class);
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        modelBusinessRules.checkIfModelNameExists(createModelRequest.getName());
        Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
        modelRepository.save(model);
    }

    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }
}