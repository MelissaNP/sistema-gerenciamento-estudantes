package tech.ada.java.gerenciamento.estudantes.gerenciamentoestudantes.Model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

//DTO
@Getter
public class TurmaRequest {

    @NotBlank(message = "{nomeTurma.not.blank}")
    private String nomeTurma;

    private Boolean estaAtiva;

    public Turma toEntity() {
        return new Turma(nomeTurma, estaAtiva);
    }
}
