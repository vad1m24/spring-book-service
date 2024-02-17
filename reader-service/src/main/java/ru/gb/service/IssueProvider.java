package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.gb.api.Issue;

@Service
@RequiredArgsConstructor
public class IssueProvider {

    private final WebClient webClient;

    public Issue getIssueByReaderId(long readerId) {
        return webClient.get().uri("http://issue-service/api/issue/" + readerId).retrieve().bodyToMono(Issue.class).block();
    }
}
