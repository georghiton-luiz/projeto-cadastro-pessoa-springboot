package one.ditialinnovation.personapi.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.ditialinnovation.personapi.enums.PhoneType;

//@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    //@Column(nullable = false)
    private PhoneType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;     
}
