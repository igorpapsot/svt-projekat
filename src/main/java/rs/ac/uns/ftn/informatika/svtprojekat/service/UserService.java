package rs.ac.uns.ftn.informatika.svtprojekat.service;

import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllByParent(User parent);

    User findOne(Integer id);

    List<User> findAll();

    User save(User user);

    void remove(Integer id);

}
