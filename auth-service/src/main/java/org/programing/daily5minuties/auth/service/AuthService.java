package org.programing.daily5minuties.auth.service;

import lombok.RequiredArgsConstructor;
import org.programing.daily5minuties.auth.model.User;
import org.programing.daily5minuties.auth.repository.UserRepository;
import org.programing.daily5minuties.auth.request.UserRequest;
import org.programing.daily5minuties.auth.response.FraudCheckResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public void registerUser(UserRequest request) {
        User user = User.builder()
                .userName(request.getUserName())
                .password(request.getPassword())
                .build();

        // todo: check if email valid
        // todo: check if email not taken
        userRepository.saveAndFlush(user);
        // todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD-SERVICE/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                user.getId()
        );

        if (fraudCheckResponse.isFraudster())
            throw new IllegalStateException("frauster");

        // todo: send notification
    }


}
