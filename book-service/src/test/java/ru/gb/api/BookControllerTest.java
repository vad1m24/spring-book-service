package ru.gb.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.gb.dto.BookRequest;
import ru.gb.service.BookService;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BookController.class)
public class BookControllerTest {

    @MockBean
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetSuccess() throws Exception {
        mockMvc.perform(get("/book")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(bookService).getAll();
    }

    @Test
    void testGetBookById() throws Exception {
        mockMvc.perform(get("/book/" + 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(bookService).getBookById(1L);
    }

    @Test
    void testAddBook() throws Exception {
        String requestBody = "{\"name\": \"name\"}";
        mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
        verify(bookService).addBook(prepareRequest());
    }

    @Test
    void testDeleteBookById() throws Exception {
        mockMvc.perform(delete("/book/" + 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(bookService).deleteBookById(1L);
    }

    private BookRequest prepareRequest() {
        return new BookRequest("name");
    }
}
