package ru.gb.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.gb.dto.IssueRequest;
import ru.gb.service.IssueService;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = IssuesController.class)
public class IssuesControllerTest {

    @MockBean
    private IssueService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetSuccess() throws Exception {
        mockMvc.perform(get("/issue")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(service).getAll();
    }

    @Test
    void testGetIssueById() throws Exception {
        mockMvc.perform(get("/issue/" + 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(service).getIssueById(1L);
    }

    @Test
    void testValidIssueRequest() throws Exception {
        String requestBody = "{\"readerId\": 1, \"bookId\": 1}";
        mockMvc.perform(post("/issue")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
        verify(service).issue(prepareRequest());
    }

    private IssueRequest prepareRequest() {
        IssueRequest issueRequest = new IssueRequest();
        issueRequest.setBookId(1L);
        issueRequest.setReaderId(1L);
        return issueRequest;
    }
}