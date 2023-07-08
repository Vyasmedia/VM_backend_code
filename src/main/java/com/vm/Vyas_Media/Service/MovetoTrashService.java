package com.vm.Vyas_Media.Service;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vm.Vyas_Media.Entity.MovetoTrash;
import com.vm.Vyas_Media.Repository.MovetoTrashRepository;

@Service
public class MovetoTrashService {

    @Autowired MovetoTrashRepository userRepository;
    @Autowired EntityManager entityManager;

    public List<MovetoTrash> findAllFilter(boolean isDeleted) {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedUserFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<MovetoTrash> users = userRepository.findAll();
        session.disableFilter("deletedUserFilter");
        return users;
    }

    public List<MovetoTrash> findAll() {
        return userRepository.findAll();
    }

    public MovetoTrash save(MovetoTrash user) {
        return userRepository.save(user);
    }

    public MovetoTrash findByContact(String contact) {
        return userRepository.findByContact(contact);
    }

    public Optional<MovetoTrash> findById(Long id) {
        return userRepository.findById(id);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
