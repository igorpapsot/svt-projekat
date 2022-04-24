package rs.ac.uns.ftn.informatika.svtprojekat.service;

import rs.ac.uns.ftn.informatika.svtprojekat.entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> findAllByParent(Admin parent);

    Admin findOne(Integer id);

    List<Admin> findAll();

    Admin save(Admin admin);

    void remove(Integer id);

}
