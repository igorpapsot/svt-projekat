package rs.ac.uns.ftn.informatika.svtprojekat.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Flair;
import rs.ac.uns.ftn.informatika.svtprojekat.repository.FlairRepository;
import rs.ac.uns.ftn.informatika.svtprojekat.service.FlairService;

import java.util.List;

public class FlairServiceImpl implements FlairService {

    @Autowired
    FlairRepository repository;

    @Override
    public List<Flair> findAllByParent(Flair parent) {
        return null;
    }

    @Override
    public Flair findOne(Integer id) {
        return null;
    }

    @Override
    public List<Flair> findAll() {
        return null;
    }

    @Override
    public Flair save(Flair flair) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
