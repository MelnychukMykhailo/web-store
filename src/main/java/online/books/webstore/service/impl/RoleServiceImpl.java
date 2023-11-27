package online.books.webstore.service.impl;

import lombok.RequiredArgsConstructor;
import online.books.webstore.exception.EntityNotFoundException;
import online.books.webstore.model.Role;
import online.books.webstore.repository.RoleRepository;
import online.books.webstore.service.RoleService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role getRoleByRoleName(Role.RoleName roleName) {
        return roleRepository.findRoleByRoleName(roleName)
                .orElseThrow(() -> new EntityNotFoundException("Can't find"
                        + " role by role name:" + roleName));
    }
}
