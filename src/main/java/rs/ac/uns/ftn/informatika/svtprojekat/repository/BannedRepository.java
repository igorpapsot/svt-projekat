package rs.ac.uns.ftn.informatika.svtprojekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Banned;

@Repository
public interface BannedRepository extends JpaRepository<Banned, Integer> {
}
