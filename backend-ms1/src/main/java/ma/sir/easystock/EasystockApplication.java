package  ma.sir.easystock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.cache.annotation.EnableCaching;


import ma.sir.easystock.bean.core.*;
import ma.sir.easystock.service.facade.admin.*;

import ma.sir.easystock.zynerator.security.common.AuthoritiesConstants;
import ma.sir.easystock.zynerator.security.bean.User;
import ma.sir.easystock.zynerator.security.bean.Permission;
import ma.sir.easystock.zynerator.security.bean.Role;
import ma.sir.easystock.zynerator.security.service.facade.UserService;
import ma.sir.easystock.zynerator.security.service.facade.RoleService;


import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableFeignClients("ma.sir.easystock.required.facade")
public class EasystockApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(EasystockApplication.class, args);
    }


    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
    return (args) -> {
        if(true){



    // Role admin

        User userForAdmin = new User("admin");

        Role roleForAdmin = new Role();
        roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
        List<Permission> permissionsForAdmin = new ArrayList<>();
        addPermissionForAdmin(permissionsForAdmin);
        roleForAdmin.setPermissions(permissionsForAdmin);
        if(userForAdmin.getRoles()==null)
            userForAdmin.setRoles(new ArrayList<>());

        userForAdmin.getRoles().add(roleForAdmin);
        userService.save(userForAdmin);
            }
        };
    }




    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }
    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("PaiementDemande.edit"));
        permissions.add(new Permission("PaiementDemande.list"));
        permissions.add(new Permission("PaiementDemande.view"));
        permissions.add(new Permission("PaiementDemande.add"));
        permissions.add(new Permission("PaiementDemande.delete"));
        permissions.add(new Permission("TauxRetardTva.edit"));
        permissions.add(new Permission("TauxRetardTva.list"));
        permissions.add(new Permission("TauxRetardTva.view"));
        permissions.add(new Permission("TauxRetardTva.add"));
        permissions.add(new Permission("TauxRetardTva.delete"));
        permissions.add(new Permission("DeclarationIs.edit"));
        permissions.add(new Permission("DeclarationIs.list"));
        permissions.add(new Permission("DeclarationIs.view"));
        permissions.add(new Permission("DeclarationIs.add"));
        permissions.add(new Permission("DeclarationIs.delete"));
        permissions.add(new Permission("EtatReception.edit"));
        permissions.add(new Permission("EtatReception.list"));
        permissions.add(new Permission("EtatReception.view"));
        permissions.add(new Permission("EtatReception.add"));
        permissions.add(new Permission("EtatReception.delete"));
        permissions.add(new Permission("EtatCommande.edit"));
        permissions.add(new Permission("EtatCommande.list"));
        permissions.add(new Permission("EtatCommande.view"));
        permissions.add(new Permission("EtatCommande.add"));
        permissions.add(new Permission("EtatCommande.delete"));
        permissions.add(new Permission("TauxIs.edit"));
        permissions.add(new Permission("TauxIs.list"));
        permissions.add(new Permission("TauxIs.view"));
        permissions.add(new Permission("TauxIs.add"));
        permissions.add(new Permission("TauxIs.delete"));
        permissions.add(new Permission("CommandeItem.edit"));
        permissions.add(new Permission("CommandeItem.list"));
        permissions.add(new Permission("CommandeItem.view"));
        permissions.add(new Permission("CommandeItem.add"));
        permissions.add(new Permission("CommandeItem.delete"));
        permissions.add(new Permission("Vente.edit"));
        permissions.add(new Permission("Vente.list"));
        permissions.add(new Permission("Vente.view"));
        permissions.add(new Permission("Vente.add"));
        permissions.add(new Permission("Vente.delete"));
        permissions.add(new Permission("EtatAvoirVente.edit"));
        permissions.add(new Permission("EtatAvoirVente.list"));
        permissions.add(new Permission("EtatAvoirVente.view"));
        permissions.add(new Permission("EtatAvoirVente.add"));
        permissions.add(new Permission("EtatAvoirVente.delete"));
        permissions.add(new Permission("EtatVente.edit"));
        permissions.add(new Permission("EtatVente.list"));
        permissions.add(new Permission("EtatVente.view"));
        permissions.add(new Permission("EtatVente.add"));
        permissions.add(new Permission("EtatVente.delete"));
        permissions.add(new Permission("Client.edit"));
        permissions.add(new Permission("Client.list"));
        permissions.add(new Permission("Client.view"));
        permissions.add(new Permission("Client.add"));
        permissions.add(new Permission("Client.delete"));
        permissions.add(new Permission("AvoirAchat.edit"));
        permissions.add(new Permission("AvoirAchat.list"));
        permissions.add(new Permission("AvoirAchat.view"));
        permissions.add(new Permission("AvoirAchat.add"));
        permissions.add(new Permission("AvoirAchat.delete"));
        permissions.add(new Permission("Banque.edit"));
        permissions.add(new Permission("Banque.list"));
        permissions.add(new Permission("Banque.view"));
        permissions.add(new Permission("Banque.add"));
        permissions.add(new Permission("Banque.delete"));
        permissions.add(new Permission("SousClassComptable.edit"));
        permissions.add(new Permission("SousClassComptable.list"));
        permissions.add(new Permission("SousClassComptable.view"));
        permissions.add(new Permission("SousClassComptable.add"));
        permissions.add(new Permission("SousClassComptable.delete"));
        permissions.add(new Permission("DevisFournisseur.edit"));
        permissions.add(new Permission("DevisFournisseur.list"));
        permissions.add(new Permission("DevisFournisseur.view"));
        permissions.add(new Permission("DevisFournisseur.add"));
        permissions.add(new Permission("DevisFournisseur.delete"));
        permissions.add(new Permission("EtatLivraison.edit"));
        permissions.add(new Permission("EtatLivraison.list"));
        permissions.add(new Permission("EtatLivraison.view"));
        permissions.add(new Permission("EtatLivraison.add"));
        permissions.add(new Permission("EtatLivraison.delete"));
        permissions.add(new Permission("Livraison.edit"));
        permissions.add(new Permission("Livraison.list"));
        permissions.add(new Permission("Livraison.view"));
        permissions.add(new Permission("Livraison.add"));
        permissions.add(new Permission("Livraison.delete"));
        permissions.add(new Permission("ComptableTraitant.edit"));
        permissions.add(new Permission("ComptableTraitant.list"));
        permissions.add(new Permission("ComptableTraitant.view"));
        permissions.add(new Permission("ComptableTraitant.add"));
        permissions.add(new Permission("ComptableTraitant.delete"));
        permissions.add(new Permission("EtatPaiementAchat.edit"));
        permissions.add(new Permission("EtatPaiementAchat.list"));
        permissions.add(new Permission("EtatPaiementAchat.view"));
        permissions.add(new Permission("EtatPaiementAchat.add"));
        permissions.add(new Permission("EtatPaiementAchat.delete"));
        permissions.add(new Permission("AvoirVente.edit"));
        permissions.add(new Permission("AvoirVente.list"));
        permissions.add(new Permission("AvoirVente.view"));
        permissions.add(new Permission("AvoirVente.add"));
        permissions.add(new Permission("AvoirVente.delete"));
        permissions.add(new Permission("DemandeItem.edit"));
        permissions.add(new Permission("DemandeItem.list"));
        permissions.add(new Permission("DemandeItem.view"));
        permissions.add(new Permission("DemandeItem.add"));
        permissions.add(new Permission("DemandeItem.delete"));
        permissions.add(new Permission("PaiementAchat.edit"));
        permissions.add(new Permission("PaiementAchat.list"));
        permissions.add(new Permission("PaiementAchat.view"));
        permissions.add(new Permission("PaiementAchat.add"));
        permissions.add(new Permission("PaiementAchat.delete"));
        permissions.add(new Permission("PaiementCommande.edit"));
        permissions.add(new Permission("PaiementCommande.list"));
        permissions.add(new Permission("PaiementCommande.view"));
        permissions.add(new Permission("PaiementCommande.add"));
        permissions.add(new Permission("PaiementCommande.delete"));
        permissions.add(new Permission("EtatPaiementLivraison.edit"));
        permissions.add(new Permission("EtatPaiementLivraison.list"));
        permissions.add(new Permission("EtatPaiementLivraison.view"));
        permissions.add(new Permission("EtatPaiementLivraison.add"));
        permissions.add(new Permission("EtatPaiementLivraison.delete"));
        permissions.add(new Permission("StockProduit.edit"));
        permissions.add(new Permission("StockProduit.list"));
        permissions.add(new Permission("StockProduit.view"));
        permissions.add(new Permission("StockProduit.add"));
        permissions.add(new Permission("StockProduit.delete"));
        permissions.add(new Permission("ClassComptable.edit"));
        permissions.add(new Permission("ClassComptable.list"));
        permissions.add(new Permission("ClassComptable.view"));
        permissions.add(new Permission("ClassComptable.add"));
        permissions.add(new Permission("ClassComptable.delete"));
        permissions.add(new Permission("DevisItemFournisseur.edit"));
        permissions.add(new Permission("DevisItemFournisseur.list"));
        permissions.add(new Permission("DevisItemFournisseur.view"));
        permissions.add(new Permission("DevisItemFournisseur.add"));
        permissions.add(new Permission("DevisItemFournisseur.delete"));
        permissions.add(new Permission("Produit.edit"));
        permissions.add(new Permission("Produit.list"));
        permissions.add(new Permission("Produit.view"));
        permissions.add(new Permission("Produit.add"));
        permissions.add(new Permission("Produit.delete"));
        permissions.add(new Permission("PaiementVente.edit"));
        permissions.add(new Permission("PaiementVente.list"));
        permissions.add(new Permission("PaiementVente.view"));
        permissions.add(new Permission("PaiementVente.add"));
        permissions.add(new Permission("PaiementVente.delete"));
        permissions.add(new Permission("EtatPaiementVente.edit"));
        permissions.add(new Permission("EtatPaiementVente.list"));
        permissions.add(new Permission("EtatPaiementVente.view"));
        permissions.add(new Permission("EtatPaiementVente.add"));
        permissions.add(new Permission("EtatPaiementVente.delete"));
        permissions.add(new Permission("LivraisonItem.edit"));
        permissions.add(new Permission("LivraisonItem.list"));
        permissions.add(new Permission("LivraisonItem.view"));
        permissions.add(new Permission("LivraisonItem.add"));
        permissions.add(new Permission("LivraisonItem.delete"));
        permissions.add(new Permission("Marque.edit"));
        permissions.add(new Permission("Marque.list"));
        permissions.add(new Permission("Marque.view"));
        permissions.add(new Permission("Marque.add"));
        permissions.add(new Permission("Marque.delete"));
        permissions.add(new Permission("AchatItem.edit"));
        permissions.add(new Permission("AchatItem.list"));
        permissions.add(new Permission("AchatItem.view"));
        permissions.add(new Permission("AchatItem.add"));
        permissions.add(new Permission("AchatItem.delete"));
        permissions.add(new Permission("Store.edit"));
        permissions.add(new Permission("Store.list"));
        permissions.add(new Permission("Store.view"));
        permissions.add(new Permission("Store.add"));
        permissions.add(new Permission("Store.delete"));
        permissions.add(new Permission("Reception.edit"));
        permissions.add(new Permission("Reception.list"));
        permissions.add(new Permission("Reception.view"));
        permissions.add(new Permission("Reception.add"));
        permissions.add(new Permission("Reception.delete"));
        permissions.add(new Permission("Magasin.edit"));
        permissions.add(new Permission("Magasin.list"));
        permissions.add(new Permission("Magasin.view"));
        permissions.add(new Permission("Magasin.add"));
        permissions.add(new Permission("Magasin.delete"));
        permissions.add(new Permission("OperationComptable.edit"));
        permissions.add(new Permission("OperationComptable.list"));
        permissions.add(new Permission("OperationComptable.view"));
        permissions.add(new Permission("OperationComptable.add"));
        permissions.add(new Permission("OperationComptable.delete"));
        permissions.add(new Permission("Abonne.edit"));
        permissions.add(new Permission("Abonne.list"));
        permissions.add(new Permission("Abonne.view"));
        permissions.add(new Permission("Abonne.add"));
        permissions.add(new Permission("Abonne.delete"));
        permissions.add(new Permission("ModePaiement.edit"));
        permissions.add(new Permission("ModePaiement.list"));
        permissions.add(new Permission("ModePaiement.view"));
        permissions.add(new Permission("ModePaiement.add"));
        permissions.add(new Permission("ModePaiement.delete"));
        permissions.add(new Permission("EtatPaiementCommande.edit"));
        permissions.add(new Permission("EtatPaiementCommande.list"));
        permissions.add(new Permission("EtatPaiementCommande.view"));
        permissions.add(new Permission("EtatPaiementCommande.add"));
        permissions.add(new Permission("EtatPaiementCommande.delete"));
        permissions.add(new Permission("DeclarationTva.edit"));
        permissions.add(new Permission("DeclarationTva.list"));
        permissions.add(new Permission("DeclarationTva.view"));
        permissions.add(new Permission("DeclarationTva.add"));
        permissions.add(new Permission("DeclarationTva.delete"));
        permissions.add(new Permission("ProprietaireChequeBanque.edit"));
        permissions.add(new Permission("ProprietaireChequeBanque.list"));
        permissions.add(new Permission("ProprietaireChequeBanque.view"));
        permissions.add(new Permission("ProprietaireChequeBanque.add"));
        permissions.add(new Permission("ProprietaireChequeBanque.delete"));
        permissions.add(new Permission("AvoirAchatItem.edit"));
        permissions.add(new Permission("AvoirAchatItem.list"));
        permissions.add(new Permission("AvoirAchatItem.view"));
        permissions.add(new Permission("AvoirAchatItem.add"));
        permissions.add(new Permission("AvoirAchatItem.delete"));
        permissions.add(new Permission("PaiementLivraison.edit"));
        permissions.add(new Permission("PaiementLivraison.list"));
        permissions.add(new Permission("PaiementLivraison.view"));
        permissions.add(new Permission("PaiementLivraison.add"));
        permissions.add(new Permission("PaiementLivraison.delete"));
        permissions.add(new Permission("EtatPaiementDemande.edit"));
        permissions.add(new Permission("EtatPaiementDemande.list"));
        permissions.add(new Permission("EtatPaiementDemande.view"));
        permissions.add(new Permission("EtatPaiementDemande.add"));
        permissions.add(new Permission("EtatPaiementDemande.delete"));
        permissions.add(new Permission("CompteComptable.edit"));
        permissions.add(new Permission("CompteComptable.list"));
        permissions.add(new Permission("CompteComptable.view"));
        permissions.add(new Permission("CompteComptable.add"));
        permissions.add(new Permission("CompteComptable.delete"));
        permissions.add(new Permission("EtatAvoirAchat.edit"));
        permissions.add(new Permission("EtatAvoirAchat.list"));
        permissions.add(new Permission("EtatAvoirAchat.view"));
        permissions.add(new Permission("EtatAvoirAchat.add"));
        permissions.add(new Permission("EtatAvoirAchat.delete"));
        permissions.add(new Permission("EtatAchat.edit"));
        permissions.add(new Permission("EtatAchat.list"));
        permissions.add(new Permission("EtatAchat.view"));
        permissions.add(new Permission("EtatAchat.add"));
        permissions.add(new Permission("EtatAchat.delete"));
        permissions.add(new Permission("AvoirVenteItem.edit"));
        permissions.add(new Permission("AvoirVenteItem.list"));
        permissions.add(new Permission("AvoirVenteItem.view"));
        permissions.add(new Permission("AvoirVenteItem.add"));
        permissions.add(new Permission("AvoirVenteItem.delete"));
        permissions.add(new Permission("ComptableValidateur.edit"));
        permissions.add(new Permission("ComptableValidateur.list"));
        permissions.add(new Permission("ComptableValidateur.view"));
        permissions.add(new Permission("ComptableValidateur.add"));
        permissions.add(new Permission("ComptableValidateur.delete"));
        permissions.add(new Permission("Bilan.edit"));
        permissions.add(new Permission("Bilan.list"));
        permissions.add(new Permission("Bilan.view"));
        permissions.add(new Permission("Bilan.add"));
        permissions.add(new Permission("Bilan.delete"));
        permissions.add(new Permission("ReceptionItem.edit"));
        permissions.add(new Permission("ReceptionItem.list"));
        permissions.add(new Permission("ReceptionItem.view"));
        permissions.add(new Permission("ReceptionItem.add"));
        permissions.add(new Permission("ReceptionItem.delete"));
        permissions.add(new Permission("VenteItem.edit"));
        permissions.add(new Permission("VenteItem.list"));
        permissions.add(new Permission("VenteItem.view"));
        permissions.add(new Permission("VenteItem.add"));
        permissions.add(new Permission("VenteItem.delete"));
        permissions.add(new Permission("Fournisseur.edit"));
        permissions.add(new Permission("Fournisseur.list"));
        permissions.add(new Permission("Fournisseur.view"));
        permissions.add(new Permission("Fournisseur.add"));
        permissions.add(new Permission("Fournisseur.delete"));
        permissions.add(new Permission("Achat.edit"));
        permissions.add(new Permission("Achat.list"));
        permissions.add(new Permission("Achat.view"));
        permissions.add(new Permission("Achat.add"));
        permissions.add(new Permission("Achat.delete"));
        permissions.add(new Permission("EtatDemande.edit"));
        permissions.add(new Permission("EtatDemande.list"));
        permissions.add(new Permission("EtatDemande.view"));
        permissions.add(new Permission("EtatDemande.add"));
        permissions.add(new Permission("EtatDemande.delete"));
        permissions.add(new Permission("Commande.edit"));
        permissions.add(new Permission("Commande.list"));
        permissions.add(new Permission("Commande.view"));
        permissions.add(new Permission("Commande.add"));
        permissions.add(new Permission("Commande.delete"));
        permissions.add(new Permission("UniteMesure.edit"));
        permissions.add(new Permission("UniteMesure.list"));
        permissions.add(new Permission("UniteMesure.view"));
        permissions.add(new Permission("UniteMesure.add"));
        permissions.add(new Permission("UniteMesure.delete"));
        permissions.add(new Permission("ProprietaireCheque.edit"));
        permissions.add(new Permission("ProprietaireCheque.list"));
        permissions.add(new Permission("ProprietaireCheque.view"));
        permissions.add(new Permission("ProprietaireCheque.add"));
        permissions.add(new Permission("ProprietaireCheque.delete"));
        permissions.add(new Permission("Demande.edit"));
        permissions.add(new Permission("Demande.list"));
        permissions.add(new Permission("Demande.view"));
        permissions.add(new Permission("Demande.add"));
        permissions.add(new Permission("Demande.delete"));
        permissions.add(new Permission("CategorieProduit.edit"));
        permissions.add(new Permission("CategorieProduit.list"));
        permissions.add(new Permission("CategorieProduit.view"));
        permissions.add(new Permission("CategorieProduit.add"));
        permissions.add(new Permission("CategorieProduit.delete"));
        permissions.add(new Permission("Societe.edit"));
        permissions.add(new Permission("Societe.list"));
        permissions.add(new Permission("Societe.view"));
        permissions.add(new Permission("Societe.add"));
        permissions.add(new Permission("Societe.delete"));
    }

}


