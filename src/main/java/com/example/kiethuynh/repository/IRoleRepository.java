//package com.example.kiethuynh.repository;
//
//import com.example.kiethuynh.entity.Category;
//import com.example.kiethuynh.entity.Role;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface IRoleRepository extends JpaRepository<Role,Long> {
//    @Query("Select r.id from role r where r.name = ?1")
//    Long getRoleIdByName(String roleName);
//}
