package bootcamp.socialMeli.IntegralTest.controller;

import bootcamp.socialMeli.dto.FollowedPostListDto;
import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;
    ObjectWriter mapper;
    FollowedPostListDto followerExpectedAsc;
    FollowedPostListDto followerExpectedDesc;
    @BeforeEach
    void SetUp(){
                 mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        List<PostDto> postDtoListDesc = new ArrayList<>();
        PostDto postDto1 = new PostDto(8,3,LocalDate.of(2023, 9, 28),
                new ProductDto(6,"Campera","Piloto","Puma","Rosa","Impermeable"),54,33000.0);
        PostDto postDto2 = new PostDto(7,7, LocalDate.of(2023, 9, 27),
                new ProductDto(4,"Cartera","Tela","XL","Violeta","Tipo mochila"),323,16000.0);
         postDtoListDesc.add(postDto1);
        postDtoListDesc.add(postDto2);
        List<PostDto> postDtoListAsc = new ArrayList<>();
        postDtoListAsc.add(postDto2);
        postDtoListAsc.add(postDto1);

        followerExpectedDesc= new FollowedPostListDto(6,postDtoListDesc);
        followerExpectedAsc = new FollowedPostListDto(6,postDtoListAsc);
    }

    @Test
    @DisplayName("US 05 add post OK")
    void addPostOkTest()  throws Exception{

            PostDto postDto = new PostDto(9,null, LocalDate.of(2023, 9, 28),
                                     new ProductDto(4,"Mochila","Cuero","Adida","Negra","Tipo mochila Deportiva")
                                     ,100,25000.00);

            String jsonPayload = mapper.writeValueAsString(postDto);
            System.out.println(jsonPayload);

            mockMvc.perform(post("/products/post")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonPayload))
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(content().contentType("text/plain;charset=UTF-8"))
                    .andExpect(jsonPath("$").isNotEmpty());
    }

        @Test
        @DisplayName("US 05 add post Valid user id and product id")
        void addPostValidTest()  throws Exception{

                PostDto postDto = new PostDto(null,null, LocalDate.of(2023, 9, 28),
                        new ProductDto(null,"Mochila","Cuero","Adida","Negra","Tipo mochila Deportiva")
                        ,100,25000.00);

                String jsonPayload = mapper.writeValueAsString(postDto);
                System.out.println(jsonPayload);

                mockMvc.perform(post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonPayload))
                        .andDo(print()).andExpect(status().isBadRequest())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(jsonPath("$").isNotEmpty());

            }
    @Test
    @DisplayName("US 05 add post user id Not found")
    void addPostNotFoundTest()  throws Exception{

        PostDto postDto = new PostDto(77,null, LocalDate.of(2023, 9, 28),
                new ProductDto(1,"Mochila","Cuero","Adida","Negra","Tipo mochila Deportiva")
                ,100,25000.00);

        String jsonPayload = mapper.writeValueAsString(postDto);
        System.out.println(jsonPayload);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isNotEmpty());

    }

    @Test
    @DisplayName("US 06 list followed by user OK")
    void getPostsByFollowedUsersTest()  throws Exception {
        //Act
        MvcResult mvcResult =  mockMvc.perform(get("/products/followed/{userId}/list",6))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        FollowedPostListDto resultDto = mapper.readValue(mvcResult.getResponse().getContentAsString(),FollowedPostListDto.class );
        //Assert
        assertEquals(followerExpectedDesc,resultDto);
    }
    @Test
    @DisplayName("US 06 list followed by user asc OK")
    void getPostsByFollowedUsersASCTest()  throws Exception {
        //Act
        MvcResult mvcResult =  mockMvc.perform(get("/products/followed/{userId}/list",6).param("order","date_asc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        FollowedPostListDto resultDto = mapper.readValue(mvcResult.getResponse().getContentAsString(),FollowedPostListDto.class );
        //Assert
        assertEquals(followerExpectedAsc,resultDto);
    }
    @Test
    @DisplayName("US 06 list followed by user Desc OK")
    void getPostsByFollowedUsersDESCTest()  throws Exception {
        //Act
        MvcResult mvcResult =  mockMvc.perform(get("/products/followed/{userId}/list",6).param("order","date_desc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        FollowedPostListDto resultDto = mapper.readValue(mvcResult.getResponse().getContentAsString(),FollowedPostListDto.class );
        //Assert
        assertEquals(followerExpectedDesc,resultDto);
    }
    @Test
    @DisplayName("US 06 list followed not found Error")
    void getPostsByFollowedUsersNotFoundTest()  throws Exception {
        //Act
        mockMvc.perform(get("/products/followed/{userId}/list",66).param("order","date_desc"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User with ID #66 not found"));
    }



}
