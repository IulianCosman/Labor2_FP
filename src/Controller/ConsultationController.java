package Controller;

import Domain.Consultation;
import Repository.ConsultationRepository;
import java.util.ArrayList;

public class ConsultationController implements ControllerInterface<Consultation> {
    private final ConsultationRepository consultationRepository;
    public ConsultationController(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }
    @Override
    public void add(ArrayList<String> newObjectData){
        /*if(consultationRepository != null) {
            if (consultationID < 0) {
                throw new IllegalArgumentException("ConsultationID is positive.");
            }
            for (Consultation consultation :consultationRepo.readAll()) {
                if (consultation.getConsultationID() == consultationID) {
                    throw new IllegalArgumentException("ConsultationID is unique.");
                }
            }
        }*/
        Consultation newObject= new Consultation(Integer.parseInt(newObjectData.get(0)), Integer.parseInt(newObjectData.get(1)), newObjectData.get(2), Integer.parseInt(newObjectData.get(3)), Integer.parseInt(newObjectData.get(5)));
        consultationRepository.add(newObject);
    }

    @Override
    public void delete(ArrayList<String> identifier) {
        if(consultationRepository.findByIdentifier(identifier) != null) {
            consultationRepository.delete(consultationRepository.findByIdentifier(identifier));
        }
        else {
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @Override
    public void update(ArrayList<String> identifier, ArrayList<String> newObjectData) {
        if(consultationRepository.findByIdentifier(identifier) != null) {
            delete(identifier);
            add(newObjectData);
        }
        else{
            throw new IllegalArgumentException("Nothing was found for the provided identifier.");
        }
    }

    @Override
    public ArrayList<Consultation> readAll(){
        return consultationRepository.readAll();
    }
}