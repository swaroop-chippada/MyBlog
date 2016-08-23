package mypage.service;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mypage.dao.DataStoreTemplate;
import mypage.domain.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	Datastore dataStore;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = getUserDetail(username);
		org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(
				user.getUserName(), user.getPassword(), true, true, true, true, getAuthorities(user.getRole()));
		return userDetail;
	}

	public List<GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		if (role.intValue() == 1) {
			authList.add(new SimpleGrantedAuthority("ROLE_USER"));
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		} else if (role.intValue() == 2) {
			authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		return authList;
	}

	public User getUserDetail(String userName) {
		Query<User> user = dataStore.find(User.class, "userName", userName);
		return user.get();
	}

	public void saveNewUser(User user) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dataStore.save(user);
	}

	@Autowired
	public void setDataStoreTemplate(DataStoreTemplate dataStoreTemplate) {
		this.dataStore = dataStoreTemplate.getDataStore();
	}

}