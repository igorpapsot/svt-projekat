package rs.ac.uns.ftn.informatika.svtprojekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
