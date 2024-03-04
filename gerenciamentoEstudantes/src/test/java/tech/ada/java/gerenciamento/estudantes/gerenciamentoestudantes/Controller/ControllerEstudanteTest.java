package tech.ada.java.gerenciamento.estudantes.gerenciamentoestudantes.Controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import tech.ada.java.gerenciamento.estudantes.gerenciamentoestudantes.DTOS.EstudanteCadastroDTO;
import tech.ada.java.gerenciamento.estudantes.gerenciamentoestudantes.Model.Estudante;
import tech.ada.java.gerenciamento.estudantes.gerenciamentoestudantes.Repository.RepositorioEstudante;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
org.springframework.http.MediaType;


@ExtendWith(MockitoExtension.class)
public class ControllerEstudanteTest {
    @Mock
    private Estudante estudante;

    @InjectMocks
    private ControllerEstudante controllerEstudante;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        estudante = new Estudante ();
        mockMvc = MockMvcBuilders.standaloneSetup(controllerEstudante).build();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

  
    @Test
    void cadastrarEstudanteHttpTest() throws Exception {
        when(controllerEstudante.cadastrarEstudante(Mockito.any())).thenReturn(ResponseEntity.status(HttpStatus.CREATED).body(estudante));

        mockMvc.perform(MockMvcRequestBuilders.post("/estudante")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(estudante)))
                .andExpect(ResponseEntity.status(HttpStatus.CREATED).body(estudante));
        verify(controllerEstudante, times(1)).cadastrarEstudante(Mockito.any());
    }




    @Test
    void testEditarTudoEstudante() {

    }

    @Test
    void testFiltrarEstudanteId() {

    }

    @Test
    void testFiltrarEstudanteNome() {

    }

    @Test
    void testFiltrarStatusTurma() {

    }

    @Test
    void testListarTodosEstudantes() {

    }
}
