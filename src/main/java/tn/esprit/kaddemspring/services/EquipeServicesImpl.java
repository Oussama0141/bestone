package tn.esprit.kaddemspring.services;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.joda.time.Days;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspring.model.*;
import tn.esprit.kaddemspring.repository.EquipeRepository;
import org.springframework.mail.javamail.JavaMailSender;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class EquipeServicesImpl implements EquipeServices {
    private final static String TWILIO_ACCOUNT_SID = "ACc11d95996ceef478537fe34c64ce8825";
    private final static String TWILIO_AUTH_TOKEN= "74570d0663f63cadf2ff03b4b840f0ec";
    @Autowired
    private EquipeRepository EquipeRepository;
    @Autowired
    private DetailsEquipeServices DetailsEquipeServices;
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public Equipe addEquipe(Equipe Equipe){
        DetailsEquipe detailsEquipe = Equipe.getDetailsequipe();
        if(detailsEquipe != null ){
            detailsEquipe = DetailsEquipeServices.addDetailsE(detailsEquipe);}
        Equipe.setDetailsequipe(detailsEquipe);

        return EquipeRepository.save(Equipe);
    }

    @Override
    public List<Equipe> findAllEquipes(){
        return (List<Equipe>) EquipeRepository.findAll();
    }

    @Override
    public void deleteEquipeById(Long id) {
        EquipeRepository.deleteById(id);
        Equipe newEquipe = this.GetEquipeById(id);
        DetailsEquipe detailsEquipe = DetailsEquipeServices.GetDetailsEquipeById(newEquipe.getIdEquipe());
        DetailsEquipeServices.deleteDetailsEquipeById(detailsEquipe.getIdDetailsEquipe());
    }

    @Override
    public Equipe UpdateEquipe(Equipe Equipe) {
        DetailsEquipe detailsEquipe = Equipe.getDetailsequipe();
        detailsEquipe = DetailsEquipeServices.UpdateDetailsEquipe(detailsEquipe);
        Equipe.setDetailsequipe(detailsEquipe);
        return EquipeRepository.save(Equipe);
    }
    @Override
    public Equipe GetEquipeById(Long id) {
        return EquipeRepository.findById(id).orElse(null);
    }

    @Override
    public void sendEmail(String toEmail, String subject, String body) {
            SimpleMailMessage message =new SimpleMailMessage();
            message.setFrom("yassine.ghoul@esprit.tn");
            message.setTo(toEmail);
            message.setText(body);
            message.setSubject(subject);
            mailSender.send(message);
            System.out.println("Mail sent");
        }
    @Override
    public ResponseEntity<String> sendSMS() {

        Twilio.init(TWILIO_ACCOUNT_SID,TWILIO_AUTH_TOKEN);

        Message.creator(new PhoneNumber("+21692981798"),
                new PhoneNumber("+14848010537"), "Equipe ajouter avec succees 📞").create();

        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }
    @Override
    public void faireEvoluerEquipes(){
        int a =0;
        float res =0;
        List<Equipe> Equipes = this.findAllEquipes();
        for (Equipe eq : Equipes) {
            if(!eq.getNiveau().equals(Niveau.Expert) ){
                if(eq.getEtudiantSet().size()>2){
                    for (Etudiant x : eq.getEtudiantSet()) {
                        int t=0;

                        for (Contrat y : x.getContratSet()){
                            if(t==0){
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-DD");

                            try {
                                Date dateAvant = sdf.parse(y.getDateDebutC().toString());
                                LocalDate todaysDate = LocalDate.now();
                                Date dateApres = sdf.parse(todaysDate.toString());
                                long diff = dateApres.getTime() - dateAvant.getTime();
                                 res = (diff / (1000*60*60*24));
                                System.out.println(res);

                                System.out.println("Nombre de jours entre les deux dates est: "+res);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if(res>365){
                                t=1;
                                a++;
                            }
                        }}
                    }
            }}
            System.out.println(a);
            if  (a>2){
            if(eq.getNiveau().equals(Niveau.Senior)) {
                eq.setNiveau(Niveau.Expert);
            }
            if(eq.getNiveau().equals(Niveau.Junior)) {
                eq.setNiveau(Niveau.Senior);
            }
            EquipeRepository.save(eq);
        }}

    }


}
