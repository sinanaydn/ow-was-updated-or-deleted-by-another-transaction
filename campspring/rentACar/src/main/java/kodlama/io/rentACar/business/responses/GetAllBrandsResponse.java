package kodlama.io.rentACar.business.responses;
// Response sınıfları: API'den client'a (istemciye) dönecek verilerin modellerini içerir
// Örnek: Marka listesi dönerken sadece gerekli alanları (id, name) içeren response modeli
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse {
    private int id;
    private String name;
} 