package br.ufc.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.ufc.model.Usuario;

public class UsuarioValidation implements Validator {
	
	

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
			
			ValidationUtils.rejectIfEmpty(errors, "nome","field.required");
			ValidationUtils.rejectIfEmpty(errors, "idade","field.required");
			ValidationUtils.rejectIfEmpty(errors, "login","field.required");
			ValidationUtils.rejectIfEmpty(errors, "senha","field.required");
			ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
			
			
			Usuario usuario = (Usuario) target;
		
	}

}
