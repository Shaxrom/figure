package infin_bank.interview.figure.core;

import infin_bank.interview.figure.FigureApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ActiveProfiles({"test", "${SPRING_TEST_DB_PROFILE:test-embedded-db}"})
@AutoConfigureMockMvc
@SpringBootTest(classes = FigureApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public @interface SpringMockWebEnvTestConfigController {
}
