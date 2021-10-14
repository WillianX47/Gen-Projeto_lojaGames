package com.gen.lojagames.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gen.lojagames.model.UsuarioModel;
import com.gen.lojagames.repository.UsuarioRepository;

/**
 * Classe base para security
 * 
 * @author Eduardo
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioModel> user = repository.findByUsuario(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username + "Not Found"));
		return user.map(UserDetailsImpl::new).get();

	}

}
