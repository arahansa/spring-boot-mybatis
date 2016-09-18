package sample.springboot.mybatis.xmlconfig.service;

import java.util.List;
import java.util.Map;

import org.springframework.boot.mybatis.autoconfigure.Mapper;

@Mapper
public interface MemberMapper {
	List<Member> findAll();
	Member findById(Long id);

	List<Map<String,Object>> findAllMap();

	List<Map<String,String>> findAllString();

	int saveMember(Member member);

	int deleteMember();
}
