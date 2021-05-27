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
public class JwtSignupRequest {
	@NonNull
	@Pattern(message="max 10 words please" , regexp="^[a-zA-Z-.0-9]{1,15}$")
	private String name;

	@NonNull
	@Pattern(regexp ="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$")
	private String email;

	@NotNull
	@Pattern(message="max 10 words please" , regexp="^[a-zA-Z-.0-9]{1,15}$")
	private String password;

	@NotNull
	@Pattern(message="max 10 words please" , regexp="^[a-zA-Z-.0-9]{1,15}$")
	private String password2;

	@NotNull
	private Integer age;

	@NotNull
	private String telephone;

	public JwtSignupRequest(
			@NonNull @Pattern(message = "max 10 words please", regexp = "^[a-zA-Z-.0-9]{1,15}$") String name,
			@NonNull @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$") String email,
			@NotNull @Pattern(message = "max 10 words please", regexp = "^[a-zA-Z-.0-9]{1,15}$") String password,
			@NotNull @Pattern(message = "max 10 words please", regexp = "^[a-zA-Z-.0-9]{1,15}$") String password2,
			@NotNull Integer age, @NotNull @NotEmpty String telephone) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.password2 = password2;
		this.age = age;
		this.telephone = telephone;
	}

	
}