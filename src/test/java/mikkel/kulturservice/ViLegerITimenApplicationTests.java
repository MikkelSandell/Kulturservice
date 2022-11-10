package mikkel.kulturservice;

import mikkel.kulturservice.controller.UserController;
import mikkel.kulturservice.repository.UserRepository;
import mikkel.kulturservice.security.JwtController;
import mikkel.kulturservice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest() //
class ViLegerITimenApplicationTests {
    private MockMvc mockMvc;
    private UserService userService;

    private JwtController jwtController;
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp()  {
        userService = new UserService(userRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(new JwtController(userService)).build();
    }

//    @Test
//    public void index() throws Exception {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())  // http 200 kode for "ok"
//                .andExpect(view().name("index"));
//    }

    @Test
    public void createUser() throws Exception {


        mockMvc.perform(post("/signup")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content("{\"username\":\"Mikkel\",\"password\":\"123\"}")
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());


//        mockMvc.perform(post("/addUser")
//                        .param("id", "123")
//                        .param("username", "anna")
//                        .param("password", "444"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("index"))
//                .andExpect(model().attribute("name","anna"))
//                .andDo(print());
    }


}