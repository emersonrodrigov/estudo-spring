package br.edu.utfpr.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.utfpr.spring.security.model.Usuario;
import br.edu.utfpr.spring.security.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	private UsuarioRepository usuarioRepositorio;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepositorio = usuarioRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByUsername(username);
		if(usuario == null){
			throw new UsernameNotFoundException("Login invalido");
		}
		return usuario;
	}

}
