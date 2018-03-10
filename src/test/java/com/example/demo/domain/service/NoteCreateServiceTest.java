package com.example.demo.domain.service;

import com.example.demo.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class NoteCreateServiceTest {

  @Autowired
  private JdbcOperations jdbcOperations; // 各テスト前処理用

  /**
   * 各テスト前処理
   */
  @Before
  public void eachBefore() {
    jdbcOperations.execute("SET FOREIGN_KEY_CHECKS=0");
    jdbcOperations.execute("TRUNCATE note");
    jdbcOperations.execute("SET FOREIGN_KEY_CHECKS=1");
  }

  @After
  public void eachAfter() {
    jdbcOperations.execute("SET FOREIGN_KEY_CHECKS=0");
    jdbcOperations.execute("TRUNCATE note");
    jdbcOperations.execute("SET FOREIGN_KEY_CHECKS=1");
  }


  @Test
  public void hoge(){
    assertTrue(true);
  }
}
