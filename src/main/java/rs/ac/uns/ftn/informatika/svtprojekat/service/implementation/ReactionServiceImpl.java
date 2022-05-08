package rs.ac.uns.ftn.informatika.svtprojekat.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Reaction;
import rs.ac.uns.ftn.informatika.svtprojekat.repository.ReactionRepository;
import rs.ac.uns.ftn.informatika.svtprojekat.service.ReactionService;

import java.util.List;

@Service
public class ReactionServiceImpl implements ReactionService {

    @Autowired
    ReactionRepository repository;

    @Override
    public List<Reaction> findAllByParent(Reaction parent) {
        return null;
    }

    @Override
    public Reaction findOne(Integer id) {
        return null;
    }

    @Override
    public List<Reaction> findAll() {
        return null;
    }

    @Override
    public Reaction save(Reaction reaction) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
