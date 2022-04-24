package rs.ac.uns.ftn.informatika.svtprojekat.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;
import rs.ac.uns.ftn.informatika.svtprojekat.repository.UserRepository;
import rs.ac.uns.ftn.informatika.svtprojekat.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public List<User> findAllByParent(User parent) {
        return null;
    }

    @Override
    public User findOne(Integer id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
