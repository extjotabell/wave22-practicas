package bootcamp.socialMeli.IntegralTest.controller;

import bootcamp.socialMeli.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    FollowedListDto followerExpectedDesc;
    FollowedListDto followerExpectedAsc;
    @BeforeEach
    void SetUp() {
        UserDto userDto1 = new UserDto(6,"Jesica");
        UserDto userDto2 = new UserDto(10,"Hector");
        List<UserDto> listAsc = new ArrayList<>(){};
        listAsc.add(userDto2);
        listAsc.add(userDto1);
        List<UserDto> listDesc = new ArrayList<>(){};
        listDesc.add(userDto1);
        listDesc.add(userDto2);
        followerExpectedAsc = new FollowedListDto(1,"Diego",listAsc );
        followerExpectedDesc = new FollowedListDto(1,"Diego",listDesc);

    }
    @Test
    @DisplayName("US 01 follow User")
    void followUserTest()  throws Exception {
        //arrage
        int userId = 10;
        int userIdToUnfollow = 9;
        String url = "/users/"+userId+"/follow/"+userIdToUnfollow;
        //Act
        mockMvc.perform(post(url))
                .andExpect(status().isOk());
     }
    @Test
    @DisplayName("US 01 exist follow User ")
    void followUserExistTest()  throws Exception {
        //arrage
        int userId = 10;
        int userIdToUnfollow = 6;
        String url = "/users/"+userId+"/follow/"+userIdToUnfollow;
        //Act
        mockMvc.perform(post(url))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Ya sigue al usuario"));

    }
    @Test
    @DisplayName("US 02 Count Followers OK")
    void getFollowersCount()  throws Exception {
        //Arrange
        FollowersCountDto followerExpected = new FollowersCountDto(6,"Jesica",2);
        //Act
        MvcResult mvcResult =  mockMvc.perform(get("/users/{userId}/followers/count",6))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        FollowersCountDto resultDto = mapper.readValue(mvcResult.getResponse().getContentAsString(),FollowersCountDto.class );
        //Assert
        assertEquals(followerExpected,resultDto);
    }

    @Test
    @DisplayName("US 02 Not found user OK")
    void getFollowersCountNotFoundTest()  throws Exception {
        //Act
        mockMvc.perform(get("/users/{userId}/followers/count",66))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User with ID #66 not found"));
    }
    @Test
    @DisplayName("US 04 Followed List ASC OK")
    void getFollowedListASCTest()  throws Exception {
        //Act
        MvcResult mvcResult =  mockMvc.perform(get("/users/{userId}/followed/list",1).param("order","name_asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        FollowedListDto resultDto = mapper.readValue(mvcResult.getResponse().getContentAsString(),FollowedListDto.class );
        //Assert
        assertEquals(followerExpectedAsc,resultDto);
    }
    @Test
    @DisplayName("US 04 Followed List DESC OK")
    void getFollowedListDESCTest()  throws Exception {
        //Act
        MvcResult mvcResult =  mockMvc.perform(get("/users/{userId}/followed/list",1).param("order","name_desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        FollowedListDto resultDto = mapper.readValue(mvcResult.getResponse().getContentAsString(),FollowedListDto.class );
        //Assert
        assertEquals(followerExpectedDesc,resultDto);
    }
    @Test
    @DisplayName("US 07 unfollow User")
    void unfollowUserTest()  throws Exception {
        //arrage
        int userId = 7;
        int userIdToUnfollow = 9;
        String url = "/users/"+userId+"/unfollow/"+userIdToUnfollow;
        //Act
        mockMvc.perform(post(url))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(jsonPath("$").value("Se dejó de seguir al usuario 9"));
    }

    @Test
    @DisplayName("US 07 unfollow User and follow equal")
    void unfollowUserAndFollowEqualTest()  throws Exception {
        //arrage
        int userId = 6;
        int userIdToUnfollow = 6;
        String url = "/users/"+userId+"/unfollow/"+userIdToUnfollow;
        //Act
        mockMvc.perform(post(url))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Los ids enviados son iguales"));
    }
    @Test
    @DisplayName("US 07 unfollow User does not follow")
    void unfollowUserDoesNotFollowTest()  throws Exception {
        //arrage
        //arrage
        int userId = 7;
        int userIdToUnfollow = 66;
        String url = "/users/"+userId+"/unfollow/"+userIdToUnfollow;
        //Act
        mockMvc.perform(post(url))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User with ID #66 not found"));
    }
}
