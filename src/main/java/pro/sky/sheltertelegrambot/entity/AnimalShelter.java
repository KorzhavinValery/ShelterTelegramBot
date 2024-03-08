package pro.sky.sheltertelegrambot.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import pro.sky.sheltertelegrambot.exeption.IncorrectDataException;

import javax.persistence.*;
import java.util.Objects;

@Getter
@EqualsAndHashCode
@Entity
@Table(name = "Animal_shelter")
public class AnimalShelter {
    @Id
    @Column(name = "name_shelter")
    private String nameShelter;

    @Column(name = "type_animal")
    private String typeAnimal;
    @Column(name = "general_information")
    private String generalInformation;
    @Column(name = "contact_information")
    private String contactInformation;
    @Column(name = "ordering_a_pass")
    private String orderingAPass;
    @Column(name = "safety_rules")
    private String safetyRules;

    public AnimalShelter() {
    }

    public AnimalShelter(String nameShelter,
                         String typeAnimal,
                         String generalInformation,
                         String contactInformation,
                         String orderingAPass,
                         String safetyRules) {
        this.nameShelter = nameShelter;
        this.typeAnimal = setTypeAnimal(typeAnimal);
        this.generalInformation = generalInformation;
        this.contactInformation = contactInformation;
        this.orderingAPass = orderingAPass;
        this.safetyRules = safetyRules;
    }

    public void setNameShelter(String nameShelter) {
        this.nameShelter = nameShelter;
    }

    /**
     * В данном методе проверяем что переданный тип соответствует заданному,
     * в случае неверного типа выкидывает ошибку IncorrectDataException
     * @param typeAnimal
     * @return в случае ошибки сохраняет в тип "Введены не корректные данные"
     */

    public String setTypeAnimal(String typeAnimal) {
        TypeAnimal[] typeAnimals = TypeAnimal.values();
        String resul = "";
        try {
            for (TypeAnimal i : typeAnimals) {
                if (i.getTypeAnimal().equalsIgnoreCase(typeAnimal)) {
                    resul = i.getTypeAnimal();
                } else throw new IncorrectDataException("Введены не корректные данные");
            }
        } catch (IncorrectDataException e) {
            resul = e.getMessage();
        }
        return resul;
    }

    public void setGeneralInformation(String generalInformation) {
        this.generalInformation = generalInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public void setOrderingAPass(String orderingAPass) {
        this.orderingAPass = orderingAPass;
    }

    public void setSafetyRules(String safetyRules) {
        this.safetyRules = safetyRules;
    }

}
