package rs.ac.uns.ftn.informatika.svtprojekat.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Admin;
import rs.ac.uns.ftn.informatika.svtprojekat.repository.AdminRepository;
import rs.ac.uns.ftn.informatika.svtprojekat.service.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository repository;

    @Override
    public List<Admin> findAllByParent(Admin parent) {
        return null;
    }

    @Override
    public Admin findOne(Integer id) {
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public Admin save(Admin admin) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
