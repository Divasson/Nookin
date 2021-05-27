package nookin.v1.nookingmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtSignupRequest {
	@NonNull
	@NotEmpty
	@Pattern(message="max 10 words please" , regexp="^[a-zA-Z-.0-9]{1,15}$")
	private String name;

	@NonNull
	@NotEmpty
	@Pattern(regexp ="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$")
	private String email;

	@NotNull
	@NotEmpty
	@Pattern(message="max 10 words please" , regexp="^[a-zA-Z-.0-9]{1,15}$")
	private String password;

	@NotNull
	@NotEmpty
	@Pattern(message="max 10 words please" , regexp="^[a-zA-Z-.0-9]{1,15}$")
	private String password2;

	@NotNull
	@NotEmpty
	private int age;

	@NotNull
	@NotEmpty
	private String telephone;
}