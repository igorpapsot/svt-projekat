package rs.ac.uns.ftn.informatika.svtprojekat.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Moderator;
import rs.ac.uns.ftn.informatika.svtprojekat.repository.ModeratorRepository;
import rs.ac.uns.ftn.informatika.svtprojekat.service.ModeratorService;

import java.util.List;

public class ModeratorServiceImpl implements ModeratorService {

    @Autowired
    ModeratorRepository repository;

    @Override
    public List<Moderator> findAllByParent(Moderator parent) {
        return null;
    }

    @Override
    public Moderator findOne(Integer id) {
        return null;
    }

    @Override
    public List<Moderator> findAll() {
        return null;
    }

    @Override
    public Moderator save(Moderator moderator) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
