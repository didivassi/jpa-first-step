package academy.mindswap.jpafirststep.services;

import academy.mindswap.jpafirststep.persistance.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Service
public class UserService {

    private EntityManagerFactory entityManagerFactory;

    public UserService() {
       entityManagerFactory = Persistence.createEntityManagerFactory("dev");
    }

    public User getUserById(Integer id){
        EntityManager em = null;
        try {
            em = entityManagerFactory.createEntityManager();
            System.out.println(id+"ggettinf");
            User user = em.find(User.class, id);
            System.out.println(user);
            return user;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public  List<User> getUsers() {
        EntityManager em = null;
        try {
            em = entityManagerFactory.createEntityManager();

            CriteriaQuery<User> query = em.getCriteriaBuilder().createQuery(User.class);
            // SELECT * FROM students;
            query.select(query.from(User.class));

           /* Query query = em.createQuery("SELECT * FROM students");
            List resultList = query.getResultList();*/
            return em.createQuery(query).getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
