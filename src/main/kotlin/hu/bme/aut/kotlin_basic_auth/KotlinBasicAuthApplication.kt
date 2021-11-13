package hu.bme.aut.kotlin_basic_auth

import hu.bme.aut.kotlin_basic_auth.data.User
import hu.bme.aut.kotlin_basic_auth.data.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.List

@SpringBootApplication
class KotlinBasicAuthApplication: CommandLineRunner{

    @Autowired
    private lateinit var repository: UserRepository

    @Autowired
    private val passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

    @Throws(Exception::class)
    override fun run(vararg args: String?) {
        val user = User("demo", passwordEncoder.encode("demo"), true, listOf("ROLE_USER"))
        /*user.setName("demo")
        user.setPassword((passwordEncoder as PasswordEncoder).encode("demo"))
        user.setEnabled(true)
        user.setRoles(List.of("ROLE_USER"))*/
        val admin = User("admin", passwordEncoder.encode("admin"), true, listOf("ROLE_ADMIN"))
        /*admin.setName("admin")
        admin.setPassword(passwordEncoder.encode("admin"))
        admin.setEnabled(true)
        admin.setRoles(List.of("ROLE_ADMIN"))*/
        repository.saveAll(listOf(user, admin))
    }

}

fun main(args: Array<String>) {
    runApplication<KotlinBasicAuthApplication>(*args)
}
