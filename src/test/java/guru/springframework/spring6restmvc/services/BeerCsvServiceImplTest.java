package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerCSVRecord;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BeerCsvServiceImplTest {

    // Crée une instance du service à tester
    BeerCsvService beerCsvService = new BeerCsvServiceImpl();

    /**
     * Teste la méthode `convertCSV` pour vérifier qu'elle lit et convertit correctement le fichier CSV.
     * @throws FileNotFoundException si le fichier CSV n'est pas trouvé
     */
    @Test
    void convertCSV() throws FileNotFoundException {

        // Charge le fichier CSV de test situé dans le répertoire 'classpath:csvdata/beers.csv'
        File file = ResourceUtils.getFile("classpath:csvdata/beers.csv");

        // Utilise le service pour convertir le fichier CSV en une liste de BeerCSVRecord
        List<BeerCSVRecord> recs = beerCsvService.convertCSV(file);

        // Affiche le nombre d'enregistrements dans la console
        System.out.println(recs.size());

        // Vérifie que la taille de la liste des enregistrements est supérieure à 0, ce qui signifie que le fichier a bien été lu
        assertThat(recs.size()).isGreaterThan(0);
    }
}