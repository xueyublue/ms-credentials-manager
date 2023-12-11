package sg.darren.ms.credentials.manager.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CredentialsCreateReqDto {

    @NotBlank
    private String appName;

    private String loginId;

    @NotBlank
    private String password;

    private String remarks;

}
