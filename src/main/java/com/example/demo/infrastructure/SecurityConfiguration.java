package com.example.demo.infrastructure;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
      // 認証対象外のパスを設定する
      .antMatchers("/**", "/logout", "/notes")
      .permitAll()

      // その他のリクエストは認証が必要
      .anyRequest().authenticated()
      .and().formLogin()
      // ログインフォームのパス
      .loginPage("/")
      // ログイン処理のパス
      .loginProcessingUrl("/login")
      // ログイン成功時の遷移先
      .defaultSuccessUrl("/login-code")
      // ログイン失敗時の遷移先
      .failureUrl("/login-error")
      // ログインフォームで使用するユーザー名のinput name
      .usernameParameter("username")
      // ログインフォームで使用するパスワードのinput name
      .passwordParameter("password").permitAll()
      .and().rememberMe();

    http.csrf().ignoringAntMatchers("/**");
    http.headers().frameOptions().sameOrigin();
  }
}
