package dev.itboot.mb.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class Staff {
    private Long id;

    // Validationを追加
    @NotBlank
    @Size(max = 60)
    private String name;

    // Validationを追加
    @NotBlank
    @Email
    @Size(max = 254)
    private String email;
    
    private boolean status;
	private Date registration;
}
