package com.application;

import com.application.persistence.entity.PermissionEntity;
import com.application.persistence.entity.RoleEntity;
import com.application.persistence.entity.RoleEnum;
import com.application.persistence.entity.UserEntity;
import com.application.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);

	}
		@Bean
		CommandLineRunner init(UserRepository userRepository) {
			return args -> {

				/* CREATE PERMISSIONS */
				PermissionEntity createPermission = PermissionEntity.builder()
						.name("CREATE")
						.build();

				PermissionEntity readPermission = PermissionEntity.builder()
						.name("READ")
						.build();

				PermissionEntity updatePermission = PermissionEntity.builder()
						.name("UPDATE")
						.build();

				PermissionEntity deletePermission = PermissionEntity.builder()
						.name("DELETE")
						.build();

				PermissionEntity refactorPermission = PermissionEntity.builder()
						.name("REFACTOR")
						.build();


				/* CREATE ROLES */
				RoleEntity roleAdmin = RoleEntity.builder()
						.roleEnum(RoleEnum.ADMIN)
						.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
						.build();

				RoleEntity roleUser = RoleEntity.builder()
						.roleEnum(RoleEnum.USER)
						.permissionList(Set.of(createPermission, readPermission))
						.build();

				RoleEntity roleGuest = RoleEntity.builder()
						.roleEnum(RoleEnum.GUEST)
						.permissionList(Set.of(readPermission))
						.build();

				RoleEntity roleDeveloper = RoleEntity.builder()
						.roleEnum(RoleEnum.DEVELOPER)
						.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
						.build();


				/* CREATE USERS */
				UserEntity userMaria = UserEntity.builder()
						.username("maria")
						.password("$2a$10$GBPLWCX1xSEBAmAtHqvjJOYm0M5mDN.KYKlsBxnbFuR0lSTlAKbMi")
						.isEnabled(true)
						.accountNoExpired(true)
						.accountNoLocked(true)
						.credentialNoExpired(true)
						.roles(Set.of(roleAdmin))
						.build();

				UserEntity userCarlos = UserEntity.builder()
						.username("carlos")
						.password("$2a$10$GBPLWCX1xSEBAmAtHqvjJOYm0M5mDN.KYKlsBxnbFuR0lSTlAKbMi")
						.isEnabled(true)
						.accountNoExpired(true)
						.accountNoLocked(true)
						.credentialNoExpired(true)
						.roles(Set.of(roleUser))
						.build();

				UserEntity userSantiago = UserEntity.builder()
						.username("santiago")
						.password("$2a$10$GBPLWCX1xSEBAmAtHqvjJOYm0M5mDN.KYKlsBxnbFuR0lSTlAKbMi")
						.isEnabled(true)
						.accountNoExpired(true)
						.accountNoLocked(true)
						.credentialNoExpired(true)
						.roles(Set.of(roleGuest))
						.build();

				UserEntity userSandra = UserEntity.builder()
						.username("sandra")
						.password("$2a$10$GBPLWCX1xSEBAmAtHqvjJOYm0M5mDN.KYKlsBxnbFuR0lSTlAKbMi")
						.isEnabled(true)
						.accountNoExpired(true)
						.accountNoLocked(true)
						.credentialNoExpired(true)
						.roles(Set.of(roleDeveloper))
						.build();

				userRepository.saveAll(List.of(userMaria, userCarlos, userSantiago, userSandra));
		};
	}
}
