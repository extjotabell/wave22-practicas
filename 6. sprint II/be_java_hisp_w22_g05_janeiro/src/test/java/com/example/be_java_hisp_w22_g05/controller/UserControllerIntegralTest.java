package com.example.be_java_hisp_w22_g05.controller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegralTest {

    @Autowired
    MockMvc mockMvc;

    //Follow Integral Tests
    @Nested
    class Follow{
        @Test
        @DisplayName("Follow OK")
        void FollowOkTest() throws Exception {
            mockMvc.perform(post("/users/4/follow/1"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.user_id").value(4));
        }

        @Test
        @DisplayName("Follow Exception")
        void FollowFollowExceptionTest() throws Exception {
            mockMvc.perform(post("/users/1/follow/1"))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.message").value("El usuario no puede seguirse a si mismo!"));
        }

    }

    //Follow Count Integral Tests
    @Nested
    class FollowersCount{
        @Test
        @DisplayName("Followers count ok")
        void FollowersCountOkTest() throws Exception{
            mockMvc.perform(get("/users/{userId}/followers/count","1"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.followers_count").value(2));
        }

        @Test
        @DisplayName("Followers count bad Argument")
        void FollowersCountBadArgumentTest() throws Exception{
            mockMvc.perform(get("/users/{userId}/followers/count","-1"))
                    .andDo(print())
                    .andExpect(status().isConflict())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.explanation").value("Errores en las siguientes validaciones:"));
        }
    }

    //List Of Followed Integral Tests
    @Nested
    class ListOfFollwed{

        @Test
        @DisplayName("List of follewd Ok")
        void listOfFollowedOkTest() throws Exception {
            mockMvc.perform(get("/users/{userId}/followed/list",1))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.user_id").value(1));
        }

        @Test
        @DisplayName("List of follewd Conflict")
        void listOfFollowedConflictTest() throws Exception {
            mockMvc.perform(get("/users/{userId}/followed/list",0))
                    .andDo(print())
                    .andExpect(status().isConflict())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.messages.[0]").value("El userId debe ser mayor que 0"));
        }
    }

    //Unfollow Integral Tests
    @Nested
    class Unfollow{
        @Test
        @DisplayName("Unfollow OK")
        void unfollowOkTest() throws Exception{
            mockMvc.perform(post("/users/1/unfollow/4"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.user_id").value(1));
        }

        @Test
        @DisplayName("Unfollow Not Found")
        void unfollowFaildTest() throws Exception{
            mockMvc.perform(post("/users/999/unfollow/4"))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.message").value("No se encontro el usuario 999"));
        }
    }

    //List of Followed Sellers Integral Tests
    @Nested
    class LisOfFollowedSellers{
        @Test
        @DisplayName("Users Following Seller Ok")
        void UsersFollowingSellerOkTest() throws Exception{
            mockMvc.perform(get("/users/{userId}/followers/list","1"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.user_id").value(1));
        }

        @Test
        @DisplayName("Users Following Seller Not Found")
        void UsersFollowingSellerNotFoundTest() throws Exception{
            mockMvc.perform(get("/users/{userId}/followers/list","999"))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.message").value("No se encontró el usuario 999"));
        }
    }

}
