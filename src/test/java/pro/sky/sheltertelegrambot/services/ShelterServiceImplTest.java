package pro.sky.sheltertelegrambot.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.sheltertelegrambot.repository.AnimalShelterRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.sheltertelegrambot.test_data.TestData.*;

@ExtendWith(MockitoExtension.class)
class ShelterServiceImplTest {
    @Mock
    private AnimalShelterRepository repository;
    @InjectMocks
    private ShelterServiceImpl shelterService;

    @Test
    @DisplayName("тест метода получающего String с информацией о приюте по наименованию приюта" +
            "  передаем существующее имя")
    void receiveGeneralInformation_correct() {
        when(repository.findById("nameShelter")).thenReturn(Optional.of(SHELTER));
        assertEquals(SHELTER.getGeneralInformation(), shelterService.receiveGeneralInformation("nameShelter"));
    }

    @Test
    @DisplayName("тест метода получающего String с информацией о приюте по наименованию приюта" +
            "  передаем несуществующее имя")
    void receiveGeneralInformation_incorrect() {
        when(repository.findById("")).thenReturn(null);
        assertEquals(SHELTER.getGeneralInformation(), shelterService.receiveGeneralInformation(""));
    }

    @Test
    @DisplayName("тест метода получающего String с контактной информацией о приюте по наименованию приюта" +
            "  передаем существующее имя")
    void receiveContactInformation_correct() {
        when(repository.findById("nameShelter")).thenReturn(Optional.of(SHELTER));
        assertEquals(SHELTER.getContactInformation(), shelterService.receiveContactInformation("nameShelter"));
    }

    @Test
    @DisplayName("тест метода получающего String с данными охраны для оформления пропуска на машину" +
            "  передаем существующее имя")
    void receiveOrderingAPass_correct() {
        when(repository.findById("nameShelter")).thenReturn(Optional.of(SHELTER));
        assertEquals(SHELTER.getOrderingAPass(), shelterService.receiveOrderingAPass("nameShelter"));
    }

    @Test
    @DisplayName("тест метода получающего String с общими рекомендациями о технике безопасности на территории приюта" +
            "  передаем существующее имя")
    void receiveSafetyRules_correct() {
        when(repository.findById("nameShelter")).thenReturn(Optional.of(SHELTER));
        assertEquals(SHELTER.getSafetyRules(), shelterService.receiveSafetyRules("nameShelter"));
    }
}