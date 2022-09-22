package mikkel.kulturservice.service;

import mikkel.kulturservice.modle.User;

import java.util.List;

public interface IUserService extends ICrudService<User,Long> {
    List<User> findUserByName(String name);
}