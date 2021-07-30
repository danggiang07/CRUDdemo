package com.example.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.User;
import com.sun.xml.bind.v2.schemagen.xmlschema.Appinfo;

//@SpringBootApplication là một chú thích tiện lợi bổ sung tất cả những điều sau:
//
//@Configuration: Gắn thẻ lớp như một nguồn định nghĩa bean cho ngữ cảnh ứng dụng.
//
//@EnableAutoConfiguration: Cho Spring Boot bắt đầu thêm các bean dựa trên cài đặt classpath, các bean khác và các cài đặt thuộc tính khác nhau. Ví dụ: nếu spring-webmvcnằm trên classpath, chú thích này sẽ gắn cờ ứng dụng là ứng dụng web và kích hoạt các hành vi chính, chẳng hạn như thiết lập a DispatcherServlet.
//
//@ComponentScan: Yêu cầu Spring tìm kiếm các thành phần, cấu hình và dịch vụ khác trong com/examplegói, cho phép nó tìm thấy bộ điều khiển.
@SpringBootApplication

public class Crud2Application{

	
	public static void main(String[] args) {
		SpringApplication.run(Crud2Application.class, args);
		
    
	}

	@Bean(name = "USER_BEAN")
	public User setUser() {
		User u = new User();
		u.setUsername("admin");
		u.setPassword("123");
		return u;
	}
}
