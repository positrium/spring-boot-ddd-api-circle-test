package com.example.demo.infrastructure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(WebSecurity web) throws Exception {
    // セキュリティ設定を無視するリクエスト設定
    // 静的リソース(images、css、javascript)に対するアクセスはセキュリティ設定を無視する
    web.ignoring().antMatchers(
      "/images/**",
      "/css/**",
      "/javascript/**",
      "/webjars/**","/notes");
  }

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.httpBasic().realmName("Spring");
//    http.csrf().disable().authorizeRequests()
//      // 認証対象外のパスを設定する
//      .antMatchers("/**", "/logout", "/notes")
//      .permitAll();
//
////      // その他のリクエストは認証が必要
////      .anyRequest().authenticated()
////      .and().formLogin()
////      // ログインフォームのパス
////      .loginPage("/")
////      // ログイン処理のパス
////      .loginProcessingUrl("/login")
////      // ログイン成功時の遷移先
////      .defaultSuccessUrl("/login-code")
////      // ログイン失敗時の遷移先
////      .failureUrl("/login-error")
////      // ログインフォームで使用するユーザー名のinput name
////      .usernameParameter("username")
////      // ログインフォームで使用するパスワードのinput name
////      .passwordParameter("password").permitAll()
////      .and().rememberMe();
//
//    http.csrf().ignoringAntMatchers("/**");
//    http.headers().frameOptions().sameOrigin();
//  }

//  @Bean
//  public UserDetailsService userDetailsService() {
//    return new LoginPrincipal.LoginPrincipalService();
//  }
//
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }
}
