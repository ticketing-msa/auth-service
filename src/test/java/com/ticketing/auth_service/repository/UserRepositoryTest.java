package com.ticketing.auth_service.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.ticketing.auth_service.entity.User;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Test
	void findByUsername() {
		// given
		User user = createUser("test", "email", "password");
		userRepository.save(user);

		// when
		Optional<User> findUser = userRepository.findByUsername(user.getUsername());

		// then
		assertTrue(findUser.isPresent());
		assertNotNull(findUser.get().getId());
		assertEquals(user.getUsername(), findUser.get().getUsername());
		assertEquals(user.getEmail(), findUser.get().getEmail());
	}

	User createUser(String username, String email, String password) {
		return User.builder()
				.username(username)
				.email(email)
				.passwordHash(password)
				.build();
	}
}