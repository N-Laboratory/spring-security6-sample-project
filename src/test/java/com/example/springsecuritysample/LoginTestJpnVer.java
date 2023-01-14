package com.example.springsecuritysample;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import com.example.springsecuritysample.config.SecurityConfig;
import com.example.springsecuritysample.entity.LoginUser;
import com.example.springsecuritysample.entity.Role;
import com.example.springsecuritysample.repository.LoginUserRepository;
import com.example.springsecuritysample.security.LoginUserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

/**
 * Spring Security v6のテスト
 */
@ContextConfiguration(classes = { SecurityConfig.class, LoginUserDetailsService.class })
@WebMvcTest
class LoginTestJpnVer {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PasswordEncoder passwordEncoder;

    @MockBean
    LoginUserRepository loginUserRepository;

    @Test
    @DisplayName("ユーザー名とパスワードが一致する場合、ログイン認証に成功してマイページへ遷移すること")
    public void validUserLogin() throws Exception {
        // Given
        Long id = 1L;
        String email = "admin@admin.com";
        String name = "admin";
        String password = "admin";
        Role role = new Role(1L, "ROLE_ADMIN");

        Optional<LoginUser> loginUser = Optional
                .of(new LoginUser(id, email, name, passwordEncoder.encode(password), role));
        when(loginUserRepository.findByEmail(any())).thenReturn(loginUser);

        // When
        mockMvc
                .perform(
                        formLogin()
                                .loginProcessingUrl("/login")
                                .user("username", email)
                                .password("password", password))
                .andExpect(authenticated().withUsername(email).withRoles("ADMIN"))
                .andExpect(redirectedUrl("/myPage"));
    }

    @Test
    @DisplayName("ユーザー名またはパスワードが一致しない場合、ログイン認証に失敗すること")
    public void invalidUserLogin() throws Exception {
        // Given
        Long id = 1L;
        String email = "admin@admin.com";
        String name = "admin";
        String password = "admin";
        Role role = new Role(1L, "ROLE_ADMIN");

        Optional<LoginUser> loginUser = Optional
                .of(new LoginUser(id, email, name, passwordEncoder.encode(password), role));
        when(loginUserRepository.findByEmail(any())).thenReturn(loginUser);

        // When
        mockMvc
                .perform(
                        formLogin()
                                .loginProcessingUrl("/login")
                                .user("username", email)
                                .password("password", "foo"))
                .andExpect(unauthenticated())
                .andExpect(redirectedUrl("/login?error"));
    }

    @Test
    @DisplayName("ログイン必須のページにアクセスした場合、ログインページへリダイレクトすること")
    public void accessMyPageWithoutLogin() throws Exception {
        // When
        mockMvc
                .perform(
                        get("/myPage"))
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @DisplayName("ログイン後にログイン必須のページにアクセスした場合、ログインページへリダイレクトされないこと")
    @WithMockUser(username = "foo", password = "bar", roles = "USER")
    public void accessMyPageAfterLogin() throws Exception {
        // When
        mockMvc
                .perform(
                        get("/myPage"))
                .andExpect(redirectedUrl(null));
    }

    @Test
    @DisplayName("ログイン不要のページにアクセスした場合、ログインページへリダイレクトされないこと")
    public void accessPublicPage() throws Exception {
        // When
        mockMvc
                .perform(
                        get("/"))
                .andExpect(redirectedUrl(null));
    }

    @Test
    @DisplayName("ログアウトした場合、トップページへリダイレクトすること")
    public void logout() throws Exception {
        // When
        mockMvc
                .perform(
                        post("/logout").with(csrf().asHeader()))
                .andExpect(redirectedUrl("/"));
    }

}
