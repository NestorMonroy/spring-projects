package mx.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;

public class UpdateUserDetailsRequestModel {
    @NotNull(message = "Required firstName")
    private String firstName;
    @NotNull(message = "Required lastName")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
