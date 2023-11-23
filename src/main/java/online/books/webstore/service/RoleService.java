package online.books.webstore.service;

import online.books.webstore.model.Role;

public interface RoleService {
    Role getRoleByRoleName(Role.RoleName roleName);
}
