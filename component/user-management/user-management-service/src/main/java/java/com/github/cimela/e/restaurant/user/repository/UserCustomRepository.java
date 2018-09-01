package java.com.github.cimela.e.restaurant.user.repository;

import org.bson.types.ObjectId;

import com.github.cimela.e.restaurant.base.repository.BaseCustomRepository;
import com.github.cimela.e.restaurant.user.model.User;

public interface UserCustomRepository extends BaseCustomRepository<User, ObjectId> {
    void insert(User user);
}
