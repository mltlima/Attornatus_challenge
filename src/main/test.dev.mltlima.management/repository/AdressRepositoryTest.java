package test.dev.mltlima.management.repository;

import dev.mltlima.management.model.Adress;
import dev.mltlima.management.repository.AdressRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AdressRepositoryTest {

    @Autowired
    private AdressRepository repository;

    @Test
    public void should_find_no_adresses_if_repository_is_empty() {
        List<Adress> adresses = repository.findAll();
        assertThat(adresses).isEmpty();
    }

    @Test
    public void should_store_an_adress() {
        Adress adress = repository.save(new Adress("Rua 1", "Bairro 1", "Cidade 1", "Estado 1", "Pais 1", "12345678", user));
        assertThat(adress).hasFieldOrPropertyWithValue("street", "Rua 1");
    }

    @Test
    public void should_find_all_adresses() {
        Adress adress1 = new Adress("Rua 1", "Bairro 1", "Cidade 1", "Estado 1", "Pais 1", "12345678", user1);
        Adress adress2 = new Adress("Rua 2", "Bairro 2", "Cidade 2", "Estado 2", "Pais 2", "12345678", user2);
        Adress adress3 = new Adress("Rua 3", "Bairro 3", "Cidade 3", "Estado 3", "Pais 3", "12345678", user3);
        repository.save(adress1);
        repository.save(adress2);
        repository.save(adress3);
        List<Adress> adresses = repository.findAll();
        assertThat(adresses).hasSize(3).contains(adress1, adress2, adress3);
    }

    @Test
    public void should_find_adress_by_id() {
        Adress adress1 = new Adress("Rua 1", "Bairro 1", "Cidade 1", "Estado 1", "Pais 1", "12345678", user1);
        Adress adress2 = new Adress("Rua 2", "Bairro 2", "Cidade 2", "Estado 2", "Pais 2", "12345678", user2);
        Adress adress3 = new Adress("Rua 3", "Bairro 3", "Cidade 3", "Estado 3", "Pais 3", "12345678", user3);
        repository.save(adress1);
        repository.save(adress2);
        repository.save(adress3);
        Adress foundAdress = repository.findById(adress2.getId()).get();
        assertThat(foundAdress).isEqualTo(adress2);
    }

    @Test
    public void should_find_adress_by_user() {
        Adress adress1 = new Adress("Rua 1", "Bairro 1", "Cidade 1", "Estado 1", "Pais 1", "12345678", user1);
        Adress adress2 = new Adress("Rua 2", "Bairro 2", "Cidade 2", "Estado 2", "Pais 2", "12345678", user2);
        Adress adress3 = new Adress("Rua 3", "Bairro 3", "Cidade 3", "Estado 3", "Pais 3", "12345678", user3);
        repository.save(adress1);
        repository.save(adress2);
        repository.save(adress3);
        Adress foundAdress = repository.findByUser(user2).get();
        assertThat(foundAdress).isEqualTo(adress2);
    }

    @Test
    public void should_update_adress_by_id() {
        Adress adress1 = new Adress("Rua 1", "Bairro 1", "Cidade 1", "Estado 1", "Pais 1", "12345678", user1);
        Adress adress2 = new Adress("Rua 2", "Bairro 2", "Cidade 2", "Estado 2", "Pais 2", "12345678", user2);
        Adress adress3 = new Adress("Rua 3", "Bairro 3", "Cidade 3", "Estado 3", "Pais 3", "12345678", user3);
        repository.save(adress1);
        repository.save(adress2);
        repository.save(adress3);
        Adress updatedAdress = new Adress("Rua 4", "Bairro 4", "Cidade 4", "Estado 4", "Pais 4", "12345678", user4);
        Adress adress = repository.findById(adress2.getId()).get();
        adress.setStreet(updatedAdress.getStreet());
        adress.setNeighborhood(updatedAdress.getNeighborhood());
        adress.setCity(updatedAdress.getCity());
        adress.setState(updatedAdress.getState());
        adress.setCountry(updatedAdress.getCountry());
        adress.setZipCode(updatedAdress.getZipCode());
        adress.setUser(updatedAdress.getUser());
        repository.save(address);
        Adress checkAdress = repository.findById(adress2.getId()).get();
        assertThat(checkAdress.getId()).isEqualTo(adress2.getId());
        assertThat(checkAdress.getStreet()).isEqualTo(updatedAdress.getStreet());
        assertThat(checkAdress.getNeighborhood()).isEqualTo(updatedAdress.getNeighborhood());
        assertThat(checkAdress.getCity()).isEqualTo(updatedAdress.getCity());
        assertThat(checkAdress.getState()).isEqualTo(updatedAdress.getState());
        assertThat(checkAdress.getCountry()).isEqualTo(updatedAdress.getCountry());
        assertThat(checkAdress.getZipCode()).isEqualTo(updatedAdress.getZipCode());
        assertThat(checkAdress.getUser()).isEqualTo(updatedAdress.getUser());
    }

    @Test
    public void should_delete_adress_by_id() {
        Adress adress1 = new Adress("Rua 1", "Bairro 1", "Cidade 1", "Estado 1", "Pais 1", "12345678", user1);
        Adress adress2 = new Adress("Rua 2", "Bairro 2", "Cidade 2", "Estado 2", "Pais 2", "12345678", user2);
        Adress adress3 = new Adress("Rua 3", "Bairro 3", "Cidade 3", "Estado 3", "Pais 3", "12345678", user3);
        repository.save(adress1);
        repository.save(adress2);
        repository.save(adress3);
        repository.deleteById(adress2.getId());
        List<Adress> adresses = repository.findAll();
        assertThat(adresses).hasSize(2).contains(adress1, adress3);
    }
}