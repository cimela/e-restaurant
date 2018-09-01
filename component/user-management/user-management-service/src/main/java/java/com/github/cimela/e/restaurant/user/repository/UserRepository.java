package java.com.github.cimela.e.restaurant.user.repository;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.github.cimela.e.restaurant.base.repository.BaseRepository;
import com.github.cimela.e.restaurant.user.model.User;

@Repository
public interface UserRepository extends BaseRepository<User, ObjectId>, UserCustomRepository {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}
