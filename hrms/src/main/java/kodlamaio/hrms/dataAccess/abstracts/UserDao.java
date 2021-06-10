package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.User;

public interface UserDao<T extends User> extends JpaRepository<T, Integer> {
    boolean existsByEmail(String email);
}
