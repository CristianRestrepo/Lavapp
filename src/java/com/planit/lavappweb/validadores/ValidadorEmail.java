/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.validadores;

import com.planit.lavappweb.modelo.dao.UsuarioDao;
import com.planit.lavappweb.modelo.dto.Usuario_TO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Desarrollo_Planit
 */
@FacesValidator("EmailValido")
public class ValidadorEmail implements Validator{

    Pattern pattern = Pattern.compile("[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");
    String user;
    int operacion;
    
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
      user = (String) o;
        //operacion = (int) component.getAttributes().get("operacion");

        Matcher matcher = pattern.matcher(o.toString());
        if (!matcher.matches()) {
            FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email invalido", "Por favor, ingrese un email valido");
            throw new ValidatorException(fmsg);
        }

        UsuarioDao userDao = new UsuarioDao();
        Usuario_TO usuario = userDao.consultarUsuarioPorLogin(user);
        if (!user.equalsIgnoreCase("")) {
            if (usuario.getIdUsuario() != 0) {
                FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email invalido", "El email ya esta en uso");
                throw new ValidatorException(fmsg);
            }
        }

    }
    
}
