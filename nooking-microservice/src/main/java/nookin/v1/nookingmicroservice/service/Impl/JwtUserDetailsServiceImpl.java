package nookin.v1.nookingmicroservice.service.Impl;

import java.util.List;


import nookin.v1.nookingmicroservice.model.Usuario;
import nookin.v1.nookingmicroservice.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		final Usuario user = usuarioRepository.getUsuarioByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user found with username: " + username);
		}

		return new User(user.getNombre(),
				user.getContrasena(),
				List.of((GrantedAuthority) () -> "USER"));
	}
}