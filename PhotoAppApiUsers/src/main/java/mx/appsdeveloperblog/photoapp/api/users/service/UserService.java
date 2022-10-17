package mx.appsdeveloperblog.photoapp.api.users.service;

import mx.appsdeveloperblog.photoapp.api.users.shared.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDetails);
}
