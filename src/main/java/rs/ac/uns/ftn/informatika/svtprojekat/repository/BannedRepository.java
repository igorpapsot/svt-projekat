package rs.ac.uns.ftn.informatika.svtprojekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Banned;

public interface BannedRepository extends JpaRepository<Banned, Integer> {
}
