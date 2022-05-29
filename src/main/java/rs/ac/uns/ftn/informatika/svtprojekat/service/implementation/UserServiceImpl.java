package rs.ac.uns.ftn.informatika.svtprojekat.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.RoleENUM;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.RegisterDTO;
import rs.ac.uns.ftn.informatika.svtprojekat.repository.UserRepository;
import rs.ac.uns.ftn.informatika.svtprojekat.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<User> findAllByParent(User parent) {
        return null;
    }

    @Override
    public User findOne(Integer id) { return repository.findById(id).orElse(null); }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public User findUserByUsername(String username) {
        Optional<User> user = repository.findFirstByUsername(username);
        if (!user.isEmpty()) {
            return user.get();
        }
        return null;
    }

    @Override
    public User createUser(RegisterDTO userDTO) {

        Optional<User> user = repository.findFirstByUsername(userDTO.getUsername());

        if(user.isPresent()){
            return null;
        }

        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        newUser.setRole(RoleENUM.USER);
        newUser.setAvatar(userDTO.getAvatar());
        newUser.setRegistrationDate(userDTO.getRegistrationDate());
        newUser.setBanned(userDTO.isBanned());
        newUser.setEmail(userDTO.getEmail());
        newUser = repository.save(newUser);

        return newUser;
    }
}
