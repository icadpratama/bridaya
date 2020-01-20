package team.kasta.bridaya.controller.authentication;

import team.kasta.bridaya.exception.AppException;
import team.kasta.bridaya.model.authentication.Role;
import team.kasta.bridaya.model.authentication.User;
import team.kasta.bridaya.payload.request.LoginRequest;
import team.kasta.bridaya.payload.request.SignUpRequest;
import team.kasta.bridaya.payload.response.JwtAuthenticationResponse;
import team.kasta.bridaya.payload.response.BridayaResponse;
import team.kasta.bridaya.security.JwtTokenProvider;
import team.kasta.bridaya.service.RoleService;
import team.kasta.bridaya.service.UserService;
import team.kasta.bridaya.util.RoleName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;

    public AuthenticationController(AuthenticationManager authenticationManager, UserService userService, RoleService roleService, PasswordEncoder passwordEncoder, JwtTokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        String message = "";
        if (userService.checkUserByUsername(signUpRequest.getUsername())) {
            message = "Username is already taken!";
        }

        if (userService.checkUserByEmail(signUpRequest.getEmail())) {
            message = "Email Address already in use!";
        }

        if (message.length() > 0) {
            return new ResponseEntity<>(new BridayaResponse(400, "failed", message), HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), signUpRequest.getPhoneNumber(), signUpRequest.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleService.setRole(RoleName.SUPERADMIN)
                .orElseThrow(() -> new AppException("User Role not set."));
        user.setRoles(Collections.singleton(userRole));
        User result = userService.crateUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new BridayaResponse(200,"success", "User registered successfully"));
    }
}
