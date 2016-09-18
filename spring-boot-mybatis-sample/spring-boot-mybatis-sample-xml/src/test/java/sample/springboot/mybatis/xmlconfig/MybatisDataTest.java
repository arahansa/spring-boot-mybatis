package sample.springboot.mybatis.xmlconfig;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import sample.springboot.mybatis.xmlconfig.service.Member;
import sample.springboot.mybatis.xmlconfig.service.MemberMapper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
/**
 * Created by jarvis on 2016. 9. 19..
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleApplication.class)
@WebAppConfiguration

public class MybatisDataTest {

  @Autowired
  WebApplicationContext wac;

  MockMvc mockMvc;

  @Autowired
  MemberMapper memberMapper;

  @Before
  public void init() {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac)
            .alwaysDo(print())
            .build();

    memberMapper.deleteMember();
    for (Long i=0L; i<1000;i++){
      Member member = new Member();
      member.setId(Long.valueOf(i));
      member.setName("member"+i);
      member.setPhone("member"+i);
      memberMapper.saveMember(member);
    }
  }

  static LocalDateTime before, after;

  @Test
  public void strTest() throws Exception{
    before = LocalDateTime.now();
    final List<Map<String, String>> allString = memberMapper.findAllString();
    after = LocalDateTime.now();
    log.info("all Map : {}", allString);
    long betweenString = ChronoUnit.MILLIS.between(before, after);
    log.info("MapStr Between : {}", betweenString);
  }

  @Test
  public void objTest() throws Exception{
    before = LocalDateTime.now();
    final List<Member> all = memberMapper.findAll();
    log.info("all : {}", all);
    after = LocalDateTime.now();
    long between = ChronoUnit.MILLIS.between(before, after);
    log.info("Member Between : {}", between);
  }

  @Test
  public void mapTest() throws Exception{
    before = LocalDateTime.now();
    final List<Map<String, Object>> allMap = memberMapper.findAllMap();
    after = LocalDateTime.now();
    log.info("all Map : {}", allMap);
    long betweenMap = ChronoUnit.MILLIS.between(before, after);
    log.info("MapObj Between : {}", betweenMap);
  }

}
