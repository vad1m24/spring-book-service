package ru.gb.springbookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.springbookservice.model.Issue;

import java.util.Set;

public interface IssuesRepository extends JpaRepository<Issue, Long> {

    Set<Issue> findIssuesByReaderId(long readerId);
}
