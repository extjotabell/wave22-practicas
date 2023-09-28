package com.meli.be_java_hisp_w22_g01.integrationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.transform.Result;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;


    /**
     * Valida que un usuario pueda tener seguidores
     * @throws Exception
     */
    @Test
    @DisplayName("Valida que un usuario tenga seguidores")
    void countFollowersTest() throws Exception{

        int userId = 1;

        MockHttpServletRequestBuilder requestBuilders =  MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.user_id").value(userId);

        mockMvc.perform(requestBuilders)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }


    /**
     * Verifica que un usuario no exista o no se pueda seguir
     * @throws Exception
     */
    @Test
    @DisplayName("Verifica que un usuario no exista o no se pueda seguir")
    void countFollowersInvalidUserErrorTest() throws Exception{

        int userId = 9;

        MockHttpServletRequestBuilder requestBuilders =  MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.message").value("No se encontró el usuario con id: " + userId);

        mockMvc.perform(requestBuilders)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }


    /**
     * Obtine un listado de todos los usuarios que siguen a un determinado vendedor
     * no se envian parametro de ordenamiento
     * @throws Exception
     */
    @Test
    @DisplayName("Obtiene los usuarios que siguen a un vendedor sin orden")
    void followersListTest() throws Exception{

        int idUser = 1;

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{userId}/followers/list", idUser);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.user_id").value(idUser);


        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }


    /**
     * Obtine un listado de todos los usuarios que siguen a un determinado vendedor
     * ordenando de forma ascendente
     * @throws Exception
     */
    @Test
    @DisplayName("Obtiene los usuarios que siguen a un vendedor order ascendente")
    void followersListOrderAscTest() throws Exception{

        int idUser = 1;
        String order = "name_asc";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{userId}/followers/list", idUser)
                .param("order", order);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.user_id").value(idUser);


        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * Obtine un listado de todos los usuarios que siguen a un determinado vendedor
     * ordenando de forma descendente
     * @throws Exception
     */
    @Test
    @DisplayName("Obtiene los usuarios que siguen a un vendedor orden descendente")
    void followersListOrderDescTest() throws Exception{

        int idUser = 1;
        String order = "name_desc";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{userId}/followers/list", idUser)
                .param("order", order);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.user_id").value(idUser);


        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * Obtine un listado de todos los usuarios que siguen a un determinado vendedor
     * ordenando de forma inexistente
     * @throws Exception
     */
    @Test
    @DisplayName("Obtiene los usuarios que siguen a un vendedor orden inexistente")
    void followersListOrderErrorTest() throws Exception{

        int idUser = 1;
        String order = "terreneitor";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{userId}/followers/list", idUser)
                .param("order", order);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.message").value("No existe ese método de ordenamiento");


        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }


    /**
     * Obtine un listado de todos los usuarios que siguen a un determinado vendedor
     * pero el usuario es inexistente
     * @throws Exception
     */
    @Test
    @DisplayName("Obtiene los usuarios que siguen a un vendedor pero con un usuario inexistente")
    void followersListOrderInvalidUserErrorTest() throws Exception{

        int idUser = 100;

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{userId}/followers/list", idUser);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.message").value("El usuario no existe");


        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }


    /**
     * Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario
     * @throws Exception
     */
    @Test
    @DisplayName("Listado de vendedores que sigue un usuario")
    void getFollowedListTest() throws Exception{

        int idUser = 4;

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users//{userId}/followed/list", idUser);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.user_id").value(idUser);

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }


    /**
     * Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario
     * usando metodo de ordenamiento asc
     * @throws Exception
     */
    @Test
    @DisplayName("Listado de vendedores que sigue un usuario de forma ascendente")
    void getFollowedListOrderAscTest() throws Exception{

        int idUser = 4;
        String order = "name_asc";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users//{userId}/followed/list", idUser)
                .param("order",order);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.user_id").value(idUser);

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }


    /**
     * Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario
     * usando metodo de ordenamiento descendente
     * @throws Exception
     */
    @Test
    @DisplayName("Listado de vendedores que sigue un usuario de forma descendente")
    void getFollowedListOrderDescTest() throws Exception{

        int idUser = 4;
        String order = "name_desc";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users//{userId}/followed/list", idUser)
                .param("order",order);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.user_id").value(idUser);

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }


    /**
     * Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario
     * se envia un usuario inexistente
     * @throws Exception
     */
    @Test
    @DisplayName("Listado de vendedores que sigue un usuario, error de usuario")
    void getFollowedListUserErrorTest() throws Exception{

        int idUser = 1000;

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{userId}/followed/list", idUser);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.message").value("No existe el usuario");

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }


    /**
     * Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
     * @throws Exception
     */
    @Test
    @DisplayName("Seguir a un vendedor")
    void sumAFollowerTest() throws Exception{

        int idUser = 4;
        int idSeller = 2;

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", idUser, idSeller);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.message").value("El user: " + idUser +" comenzo a seguir a: " + idSeller);

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }



    /**
     * Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
     * el vendedor no existe
     * @throws Exception
     */
    @Test
    @DisplayName("Seguir a un vendedor -  error de vendedor")
    void sumAFollowerSellerErrorTest() throws Exception{

        int idUser = 4;
        int idSeller = 20;

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", idUser, idSeller);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.message").value("No se encontro el seller");

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }


    /**
     * Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
     * el usuario no existe
     * @throws Exception
     */
    @Test
    @DisplayName("Seguir a un vendedor -  error de usuario")
    void sumAFollowerUserErrorTest() throws Exception{

        int idUser = 40;
        int idSeller = 2;

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", idUser, idSeller);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.message").value("No existe el usuario");

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }


    /**
     * Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
     * no se puede volver a seguir a alquien que ya sigue
     * @throws Exception
     */
    @Test
    @DisplayName("Seguir a un vendedor -  ya se sigue al vendedor")
    void sumAFollowerUserSellerErrorTest() throws Exception{

        int idUser = 4;
        int idSeller = 2;

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", idUser, idSeller);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.message").value("Ya es seguidor de ese seller");

        // primera solicitud de seguimiento
        mockMvc.perform(requestBuilder);

        // seguimiento error, ya lo sigue
        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }



    /**
     * Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
     * @throws Exception
     */
    @Test
    @DisplayName("Dejar de seguir a un vendedor")
    void unfollowUserTest() throws Exception{

        int idUser = 6;
        int idSeller = 1;

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", idUser, idSeller);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.message").value("El usuario userId: " + idUser + " ha dejado de seguir a userId: " + idSeller);

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }


    /**
     * Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
     * error de que el usuario no sigue al vendedor
     * @throws Exception
     */
    @Test
    @DisplayName("Dejar de seguir a un vendedor - error, el usuario no sigue al vendedor")
    void unfollowUserErrorTest() throws Exception{

        int idUser = 5;
        int idSeller = 2;

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", idUser, idSeller);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.message").value("El usuario userId: " + idUser + " no sigue al vendedor userId: " + idSeller);

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
     * error de que el usuario no existe
     * @throws Exception
     */
    @Test
    @DisplayName("Dejar de seguir a un vendedor - error, el usuario no existe")
    void unfollowUserInvalidUserErrorITest() throws Exception{

        int idUser = 2;
        int idSeller = 4;

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", idUser, idSeller);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.message").value("No se encontró el usuario a editar. userId: " + idUser + " Recuerda que los vendedores no pueden seguir usuarios");

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }

}
