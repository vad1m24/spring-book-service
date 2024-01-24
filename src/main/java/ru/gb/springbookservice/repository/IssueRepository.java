package ru.gb.springbookservice.repository;

import org.springframework.stereotype.Repository;
import ru.gb.springbookservice.model.Issue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class IssueRepository {

    private final List<Issue> issues;

    public IssueRepository() {
        this.issues = new ArrayList<>();
    }

    public void save(Issue issue) {
        // insert into ....
        issues.add(issue);
    }

    public Issue getIssueById(long id) {
        return issues.stream().filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Set<Issue> getIssuesByReaderId(long readerId) {
        return issues.stream().filter(it -> Objects.equals(it.getReaderId(), readerId)).collect(Collectors.toSet());
    }

    public List<Issue> getIssues() {
        return issues;
    }


}
