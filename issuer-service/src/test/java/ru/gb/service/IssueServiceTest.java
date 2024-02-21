package ru.gb.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.api.Book;
import ru.gb.dto.IssueRequest;
import ru.gb.exceptions.ConflictException;
import ru.gb.model.Issue;
import ru.gb.repository.IssuesRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Class for test {@link IssueService}
 */
@ExtendWith(MockitoExtension.class)
public class IssueServiceTest {

    @Mock
    private BookProvider bookProvider;
    @Mock
    private IssuesRepository issueRepository;
    @InjectMocks
    private IssueService issueService;

    @Test
    public void issueNotFountTest() {
        when(bookProvider.getBookById(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> issueService.issue(prepareRequest()));

        verify(bookProvider).getBookById(1L);
    }

    @Test
    public void ConflictTest() {
        when(bookProvider.getBookById(1L)).thenReturn(prepareBook());
        when(issueRepository.findById(1L)).thenReturn(Optional.of(prepareIssue()));

        assertThrows(ConflictException.class, () -> issueService.issue(prepareRequest()));

        verify(bookProvider).getBookById(1L);
        verify(issueRepository).findById(1L);
    }

    @Test
    public void getIssueById() {
        when(issueRepository.findById(1L)).thenReturn(Optional.of(prepareIssue()));

        Issue issue = issueService.getIssueById(1L);

        verify(issueRepository).findById(1L);
        assertEquals(issue, prepareIssue());
    }

    @Test
    public void getIssuesByReaderId() {
        when(issueRepository.findIssuesByReaderId(1L)).thenReturn(Set.of(prepareIssue()));

        Set<Issue> issuesByReaderId = issueService.getIssuesByReaderId(1L);

        verify(issueRepository).findIssuesByReaderId(1L);
        assertEquals(issuesByReaderId, Set.of(prepareIssue()));
    }

    @Test
    public void getAll() {
        when(issueRepository.findAll()).thenReturn(List.of(prepareIssue()));

        List<Issue> issueList = issueService.getAll();

        verify(issueRepository).findAll();
        assertEquals(issueList, List.of(prepareIssue()));
    }

    private IssueRequest prepareRequest() {
        IssueRequest issueRequest = new IssueRequest();
        issueRequest.setBookId(1L);
        issueRequest.setReaderId(1L);
        return issueRequest;
    }

    private Book prepareBook() {
        return new Book();
    }

    private Issue prepareIssue() {
        return new Issue();
    }
}
