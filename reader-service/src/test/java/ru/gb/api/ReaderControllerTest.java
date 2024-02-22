package ru.gb.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.gb.ReaderServiceApplication;
import ru.gb.dto.ReaderRequest;
import ru.gb.service.ReaderService;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ReaderController.class)
@ContextConfiguration(classes= ReaderServiceApplication.class)
public class ReaderControllerTest {

    @MockBean
    private ReaderService readerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetSuccess() throws Exception {
        mockMvc.perform(get("/reader")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(readerService).getAll();
    }

    @Test
    void testGetReaderById() throws Exception {
        mockMvc.perform(get("/reader/" + 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(readerService).getReaderById(1L);
    }

    @Test
    void testAddReader() throws Exception {
        String requestBody = "{\"name\": \"name\"}";
        mockMvc.perform(post("/reader")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
        verify(readerService).addReader(prepareRequest());
    }

    @Test
    void testDeleteReaderById() throws Exception {
        mockMvc.perform(delete("/reader/" + 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(readerService).deleteReaderById(1L);
    }

    private ReaderRequest prepareRequest() {
        return new ReaderRequest("name");
    }
}
