package java.com.github.cimela.e.restaurant.user.repository;

import org.bson.types.ObjectId;

import com.github.cimela.e.restaurant.base.repository.BaseCustomRepository;
import com.github.cimela.e.restaurant.base.repository.BaseRepository;
import com.github.cimela.e.restaurant.user.model.User;

public interface UserRepository extends BaseRepository<User, ObjectId>, BaseCustomRepository<User, ObjectId> {

}
