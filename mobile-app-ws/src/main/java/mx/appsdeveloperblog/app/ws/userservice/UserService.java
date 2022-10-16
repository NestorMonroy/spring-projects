package mx.appsdeveloperblog.app.ws.userservice;

import mx.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import mx.appsdeveloperblog.app.ws.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetail);
}
