package guru.springframework.spring6restmvc.services;

import com.opencsv.bean.CsvToBeanBuilder;
import guru.springframework.spring6restmvc.model.BeerCSVRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class BeerCsvServiceImpl implements BeerCsvService {

    /**
     * Cette méthode prend un fichier CSV en entrée et le convertit en une liste d'objets `BeerCSVRecord`.
     *
     * @param csvFile le fichier CSV contenant les données à convertir en objets `BeerCSVRecord`
     * @return une liste d'objets `BeerCSVRecord` qui représentent les données du fichier CSV
     * @throws RuntimeException si le fichier CSV n'est pas trouvé (FileNotFoundException)
     *
     * Cette méthode utilise la classe `CsvToBeanBuilder` de la bibliothèque OpenCSV pour mapper
     * chaque ligne du fichier CSV à un objet `BeerCSVRecord`.
     */
    @Override
    public List<BeerCSVRecord> convertCSV(File csvFile) {
        try {
            // Utilise CsvToBeanBuilder pour lire et convertir le fichier CSV en objets BeerCSVRecord
            List<BeerCSVRecord> beerCSVRecords = new CsvToBeanBuilder<BeerCSVRecord>(new FileReader(csvFile))
                    .withType(BeerCSVRecord.class)
                    .build().parse();
            return beerCSVRecords;
        } catch (FileNotFoundException e) {
            // Lance une RuntimeException si le fichier CSV n'est pas trouvé
            throw new RuntimeException(e);
        }
    }
}