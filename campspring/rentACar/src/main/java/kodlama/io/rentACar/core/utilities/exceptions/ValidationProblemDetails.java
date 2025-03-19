package kodlama.io.rentACar.core.utilities.exceptions;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {
    private Map<String, String> validationErrors;
} 