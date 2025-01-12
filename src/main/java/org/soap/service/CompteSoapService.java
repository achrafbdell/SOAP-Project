package org.soap.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.soap.model.Compte;
import org.soap.model.TypeCompte;
import org.soap.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@WebService(serviceName = "BanqueWS")
public class CompteSoapService {

    @Autowired
    private CompteRepository compteRepository;

    @WebMethod
    public List<Compte> getCompte(){
        return compteRepository.findAll();
    }

    @WebMethod
    public Compte getCompteById(@WebParam(name = "id") Long id){
        return compteRepository.findById(id).orElse(null);
    }

    @WebMethod
    public Compte createCompte(@WebParam(name= "solde") double solde, @WebParam(name = "typeCompte")TypeCompte typeCompte){
        Compte compte = new Compte(null, solde, new Date(), typeCompte);
        return compteRepository.save(compte);
    }

    @WebMethod
    public boolean deleteCompte(@WebParam(name= "id") Long id){
        if(compteRepository.existsById(id)){
            compteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
