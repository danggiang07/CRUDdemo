package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.User;
//@Repository Đánh dấu một Class Là tầng Repository, phục vụ truy xuất dữ liệu.
public interface UserRepository extends CrudRepository<User, String>{
// cung cấp phương thức crud k cần phải viết query
}
