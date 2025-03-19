package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {
    private int id;
    
    
    @NotBlank
    @Size(min = 2, message = "Model ismi minimum 2 karakter olmalıdır")
    private String name;
    
    @NotNull
    private int brandId;
} 