package ru.gb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.gb.model.Issue;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class IssuesRepositoryTest {

    @Autowired
    private IssuesRepository issuesRepository;

    @Test
    void findIssuesByReaderId() {

        Issue issue = new Issue();
        issue.setId(1L);
        issue.setReaderId(1L);
        Issue issue2 = new Issue();
        issue2.setId(2L);
        issue2.setReaderId(1L);
        Issue issue3 = new Issue();
        issue3.setId(3L);
        issue3.setReaderId(2L);

        issuesRepository.saveAll(Set.of(issue, issue2, issue3));
        Set<Issue> issuesByReaderId = issuesRepository.findIssuesByReaderId(1L);

        assertFalse(issuesByReaderId.contains(issue3));
        assertTrue(issuesByReaderId.size() == 2);
        assertTrue(issuesByReaderId.contains(issue2));
        assertTrue(issuesByReaderId.contains(issue));
    }
}
