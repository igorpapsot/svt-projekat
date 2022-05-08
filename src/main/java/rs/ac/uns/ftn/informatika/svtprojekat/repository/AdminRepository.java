package rs.ac.uns.ftn.informatika.svtprojekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
