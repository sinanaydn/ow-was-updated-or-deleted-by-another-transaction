package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    @NotNull
    @NotBlank
    @Size(min = 2, message = "Plaka ismi minimum 2 karakter olmalıdır")
    private String plate;
    
    @NotNull
    @Min(value = 0, message = "Günlük fiyat sıfırdan büyük olmalıdır")
    private double dailyPrice;
    
    @NotNull
    @Min(value = 1900, message = "Model yılı 1900'den büyük olmalıdır")
    private int modelYear;
    
    private int state;
    
    @NotNull
    private int modelId;
}
