package kodlama.io.rentACar.business.requests;
// Request sınıfları: Client'tan (istemciden) API'ye gelen verilerin modellerini içerir
// Örnek: Yeni marka eklerken sadece gerekli alanları (name) içeren request modeli
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {
    @NotNull
    @NotBlank
    @Size(min = 2, message = "Marka ismi minimum 2 karakter olmalıdır")
    private String name;
} 