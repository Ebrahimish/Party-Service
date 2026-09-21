package com.example.usermonitoring.service;


import com.example.usermonitoring.dto.UserRequest;
import java.util.List;
import com.example.usermonitoring.entity.User;
import com.example.usermonitoring.repository.UserRepository;
import org.springframework.stereotype.Service;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;


@Service
public class UserService {

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    private final UserRepository userRepository;
    private final Counter searchCounter;
    private final Counter createCounter;


    public UserService(
            UserRepository userRepository,
            MeterRegistry meterRegistry) {


        this.userRepository = userRepository;


        this.searchCounter =
                Counter.builder("user.search.count")
                        .description("Number of user searches")
                        .register(meterRegistry);

        this.createCounter = Counter.builder("user.create.count")
                .description("Number of created users")
                .register(meterRegistry);

    }


    public User findById(Long id) {

        return userRepository.findById(id)
                .orElse(null);
    }

    public User findByNationalId(String nationalId) {
        searchCounter.increment();
        return userRepository.findByNationalId(nationalId);
    }
    public User findNativeByNationalId(String nationalId) {
        searchCounter.increment();
        return userRepository.findNativeByNationalId(nationalId);

    }
    public User saveUser(UserRequest request) {

        createCounter.increment();

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setNationalId(request.getNationalId());

        return userRepository.save(user);
    }


}