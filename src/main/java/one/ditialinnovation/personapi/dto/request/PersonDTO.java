package one.ditialinnovation.personapi.dto.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;
    
    @NotEmpty
    private String cpf;

    private LocalDate birthDate;

    //@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @NotEmpty
    private List<PhoneDTO> phone;
}
