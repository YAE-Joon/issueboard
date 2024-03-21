package board.issue.entity.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UsersDTO {

    @NotEmpty
    private String userId;

    @NotEmpty
    private String password;
}
